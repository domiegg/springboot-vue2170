package com.controller;

import java.io.File;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.entity.Xinwentongzhi;
import com.entity.Yonghuzhuce;
import com.entity.Yonghu;import com.entity.Shangpinxinxi;import com.entity.Gouwuche;//jixacxishxu1

import com.server.XinwentongzhiServer;
import com.server.YonghuzhuceServer;
import com.server.YonghuServer;import com.server.ShangpinxinxiServer;import com.server.GouwucheServer;//jixacxishxu2

import com.util.PageBean;

@Controller
public class IndexController {
	
	
	@Resource
	private XinwentongzhiServer xinwentongzhiService;
	@Resource
	private YonghuzhuceServer yonghuzhuceServer;
	@Resource	private YonghuServer yonghuServer;	@Resource	private ShangpinxinxiServer shangpinxinxiServer;	@Resource	private GouwucheServer gouwucheServer;	//jixacxishxu3
	
	
	
//	首页显示内容
	@RequestMapping("index.do")
	public String showIndex(ModelMap map){

		List<Xinwentongzhi> syxinwentongzhi1=xinwentongzhiService.getsyxinwentongzhi1(null);
		List<Xinwentongzhi> syxinwentongzhi2=xinwentongzhiService.getsyxinwentongzhi2(null);
		List<Xinwentongzhi> syxinwentongzhi3=xinwentongzhiService.getsyxinwentongzhi3(null);

		List<Yonghuzhuce> syyonghuzhuce1=yonghuzhuceServer.getsyyonghuzhuce1(null);
		List<Yonghu> syyonghu1=yonghuServer.getsyyonghu1(null);		List<Yonghu> syyonghu2=yonghuServer.getsyyonghu2(null);		List<Yonghu> syyonghu3=yonghuServer.getsyyonghu3(null);		List<Shangpinxinxi> syshangpinxinxi1=shangpinxinxiServer.getsyshangpinxinxi1(null);		List<Shangpinxinxi> syshangpinxinxi2=shangpinxinxiServer.getsyshangpinxinxi2(null);		List<Shangpinxinxi> syshangpinxinxi3=shangpinxinxiServer.getsyshangpinxinxi3(null);		List<Gouwuche> sygouwuche1=gouwucheServer.getsygouwuche1(null);		List<Gouwuche> sygouwuche2=gouwucheServer.getsygouwuche2(null);		List<Gouwuche> sygouwuche3=gouwucheServer.getsygouwuche3(null);		//jixacxishxu4
		
	    map.put("syxinwentongzhi1", syxinwentongzhi1);
	    map.put("syxinwentongzhi2", syxinwentongzhi2);
	    map.put("syxinwentongzhi3", syxinwentongzhi3);
	    map.put("syyonghuzhuce1", syyonghuzhuce1);
	    map.put("syyonghu1", syyonghu1);	    map.put("syyonghu2", syyonghu2);	    map.put("syyonghu3", syyonghu3);	    map.put("syshangpinxinxi1", syshangpinxinxi1);	    map.put("syshangpinxinxi2", syshangpinxinxi2);	    map.put("syshangpinxinxi3", syshangpinxinxi3);	    map.put("sygouwuche1", sygouwuche1);	    map.put("sygouwuche2", sygouwuche2);	    map.put("sygouwuche3", sygouwuche3);	    //jixacxishxu5

		return "default";
	}

	

	
}
