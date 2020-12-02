package net.alibaran.yurtici.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingOrderResultVO implements Serializable {

    @JsonProperty("outFlag")
    @NonNull
    private String outFlag;

    @JsonProperty("outResult")
    private String outResult;

    @JsonProperty("errCode")
    private Integer errCode;

    @JsonProperty("senderCustId")
    private Integer senderCustId;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("jobId")
    private Integer jobId;

    @JsonProperty("shippingCancelDetailVO")
    private ShippingCancelDetailVO shippingCancelDetailVO;

    @JsonProperty("shippingOrderDetailVO")
    private ShippingOrderDetailVO shippingOrderDetailVO;

    @JsonProperty("shippingDeliveryDetailVO")
    private ShippingDeliveryDetailVO shippingDeliveryDetailVO;
}
