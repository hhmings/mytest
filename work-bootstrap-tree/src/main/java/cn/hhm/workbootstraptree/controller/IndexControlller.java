package cn.hhm.workbootstraptree.controller;

import cn.hhm.workbootstraptree.entity.Nodes;
import cn.hhm.workbootstraptree.sercice.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Ming
 * @create 2018-04-20 9:04
 */
@Controller
public class IndexControlller {

    @Autowired
    private NodeService nodeService;

    @GetMapping("/index1")
    public String index(){
        return "index1";
    }
    @GetMapping("/index2")
    public String index2(){
        return "index2";
    }


    @GetMapping("/node")
    @ResponseBody
    public List<Nodes> getNode(){
        List<Nodes> list = nodeService.getNode();
        System.out.println(list);
        return list;
    }


}
