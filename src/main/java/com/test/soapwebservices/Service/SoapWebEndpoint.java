package com.test.soapwebservices.Service;
import com.test.soapwebservices.POJO.Model.Services;
import com.test.soapwebservices.POJO.Request.Sampleservicerq;
import com.test.soapwebservices.POJO.Response.Sampleservicers;
import com.test.soapwebservices.Repository.ServiceRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SoapWebEndpoint {
    private static final String NAMESPACE_URI="http://www.oracle.com/external/services/sampleservice/request/v1.0";
    private final SoapWebService webService;
    private final ServiceRepository repository;

    public SoapWebEndpoint(SoapWebService webService, ServiceRepository repository) {
        this.webService = webService;
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sampleservicerq")
    @ResponsePayload
    public Sampleservicers save(@RequestPayload Sampleservicerq request){
        Sampleservicers response = new Sampleservicers();
        var check = webService.getOne(request.getServiceId());
        if(check.equals("0000")){
            Services services = new Services();
            services.setServiceId(request.getServiceId());
            services.setOrderType(request.getOrderType());
            services.setType(request.getType());
            services.setTrxId(request.getTrxId());
            repository.save(services);
            return Sampleservicers.builder()
                    .errorCode("0000")
                    .errorMsg("Success")
                    .trxId(check.getTrxId())
                    .build();
//            SampleServiceRsJSON convert = convertSampleservicersToJson(sampleservicers);
//            return convert;
        } else {
            return Sampleservicers.builder()
                    .errorCode("400")
                    .errorMsg("Duplicate Service Id")
                    .trxId(check.getTrxId())
                    .build();
//            String convert = convertSampleservicersToJson(sampleservicers);
//            return convert;
        }
    }
//    public static String convertSampleservicersToJson(Sampleservicers sampleservicers) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            return objectMapper.writeValueAsString(sampleservicers);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "{}";
//        }
//    }
}
