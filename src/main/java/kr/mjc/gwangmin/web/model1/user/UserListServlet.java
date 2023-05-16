package kr.mjc.gwangmin.web.model1.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.mjc.gwangmin.web.dao.User;
import kr.mjc.gwangmin.web.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.util.List;

@WebServlet("/servlets/user/userList")
@Slf4j
public class UserListServlet extends HttpServlet {

  private UserDao userDao;

  @Override
  public void init() {
    // for standalone container
    ApplicationContext applicationContext =
        WebApplicationContextUtils.getRequiredWebApplicationContext(
            getServletContext());
    userDao = applicationContext.getBean(UserDao.class);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int count = Integer.parseInt(req.getParameter("count"));
    int page = Integer.parseInt(req.getParameter("page"));
    List<User> userList = userDao.listUsers(count, page);
    req.setAttribute("userList", userList);
    req.getRequestDispatcher("/WEB-INF/jsp/user/userList.jsp")
        .forward(req, resp);
  }
}