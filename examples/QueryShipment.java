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

        List<String> cargoKeys = new ArrayList<>();
        cargoKeys.add("BARCODE1");
        cargoKeys.add("BARCODE2");

        shipmentService.queryShipment(cargoKeys);

    }
}
