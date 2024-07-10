package model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BookDAOTest
{
    private BookDAO daoBook;
    private Connection connection;

    @BeforeEach
    public void setUp() throws SQLException {
        // Set up the database connection and ensure the table is ready
        String url = "jdbc:sqlserver://localhost:1433;databaseName=EBook";
        String username = "sa";
        String password = "1234";

        connection = DriverManager.getConnection(url, username, password);
        daoBook = new BookDAO(connection);
    }

    @Test
    public void testGetBookBySearch() {
        daoBook.getBookBySearch("C");

        assertNotEquals("null", daoBook.getBookBySearch("C").toString());
        assertNotEquals("       ", daoBook.getBookBySearch("C").toString());
        assertNotEquals("", daoBook.getBookBySearch("C").toString());
        Assertions.assertEquals("C", daoBook.getBookBySearch("C").toString());
        assertNotEquals("qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvb", daoBook.getBookBySearch("C").toString());
        assertEquals("C Language", daoBook.getBookBySearch("c").toString());
    }

    @Test
    public void testGetBookByPrice() {
        daoBook.getBookByPrice("170");

        assertNotEquals("null", daoBook.getBookByPrice("170").toString());
        assertNotEquals("       ", daoBook.getBookByPrice("170").toString());
        assertNotEquals("", daoBook.getBookByPrice("170").toString());
        assertNotEquals("ABC", daoBook.getBookByPrice("170").toString());
        assertNotEquals("070", daoBook.getBookByPrice("170").toString());
        assertNotEquals("< 0", daoBook.getBookByPrice("170").toString());
        assertNotEquals("0", daoBook.getBookByPrice("170").toString());
        assertNotEquals("0-100", daoBook.getBookByPrice("170").toString());
        assertEquals("100-200", daoBook.getBookByPrice("170").toString());
        assertNotEquals("200-300", daoBook.getBookByPrice("170").toString());
        assertNotEquals("> 300", daoBook.getBookByPrice("170").toString());
    }
}
