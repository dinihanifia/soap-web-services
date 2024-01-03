package com.test.soapwebservices.POJO.Json;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleServiceRsJSON {
    protected String errorCode;
    protected String errorMsg;
    protected String trxId;
}
