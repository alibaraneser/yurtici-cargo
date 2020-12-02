# Yurtici Cargo API Integration

It is a Web Service integration prepared for the **Yurtiçi Kargo**.

### Installation

The package was written in Java version **1.8** 

First of all, download [Yurtici-Kargo.jar](https://github.com/alibaraneser/yurtici-cargo/releases/tag/1.0) and add dependency for your project.

### Services

 - Create Shipment
 - Cancel Shipment
 - Query Shipment


#### Setup Authentication

```sh
AuthShipmentRequest authShipmentRequest = new AuthShipmentRequest();
authShipmentRequest.setWsUserName("XXX");
authShipmentRequest.setWsPassword("XXX");
authShipmentRequest.setUserLanguage("TR");
authShipmentRequest.setWsLanguage("TR");
```

```sh
//initialize service
ShipmentService shipmentService = new ShipmentService(authShipmentRequest);
```

#### Create Standart Shipment (Sender Paid)



```sh

//a new shipment
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

```

#### Shipment (pay at door)


```sh

ShippingOrderDoorPayment shipingOrderDoorPayment = new ShippingOrderDoorPayment();

shipingOrderDoorPayment.setTtDocumentId(ANY_DIGIT_NUMBER);
shipingOrderDoorPayment.setTtInvoiceAmount(AMOUNT);
shipingOrderDoorPayment.setTtCollectionType(0);
shipingOrderDoorPayment.setTtDocumentSaveType(0);

shippingOrderVO.setShippingOrderDoorPayment(shipingOrderDoorPayment);

```

#### Shipment (pay at door with credit cart)


```sh

ShippingOrderDoorPaymentCC shipingOrderDoorPaymentCC = new ShippingOrderDoorPaymentCC();

shipingOrderDoorPaymentCC.setTtDocumentId( orderCargoSummary.getOrderNo());
shipingOrderDoorPaymentCC.setTtInvoiceAmount( orderCargoSummary.getTotalPrice());
shipingOrderDoorPaymentCC.setTtCollectionType(1);
shipingOrderDoorPaymentCC.setDcCreditRule(1);
shipingOrderDoorPaymentCC.setDcSelectedCredit(1);
shipingOrderDoorPaymentCC.setTtDocumentSaveType(0);

shippingOrderVO.setShippingOrderDoorPayment(shipingOrderDoorPayment);

```

Choose type of shipment

```sh

public enum ShipmentType {
    STANDART,
    PAYMENT_DOOR,
    PAYMENT_DOOR_CC
}

```

Send Request to API

```sh

shipmentService.createShipment(shippingOrderVO, ShipmentType.STANDART);

```

#### Cancel Shipment

```sh
List<String> cargoKeys = new ArrayList<>();
cargoKeys.add("BARCODE1");
cargoKeys.add("BARCODE2");

shipmentService.cancelShipment(cargoKeys);
```

#### Query Shipment

```sh
List<String> cargoKeys = new ArrayList<>();
cargoKeys.add("BARCODE1");
cargoKeys.add("BARCODE2");

shipmentService.queryShipment(cargoKeys);
```

> **Note:** You can view examples of services in **examples** folder.