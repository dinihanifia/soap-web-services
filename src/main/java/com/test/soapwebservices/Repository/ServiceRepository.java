package com.test.soapwebservices.Repository;
import com.test.soapwebservices.POJO.Model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Services, String> {
}
