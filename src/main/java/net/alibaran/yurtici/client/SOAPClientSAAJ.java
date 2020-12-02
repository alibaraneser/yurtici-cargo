package net.alibaran.yurtici.client;

import net.alibaran.yurtici.core.ReadProperties;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

;
public class SOAPClientSAAJ {

    ReadProperties readProperties;

    {
        try {
            readProperties = new ReadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SOAPMessage callSoapWebService(String xml) {
    	
    	SOAPMessage soapResponse = null;
    	
        try {
            // Create SOAP Connection
        	SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            String url = readProperties.getServicePath();

            InputStream is = new ByteArrayInputStream(xml.getBytes());
            SOAPMessage request = MessageFactory.newInstance().createMessage(null, is);

            soapResponse = soapConnection.call(request, url);
            soapResponse.writeTo(System.out);
            soapConnection.close();
            
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }

		return soapResponse;
		
    }

}