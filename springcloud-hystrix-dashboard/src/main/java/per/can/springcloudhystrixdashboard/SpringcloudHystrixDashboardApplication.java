package per.can.springcloudhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //注解开启仪表盘
public class SpringcloudHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudHystrixDashboardApplication.class, args);
    }

}
