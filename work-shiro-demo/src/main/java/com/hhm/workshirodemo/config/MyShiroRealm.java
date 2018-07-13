package com.hhm.workshirodemo.config;

import com.hhm.workshirodemo.dao.SysUserMapper;
import com.hhm.workshirodemo.domain.SysPermission;
import com.hhm.workshirodemo.domain.UserInfo;
import com.hhm.workshirodemo.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author Ming
 * @create 2018-04-27 16:55
 */
public class MyShiroRealm extends AuthorizingRealm {

    private Logger log = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserMapper sysUserMapper;


    /**
     * 进行身份认证，用户名或者密码是否正确
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {

        log.error("MyShiroRealm...doGetAuthorizationInfo()...身份认证");

        //获取用户输入的账号
        String username = (String) authenticationToken.getPrincipal();
        UserInfo userInfo = sysUserMapper.selectUserInfo(username);
        if (userInfo == null) {
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, userInfo.getPasswd(),
                getName()
        );
        return authenticationInfo;
    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        log.error("MyShiroRealm...doGetAuthorizationInfo()...授权");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        List<SysPermission> list = sysUserMapper.selectSysPermissionList(userInfo.getUid());

        if (list != null && list.size() > 0) {
            list.stream().forEach(sysPermission -> {
                if (!StringUtils.isEmpty(sysPermission.getPermissions())) {
                    info.addStringPermission(sysPermission.getPermissions());
                }
            });
        }
        return info;
    }

    /**
     * 清除当前用户的权限
     */
    public void clearCurrentUserAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }

    public void clearAllUserAuthorizationInfo() {


        Object authorizationCacheKey = getAuthorizationCacheKey(SecurityUtils.getSubject().getPrincipals());

        log.error("当前用户缓存 key = " + authorizationCacheKey);

        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        if (cache != null) {
            for (Object key : cache.keys()) {
                log.error("授权 key = " + key);
                log.error("授权haha......." + key + "--" + key.toString());
                cache.remove(key);
            }
        }
    }


}
