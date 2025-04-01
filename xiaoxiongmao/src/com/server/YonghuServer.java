package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yonghu;

public interface YonghuServer {

  public int add(Yonghu po);

  public int update(Yonghu po);
  
  
  
  public int delete(int id);

  public List<Yonghu> getAll(Map<String,Object> map);
  public List<Yonghu> getsyyonghu1(Map<String,Object> map);
  public List<Yonghu> getsyyonghu2(Map<String,Object> map);
  public List<Yonghu> getsyyonghu3(Map<String,Object> map);
  public Yonghu quchongYonghu(Map<String, Object> acount);

  public Yonghu getById( int id);

  public List<Yonghu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yonghu> select(Map<String, Object> map);
}
//	所有List
