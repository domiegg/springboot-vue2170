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

import com.entity.Gouwuche;
import com.server.GouwucheServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class GouwucheController {
	@Resource
	private GouwucheServer gouwucheService;


   
	@RequestMapping("addGouwuche.do")
	public String addGouwuche(HttpServletRequest request,Gouwuche gouwuche,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		gouwuche.setAddtime(time.toString().substring(0, 19));
		gouwucheService.add(gouwuche);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "gouwucheList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:gouwucheList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateGouwuche.do")
	public String doUpdateGouwuche(int id,ModelMap map,Gouwuche gouwuche){
		gouwuche=gouwucheService.getById(id);
		map.put("gouwuche", gouwuche);
		return "gouwuche_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("gouwucheDetail.do")
	public String gouwucheDetail(int id,ModelMap map,Gouwuche gouwuche){
		gouwuche=gouwucheService.getById(id);
		map.put("gouwuche", gouwuche);
		return "gouwuche_detail";
	}
//	前台详细
	@RequestMapping("gwcDetail.do")
	public String gwcDetail(int id,ModelMap map,Gouwuche gouwuche){
		gouwuche=gouwucheService.getById(id);
		map.put("gouwuche", gouwuche);
		return "gouwuchedetail";
	}
//	
	@RequestMapping("updateGouwuche.do")
	public String updateGouwuche(int id,ModelMap map,Gouwuche gouwuche,HttpServletRequest request,HttpSession session){
		gouwucheService.update(gouwuche);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:gouwucheList.do";
	}

//	分页查询
	@RequestMapping("gouwucheList.do")
	public String gouwucheList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gouwuche gouwuche, String shangpinbianhao, String shangpinmingcheng, String jiage, String goumaishuliang1,String goumaishuliang2, String zongjia, String goumairen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}		
		int total=gouwucheService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gouwuche> list=gouwucheService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gouwuche_list";
	}
	
	@RequestMapping("gouwucheList2.do")
	public String gouwucheList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gouwuche gouwuche, String shangpinbianhao, String shangpinmingcheng, String jiage, String goumaishuliang1,String goumaishuliang2, String zongjia, String goumairen, String issh,HttpServletRequest request){
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
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}		
		
		int total=gouwucheService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gouwuche> list=gouwucheService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gouwuche_list2";
	}	
	
	@RequestMapping("gwcList.do")
	public String gwcList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gouwuche gouwuche, String shangpinbianhao, String shangpinmingcheng, String jiage, String goumaishuliang1,String goumaishuliang2, String zongjia, String goumairen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}		
		int total=gouwucheService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gouwuche> list=gouwucheService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gouwuchelist";
	}
	
	@RequestMapping("deleteGouwuche.do")
	public String deleteGouwuche(int id,HttpServletRequest request){
		gouwucheService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:gouwucheList.do";
	}
	
	
}
