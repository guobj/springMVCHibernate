package com.gbj.example.AuthorizingRealm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

@Service
public class AuthorRealm extends AuthorizingRealm {

	/***
	  * 获取授权信息
	  */
	//根据自己系统规则的需要编写获取授权信息，这里为了快速入门只获取了用户对应角色的资源url信息
	//该方法的调用时机是前面有需要授权资源的请求时，比如前台验证某角色是否有改权限
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

		System.out.println("AuthorizationInfo");
		return null;
	}

	//该方法的调用时机为controller层里面的login方法  shiro自动封装的登录方法就会跳到这个方法
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

		System.out.println("AuthenticationInfo");
		return null;
	}
}
