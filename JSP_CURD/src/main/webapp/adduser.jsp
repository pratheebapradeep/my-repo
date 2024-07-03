<%@page import="com.example.dao.UserDao"%>  
<jsp:useBean id="u" class="com.example.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
  
<%  
int i=UserDao.save(u);  
if(i==1)
{  
response.sendRedirect("adduser-sucess.jsp");  
}
else
{  
response.sendRedirect("adduser-error.jsp");  
}  
%>  