package web.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        Boolean flag = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    // 有该Cookie，不是第一次访问
                    String value = cookie.getValue();
                    // 响应数据
                    // 获取Cookie的value，时间
                    pw.write("Before decode: " + value + "<br>");
                    // URL解码：
                    value = URLDecoder.decode(value, "utf-8");
                    pw.write("After decode: " + value + "<br>");
                    pw.write("<h1>欢迎回来，您上次访问时间为:" + value + "</h1>" + "<br>");
                    flag = true;// 有lastTime的cookie

                    // 设置Cookie的value
                    // 获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    // System.out.println("编码前：" + str_date);
                    pw.write("Before encode: " + str_date + "<br>");
                    // URL编码
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    // System.out.println("编码后：" + str_date);
                    pw.write("After encode: " + str_date + "<br>");
                    cookie.setValue(str_date);
                    // 设置cookie的存活时间
                    cookie.setMaxAge(60 * 60 * 24 * 30);// 一个月
                    resp.addCookie(cookie);

                    break;
                }
            }
        }

        if (cookies == null || cookies.length == 0 || flag == false) {
            // 没有，第一次访问
            // 设置Cookie的value
            // 获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            pw.write("Before encode: " + str_date + "<br>");
            // URL编码
            str_date = URLEncoder.encode(str_date, "utf-8");
            pw.write("After encode: " + str_date + "<br>");

            Cookie cookie = new Cookie("lastTime", str_date);
            // 设置cookie的存活时间
            cookie.setMaxAge(60 * 60 * 24 * 30);// 一个月
            resp.addCookie(cookie);

            resp.getWriter().write("<h1>您好，欢迎您首次访问</h1>" + "<br>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
