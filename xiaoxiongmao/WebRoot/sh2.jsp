<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ page isELIgnored="false" %> 


<%
String id=request.getParameter("id");

String sql="";

	sql="update yonghu set quanxian='会员' where id="+request.getParameter("id");


connDbBean.hsgexecute(sql);
out.print("<script>javascript:alert('升级成功！');location.href='yonghuList.do';</script>");


%>



