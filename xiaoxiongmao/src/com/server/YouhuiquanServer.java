package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Youhuiquan;

public interface YouhuiquanServer {

  public int add(Youhuiquan po);

  public int update(Youhuiquan po);
  
  
  
  public int delete(int id);

  public List<Youhuiquan> getAll(Map<String,Object> map);
  public List<Youhuiquan> getsyyouhuiquan1(Map<String,Object> map);
  public List<Youhuiquan> getsyyouhuiquan2(Map<String,Object> map);
  public List<Youhuiquan> getsyyouhuiquan3(Map<String,Object> map);
  public Youhuiquan quchongYouhuiquan(Map<String, Object> acount);

  public Youhuiquan getById( int id);

  public List<Youhuiquan> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Youhuiquan> select(Map<String, Object> map);
}
//	所有List
