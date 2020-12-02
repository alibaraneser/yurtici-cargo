package net.alibaran.yurtici.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShippingDeliveryDetailVO {

	@JsonProperty("cargoKey")
	private String cargoKey;

	@JsonProperty("invoiceKey")
	private String invoiceKey;

	@JsonProperty("jobId")
	private Integer jobId;

	@JsonProperty("operationCode")
	private Integer operationCode;

	@JsonProperty("operationMessage")
	private String operationMessage;

	@JsonProperty("operationStatus")
	private String operationStatus;

	@JsonProperty("docId")
	private String docId;

	@JsonProperty("errCode")
	private Integer errCode;

	@JsonProperty("errMessage")
	private String errMessage;

	@JsonProperty("shippingDeliveryItemDetailVO")
	private ShippingDeliveryItemDetailVO shippingDeliveryItemDetailVO;

}
