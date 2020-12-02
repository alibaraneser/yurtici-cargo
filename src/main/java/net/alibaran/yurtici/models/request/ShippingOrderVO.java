package net.alibaran.yurtici.models.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)

public class ShippingOrderVO {

	@XmlElement(name = "receiverCustName")
	private String receiverCustName;

	@XmlElement(name = "receiverAddress")
	private String receiverAddress;

	@XmlElement(name = "receiverPhone1")
	private String receiverPhone1;

	@XmlElement(name = "cargoKey")
	private String cargoKey;

	@XmlElement(name = "invoiceKey")
	private String invoiceKey;

	@XmlElement(name = "description")
	private String description;

	@XmlElement(name = "cityName")
	private String cityName;

	@XmlElement(name = "townName")
	private String townName;

	@XmlElement(name = "cargoCount")
	private Integer cargoCount;

	@XmlElement(name = "shipingOrderDoorPayment")
    ShippingOrderDoorPayment shippingOrderDoorPayment;

	@XmlElement(name = "shipingOrderDoorPaymentCC")
    ShippingOrderDoorPaymentCC shippingOrderDoorPaymentCC;


}