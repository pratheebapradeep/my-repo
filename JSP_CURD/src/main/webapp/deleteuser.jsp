<%@page import="com.example.dao.UserDao"%>  
<jsp:useBean id="u" class="com.example.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
UserDao.delete(u);  
response.sendRedirect("viewusers.jsp");  
%>  