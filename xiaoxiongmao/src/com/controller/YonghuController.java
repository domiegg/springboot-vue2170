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

import com.entity.Yonghu;
import com.server.YonghuServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YonghuController {
	@Resource
	private YonghuServer yonghuService;


   
	@RequestMapping("addYonghu.do")
	public String addYonghu(HttpServletRequest request,Yonghu yonghu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		yonghu.setAddtime(time.toString().substring(0, 19));
		yonghuService.add(yonghu);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "yonghuList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:yonghuList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYonghu.do")
	public String doUpdateYonghu(int id,ModelMap map,Yonghu yonghu){
		yonghu=yonghuService.getById(id);
		map.put("yonghu", yonghu);
		return "yonghu_updt";
	}
	
	@RequestMapping("doUpdateYonghu2.do")
	public String doUpdateYonghu2(ModelMap map,Yonghu yonghu,HttpServletRequest request){
		yonghu=yonghuService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("yonghu", yonghu);
		return "yonghu_updt2";
	}
	
@RequestMapping("updateYonghu2.do")
	public String updateYonghu2(int id,ModelMap map,Yonghu yonghu){
		yonghuService.update(yonghu);
		return "redirect:doUpdateYonghu2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("yonghuDetail.do")
	public String yonghuDetail(int id,ModelMap map,Yonghu yonghu){
		yonghu=yonghuService.getById(id);
		map.put("yonghu", yonghu);
		return "yonghu_detail";
	}
//	前台详细
	@RequestMapping("yhDetail.do")
	public String yhDetail(int id,ModelMap map,Yonghu yonghu){
		yonghu=yonghuService.getById(id);
		map.put("yonghu", yonghu);
		return "yonghudetail";
	}
//	
	@RequestMapping("updateYonghu.do")
	public String updateYonghu(int id,ModelMap map,Yonghu yonghu,HttpServletRequest request,HttpSession session){
		yonghuService.update(yonghu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:yonghuList.do";
	}

//	分页查询
	@RequestMapping("yonghuList.do")
	public String yonghuList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonghu yonghu, String yonghuming, String mima, String xingming, String xingbie, String lianxishouji, String dizhi, String jifen, String quanxian){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}		if(quanxian==null||quanxian.equals("")){pmap.put("quanxian", null);}else{pmap.put("quanxian", quanxian);}		
		int total=yonghuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonghu> list=yonghuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonghu_list";
	}
	
	
	
	@RequestMapping("yhList.do")
	public String yhList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonghu yonghu, String yonghuming, String mima, String xingming, String xingbie, String lianxishouji, String dizhi, String jifen, String quanxian){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxishouji==null||lianxishouji.equals("")){pmap.put("lianxishouji", null);}else{pmap.put("lianxishouji", lianxishouji);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}		if(quanxian==null||quanxian.equals("")){pmap.put("quanxian", null);}else{pmap.put("quanxian", quanxian);}		
		int total=yonghuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonghu> list=yonghuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonghulist";
	}
	
	@RequestMapping("deleteYonghu.do")
	public String deleteYonghu(int id,HttpServletRequest request){
		yonghuService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:yonghuList.do";
	}
	
	@RequestMapping("quchongYonghu.do")
	public void quchongYonghu(Yonghu yonghu,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yonghuming", yonghu.getYonghuming());
		   System.out.println("yonghuming==="+yonghu.getYonghuming());
		   System.out.println("yonghuming222==="+yonghuService.quchongYonghu(map));
		   JSONObject obj=new JSONObject();
		   if(yonghuService.quchongYonghu(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "用户名可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
