package frank.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 通过http请求路径通过/login路径映射到本servlet，通过@WebServlet中配置的路径关联
 *  @ WebServlet 必须以/开头
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//请求数据编码;只对请求体产生作用,url中的数据无效
        resp.setCharacterEncoding("UTF-8");//服务端响应的内容设置编码
        //告诉浏览器:1.数据类型(浏览器处理数据的方式)
        //2.编码(浏览器解析数据的编码)
        resp.setContentType("text/html;charset=UTF-8");

        //getParameter获取url中或者请求体中的数据,根据key获取value,反之null
        //接受的请求数据类型,可以是get
        String username = req.getParameter("username");//根据key获取value,获取不到为null
        String password = req.getParameter("password");
        PrintWriter pw = resp.getWriter();
        if("abc".equals(username) && "123".equals(password)) {
            /**
             * 获取当前http请求的session,
             * 如果获取不到,参数为true时:创建一个,反之,返回null
             * 一般的使用:登录并且用户身份校验通过,getSession(),存放用户信息
             *           访问敏感资源时:getSession(false).然后判断是否为null
             *           还可以通过存放的用户信息,校验访问权限
             * 整体看,服务端保存session的结构为Map<V,Map<K,V>>
             */
            HttpSession session = req.getSession();//=getSession(true)
            session.setAttribute("user",username);
            resp.sendRedirect("index.html");

        } else {
            pw.println("登陆失败");
        }
        pw.flush();
    }
}
