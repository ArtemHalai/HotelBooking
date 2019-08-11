package controller.servlets;

import enums.Role;
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

import static enums.Mappings.LOGGED_IN;
import static enums.Mappings.LOGGED_IN_VIEW;
import static enums.Role.ADMIN;
import static enums.Role.GUEST;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoggedInServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher dispatcher;

    @InjectMocks
    private LoggedInServlet servlet;

    @Test
    public void doGet() throws ServletException, IOException {
        when(request.getRequestDispatcher(LOGGED_IN.getName())).thenReturn(dispatcher);
        when(request.getSession(false)).thenReturn(session);
        when(request.getRequestURI()).thenReturn(LOGGED_IN_VIEW.getName());
        when(session.getAttribute(GUEST.getName())).thenReturn(null);
        when(session.getAttribute(ADMIN.getName())).thenReturn(null);

        servlet.doGet(request, response);

        verify(request, times(1)).getRequestDispatcher(LOGGED_IN.getName());
        verify(request, times(2)).getRequestURI();

        assertEquals(LOGGED_IN_VIEW.getName(), request.getRequestURI());
    }
}