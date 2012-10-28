<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="view.fc" method="post">
    Birth date <input type="text" name="data"/>
    <%session.setAttribute("middleName", request.getParameter("data"));%>
    <input type="submit" value="next"/>
</form>
</body>
</html>