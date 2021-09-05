package per.can.springclouldcomsumer.config;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BeanConfig {


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

    /**
     * 覆盖掉原来ribbon默认的轮询负载均衡策略
     *
     *
     * @return
     */
    //@Bean
    public IRule iRule() {
       // return new RandomRule(); //采用随机的负载均衡策略
        return new RetryRule(); //采用重试的负载均衡策略
    }
}
