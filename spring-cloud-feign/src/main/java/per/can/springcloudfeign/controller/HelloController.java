package per.can.springcloudfeign.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.can.springcloudfeign.service.HelloService;

@RestController
public class HelloController {


    @Autowired
    private HelloService helloService;

    @RequestMapping("/web1/hello")
    public String Hello(){
        return  helloService.hello();
    }
}
