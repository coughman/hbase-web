package com.td.ecrr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import com.cloudera.cdk.hbase.data.service.AddressDatasetService;
import com.cloudera.cdk.hbase.data.service.AgreementDatasetService;
import com.cloudera.cdk.hbase.data.service.EventDatasetService;
import com.cloudera.cdk.hbase.data.service.PartyAddressDatasetService;
import com.cloudera.cdk.hbase.data.service.PartyAgreementDatasetService;
import com.cloudera.cdk.hbase.data.service.PartyDatasetService;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Application {
	@Value("${hbase.url:repo:hbase:localhost}")
	private String hbaseUrl; 
	
	@Bean
	AddressDatasetService addressDatasetService() {
		AddressDatasetService service = new AddressDatasetService();
		service.setHbaseUrl(this.hbaseUrl);
		return service;
	}

	@Bean
	AgreementDatasetService agreementDatasetService() {
		AgreementDatasetService service = new AgreementDatasetService();
		service.setHbaseUrl(this.hbaseUrl);
		return service;
	}
	
	@Bean
	EventDatasetService eventDatasetService() {
		EventDatasetService service = new EventDatasetService();
		service.setHbaseUrl(this.hbaseUrl);
		return service;
	}
	
	@Bean
	PartyAddressDatasetService partyAddressDatasetService() {
		PartyAddressDatasetService service = new PartyAddressDatasetService(this.hbaseUrl);
		return service;
	}
	
	@Bean
	PartyAgreementDatasetService partyAgreementDatasetService() {
		PartyAgreementDatasetService service = new PartyAgreementDatasetService(this.hbaseUrl);
		return service;
	}
	
	@Bean
	PartyDatasetService partyDatasetService() {
		PartyDatasetService service = new PartyDatasetService();
		service.setHbaseUrl(this.hbaseUrl);
		return service;
	}
	
    @Bean
    ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        return resolver;
    }
    
    @Bean
    SpringTemplateEngine engine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        return engine;
    }
    
    @Bean
    ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(engine());
        return viewResolver;
    }
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
