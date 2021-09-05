package per.can.springcloudfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import per.can.springcloudfeign.myfallback.MyFallBack;
import per.can.springcloudfeign.myfallback.MyFallBackFactory;

@FeignClient(value = "spring-clould-test-provider" ,fallbackFactory = MyFallBackFactory.class )
public interface HelloService {

    @RequestMapping("/service/hello")
    public String hello();
}
