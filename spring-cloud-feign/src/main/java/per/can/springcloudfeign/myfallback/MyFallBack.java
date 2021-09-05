package per.can.springcloudfeign.myfallback;

import org.springframework.stereotype.Component;
import per.can.springcloudfeign.controller.HelloController;
import per.can.springcloudfeign.service.HelloService;


@Component
public class MyFallBack  implements HelloService {
    @Override
    public String hello() {
        return "远程服务调不通 ，用本地逻辑处理";
    }
}
