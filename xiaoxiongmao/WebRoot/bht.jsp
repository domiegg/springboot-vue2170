<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<div class="banner">
	<div class="focusBox">
		<ul class="pic">
			<%
			int xxbhti=0;
			String sqlbht="select  shouyetupian from xinwentongzhi where leibie='变幻图'  order by id desc limit 0,5";
			ResultSet RS_resultbht=connDbBean.executeQuery(sqlbht);
while(RS_resultbht.next())
{
	xxbhti++;
		%>
			<li style="background:url(<%=RS_resultbht.getString("shouyetupian")%>) center top no-repeat;"><a href="#"></a></li>
				<%
		}
		%>
		</ul>
		<a class="prev" href="javascript:void(0)"></a>
		<a class="next" href="javascript:void(0)"></a>
		<ul class="hd">
		<%
		for(int bhti=0;bhti<xxbhti;bhti++)
		{
		%>
			<li></li>
			<%
	  }
	  %>
			
		</ul>
	</div>
</div>



