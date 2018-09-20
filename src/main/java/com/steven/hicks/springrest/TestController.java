package com.steven.hicks.springrest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController
{

    @RequestMapping("/")
    public String home()
    {
        return "index.html";
    }

}
