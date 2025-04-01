package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Dingdan;

public interface DingdanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dingdan record);

    int insertSelective(Dingdan record);

    Dingdan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dingdan record);
	
    int updateByPrimaryKey(Dingdan record);
	public Dingdan quchongDingdan(Map<String, Object> goumairen);
	public List<Dingdan> getAll(Map<String, Object> map);
	public List<Dingdan> getsydingdan1(Map<String, Object> map);
	public List<Dingdan> getsydingdan3(Map<String, Object> map);
	public List<Dingdan> getsydingdan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Dingdan> getByPage(Map<String, Object> map);
	public List<Dingdan> select(Map<String, Object> map);
//	所有List
}

