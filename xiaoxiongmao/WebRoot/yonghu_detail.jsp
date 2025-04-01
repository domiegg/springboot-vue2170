<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>用户详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  用户详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>用户名：</td><td width='39%'>${yonghu.yonghuming}</td>     <td width='11%'>密码：</td><td width='39%'>${yonghu.mima}</td></tr><tr>     <td width='11%'>姓名：</td><td width='39%'>${yonghu.xingming}</td>     <td width='11%'>性别：</td><td width='39%'>${yonghu.xingbie}</td></tr><tr>     <td width='11%'>联系手机：</td><td width='39%'>${yonghu.lianxishouji}</td>     <td width='11%'>地址：</td><td width='39%'>${yonghu.dizhi}</td></tr><tr>     <td width='11%'>积分：</td><td width='39%'>${yonghu.jifen}</td>     <td width='11%'>权限：</td><td width='39%'>${yonghu.quanxian}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

