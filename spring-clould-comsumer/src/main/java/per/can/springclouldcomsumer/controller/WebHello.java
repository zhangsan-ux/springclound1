package per.can.springclouldcomsumer.controller;


import com.google.common.collect.Multimap;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import per.can.springclouldcomsumer.hystrix.MyHystrixCommand;
import per.can.springclouldcomsumer.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class WebHello {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/cloud/hello")
    public String helloController() {
        ResponseEntity<String> responseEntity =restTemplate.getForEntity("http://spring-clould-test-provider/service/hello", String.class);

//        String body = responseEntity.getBody();
//        HttpStatus statusCode = responseEntity.getStatusCode();
//        int statusCodeValue = responseEntity.getStatusCodeValue();
//        HttpHeaders headers = responseEntity.getHeaders();
//        System.out.println(body);
//        System.out.println(statusCode);
//        System.out.println(statusCodeValue);
//        System.out.println(headers);
        return  responseEntity.getBody();
    }

    @RequestMapping(value="/cloud/user")
    public User user() {
        ResponseEntity<User> responseEntity =restTemplate.getForEntity("http://spring-clould-test-provider/service/user", User.class);

        User user =responseEntity.getBody() ;
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        System.out.println(user);
        System.out.println(statusCode);
        System.out.println(statusCodeValue);
        System.out.println(headers);
        return  restTemplate.getForEntity("http://spring-clould-test-provider/service/user", User.class).getBody();
    }

    @RequestMapping(value="/cloud/getuser")
    public User getuser() {


       String[] arr = {"11","张无忌","16800000"};
        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("id", 199);
        paramMap.put("name", "张翠山");
        paramMap.put("phone", "178000000");
       // ResponseEntity<User> responseEntity =restTemplate.getForEntity("http://spring-clould-test-provider/service/getuser?id={0}&name={1}&phone={3}", User.class,arr);
      //  ResponseEntity<User> responseEntity =restTemplate.getForEntity("http://spring-clould-test-provider/service/getuser?id={id}&name={name}&phone={phone}", User.class,paramMap);
       User responseEntity1 =restTemplate.getForObject("http://spring-clould-test-provider/service/getuser?id={id}&name={name}&phone={phone}", User.class,paramMap);


        User responseEntity2 =restTemplate.getForObject("http://spring-clould-test-provider/service/getuser?id={0}&name={1}&phone={2}", User.class,arr);

//        User user =responseEntity.getBody() ;
//        HttpStatus statusCode = responseEntity.getStatusCode();
//        int statusCodeValue = responseEntity.getStatusCodeValue();
//        HttpHeaders headers = responseEntity.getHeaders();
//        System.out.println(statusCode);
//        System.out.println(statusCodeValue);
//        System.out.println(headers);
 //       System.out.println(user.getId()+"--"+user.getName()+"--"+user.getPhone());
        System.out.println(responseEntity1.getId()+"--"+responseEntity1.getName()+"--"+responseEntity1.getPhone());
        System.out.println(responseEntity2.getId()+"--"+responseEntity2.getName()+"--"+responseEntity2.getPhone());

        return  restTemplate.getForEntity("http://spring-clould-test-provider/service/getuser?id={id}&name={name}&phone={phone}", User.class,paramMap).getBody();
    }


    @RequestMapping(value="/cloud/adduser")
    public User adduser() {


        String[] arr = {"11","张无忌","16800000"};
        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("id", 199);
        paramMap.put("name", "张翠山");
        paramMap.put("phone", "178000000");


        MultiValueMap dateMap = new LinkedMultiValueMap();
        dateMap.add("id",11);
        dateMap.add("name","张翠山");
        dateMap.add("phone","12345678");
        // ResponseEntity<User> responseEntity =restTemplate.getForEntity("http://spring-clould-test-provider/service/getuser?id={0}&name={1}&phone={3}", User.class,arr);
        //  ResponseEntity<User> responseEntity =restTemplate.getForEntity("http://spring-clould-test-provider/service/getuser?id={id}&name={name}&phone={phone}", User.class,paramMap);
        ResponseEntity<User> responseEntity1 =restTemplate.postForEntity("http://spring-clould-test-provider/service/adduser", dateMap,User.class);
        User user1 = responseEntity1.getBody();

        User user2 =restTemplate.postForObject("http://spring-clould-test-provider/service/adduser",dateMap, User.class);

//        User user =responseEntity.getBody() ;
//        HttpStatus statusCode = responseEntity.getStatusCode();
//        int statusCodeValue = responseEntity.getStatusCodeValue();
//        HttpHeaders headers = responseEntity.getHeaders();
//        System.out.println(statusCode);
//        System.out.println(statusCodeValue);
//        System.out.println(headers);
        //       System.out.println(user.getId()+"--"+user.getName()+"--"+user.getPhone());
        System.out.println(user1.getId()+"--"+user1.getName()+"--"+user1.getPhone());
        System.out.println(user2.getId()+"--"+user2.getName()+"--"+user2.getPhone());

        return  restTemplate.postForEntity("http://spring-clould-test-provider/service/adduser",dateMap, User.class).getBody();
    }


    @PutMapping(value="/cloud/updateuser")
    public String updateuser() {

        MultiValueMap dateMap = new LinkedMultiValueMap();
        dateMap.add("id",11);
        dateMap.add("name","张翠山");
        dateMap.add("phone","12345678");
        // ResponseEntity<User> responseEntity =restTemplate.getForEntity("http://spring-clould-test-provider/service/getuser?id={0}&name={1}&phone={3}", User.class,arr);
        //  ResponseEntity<User> responseEntity =restTemplate.getForEntity("http://spring-clould-test-provider/service/getuser?id={id}&name={name}&phone={phone}", User.class,paramMap);


        restTemplate.put("http://spring-clould-test-provider/service/updateuser",dateMap);

//        User user =responseEntity.getBody() ;
//        HttpStatus statusCode = responseEntity.getStatusCode();
//        int statusCodeValue = responseEntity.getStatusCodeValue();
//        HttpHeaders headers = responseEntity.getHeaders();
//        System.out.println(statusCode);
//        System.out.println(statusCodeValue);
//        System.out.println(headers);
        //       System.out.println(user.getId()+"--"+user.getName()+"--"+user.getPhone());

        restTemplate.put("http://spring-clould-test-provider/service/updateuser",dateMap);

        return "sucess";
    }


    @DeleteMapping(value="/cloud/deleteuser")
    public String deleteuser() {
        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("id", 199);
        paramMap.put("name", "张翠山");
        paramMap.put("phone", "178000000");
        // ResponseEntity<User> responseEntity =restTemplate.getForEntity("http://spring-clould-test-provider/service/getuser?id={0}&name={1}&phone={3}", User.class,arr);
        //  ResponseEntity<User> responseEntity =restTemplate.getForEntity("http://spring-clould-test-provider/service/getuser?id={id}&name={name}&phone={phone}", User.class,paramMap);


        restTemplate.delete("http://spring-clould-test-provider/service/deleteuser?id={id}&name={name}&phone={phone}",paramMap);

//        User user =responseEntity.getBody() ;
//        HttpStatus statusCode = responseEntity.getStatusCode();
//        int statusCodeValue = responseEntity.getStatusCodeValue();
//        HttpHeaders headers = responseEntity.getHeaders();
//        System.out.println(statusCode);
//        System.out.println(statusCodeValue);
//        System.out.println(headers);
        //       System.out.println(user.getId()+"--"+user.getName()+"--"+user.getPhone());
        String[] arr = {"11","张无忌","16800000"};
        restTemplate.delete("http://spring-clould-test-provider/service/deleteuser?id={0}&name={1}&phone={2}",arr);

        return "sucess";
    }



    @RequestMapping(value="/cloud/hystrix")
    @HystrixCommand(fallbackMethod = "error", ignoreExceptions = Exception.class, commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3500")})
    public String hystrix() {

      //  int  a=10/0;
        ResponseEntity<String> responseEntity =restTemplate.getForEntity("http://spring-clould-test-provider/service/hello", String.class);

        return  responseEntity.getBody();
    }

      public  String error(Throwable throwable){

        System.out.println("异常 ："+throwable.getMessage());
        return "TimeError";
    }

    @RequestMapping(value="/cloud/hystrix2")

    public String hystrix2() throws ExecutionException, InterruptedException {

        //  int  a=10/0;
        // ResponseEntity<String> responseEntity =restTemplate.getForEntity("http://spring-clould-test-provider/service/hello", String.class);
        MyHystrixCommand myHystrixCommand = new MyHystrixCommand(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")),restTemplate);
        //同步调用
      //  String str =myHystrixCommand.execute();

        //异步调用
        Future<String>  future= myHystrixCommand.queue();
        //处理业务逻辑
        Thread.sleep(3000);
        System.out.println("处理业务1完成");
        String str = future.get();

        System.out.println("处理业务2。。。。完成");

        //处理业务逻辑
        return  str;
    }
}
