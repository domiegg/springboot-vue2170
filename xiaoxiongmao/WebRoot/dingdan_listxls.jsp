<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="dingdanhsgb" scope="page" class="com.bean.DingdanBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=dingdan.xls");
%>
<html>
  <head>
    <title>����</title>
  </head>

  <body >
 <%
			String sql="select * from dingdan  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>�������</td>        <td align='center'>������</td>    <td align='center'>�ܽ��</td>    <td align='center'>��ϵ�ֻ�</td>    <td align='center'>�ͻ���ַ</td>        <td  width='80' align='center'>�Ƿ�֧��</td>    <td  width='80' align='center'>�Ƿ����</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=dingdanhsgb.getAllDingdan(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.dingdanbianhao}</td>        <td>${u.goumairen}</td>    <td>${u.zongjine}</td>    <td>${u.lianxishouji}</td>    <td>${u.songhuodizhi}</td>        <td align='center'>${u.beizhu}</td>    <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=dingdan'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

