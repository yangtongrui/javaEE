package servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class cookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("name","20");
        resp.addCookie(cookie);
        cookie.setMaxAge(60*10);
        Cookie[] cookies = req.getCookies();
        for(Cookie c:cookies){
            if(c.getName().equals("name")){
                if(c.getName().equals("age"))
                resp.getWriter().write(c.getValue());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
