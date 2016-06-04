package com.imlewis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imlewis.model.Role;
import com.imlewis.model.User;
import com.imlewis.repository.RoleDao;
import com.imlewis.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public void save(User user) {
    	user.setEnabled(true);
    	if(user.getUserId() == 0){
    		Role role = new Role();
        	role.setEmail(user.getEmail());
        	role.setAuthority("ROLE_USER");
        	role.setUser(user);
        	userDao.save(user);
        	roleDao.save(role);
    	}else{
    		userDao.save(user);
    	}
    }
}
