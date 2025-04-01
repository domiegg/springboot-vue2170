package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YouhuiquanMapper;
import com.entity.Youhuiquan;
import com.server.YouhuiquanServer;
@Service
public class YouhuiquanServerImpi implements YouhuiquanServer {
   @Resource
   private YouhuiquanMapper gdao;
	@Override
	public int add(Youhuiquan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Youhuiquan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Youhuiquan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Youhuiquan> getsyyouhuiquan1(Map<String, Object> map) {
		return gdao.getsyyouhuiquan1(map);
	}
	public List<Youhuiquan> getsyyouhuiquan2(Map<String, Object> map) {
		return gdao.getsyyouhuiquan2(map);
	}
	public List<Youhuiquan> getsyyouhuiquan3(Map<String, Object> map) {
		return gdao.getsyyouhuiquan3(map);
	}
	
	@Override
	public Youhuiquan quchongYouhuiquan(Map<String, Object> account) {
		return gdao.quchongYouhuiquan(account);
	}

	@Override
	public List<Youhuiquan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Youhuiquan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Youhuiquan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

