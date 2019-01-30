package com.example.gatewayzuul.filter;

import com.example.gatewayzuul.model.ErrorCode;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Component//开发时可注释掉过滤器
public class PermissionIdFilter extends ZuulFilter {
    /**
     * 过滤器类型
     * pre：可以在请求被路由之前调用
     * route：在路由请求时候被调用
     * post：在route和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行的顺序
     * 当一个请求在同一个阶段的时候存在多个过滤器，多个过滤器的执行顺序
     *
     * @return int值来定义过滤器的执行顺序，优先级为0，数值越小优先级越高
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    /**
     * 判断过滤器是否生效
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //TODO 可根据实际情况填写，默认过滤所有请求
        return true;

        /*
        //具体情况举例：只过滤POST 请求
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if(request.getMethod().equals(RequestMethod.POST.name())){
            return true;
        }
        return false;*/
    }

    /**
     * 依据实际情况编写过滤器拦截业务逻辑代码
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //案例：拦截所有的服务接口，判断服务接口上是否传递userToken参数

        //1.获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();

        //2.获取Request
        HttpServletRequest request = currentContext.getRequest();
        //3.获取加密权限码
        String permissionId = request.getParameter("permissionId");
        if (StringUtils.isEmpty(permissionId)) {
            //todo 加解密 进行数据库对比 看permissionid在数据库有没有配置
            //不会继续执行。。。
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("no permission");
            currentContext.setResponseStatusCode(ErrorCode.FORBIDDEN);
            return null;
        }
        return null;
    }

}
