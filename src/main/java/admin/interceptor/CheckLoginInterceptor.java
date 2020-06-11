package admin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @program: SpringMVC
 * @description: 登录拦截器
 * @author: Defend
 * @create: 2020-06-08 17:43
 **/
public class CheckLoginInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String requestUrl = request.getRequestURI();

        if(requestUrl.endsWith("login.ftl"))
        {
            return true;
        }

        String session = String.valueOf(WebUtils.getSessionAttribute(request, "userId"));
        String session1 = String.valueOf(WebUtils.getSessionAttribute(request, "student"));

        if("null".equals(session) || "null".equals(session1))
        {
            if(request.getHeader("x-requested-with")!=null)
            {
                response.setHeader("sessionstatus", "timeout");
            }
        }
        else
        {
            return true;
        }

        System.out.println(requestUrl);
        System.out.println(request);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {

    }
}
