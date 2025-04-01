package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yonghu;

public interface YonghuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yonghu record);

    int insertSelective(Yonghu record);

    Yonghu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yonghu record);
	
    int updateByPrimaryKey(Yonghu record);
	public Yonghu quchongYonghu(Map<String, Object> yonghuming);
	public List<Yonghu> getAll(Map<String, Object> map);
	public List<Yonghu> getsyyonghu1(Map<String, Object> map);
	public List<Yonghu> getsyyonghu3(Map<String, Object> map);
	public List<Yonghu> getsyyonghu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yonghu> getByPage(Map<String, Object> map);
	public List<Yonghu> select(Map<String, Object> map);
//	所有List
}

