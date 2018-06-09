package cn.hhm.workshiro.config;

import cn.hhm.workshiro.entity.SysPermission;
import cn.hhm.workshiro.entity.SysRole;
import cn.hhm.workshiro.entity.UserInfo;
import cn.hhm.workshiro.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ming
 * @create 2018-04-27 16:55
 */
public class MyShiroRealm extends AuthorizingRealm {

    private Logger log = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        log.error("MyShiroRealm...doGetAuthorizationInfo()...授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();

        for (SysRole sysRole:userInfo.getRoles()) {
            info.addRole(sysRole.getRole());
            for (SysPermission sysPermission:sysRole.getPermissions()) {
                info.addStringPermission(sysPermission.getPermission());
            }
        }
        return info;
    }

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
        System.out.println(authenticationToken.getCredentials());
        UserInfo userInfo = userInfoService.findByUsername(username);
        if (userInfo == null){
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo,userInfo.getPasswrod(),
                getName()
        );
        return authenticationInfo;
    }
}
