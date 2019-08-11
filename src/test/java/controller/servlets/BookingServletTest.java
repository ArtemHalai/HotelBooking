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

import static enums.Mappings.BOOKING;
import static enums.Mappings.BOOKING_PAGE;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookingServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher dispatcher;

    @InjectMocks
    private BookingServlet servlet;

    @Test
    public void doGet() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("booking")).thenReturn("bookingData");
        when(request.getRequestDispatcher(BOOKING_PAGE.getName())).thenReturn(dispatcher);

        servlet.doGet(request, response);

        verify(request).getRequestDispatcher(BOOKING_PAGE.getName());
        assertEquals("bookingData", session.getAttribute("booking"));
        verify(session).getAttribute("booking");
        assertEquals(dispatcher, request.getRequestDispatcher(BOOKING_PAGE.getName()));
        assertEquals(session, request.getSession());
    }

    @Test
    public void doPost() throws ServletException, IOException {
        when(request.getRequestURI()).thenReturn(BOOKING.getName());
        when(request.getRequestDispatcher(BOOKING_PAGE.getName())).thenReturn(dispatcher);
        when(request.getParameter("balcony")).thenReturn("on");
        when(request.getParameter("smoke")).thenReturn("on");
        when(request.getParameter("dateIn")).thenReturn("2019-07-21");
        when(request.getParameter("dateOut")).thenReturn("2019-07-23");
        when(request.getParameter("roomType")).thenReturn("single - 1");
        when(request.getParameter("priceRange")).thenReturn("0-300");

        servlet.doPost(request, response);
        verify(request, times(2)).getRequestURI();
        verify(request, times(1)).getRequestDispatcher(BOOKING_PAGE.getName());
    }
}