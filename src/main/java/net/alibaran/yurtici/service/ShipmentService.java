package net.alibaran.yurtici.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.alibaran.yurtici.core.ObjectToXML;
import net.alibaran.yurtici.core.ReadProperties;
import net.alibaran.yurtici.client.SOAPClientSAAJ;

import net.alibaran.yurtici.models.enumaration.ShipmentType;
import net.alibaran.yurtici.models.request.*;
import net.alibaran.yurtici.models.response.ShippingOrderResultVO;
import net.alibaran.yurtici.service.interfaces.*;
import org.json.JSONException;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.json.XML;

public class ShipmentService implements ShipmentInterface {

	private final AuthShipmentRequest authShipmentRequest;
	private final SOAPClientSAAJ soapClientSAAJ = new SOAPClientSAAJ();
	private final String xmlPath;
	private static final int PRETTY_PRINT_INDENT_FACTOR = 4;
	private ReadProperties readProperties;

	{
		try {
			readProperties = new ReadProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ShipmentService(AuthShipmentRequest authShipmentRequest) {
		this.authShipmentRequest = authShipmentRequest;
		this.xmlPath = readProperties.getXmlPath();
	}

	@Override
	public ShippingOrderResultVO createShipment(ShippingOrderVO shippingOrderVO, ShipmentType shipmentType) {

		if(shipmentType.equals(ShipmentType.PAYMENT_DOOR) && shippingOrderVO.getShippingOrderDoorPayment() == null){
			throw new NoSuchElementException("You have to fill ShippingOrderDoorPayment model!");
		}

		if(shipmentType.equals(ShipmentType.PAYMENT_DOOR_CC) && shippingOrderVO.getShippingOrderDoorPaymentCC() == null){
			throw new NoSuchElementException("You have to fill ShippingOrderDoorPaymentCC model!");
		}

		CreateShipmentRequest createShipmentRequest = new CreateShipmentRequest();

		createShipmentRequest.setAuthShippmentRequest(this.authShipmentRequest);

		createShipmentRequest.setShippingOrderVO(shippingOrderVO);

		String xmlInfo = ObjectToXML.jaxbObjectToXML(createShipmentRequest);

		xmlInfo = ejectStringFromXML(xmlInfo, shipmentType);

		String xml = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:ship='" + xmlPath + "'>"
				+ "<soapenv:Header/><soapenv:Body><ship:createShipment>" + xmlInfo + "</ship:createShipment></soapenv:Body></soapenv:Envelope>";

		SOAPMessage soapResponse = soapClientSAAJ.callSoapWebService(xml);

		return this.shippingOrderMapper(soapResponse, "ShippingOrderResultVO");
	}

	@Override
	public ShippingOrderResultVO cancelShipment(List<String> cargoKeys) {

		CancelShipmentRequest cancelShipmentRequest = new CancelShipmentRequest();
		cancelShipmentRequest.setCargoKeys(cargoKeys);
		cancelShipmentRequest.setAuthShipmentRequest(authShipmentRequest);

		String xmlInfo = ObjectToXML.jaxbObjectToXML(cancelShipmentRequest);

		String xml = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:ship='" + xmlPath + "'>"
				+ "<soapenv:Header/><soapenv:Body><ship:cancelShipment>" + xmlInfo + "</ship:cancelShipment></soapenv:Body></soapenv:Envelope>";

		SOAPMessage soapResponse = soapClientSAAJ.callSoapWebService(xml);

		return this.shippingOrderMapper(soapResponse, "ShippingOrderResultVO");
	}

	@Override
	public ShippingOrderResultVO queryShipment(List<String> cargoKeys) {

		QueryShipmentRequest queryShipmentRequest = new QueryShipmentRequest();
		queryShipmentRequest.setKeyType(0);
		queryShipmentRequest.setOnlyTracking(true);
		queryShipmentRequest.setAddHistoricalData(true);
		queryShipmentRequest.setKeys(cargoKeys);
		queryShipmentRequest.setAuthShipmentRequest(authShipmentRequest);

		String xmlInfo = ObjectToXML.jaxbObjectToXML(queryShipmentRequest);

		String xml = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:ship='" + xmlPath + "'>"
				+ "<soapenv:Header/><soapenv:Body><ship:queryShipment>" + xmlInfo + "</ship:queryShipment></soapenv:Body></soapenv:Envelope>";

		SOAPMessage soapResponse = soapClientSAAJ.callSoapWebService(xml);

		return this.shippingOrderMapper(soapResponse, "shipingDeliveryDetailVO");
	}

	private ShippingOrderResultVO shippingOrderMapper(SOAPMessage soapResponse, String rootElement){
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			soapResponse.writeTo(out);
			String strMsg = new String(out.toByteArray());
			JSONObject xmlJSONObj = XML.toJSONObject( strMsg);
			String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
			String getDataInJson = this.getDataInJSON(jsonPrettyPrintString, rootElement);

			if(Objects.nonNull(getDataInJson)){
				return new ObjectMapper().readValue(getDataInJson, ShippingOrderResultVO.class);
			}

		} catch (JSONException | SOAPException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String ejectStringFromXML(String xml, ShipmentType shipmentType){

		if(shipmentType == ShipmentType.STANDART){
			xml = xml.replaceAll("<shipingOrderDoorPaymentCC>[a-zA-Z0-9\\t\\s\\<\\>\\/\\.]+<\\/shipingOrderDoorPaymentCC>", "").
					replaceAll("<shipingOrderDoorPayment>[a-zA-Z0-9\\t\\s\\<\\>\\/\\.]+<\\/shipingOrderDoorPayment>", "");

		}else if(shipmentType == ShipmentType.PAYMENT_DOOR) {
			xml = xml.replaceAll("<shipingOrderDoorPaymentCC>[a-zA-Z0-9\\t\\s\\<\\>\\/\\.]+<\\/shipingOrderDoorPaymentCC>", "");
			xml = xml.replace("<shipingOrderDoorPayment>", "").replace("</shipingOrderDoorPayment>", "");
		}
		else if(shipmentType == ShipmentType.PAYMENT_DOOR_CC){
			xml = xml.replaceAll("<shipingOrderDoorPayment>[a-zA-Z0-9\\t\\s\\<\\>\\/\\.]+<\\/shipingOrderDoorPayment>", "");
			xml = xml.replace("<shipingOrderDoorPaymentCC>", "").replace("</shipingOrderDoorPaymentCC>", "");

		}

		return xml;
	}

	private String getDataInJSON(String xml, String rootElement) {
		Pattern pattern = Pattern.compile("(?<=\\\""+rootElement+"\\\"\\:)(\\W+)[\\W\\w\\s]+(?=\\}\\,)}", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(xml);
		boolean matchFound = matcher.find();
		if(matchFound) {
			return matcher.group();
		}
		return null;
	}
}
