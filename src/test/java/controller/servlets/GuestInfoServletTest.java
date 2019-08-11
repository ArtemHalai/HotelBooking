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
import static enums.Mappings.GUEST_INFO;
import static enums.Mappings.GUEST_INFO_PAGE;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GuestInfoServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher dispatcher;

    @InjectMocks
    private GuestInfoServlet servlet;

    @Test
    public void doGet() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("info")).thenReturn("guestInfo");
        when(request.getRequestDispatcher(GUEST_INFO_PAGE.getName())).thenReturn(dispatcher);

        servlet.doGet(request, response);

        verify(request).getRequestDispatcher(GUEST_INFO_PAGE.getName());
        assertEquals("guestInfo", session.getAttribute("info"));
        verify(session).getAttribute("info");
        assertEquals(dispatcher, request.getRequestDispatcher(GUEST_INFO_PAGE.getName()));
        assertEquals(session, request.getSession());
    }

    @Test
    public void doPost() throws ServletException, IOException {
        when(request.getRequestURI()).thenReturn(GUEST_INFO.getName());
        when(request.getSession()).thenReturn(session);
        when(request.getParameter(NAME.getName())).thenReturn("name");
        when(request.getParameter(SURNAME.getName())).thenReturn("surname");
        when(request.getParameter(AGE.getName())).thenReturn("20");
        when(request.getParameter(PHONE_NUMBER.getName())).thenReturn("+380000000000");
        when(request.getParameter(PASSPORT_ID.getName())).thenReturn("TY645789");
        when(request.getParameter(PRICE.getName())).thenReturn("300.00");
        when(request.getParameter(ROOM_ID.getName())).thenReturn("1");
        when( request.getParameter(RESERVATION_ID.getName())).thenReturn("1");
        when(request.getParameter(CARD_NUMBER.getName())).thenReturn("1234123412341234");
        when(request.getParameter(CV_CODE.getName())).thenReturn("123");
        when(request.getParameter(EXPIRY_DATE.getName())).thenReturn("2019-05-20");

        servlet.doPost(request, response);
        verify(request,times(2)).getRequestURI();
    }
}