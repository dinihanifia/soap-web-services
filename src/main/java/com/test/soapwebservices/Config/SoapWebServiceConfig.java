package com.test.soapwebservices.Config;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/external/services/ws/sample-service/*");
    }

    @Bean(name = "sample-service")
    public DefaultWsdl11Definition detailsRequestWsdl(XsdSchema detailsRequestSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SampleServicePort");
        wsdl11Definition.setLocationUri("/external/services/ws/sample-service");
        wsdl11Definition.setTargetNamespace("http://www.oracle.com/external/services/sampleservice/request/v1.0");
        wsdl11Definition.setSchema(detailsRequestSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema soapRequestSchema() {
        return new SimpleXsdSchema(new ClassPathResource("Main.xsd"));
    }
}
