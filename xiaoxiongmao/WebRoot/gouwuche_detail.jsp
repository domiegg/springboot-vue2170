<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>购物车详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  购物车详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>商品编号：</td><td width='39%'>${gouwuche.shangpinbianhao}</td>     <td width='11%'>商品名称：</td><td width='39%'>${gouwuche.shangpinmingcheng}</td></tr><tr>     <td width='11%'>价格：</td><td width='39%'>${gouwuche.jiage}</td>     <td width='11%'>购买数量：</td><td width='39%'>${gouwuche.goumaishuliang}</td></tr><tr>     <td width='11%'>总价：</td><td width='39%'>${gouwuche.zongjia}</td>     <td width='11%'>购买人：</td><td width='39%'>${gouwuche.goumairen}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

