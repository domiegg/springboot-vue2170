package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Dingdan;
import com.server.DingdanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class DingdanController {
	@Resource
	private DingdanServer dingdanService;


   
	@RequestMapping("addDingdan.do")
	public String addDingdan(HttpServletRequest request,Dingdan dingdan,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		dingdan.setAddtime(time.toString().substring(0, 19));
		dingdanService.add(dingdan);
		
		String sql="";
		String sql2="";
			sql="update gouwuche set issh='是' where goumairen='"+(String)request.getSession().getAttribute("username")+"'";
			sql2="update yonghu set jifen=jifen+"+dingdan.getZongjine()+"    where   yonghuming='"+(String)request.getSession().getAttribute("username")+"'";
			
			db dbo = new db();
			dbo.hsgexecute(sql);
				dbo.hsgexecute(sql2);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "dingdanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:dingdanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateDingdan.do")
	public String doUpdateDingdan(int id,ModelMap map,Dingdan dingdan){
		dingdan=dingdanService.getById(id);
		map.put("dingdan", dingdan);
		return "dingdan_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("dingdanDetail.do")
	public String dingdanDetail(int id,ModelMap map,Dingdan dingdan){
		dingdan=dingdanService.getById(id);
		map.put("dingdan", dingdan);
		return "dingdan_detail";
	}
//	前台详细
	@RequestMapping("ddDetail.do")
	public String ddDetail(int id,ModelMap map,Dingdan dingdan){
		dingdan=dingdanService.getById(id);
		map.put("dingdan", dingdan);
		return "dingdandetail";
	}
//	
	@RequestMapping("updateDingdan.do")
	public String updateDingdan(int id,ModelMap map,Dingdan dingdan,HttpServletRequest request,HttpSession session){
		dingdanService.update(dingdan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:dingdanList.do";
	}

//	分页查询
	@RequestMapping("dingdanList.do")
	public String dingdanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdan dingdan, String dingdanbianhao, String neirong, String goumairen, String zongjine, String lianxishouji, String songhuodizhi, String beizhu, String issh,String iszf){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		if(zongjine==null||zongjine.equals("")){pmap.put("zongjine", null);}else{pmap.put("zongjine", zongjine);}
		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}
		if(songhuodizhi==null||songhuodizhi.equals("")){pmap.put("songhuodizhi", null);}else{pmap.put("songhuodizhi", songhuodizhi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=dingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdan> list=dingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdan_list";
	}
	
	@RequestMapping("dingdanList2.do")
	public String dingdanList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdan dingdan, String dingdanbianhao, String neirong, String goumairen, String zongjine, String lianxishouji, String songhuodizhi, String beizhu, String iszf,String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("goumairen", (String)request.getSession().getAttribute("username"));
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}
		if(zongjine==null||zongjine.equals("")){pmap.put("zongjine", null);}else{pmap.put("zongjine", zongjine);}
		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}
		if(songhuodizhi==null||songhuodizhi.equals("")){pmap.put("songhuodizhi", null);}else{pmap.put("songhuodizhi", songhuodizhi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		
		int total=dingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdan> list=dingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdan_list2";
	}
	
	
	@RequestMapping("ddList.do")
	public String ddList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdan dingdan, String dingdanbianhao, String neirong, String goumairen, String zongjine, String lianxishouji, String songhuodizhi, String beizhu, String iszf,String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		if(zongjine==null||zongjine.equals("")){pmap.put("zongjine", null);}else{pmap.put("zongjine", zongjine);}
		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}
		if(songhuodizhi==null||songhuodizhi.equals("")){pmap.put("songhuodizhi", null);}else{pmap.put("songhuodizhi", songhuodizhi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=dingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdan> list=dingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdanlist";
	}
	
	@RequestMapping("deleteDingdan.do")
	public String deleteDingdan(int id,HttpServletRequest request){
		dingdanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:dingdanList.do";
	}
	
	
}
