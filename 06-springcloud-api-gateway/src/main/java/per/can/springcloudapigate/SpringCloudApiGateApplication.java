package per.can.springcloudapigate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableZuulProxy //开启 Zuul 的 API 网关服务功
@SpringBootApplication
public class SpringCloudApiGateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApiGateApplication.class, args);
    }

}
