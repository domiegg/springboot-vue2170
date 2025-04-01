package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YonghuMapper;
import com.entity.Yonghu;
import com.server.YonghuServer;
@Service
public class YonghuServerImpi implements YonghuServer {
   @Resource
   private YonghuMapper gdao;
	@Override
	public int add(Yonghu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yonghu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yonghu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yonghu> getsyyonghu1(Map<String, Object> map) {
		return gdao.getsyyonghu1(map);
	}
	public List<Yonghu> getsyyonghu2(Map<String, Object> map) {
		return gdao.getsyyonghu2(map);
	}
	public List<Yonghu> getsyyonghu3(Map<String, Object> map) {
		return gdao.getsyyonghu3(map);
	}
	
	@Override
	public Yonghu quchongYonghu(Map<String, Object> account) {
		return gdao.quchongYonghu(account);
	}

	@Override
	public List<Yonghu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yonghu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yonghu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

