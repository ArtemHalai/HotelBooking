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

import static enums.Attributes.*;
import static enums.Mappings.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher dispatcher;

    @Mock
    private HttpSession session;

    @InjectMocks
    private RegistrationServlet servlet;

    @Test
    public void doGet() throws ServletException, IOException {
        when(request.getRequestDispatcher(REGISTRATION_PAGE.getName())).thenReturn(dispatcher);
        servlet.doGet(request,response);
        verify(request, times(1)).getRequestDispatcher(REGISTRATION_PAGE.getName());
    }

    @Test
    public void doPost() throws ServletException, IOException {
        when(request.getRequestURI()).thenReturn(REGISTRATION_VIEW.getName());
        when(request.getRequestDispatcher(REGISTRATION_PAGE.getName())).thenReturn(dispatcher);
        when(request.getSession()).thenReturn(session);
        when(request.getParameter(NAME.getName())).thenReturn("name");
        when(request.getParameter(SURNAME.getName())).thenReturn("surname");
        when(request.getParameter(USERNAME.getName())).thenReturn("username");
        when(request.getParameter(PASSWORD.getName())).thenReturn("password");
        when(request.getParameter(AGE.getName())).thenReturn("20");
        when(request.getParameter(PHONE_NUMBER.getName())).thenReturn("+380000000000");
        when(request.getParameter(PASSPORT_ID.getName())).thenReturn("TY645789");

        servlet.doPost(request, response);
        verify(request, times(2)).getRequestURI();
    }
}