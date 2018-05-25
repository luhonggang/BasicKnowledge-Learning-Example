package com.study.mapper;

import java.util.List;

import com.study.entity.UserEntity;
import com.study.param.UserParam;

public interface UserMapper {

	List<UserEntity> getAll();

	List<UserEntity> getList(UserParam userParam);

	int getCount(UserParam userParam);

	UserEntity getOne(Long id);

	void insert(UserEntity user);

	int update(UserEntity user);

	int delete(Long id);

}