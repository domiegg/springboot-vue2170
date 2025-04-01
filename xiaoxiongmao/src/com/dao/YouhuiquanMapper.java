package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Youhuiquan;

public interface YouhuiquanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Youhuiquan record);

    int insertSelective(Youhuiquan record);

    Youhuiquan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Youhuiquan record);
	
    int updateByPrimaryKey(Youhuiquan record);
	public Youhuiquan quchongYouhuiquan(Map<String, Object> yonghu);
	public List<Youhuiquan> getAll(Map<String, Object> map);
	public List<Youhuiquan> getsyyouhuiquan1(Map<String, Object> map);
	public List<Youhuiquan> getsyyouhuiquan3(Map<String, Object> map);
	public List<Youhuiquan> getsyyouhuiquan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Youhuiquan> getByPage(Map<String, Object> map);
	public List<Youhuiquan> select(Map<String, Object> map);
//	所有List
}

