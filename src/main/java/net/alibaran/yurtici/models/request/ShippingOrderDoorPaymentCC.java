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
public class ShippingOrderDoorPaymentCC {
    @XmlElement(name = "ttDocumentId")
    private Long ttDocumentId;

    @XmlElement(name = "ttInvoiceAmount")
    private Double ttInvoiceAmount;

    @XmlElement(name = "ttCollectionType")
    private Integer ttCollectionType;

    @XmlElement(name = "ttDocumentSaveType")
    private Integer ttDocumentSaveType;

    @XmlElement(name = "dcSelectedCredit")
    private Integer dcSelectedCredit;

    @XmlElement(name = "dcCreditRule")
    private Integer dcCreditRule;
}
