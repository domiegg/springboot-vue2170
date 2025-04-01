package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Gouwuche;

public interface GouwucheServer {

  public int add(Gouwuche po);

  public int update(Gouwuche po);
  
  
  
  public int delete(int id);

  public List<Gouwuche> getAll(Map<String,Object> map);
  public List<Gouwuche> getsygouwuche1(Map<String,Object> map);
  public List<Gouwuche> getsygouwuche2(Map<String,Object> map);
  public List<Gouwuche> getsygouwuche3(Map<String,Object> map);
  public Gouwuche quchongGouwuche(Map<String, Object> acount);

  public Gouwuche getById( int id);

  public List<Gouwuche> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Gouwuche> select(Map<String, Object> map);
}
//	所有List
