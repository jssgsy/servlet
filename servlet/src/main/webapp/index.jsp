<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>普通表单测试</h2>
<form action="/helloServlet" method="post">
    <select name="name">
        <%--value的值才是真正传递到后台的值,option标签中的值只是页面显示用--%>
        <option value="">默认值""</option>
        <option value="用户选定的值value">用户选定的值</option>
    </select>
    <input type="submit" >
</form>
<hr>

<h2>文件上传表单测试</h2>
<form action="/fileUpload" method="post" enctype="multipart/form-data">
   普通文本域: <input type="text" name="textInputName"/>
    <br/>
    文件上传域: <input type="file" name="fileName" />
    <br>
    <input type="submit" >
</form>
<hr>


<h2>cookie传递数据</h2>
<a href="/cookieServlet?cookieName=cookieValue">访问/cookieServlet</a>

</body>
</html>