<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 15.11.2019
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<html>
<body>
<%
    List<String> fileList = (List<String>) request.getAttribute("files");
    if (fileList == null)
        return;
    for (String file : fileList)
    {
%>
<p><%=file%></p>
<%
    }
%>
</body>
</html>