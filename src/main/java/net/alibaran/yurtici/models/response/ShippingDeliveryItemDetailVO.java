package net.alibaran.yurtici.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingDeliveryItemDetailVO {

    @JsonProperty("docId")
    private String docId;

    @JsonProperty("documentDate")
    private String documentDate;

    @JsonProperty("documentTime")
    private String documentTime;

    @JsonProperty("deliveryDate")
    private String deliveryDate;

    @JsonProperty("deliveryTime")
    private String deliveryTime;

    @JsonProperty("rejectStatus")
    private String rejectStatus;

    @JsonProperty("rejectReasonExplanation")
    private String rejectReasonExplanation;

}
