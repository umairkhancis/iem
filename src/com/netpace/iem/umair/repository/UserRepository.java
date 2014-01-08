package com.netpace.iem.umair.repository;

import org.springframework.data.jpa.repository.Query;

import com.netpace.iem.umair.model.User;

public interface UserRepository extends BaseRepository<User, Integer> {
	
	@Query("Select u From User u Where u.username=?1 and u.password=?2")
	User validate(String username, String password);
	
}
