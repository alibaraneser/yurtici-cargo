package net.alibaran.yurtici.examples;

import net.alibaran.yurtici.models.request.AuthShipmentRequest;
import net.alibaran.yurtici.service.ShipmentService;

import java.util.ArrayList;
import java.util.List;

public class CreateShipment {
    public static void main(String[] args){
        AuthShipmentRequest authShipmentRequest = new AuthShipmentRequest();
        authShipmentRequest.setWsUserName("XXX");
        authShipmentRequest.setWsPassword("XXX");
        authShipmentRequest.setUserLanguage("TR");
        authShipmentRequest.setWsLanguage("TR");

        ShipmentService shipmentService = new ShipmentService(authShipmentRequest);

        // Standart Shipment (Sender Paid)
        ShippingOrderVO shippingOrderVO = new ShippingOrderVO();

        shippingOrderVO.setReceiverCustName("Ali Baran Eser");
        shippingOrderVO.setReceiverAddress("Lorem ipsum dolar sit amet");
        shippingOrderVO.setReceiverPhone1("XXXXXXXXXXXX");
        shippingOrderVO.setCargoKey("BARCODE_KEY");
        shippingOrderVO.setInvoiceKey("INVOCE_KEY");
        shippingOrderVO.setDescription("Lorem ipsum dolar sit amet");
        shippingOrderVO.setCityName("İzmir");
        shippingOrderVO.setTownName("Konak");
        shippingOrderVO.setCargoCount(1);

        // Pay at door
        ShippingOrderDoorPayment shipingOrderDoorPayment = new ShippingOrderDoorPayment();

        shipingOrderDoorPayment.setTtDocumentId(ANY_DIGIT_NUMBER);
        shipingOrderDoorPayment.setTtInvoiceAmount(AMOUNT);
        shipingOrderDoorPayment.setTtCollectionType(0);
        shipingOrderDoorPayment.setTtDocumentSaveType(0);

        shippingOrderVO.setShippingOrderDoorPayment(shipingOrderDoorPayment);

        // Pay at door with credit cart
        ShippingOrderDoorPaymentCC shipingOrderDoorPaymentCC = new ShippingOrderDoorPaymentCC();

        shipingOrderDoorPaymentCC.setTtDocumentId( orderCargoSummary.getOrderNo());
        shipingOrderDoorPaymentCC.setTtInvoiceAmount( orderCargoSummary.getTotalPrice());
        shipingOrderDoorPaymentCC.setTtCollectionType(1);
        shipingOrderDoorPaymentCC.setDcCreditRule(1);
        shipingOrderDoorPaymentCC.setDcSelectedCredit(1);
        shipingOrderDoorPaymentCC.setTtDocumentSaveType(0);

        shippingOrderVO.setShippingOrderDoorPayment(shipingOrderDoorPayment);

        shipmentService.createShipment(shippingOrderVO, ShipmentType.STANDART);


    }
}
