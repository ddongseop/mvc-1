package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Servlet으로 Controller 역할, JSP로 View 역할
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        //외부에서 직접적으로 안부르고, Controller를 통하고 싶을 때 WEB-INF (내부에서 forward해야 갈 수 있음)

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); //Controller에서 View로 이동할 때
        dispatcher.forward(request, response); //Servlet에서 JSP를 호출 (서버 내부에서 호출 발생 <-> Redirect)
    }
}
