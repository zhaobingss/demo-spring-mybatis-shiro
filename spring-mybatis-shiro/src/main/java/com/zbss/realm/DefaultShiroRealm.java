package com.zbss.realm;

import com.zbss.dao.impl.UserDao;
import com.zbss.entity.User;
import com.zbss.util.PasswordUtils;
import com.zbss.util.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhaobing on 2017/7/3.
 */
public class DefaultShiroRealm extends AuthorizingRealm{

	@Autowired
	private UserDao userDao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 为当前登录的Subject授予角色和权限
	 * 经测试:本例中该方法的调用时机为需授权资源被访问时
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String username = (String) getAvailablePrincipal(principalCollection);
		if (!StringUtils.isEmpty(username)){
			SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
			simpleAuthorInfo.addRole("admin");
			simpleAuthorInfo.addStringPermission("admin:manage");
			return simpleAuthorInfo;
		}

		return null;
	}


	/**
	 * 验证当前登录的Subject
	 * 经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;

		String userName = token.getUsername();
		String userPass = new String(token.getPassword());

		List<User> list = null;
		try {
			list = userDao.selectByName(userName);
		} catch (Exception e) {
			logger.error("Get user error:"+e.getMessage());
		}

		if (null == list || list.isEmpty()){
			throw new UnknownAccountException();
		}

		String up = PasswordUtils.encrypt(userName, userPass);
		User user = new User();
		user.setUserName(userName);
		user.setUserPass(up);

		User u = null;
		try {
			u = userDao.selectByNameAndPassword(user);
		} catch (Exception e) {
			logger.error("Get user error:"+e.getMessage());
		}

		if (null != u){
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(userName, userPass, getName());
			return authcInfo;
		}else {
			throw new IncorrectCredentialsException();
		}
	}
}
