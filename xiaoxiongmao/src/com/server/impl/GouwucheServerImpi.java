package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GouwucheMapper;
import com.entity.Gouwuche;
import com.server.GouwucheServer;
@Service
public class GouwucheServerImpi implements GouwucheServer {
   @Resource
   private GouwucheMapper gdao;
	@Override
	public int add(Gouwuche po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Gouwuche po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Gouwuche> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Gouwuche> getsygouwuche1(Map<String, Object> map) {
		return gdao.getsygouwuche1(map);
	}
	public List<Gouwuche> getsygouwuche2(Map<String, Object> map) {
		return gdao.getsygouwuche2(map);
	}
	public List<Gouwuche> getsygouwuche3(Map<String, Object> map) {
		return gdao.getsygouwuche3(map);
	}
	
	@Override
	public Gouwuche quchongGouwuche(Map<String, Object> account) {
		return gdao.quchongGouwuche(account);
	}

	@Override
	public List<Gouwuche> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Gouwuche> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Gouwuche getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

