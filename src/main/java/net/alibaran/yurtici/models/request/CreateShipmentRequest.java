package net.alibaran.yurtici.models.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@NoArgsConstructor
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)

public class CreateShipmentRequest {

	@XmlElement(name = "auth")
	private AuthShipmentRequest authShippmentRequest;

	@XmlElement(name = "ShippingOrderVO")
	private ShippingOrderVO shippingOrderVO;


}