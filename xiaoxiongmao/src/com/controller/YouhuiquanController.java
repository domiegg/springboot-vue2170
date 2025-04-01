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

import com.entity.Youhuiquan;
import com.server.YouhuiquanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YouhuiquanController {
	@Resource
	private YouhuiquanServer youhuiquanService;


   
	@RequestMapping("addYouhuiquan.do")
	public String addYouhuiquan(HttpServletRequest request,Youhuiquan youhuiquan,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		youhuiquan.setAddtime(time.toString().substring(0, 19));
		youhuiquanService.add(youhuiquan);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "youhuiquanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:youhuiquanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYouhuiquan.do")
	public String doUpdateYouhuiquan(int id,ModelMap map,Youhuiquan youhuiquan){
		youhuiquan=youhuiquanService.getById(id);
		map.put("youhuiquan", youhuiquan);
		return "youhuiquan_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("youhuiquanDetail.do")
	public String youhuiquanDetail(int id,ModelMap map,Youhuiquan youhuiquan){
		youhuiquan=youhuiquanService.getById(id);
		map.put("youhuiquan", youhuiquan);
		return "youhuiquan_detail";
	}
//	前台详细
	@RequestMapping("yhqDetail.do")
	public String yhqDetail(int id,ModelMap map,Youhuiquan youhuiquan){
		youhuiquan=youhuiquanService.getById(id);
		map.put("youhuiquan", youhuiquan);
		return "youhuiquandetail";
	}
//	
	@RequestMapping("updateYouhuiquan.do")
	public String updateYouhuiquan(int id,ModelMap map,Youhuiquan youhuiquan,HttpServletRequest request,HttpSession session){
		youhuiquanService.update(youhuiquan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:youhuiquanList.do";
	}

//	分页查询
	@RequestMapping("youhuiquanList.do")
	public String youhuiquanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Youhuiquan youhuiquan, String youhuiquanbianhao, String youxiaoriqi1,String youxiaoriqi2, String shiyongshuoming, String yonghu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(youhuiquanbianhao==null||youhuiquanbianhao.equals("")){pmap.put("youhuiquanbianhao", null);}else{pmap.put("youhuiquanbianhao", youhuiquanbianhao);}		if(youxiaoriqi1==null||youxiaoriqi1.equals("")){pmap.put("youxiaoriqi1", null);}else{pmap.put("youxiaoriqi1", youxiaoriqi1);}		if(youxiaoriqi2==null||youxiaoriqi2.equals("")){pmap.put("youxiaoriqi2", null);}else{pmap.put("youxiaoriqi2", youxiaoriqi2);}		if(shiyongshuoming==null||shiyongshuoming.equals("")){pmap.put("shiyongshuoming", null);}else{pmap.put("shiyongshuoming", shiyongshuoming);}		if(yonghu==null||yonghu.equals("")){pmap.put("yonghu", null);}else{pmap.put("yonghu", yonghu);}		
		int total=youhuiquanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youhuiquan> list=youhuiquanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youhuiquan_list";
	}
	
	@RequestMapping("youhuiquanList2.do")
	public String youhuiquanList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Youhuiquan youhuiquan, String youhuiquanbianhao, String youxiaoriqi1,String youxiaoriqi2, String shiyongshuoming, String yonghu,HttpServletRequest request){
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
		
		pmap.put("yonghu", (String)request.getSession().getAttribute("username"));
		if(youhuiquanbianhao==null||youhuiquanbianhao.equals("")){pmap.put("youhuiquanbianhao", null);}else{pmap.put("youhuiquanbianhao", youhuiquanbianhao);}		if(youxiaoriqi1==null||youxiaoriqi1.equals("")){pmap.put("youxiaoriqi1", null);}else{pmap.put("youxiaoriqi1", youxiaoriqi1);}		if(youxiaoriqi2==null||youxiaoriqi2.equals("")){pmap.put("youxiaoriqi2", null);}else{pmap.put("youxiaoriqi2", youxiaoriqi2);}		if(shiyongshuoming==null||shiyongshuoming.equals("")){pmap.put("shiyongshuoming", null);}else{pmap.put("shiyongshuoming", shiyongshuoming);}		
		
		int total=youhuiquanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youhuiquan> list=youhuiquanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youhuiquan_list2";
	}	
	
	@RequestMapping("yhqList.do")
	public String yhqList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Youhuiquan youhuiquan, String youhuiquanbianhao, String youxiaoriqi1,String youxiaoriqi2, String shiyongshuoming, String yonghu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(youhuiquanbianhao==null||youhuiquanbianhao.equals("")){pmap.put("youhuiquanbianhao", null);}else{pmap.put("youhuiquanbianhao", youhuiquanbianhao);}		if(youxiaoriqi1==null||youxiaoriqi1.equals("")){pmap.put("youxiaoriqi1", null);}else{pmap.put("youxiaoriqi1", youxiaoriqi1);}		if(youxiaoriqi2==null||youxiaoriqi2.equals("")){pmap.put("youxiaoriqi2", null);}else{pmap.put("youxiaoriqi2", youxiaoriqi2);}		if(shiyongshuoming==null||shiyongshuoming.equals("")){pmap.put("shiyongshuoming", null);}else{pmap.put("shiyongshuoming", shiyongshuoming);}		if(yonghu==null||yonghu.equals("")){pmap.put("yonghu", null);}else{pmap.put("yonghu", yonghu);}		
		int total=youhuiquanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youhuiquan> list=youhuiquanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youhuiquanlist";
	}
	
	@RequestMapping("deleteYouhuiquan.do")
	public String deleteYouhuiquan(int id,HttpServletRequest request){
		youhuiquanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:youhuiquanList.do";
	}
	
	
}
