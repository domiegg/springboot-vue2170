package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Dingdan;

public interface DingdanServer {

  public int add(Dingdan po);

  public int update(Dingdan po);
  
  
  
  public int delete(int id);

  public List<Dingdan> getAll(Map<String,Object> map);
  public List<Dingdan> getsydingdan1(Map<String,Object> map);
  public List<Dingdan> getsydingdan2(Map<String,Object> map);
  public List<Dingdan> getsydingdan3(Map<String,Object> map);
  public Dingdan quchongDingdan(Map<String, Object> acount);

  public Dingdan getById( int id);

  public List<Dingdan> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Dingdan> select(Map<String, Object> map);
}
//	所有List
