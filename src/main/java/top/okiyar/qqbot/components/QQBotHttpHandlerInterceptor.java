package top.okiyar.qqbot.components;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.okiyar.qqbot.QQBot;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * QQBot Http 请求拦截器
 */
public class QQBotHttpHandlerInterceptor implements HandlerInterceptor {

    private QQBot qqBot;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, String> map = new HashMap<>();
        // 验证请求头
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ":" + request.getHeader(headerName));
        }

        ServletInputStream is = request.getInputStream();

        System.out.println(is.isFinished());

        int len = 0;
        byte[] bytes = new byte[1024];
        StringBuilder buffer = new StringBuilder();
        while ((len = is.read(bytes)) != -1) {
            buffer.append(new String(bytes, 0, len));
        }
        System.out.println(buffer.toString());
        response.setStatus(HttpServletResponse.SC_OK);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行afterCompletion");
    }
}
