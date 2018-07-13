package com.hhm.workshirodemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Ming
 * @create 2018-07-12 16:06
 */
@Controller
public class SysMoneyController {

    @GetMapping("/money/page")
    public String moneyPage(){
        return "money_list";
    }
}
