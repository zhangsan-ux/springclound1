package per.can.springclouldcomsumer.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MyHystrixCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;


    public MyHystrixCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate=restTemplate;
    }

    @Override
    protected String run() throws Exception {
        int a=10/0;
        ResponseEntity<String> responseEntity =restTemplate.getForEntity("http://spring-clould-test-provider/service/hello", String.class);

        return responseEntity.getBody();
    }

   public   String getFallback(){

       Throwable throwable=   super.getExecutionException();
       System.out.println("异常 ："+throwable.getMessage());
       System.out.println("异常 ："+throwable.getStackTrace());
        return "MyHystrixCommandError";
   }
}
