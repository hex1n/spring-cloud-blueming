package com.dlwlrma.blueming.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:hex1n
 * @Date:2020/1/19 10:43
 */
public class TokenFilter extends ZuulFilter {
    /**
     * 过滤器类型,它决定过滤器在请求的那个生命周期中执行.
     * 这里定义为pre,代表会在请求被路由之前执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filter执行顺序,通过数字指定
     * 数字越大,优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要执行.这里我们直接返回true,因此该过滤器对所有请求都会生效
     * 实际运用中我们可以利用改函数来指定过滤器的有效范围
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            ctx.setResponseBody("token is empty");
        }
        return null;
    }
}
