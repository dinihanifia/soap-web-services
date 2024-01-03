package com.test.soapwebservices.Controller;
import com.test.soapwebservices.POJO.ReqRes.Sampleservicerq;
import com.test.soapwebservices.POJO.ReqRes.Sampleservicers;
import com.test.soapwebservices.Service.SoapWebService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoapController {
    private final SoapWebService service;

    public SoapController(SoapWebService service) {
        this.service = service;
    }
    @PostMapping("/external/services/rest/sample-service")
    public Sampleservicers save(@RequestBody Sampleservicerq request){
        return service.save(request);
    }
}
