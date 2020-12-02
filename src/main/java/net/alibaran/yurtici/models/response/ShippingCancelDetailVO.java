package net.alibaran.yurtici.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShippingCancelDetailVO {

	@JsonProperty("cargoKey")
	private String cargoKey;

	@JsonProperty("invoiceKey")
	private String invoiceKey;

	@JsonProperty("jobId")
	private Integer jobId;

	@JsonProperty("docId")
	private Integer docId;

	@JsonProperty("operationCode")
	private Integer operationCode;

	@JsonProperty("operationMessage")
	private String operationMessage;

	@JsonProperty("operationStatus")
	private String operationStatus;

	@JsonProperty("errCode")
	private Integer errCode;

	@JsonProperty("errMessage")
	private String errMessage;

}
