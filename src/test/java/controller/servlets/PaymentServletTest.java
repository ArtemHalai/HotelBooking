package controller.servlets;

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

import static enums.Attributes.*;
import static enums.Mappings.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @InjectMocks
    private PaymentServlet servlet;

    @Test
    public void doGet() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        servlet.doGet(request,response);
        verify(response, times(1)).sendRedirect(LOGIN_VIEW_PATH.getName());
        verify(request, times(1)).getSession();
        verify(session).getAttribute(Role.GUEST.getName());
    }

    @Test
    public void doPost() throws ServletException, IOException {
        when(request.getRequestURI()).thenReturn(PAYMENT.getName());
        when(request.getSession()).thenReturn(session);
        when(request.getParameter(ROOM_ID.getName())).thenReturn("1");
        when( request.getParameter(RESERVATION_ID.getName())).thenReturn("1");
        when(request.getParameter(CARD_NUMBER.getName())).thenReturn("1234123412341234");
        when(request.getParameter(CV_CODE.getName())).thenReturn("123");
        when(request.getParameter(EXPIRY_DATE.getName())).thenReturn("2019-05-20");
        when(request.getParameter(GUEST.getName())).thenReturn("guestname");
        when(request.getParameter(PRICE.getName())).thenReturn("300.00");

        servlet.doPost(request, response);
        verify(request, times(2)).getRequestURI();

        assertEquals(PAYMENT.getName(), request.getRequestURI());
    }
}