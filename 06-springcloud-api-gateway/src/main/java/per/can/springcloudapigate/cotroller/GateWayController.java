package per.can.springcloudapigate.cotroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GateWayController {

    @RequestMapping("/api/local")
    public String hello() {

        int i =1/0;
        System.out.println("GateWayController。。。。。");
        return "exec the api gateway.";
    }
}
