package cn.hhm.workbootstraptree.controller;

import cn.hhm.workbootstraptree.entity.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ming
 * @create 2018-06-12 13:51
 */
@Controller
public class SelectorController {

    @GetMapping("/selector")
    public String selector(HttpServletRequest request) {
        List<City> list = new ArrayList<>();

        list.add(new City(1,"北京"));
        list.add(new City(2,"南京"));
        list.add(new City(3,"天津"));
        list.add(new City(4,"安徽"));
        list.add(new City(5,"河北"));
        list.add(new City(6,"河南"));
        list.add(new City(7,"上海"));
        request.setAttribute("list", list);

        return "selector";
    }


}
