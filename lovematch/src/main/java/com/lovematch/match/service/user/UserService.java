package com.lovematch.match.service.user;

import com.lovematch.match.jpa.entity.User;
import com.lovematch.match.service.BaseService;

public interface UserService extends BaseService<User> {
	User findByNameAndPwd(String name,String pwd);
	User findByName(String name);
}
