package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.DingdanMapper;
import com.entity.Dingdan;
import com.server.DingdanServer;
@Service
public class DingdanServerImpi implements DingdanServer {
   @Resource
   private DingdanMapper gdao;
	@Override
	public int add(Dingdan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Dingdan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Dingdan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Dingdan> getsydingdan1(Map<String, Object> map) {
		return gdao.getsydingdan1(map);
	}
	public List<Dingdan> getsydingdan2(Map<String, Object> map) {
		return gdao.getsydingdan2(map);
	}
	public List<Dingdan> getsydingdan3(Map<String, Object> map) {
		return gdao.getsydingdan3(map);
	}
	
	@Override
	public Dingdan quchongDingdan(Map<String, Object> account) {
		return gdao.quchongDingdan(account);
	}

	@Override
	public List<Dingdan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Dingdan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Dingdan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

