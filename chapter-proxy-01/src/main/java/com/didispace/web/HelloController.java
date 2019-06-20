package com.didispace.web;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/5/19 下午1:27.
 * @blog http://blog.didispace.com
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @Async
    public String hello(@RequestParam String name) {
        System.out.println(" ++++++++++ call hello() ++++++++++ 方法");
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    @Async
    public String hello2(@RequestParam String name) {
        System.out.println(" ++++++++++ call hello2() ++++++++++ 方法");
        return "Hello2 " + name;
    }
}
