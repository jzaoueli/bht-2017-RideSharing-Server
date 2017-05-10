package io.oasp.logistic.ridesharing;


import io.oasp.module.jpa.dataaccess.api.common.AdvancedRevisionEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class })
@SpringBootApplication(exclude = {EndpointAutoConfiguration.class})
@EntityScan(basePackages = {"io.oasp.logistic.ridesharing"}, basePackageClasses = {AdvancedRevisionEntity.class})
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SpringBootApp {

    /**
     * Entry point for spring-boot based app
     *
     * @param args - arguments
     */
    public static void main(String[] args) {

        SpringApplication.run(SpringBootApp.class, args);
    }
}
