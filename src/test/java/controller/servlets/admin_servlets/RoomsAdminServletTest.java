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
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RoomsAdminServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @InjectMocks
    private RoomsAdminServlet servlet;

    @Test
    public void doGet() throws ServletException, IOException {
        when(request.getRequestURI()).thenReturn(ROOMS_ADMIN.getName());
        when(request.getSession()).thenReturn(session);
        servlet.doGet(request,response);
        verify(request, times(3)).getRequestURI();
        verify(session, times(1)).getAttribute(Role.ADMIN.getName());
        verify(response, times(1)).sendRedirect(LOGIN_VIEW.getName());
        assertEquals(ROOMS_ADMIN.getName(), request.getRequestURI());
        assertThat(request.getRequestURI(), is(ROOMS_ADMIN.getName()));
    }


}