package per.can.springcloudapigate.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest httpRequest = requestContext.getRequest();
        String token = httpRequest.getParameter("token");
        if (token == null) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);

            requestContext.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
            requestContext.setResponseBody("非法访问");

        }
        return null;
}

    }
