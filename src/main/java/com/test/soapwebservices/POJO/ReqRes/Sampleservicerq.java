package com.test.soapwebservices.POJO.ReqRes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serviceId",
    "orderType",
    "type",
    "trxId"
})
@XmlRootElement(name = "sampleservicerq")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Sampleservicerq {

    @XmlElement(name = "service_id", required = true)
    protected String serviceId;
    @XmlElement(name = "order_type", required = true)
    protected String orderType;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(name = "trx_id", required = true)
    protected String trxId;
}
