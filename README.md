## servlet 
maven组织的servlet项目,用来测试j2ee方面的小知识.

## 使用说明

1. 访问方法： http://localhost:8080/servlet/ajax01.html
2. 访问AjaxServlet时记得加参数name,如： http://localhost:8080/servlet/get_text?name=柳明录
3. 想看详尽的输出,将log4j.properties中的级别改成debug。

### 包含功能

* 普通servlet与filte的使用;
* 注解servlet与filter的使用;
* 各种类型listener的使用;
* 编码过滤器(只对post请求有效);
* 利用cookie传递数据;
* 利用commons-fileupload进行文件上传；