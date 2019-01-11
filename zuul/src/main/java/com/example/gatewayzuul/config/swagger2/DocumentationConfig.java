package com.example.gatewayzuul.config.swagger2;

import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//添加文档来源
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {
    private final RouteLocator routeLocator;

    public DocumentationConfig(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    @Override
    public List<SwaggerResource> get() {
        //TODO 判断是否有权限码 权限加解密
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String permissionId = request.getParameter("permissionId");

        List<SwaggerResource> resources = new ArrayList<>();
        List<Route> routes = routeLocator.getRoutes();
        for (Route route : routes) {
            resources.add(setSwaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs?group=miya&permissionId=" + permissionId), "0.1"));
        }
        return resources;
    }

    /**
     * @param name     随便写
     * @param location zuul yml中配置的服务路径+/v2/api-docs，如果有组要加上group=xxxx
     * @param version  版本
     * @return
     */
    private SwaggerResource setSwaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

}
