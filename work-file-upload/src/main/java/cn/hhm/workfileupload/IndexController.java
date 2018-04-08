package cn.hhm.workfileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @outhor Ming
 * @create 2018-04-03 9:37
 */
@Controller
public class IndexController {

    @GetMapping("/file")
    public String index(){
        return "file";
    }

}
