package com.example.lab5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/san-pham/hien-thi",
        "/san-pham/delete",
        "/san-pham/detail",
        "/san-pham/update"
})
public class UserServlet extends HttpServlet {
    UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("/delete-user")){
            String id = req.getParameter("id");
            service.deleteById(id);
            resp.sendRedirect("/user");
            return;
        }

        if(uri.contains("/update-user")){
            String id = req.getParameter("id");
            User curentUser = service.findById(id);
            req.setAttribute("curentUser",curentUser);
        }

        req.setAttribute("list", service.findAll());
        req.getRequestDispatcher("/views/user/index.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String u
        User u = new User();
        u.setId(req.getParameter("id"));
        u.setPassword(req.getParameter("password"));
        u.setAdmin(req.getParameter("admin") != null);

        if(req.getRequestURI().contains("/update-user")){
            service.update(u);
        }else {
            service.add(u);
        }

        resp.sendRedirect("user");
    }



}
