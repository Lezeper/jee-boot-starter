package com.imlewis.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import com.imlewis.model.User;

@Transactional
public interface UserDao extends CrudRepository<User, Long>{
	User findByEmail(String email);
	
}
