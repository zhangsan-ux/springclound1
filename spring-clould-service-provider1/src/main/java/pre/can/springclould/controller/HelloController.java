package pre.can.springclould.controller;


import org.springframework.web.bind.annotation.*;
import pre.can.springclould.model.User;

@RestController
public class HelloController {

      @RequestMapping("/service/hello")
    public String hello(){
          System.out.println("Hello service provider 2");

         // int a= 10/0;
        return " Hello service provider 2";
    }


    @RequestMapping("/service/user")
    public User user(){
        System.out.println("Hello service provider 2");
        User myUser = new User();
        myUser.setId(18);
        myUser.setName("小明");
        myUser.setPhone("1234567");

        return myUser;
    }

    @RequestMapping("/service/getuser")
    public User getUser(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("phone") String
            phone){
        System.out.println("Hello service provider 2");
        User myUser = new User();
        myUser.setId(id);
        myUser.setName(name);
        myUser.setPhone(phone);

        return myUser;
    }

    @PostMapping("/service/adduser")
    public User adduser(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("phone") String
            phone){
        System.out.println("Hello service provider 2");
        User myUser = new User();
        myUser.setId(id);
        myUser.setName(name);
        myUser.setPhone(phone);

        return myUser;
    }

    @PutMapping("/service/updateuser")
    public User updateuser(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("phone") String
            phone){
        System.out.println("Hello service provider 2"+id+"--"+name+"--"+phone);
        User myUser = new User();
        myUser.setId(id);
        myUser.setName(name);
        myUser.setPhone(phone);

        return myUser;
    }

    @DeleteMapping("/service/deleteuser")
    public User deleteeuser(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("phone") String
            phone){
        System.out.println("Hello service provider 2。。。。。"+id+"--"+name+"--"+phone);
        User myUser = new User();
        myUser.setId(id);
        myUser.setName(name);
        myUser.setPhone(phone);

        return myUser;
    }




}
