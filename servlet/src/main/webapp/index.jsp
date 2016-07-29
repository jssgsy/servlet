<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/servlet/helloServlet" method="post">

    <select name="name">
        <%--value的值才是真正传递到后台的值,option标签中的值只是页面显示用--%>
        <option value="">默认值""</option>
        <option value="用户选定的值value">用户选定的值</option>

    </select>
    <input type="submit" >

</form>
</body>
</html>