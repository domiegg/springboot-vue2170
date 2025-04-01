<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>订单详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  订单详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>订单编号：</td><td width='39%'>${dingdan.dingdanbianhao}</td>     <td width='11%'>内容：</td><td width='39%'>${dingdan.neirong}</td></tr><tr>     <td width='11%'>购买人：</td><td width='39%'>${dingdan.goumairen}</td>     <td width='11%'>总金额：</td><td width='39%'>${dingdan.zongjine}</td></tr><tr>     <td width='11%'>联系手机：</td><td width='39%'>${dingdan.lianxishouji}</td>     <td width='11%'>送货地址：</td><td width='39%'>${dingdan.songhuodizhi}</td></tr><tr>     <td width='11%'>备注：</td><td width='39%'>${dingdan.beizhu}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

