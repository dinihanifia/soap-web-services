package com.test.soapwebservices.Service;
import com.test.soapwebservices.POJO.Model.Services;
import com.test.soapwebservices.Repository.ServiceRepository;
import com.test.soapwebservices.POJO.ReqRes.Sampleservicerq;
import com.test.soapwebservices.POJO.ReqRes.Sampleservicers;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SoapWebService {

    private final ServiceRepository serviceRepository;

    public SoapWebService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Sampleservicers save(Sampleservicerq request){
        Sampleservicers response = new Sampleservicers();
        response.setErrorCode("400");
        response.setErrorMsg("Bad Request");
        try {
            // cek service id if duplicate
            var check = getOne(request.getServiceId());
            if(check.equals("404")){
                Services services = new Services();
                services.setServiceId(request.getServiceId());
                services.setOrderType(request.getOrderType());
                services.setType(request.getType());
                services.setTrxId(request.getTrxId());
                serviceRepository.save(services);
                return Sampleservicers.builder()
                        .errorCode("0000")
                        .errorMsg("Success")
                        .trxId(request.getTrxId())
                        .build();
            } else {
                return Sampleservicers.builder()
                        .errorCode("400")
                        .errorMsg("Duplicate Service Id")
                        .trxId(request.getTrxId())
                        .build();
            }
        } catch (Exception e){
            response.setErrorCode("500");
            response.setErrorMsg("Internal Server Error");
        }
        return response;
    }

    public Sampleservicers getOne(String serviceId){
        Sampleservicers response = new Sampleservicers();
        response.setErrorCode("400");
        response.setErrorMsg("Bad Request");
        try {
            Optional<Services> checkService = serviceRepository.findById(serviceId);
            checkService.ifPresentOrElse(
                    services -> {
                        response.setErrorCode("0000");
                        response.setErrorMsg("Success");
                        response.setTrxId(services.getServiceId());
                    },
                    () -> {
                        response.setErrorCode("404");
                        response.setErrorMsg("Not Found");
                        response.setTrxId(null);
                    }
            );
        } catch (Exception e){
            response.setErrorCode("500");
            response.setErrorMsg("Internal Server Error");
        }
        return response;
    }
}
