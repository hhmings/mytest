package com.hhm.workshirodemo.web;

import com.hhm.workshirodemo.config.MyShiroRealm;
import com.hhm.workshirodemo.dao.RolePermissionMapper;
import com.hhm.workshirodemo.domain.SysMsg;
import com.hhm.workshirodemo.domain.UserInfo;
import com.hhm.workshirodemo.service.SysMsgService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Ming
 * @create 2018-07-12 15:10
 */
@Controller
@RequestMapping("/msg")
public class SysMsgController {
    @Autowired
    private SysMsgService sysMsgService;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @GetMapping("/page")
    @RequiresPermissions("sys:msg:msg")
    public String msgPage(HttpServletRequest request) {
        List<SysMsg> msgList = sysMsgService.selectMsgList();
        request.setAttribute("msgList", msgList);
        return "msg_list";
    }

    @RequiresPermissions("sys:msg:add")
    @RequestMapping("/add")
    @ResponseBody
    public String msgAdd() {
        System.out.println("信息添加.......");
        return "ok";
    }

    @RequiresPermissions("sys:msg:edit")
    @GetMapping("/edit")
    @ResponseBody
    public String msgEdit() {
        System.out.println("信息编辑.......");
        return "ok";
    }

    @RequiresPermissions("sys:msg:del")
    @GetMapping("/del")
    @ResponseBody
    public String msgDel() {

        try {
            System.out.println("信息删除.......修改权限");
            rolePermissionMapper.updateInfo(15);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RealmSecurityManager realmSecurityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        MyShiroRealm realm = (MyShiroRealm) realmSecurityManager.getRealms().iterator().next();
        realm.clearAllUserAuthorizationInfo();

        return "ok";
    }

}
