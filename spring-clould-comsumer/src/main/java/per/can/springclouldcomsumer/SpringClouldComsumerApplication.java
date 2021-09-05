package per.can.springclouldcomsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class SpringClouldComsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringClouldComsumerApplication.class, args);
    }

}
