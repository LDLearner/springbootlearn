package com.lidong.springbootlearn.Get;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 返回一个cookies的get请求接口
 */
@RestController
@Api(value = "/", description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到cookies", httpMethod = "Get")
    public String getCookies(HttpServletResponse response) {
        //HttpServletRequest  装请求信息的类
        //HttpServletResponse  装响应信息的类  是一个类，不是参数
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功！";
    }

    /**
     * 要求客户端带cookies访问
     */
    @RequestMapping(value = "get/with/cookies", method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端带cookies访问", httpMethod = "Get")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你必须携带一个cookie！";
        }
        for (Cookie cookie : cookies) {

            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {

                return "恭喜你访问成功！";

            } else {
                return "你的cookie值错误";
            }

        }


        return "你必须携带一个cookie！";
    }

    /**
     * 开发一个需要携带参数的get 请求
     * 第一种实现方式 url: key=value&key=value
     * 模拟获取商品列表
     */

    @RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
    @ApiOperation(value = "开发一个需要携带参数的get 请求， url: key=value&key=value", httpMethod = "GET")
    public Map<String, Integer> getList(@RequestParam Integer start, @RequestParam Integer end) {

        Map<String, Integer> mylist = new HashMap<>();
        mylist.put("鞋", 400);
        mylist.put("衬衫", 300);
        mylist.put("裤子", 400);
        return mylist;
    }

    /**
     * 第二种需要携带参数访问的get请求
     * url: ip:port/get/with/param/10/20  http://127.0.0.1:8080/get/with/param/10/20
     */

    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value = "开发一个需要携带参数的get 请求， url: ip:port/get/with/param/10/20", httpMethod = "GET")
    public Map myGetList(@PathVariable Integer start, @PathVariable Integer end) {

        Map<String, Integer> mylist = new HashMap<>();
        mylist.put("鞋", 400);
        mylist.put("衬衫", 300);
        mylist.put("裤子", 400);
        return mylist;
    }
}
