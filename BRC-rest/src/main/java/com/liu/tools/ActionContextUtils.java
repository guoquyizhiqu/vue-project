package com.liu.tools;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * Created by xing on 2018/4/23.
 */
public class ActionContextUtils {

    /**
     * 获取指定的键所对应的对象的值 的第一个字符串。<br>
     * 对应HttpServletRequest对象中的request.getParameterMap()方法。
     *
     * @param key
     *            指定的键
     * @return 指定的键所映射到的值的第一个字符串
     */
    public static String getParameter(String key) {
        HttpServletRequest request = getRequest();
        return request.getParameter(key);
    }

    /**
     * 获取HttpServletRequest对象。
     *
     * @return HttpServletRequest对象
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();;
        return request;
    }
}
