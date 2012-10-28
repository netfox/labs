<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="form4.jsp" method="post">
    Middle name <input type="text" name="data"/>
    <%session.setAttribute("lastName", request.getParameter("data"));%>
    <input type="submit" value="next"/>
</form>
</body>
</html>