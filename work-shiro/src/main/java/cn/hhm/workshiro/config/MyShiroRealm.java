package cn.hhm.workshiro.config;

import cn.hhm.workshiro.entity.UserInfo;
import cn.hhm.workshiro.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ming
 * @create 2018-04-27 16:55
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        return null;
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
        //获取用户输入的账号
        String username = (String) authenticationToken.getPrincipal();
        System.out.println(authenticationToken.getCredentials());
        UserInfo userInfo = userInfoService.findByUsername(username);
        System.out.println("userInfo:"+userInfo.getName());
        if (userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo,userInfo.getPasswrod(),
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
                getName()
        );
        return authenticationInfo;
    }
}
