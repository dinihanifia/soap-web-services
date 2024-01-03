# SOAP Web Service

### SOAP URL
```
http://localhost:8087/external/services/ws/sample-service
```

### wsdl file
```
http://localhost:8087/external/services/ws/sample-service/request-service.wsdl
http://localhost:8087/external/services/ws/sample-service/response-service.wsdl
```

### SOAP request
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Header/>
    <soapenv:Body>
        <v1:sampleservicerq xmlns:v1="http://www.oracle.com/external/services/sampleservice/request/v1.0">
            <v1:service_id>1234567890</v1:service_id>
            <v1:order_type>CH</v1:order_type>
            <v1:type>PO</v1:type>
            <v1:trx_id>c6714ec0-b379-11e9-889b-7f7167f4f72d</v1:trx_id>
        </v1:sampleservicerq>
    </soapenv:Body>
</soapenv:Envelope>
```

### SOAP response if success
```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:sampleservicers xmlns:ns2="http://www.oracle.com/external/services/sampleservice/response/v1.0">
            <ns2:error_code>0000</ns2:error_code>
            <ns2:error_msg>Success</ns2:error_msg>
            <ns2:trx_id>1234567890</ns2:trx_id>
        </ns2:sampleservicers>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### SOAP response if not success
```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:sampleservicers xmlns:ns2="http://www.oracle.com/external/services/sampleservice/response/v1.0">
            <ns2:error_code>400</ns2:error_code>
            <ns2:error_msg>Duplicate Service Id</ns2:error_msg>
            <ns2:trx_id>1234567890</ns2:trx_id>
        </ns2:sampleservicers>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

# REST

### REST URL
```
http://localhost:8087/external/services/rest/sample-service
```

### REST request
```
{
    "serviceId": "20200421201455122",
    "orderType": "PRO",
    "type": "20221120233514",
    "trxId": "c6714ec0-b379-11e9-889b-7f7167f4f72d"
}
```

### REST response if success
```
{
    "errorCode": "0000",
    "errorMsg": "Success",
    "trxId": "c6714ec0-b379-11e9-889b-7f7167f4f72d"
}
```

### REST response if not success
```
{
    "errorCode": "400",
    "errorMsg": "Duplicate Service Id",
    "trxId": "c6714ec0-b379-11e9-889b-7f7167f4f72d"
}
```
