package per.can.springcloudapigate.cotroller;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandlerController  implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }
    @RequestMapping("/error")
    public Object error(){
        RequestContext ctx = RequestContext.getCurrentContext();
        ZuulException exception = (ZuulException)ctx.getThrowable();
        return exception.nStatusCode + "--" + exception.getMessage();
    }

}
