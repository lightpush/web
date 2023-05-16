package kr.mjc.gwangmin.web.examples;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.mjc.gwangmin.web.dao.User;
import kr.mjc.gwangmin.web.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.util.List;

@WebServlet("/examples/userList")
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
      throws IOException {
    List<User> userList = userDao.listUsers(10, 1);

    String html = """
        <!DOCTYPE html>
        <html>
        <body>
        <pre>%s</pre>
        </body>
        </html>
        """.formatted(userList);

    resp.setContentType("text/html");
    resp.getWriter().println(html);
  }
}