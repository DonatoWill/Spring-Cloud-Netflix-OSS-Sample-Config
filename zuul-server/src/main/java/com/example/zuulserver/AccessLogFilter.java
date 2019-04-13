package com.example.zuulserver;

import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import io.micrometer.core.instrument.util.IOUtils;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;


@Component
public class AccessLogFilter extends ZuulFilter{

    private static org.slf4j.Logger log =
            LoggerFactory.getLogger(AccessLogFilter.class);

    @Override
    public String filterType() {
        return "post";
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
    public Object run(){

        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();

        log.info("http-method = " + request.getMethod() + "\n" +
                 "user-ip = " + request.getRemoteAddr() + "\n" +
                 "body = " + extractPostRequestBody(request)+ "\n" +
                 "url = " + request.getRequestURL() + "\n" +
                 "response-body = " + RequestContext.getCurrentContext().getResponseBody() + "\n" +
                 "response-status = " + response.getStatus());


        return null;
    }

    private String extractPostRequestBody(HttpServletRequest request) {

        String value = "";

        if(!Http.HttpMethod.GET.name().equalsIgnoreCase(request.getMethod())
                && request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)){
            try{
                value = IOUtils.toString(request.getInputStream(), Charset.forName("UTF-8"));
            }catch (IOException e){
                log.error("error on parse body request: ", e);
            }
        }else{
            value = "body to large";
        }
        return value;

    }
}
