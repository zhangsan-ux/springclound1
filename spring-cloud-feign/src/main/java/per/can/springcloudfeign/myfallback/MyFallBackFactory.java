package per.can.springcloudfeign.myfallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import per.can.springcloudfeign.service.HelloService;

@Component
public class MyFallBackFactory  implements FallbackFactory<HelloService> {

    @Override
    public HelloService create(Throwable throwable) {
        return new HelloService() {
            @Override
            public String hello() {
                return throwable.getMessage();
            }
        };
    }
}
