<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="form3.jsp" method="post">
    Last name <input type="text" name="data"/>
    <%session.setAttribute("firstName", request.getParameter("data"));%>
    <input type="submit" value="next"/>
</form>
</body>
</html>