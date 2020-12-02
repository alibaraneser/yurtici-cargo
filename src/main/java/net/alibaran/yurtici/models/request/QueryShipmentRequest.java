package net.alibaran.yurtici.models.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class QueryShipmentRequest {

	@XmlElement(name = "auth")
	private AuthShipmentRequest authShipmentRequest;

	@XmlElement(name = "onlyTracking")
	private Boolean onlyTracking;

	@XmlElement(name = "addHistoricalData")
	private Boolean addHistoricalData;

	@XmlElement(name = "keyType")
	private Integer keyType;

	@XmlElement(name = "keys")
	private List<String> keys;

}
