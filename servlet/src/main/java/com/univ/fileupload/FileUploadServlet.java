package com.univ.fileupload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Univ
 * 16/8/28 09:02
 */

/**
 * 演示利用commons-fileupload组件进行文件上传
 *
 *
 * 1.使用ServletFileUpload代替DiskFileUpload类;
 * 2.核心类:
 *      DiskFileItemFactory;
 *      ServletFileUpload;
 *      FileItem;//对应于表单中的每个输入域(包含文件输入域或者普通文本输入域)
 */
@WebServlet(urlPatterns = {"/fileUpload"})
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!ServletFileUpload.isMultipartContent(req)) {
            System.out.println("此请求不是文件上传请求。");
        } else {
            /**
             * 下面这句必不可少,还可以给DiskFileItemFactory设置诸多属性,
             * 如上传文件大小的限制,上传文件大小大于某个值时会将其临时存储在硬盘上等等;参考javadoc
             */
            DiskFileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            List<FileItem> fileItems = null;
            try {
                fileItems = fileUpload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            Iterator<FileItem> iterator = fileItems.iterator();
            while (iterator.hasNext()) {
                FileItem fileItem = iterator.next();

                if (fileItem.isFormField()) {//非文件输入域,一般操作就是获取此输入域对应的name与value
                    String name = fileItem.getFieldName();//表单input标签name指定的值
                    String value = fileItem.getString();//用户在输入域中输入的值
                } else {//文件输入域(type=file)
                    String tempName = fileItem.getName();//大部分浏览器传递的是文件名,有的浏览器传递的是文件全路径名
                    String fileName = tempName.substring(tempName.lastIndexOf("/")+1);
                    String pathToStore = "/Users/Univ/Desktop/" + fileName;
                    File file = new File(pathToStore);
                    try {
                        fileItem.write(file);//此方法很有用,直接就可以将上传的文件保存到本地(不用借助流)。
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
