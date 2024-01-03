package com.test.soapwebservices.POJO.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "service_tbl")
public class Services {
    @Id
    @Column(nullable = false)
    private String serviceId;
    private String orderType;
    private String type;
    private String trxId;
}
