package jmockit.simple;

import mockit.*;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yonggao.Dong on 16/1/10.
 *
 */
public class AuthenticationServletTest {

    @Mocked
    HttpServletRequest request;
    @Mocked
    HttpServletResponse response;

    @Injectable
    AccountDao dao;


    @Tested
    private AuthenticationServlet servlet;


    @Test
    public void should_forward_to_home_when_login_succeed() throws ServletException, IOException {
        new Expectations() {{
            request.getParameter("name");result = "yoogo";
            request.getParameter("password");result = "yoogo";
            dao.isValid("yoogo","yoogo");result = true ;
        }};

        servlet.doPost(request, response);

        new Verifications() {{
            request.getRequestDispatcher("/home").forward(request, response);
        }};
    }

    @Test
    public void should_forward_to_login_when_login_failed() throws ServletException, IOException {
        new Expectations() {{
                request.getParameter("name");result = "foo";
                request.getParameter("password");result = "bar";
                dao.isValid("foo", "bar");result = false;
        }};
        
        servlet.doPost(request, response);

        new Verifications() {{
            request.setAttribute("errorMessage", anyString);
            request.getRequestDispatcher("/login").forward(request, response);
        }};
    }



    @Test
    public void should_call_doRequest_if_call_doGet() throws ServletException, IOException {
        new Expectations(servlet){{
//            servlet.doRequest(request,response); private 的,无法直接调用;
            Deencapsulation.invoke(servlet,"doRequest",request,response);
        }};

        servlet.doGet(request,response);
    }


}
