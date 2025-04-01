package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Gouwuche;

public interface GouwucheMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gouwuche record);

    int insertSelective(Gouwuche record);

    Gouwuche selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gouwuche record);
	
    int updateByPrimaryKey(Gouwuche record);
	public Gouwuche quchongGouwuche(Map<String, Object> goumairen);
	public List<Gouwuche> getAll(Map<String, Object> map);
	public List<Gouwuche> getsygouwuche1(Map<String, Object> map);
	public List<Gouwuche> getsygouwuche3(Map<String, Object> map);
	public List<Gouwuche> getsygouwuche2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Gouwuche> getByPage(Map<String, Object> map);
	public List<Gouwuche> select(Map<String, Object> map);
//	所有List
}

