package net.alibaran.yurtici.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShippingOrderDetailVO {

	@JsonProperty("cargoKey")
	private String cargoKey;

	@JsonProperty("invoiceKey")
	private String invoiceKey;

	@JsonProperty("errCode")
	private Integer errCode;

	@JsonProperty("errMessage")
	private String errMessage;

}
