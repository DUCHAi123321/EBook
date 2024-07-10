package model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOOrderTest {

    private DAOOrder daoOrder;
    private Connection mockConnection;
    private Statement mockStatement;


    @Before
    public void setUp() throws SQLException {
        daoOrder = new DAOOrder();
        mockConnection = org.mockito.Mockito.mock(Connection.class);
        mockStatement = org.mockito.Mockito.mock(Statement.class);
        daoOrder.conn = mockConnection;
        org.mockito.Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
    }

    @Test
    public void testDeleteOrder_ValidOrderId_BothTablesExist() throws SQLException {
        int orderId = 1;
        org.mockito.Mockito.when(mockStatement.executeUpdate("delete from orderitem where orderid=" + orderId)).thenReturn(1);
        org.mockito.Mockito.when(mockStatement.executeUpdate("delete from orders where orderid=" + orderId)).thenReturn(1);

        boolean result = daoOrder.deleteOrder(orderId);
        assertTrue(result);
    }

    @Test
    public void testDeleteOrder_ValidOrderId_OrderItemNotExists() throws SQLException {
        int orderId = 2;
        org.mockito.Mockito.when(mockStatement.executeUpdate("delete from orderitem where orderid=" + orderId)).thenReturn(0);
        org.mockito.Mockito.when(mockStatement.executeUpdate("delete from orders where orderid=" + orderId)).thenReturn(1);

        boolean result = daoOrder.deleteOrder(orderId);
        assertFalse(result);
    }

    @Test
    public void testDeleteOrder_ValidOrderId_OrdersNotExists() throws SQLException {
        int orderId = 3;
        org.mockito.Mockito.when(mockStatement.executeUpdate("delete from orderitem where orderid=" + orderId)).thenReturn(1);
        org.mockito.Mockito.when(mockStatement.executeUpdate("delete from orders where orderid=" + orderId)).thenReturn(0);

        boolean result = daoOrder.deleteOrder(orderId);
        assertFalse(result);
    }

    @Test
    public void testDeleteOrder_OrderIdNegative() throws SQLException {
        int orderId = -1;

        boolean result = daoOrder.deleteOrder(orderId);
        assertFalse(result);
    }

    @Test
    public void testDeleteOrder_OrderIdZero() throws SQLException {
        int orderId = 0;

        boolean result = daoOrder.deleteOrder(orderId);
        assertFalse(result);
    }

    @Test
    public void testDeleteOrder_OrderIdNull() throws SQLException {
        Integer orderId = null;

        boolean result = daoOrder.deleteOrder(orderId);
        assertFalse(result);
    }

    @Test
    public void testDeleteOrder_SQLExceptionOnFirstQuery() throws SQLException {
        int orderId = 4;
        org.mockito.Mockito.when(mockStatement.executeUpdate("delete from orderitem where orderid=" + orderId)).thenThrow(new SQLException("SQL Exception"));

        boolean result = daoOrder.deleteOrder(orderId);
        assertFalse(result);
    }

    @Test
    public void testDeleteOrder_SQLExceptionOnSecondQuery() throws SQLException {
        int orderId = 5;
        org.mockito.Mockito.when(mockStatement.executeUpdate("delete from orderitem where orderid=" + orderId)).thenReturn(1);
        org.mockito.Mockito.when(mockStatement.executeUpdate("delete from orders where orderid=" + orderId)).thenThrow(new SQLException("SQL Exception"));

        boolean result = daoOrder.deleteOrder(orderId);
        assertFalse(result);
    }

    @Test
    public void testDeleteOrder_OrderIdVeryLarge() throws SQLException {
        int orderId = Integer.MAX_VALUE;

        boolean result = daoOrder.deleteOrder(orderId);
        assertFalse(result);
    }
    @Test
    public void testDeleteOrder_InvalidOrderId() throws SQLException {
        String orderId = "aa";

        boolean result = daoOrder.deleteOrder(Integer.parseInt(orderId));


    }
}
