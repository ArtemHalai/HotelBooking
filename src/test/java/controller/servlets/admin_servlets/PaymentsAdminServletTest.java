package controller.servlets.admin_servlets;

import enums.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static enums.Mappings.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentsAdminServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @InjectMocks
    private PaymentsAdminServlet servlet;

    @Test
    public void doGet() throws ServletException, IOException {
        when(request.getRequestURI()).thenReturn(PAYMENTS_ADMIN.getName());
        when(request.getSession()).thenReturn(session);
        servlet.doGet(request,response);
        verify(request, times(3)).getRequestURI();
        verify(session, times(1)).getAttribute(Role.ADMIN.getName());
        verify(response, times(1)).sendRedirect(LOGIN_VIEW.getName());
    }
}