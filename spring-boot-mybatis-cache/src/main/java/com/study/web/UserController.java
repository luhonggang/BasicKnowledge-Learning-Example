package com.study.web;

import java.util.List;

import com.study.param.UserParam;
import com.study.result.Page;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.UserEntity;
import com.study.mapper.UserMapper;

import javax.annotation.Resource;

@RestController
public class UserController {
    private static Logger log = Logger.getLogger(UserController.class);
	
	@Resource
	private UserMapper userMapper;
	
	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
	    long startTime = System.currentTimeMillis();
		List<UserEntity> users=userMapper.getAll();
		long endTime = System.currentTimeMillis();
        System.out.println(" ++++++ 耗时 : "+(endTime - startTime) +" 毫秒 ++++++ ");
		return users;
	}

    @RequestMapping("/getList")
    public Page<UserEntity> getList(UserParam userParam) {
        long startTime = System.currentTimeMillis();
        List<UserEntity> users=userMapper.getList(userParam);
        long start2Time = System.currentTimeMillis();
        System.out.println("------> 二级缓存耗时 : "+(start2Time - startTime)+ " 毫秒 <------");
        long count=userMapper.getCount(userParam);
        Page page = new Page(userParam,count,users);
        long endTime = System.currentTimeMillis();
        System.out.println(" ++++++ 耗时 : "+(endTime - startTime) +" 毫秒 ++++++ ");
        return page;
    }
	
    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
    	UserEntity user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(UserEntity user) {
    	userMapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(UserEntity user) {
    	userMapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }
    
    
}