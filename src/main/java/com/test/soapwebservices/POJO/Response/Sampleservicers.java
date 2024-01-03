package com.test.soapwebservices.POJO.Response;
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
    "errorCode",
    "errorMsg",
    "trxId"
})
@XmlRootElement(name = "sampleservicers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Sampleservicers {

    @XmlElement(name = "error_code", required = true)
    protected String errorCode;
    @XmlElement(name = "error_msg", required = true)
    protected String errorMsg;
    @XmlElement(name = "trx_id", required = true)
    protected String trxId;
}
