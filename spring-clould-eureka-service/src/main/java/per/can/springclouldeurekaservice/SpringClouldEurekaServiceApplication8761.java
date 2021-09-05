package per.can.springclouldeurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class SpringClouldEurekaServiceApplication8761 {

    public static void main(String[] args) {
        SpringApplication.run(SpringClouldEurekaServiceApplication8761.class, args);
    }

}
