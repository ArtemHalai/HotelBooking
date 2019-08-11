package controller.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static enums.Attributes.PASSWORD;
import static enums.Attributes.USERNAME;
import static enums.Mappings.LOGIN_PAGE;
import static enums.Mappings.LOGIN_VIEW;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher dispatcher;

    @InjectMocks
    private LoginServlet servlet;

    @Test
    public void doGet() throws ServletException, IOException {
        when(request.getRequestDispatcher(LOGIN_PAGE.getName())).thenReturn(dispatcher);
        servlet.doGet(request, response);
        verify(request, times(1)).getRequestDispatcher(LOGIN_PAGE.getName());
    }

    @Test
    public void doPost() throws ServletException, IOException {
        when(request.getRequestURI()).thenReturn(LOGIN_VIEW.getName());
        when(request.getSession()).thenReturn(session);
        when(request.getParameter(USERNAME.getName())).thenReturn("username");
        when(request.getParameter(PASSWORD.getName())).thenReturn("password");
        servlet.doPost(request, response);
        verify(request, times(2)).getRequestURI();

        assertEquals(LOGIN_VIEW.getName(), request.getRequestURI());
    }
}