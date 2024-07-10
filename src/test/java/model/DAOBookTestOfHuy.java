package model;

import entity.Book;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class DAOBookTestOfHuy {
    private DAOBook daoBook;
    private Connection conn;
    @BeforeEach
    public void setUp() throws SQLException {
        daoBook = new DAOBook();

        // Connect to SQL Server
        conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=EBook", "sa", "123");
        daoBook.conn = conn;

    }
    // Test to retrieve old books for a valid email (original DFID001)
    @Test
    public void test_getOldBook_validEmail() {
        Vector<Book> books = daoBook.getOldBook("email1@example.com", "Old");
        assertFalse(books.isEmpty());
    }

    // Test to retrieve old books for an invalid email not exited (original DFID002)
    @Test
    public void test_getOldBook_invalidEmailFormat() {
        Vector<Book> books = daoBook.getOldBook("huy@gmaicom", "Old");
        assertTrue(books.isEmpty(), "Retrieved books for invalid email not exited 'huy@gmaicom'");
    }



    @Test
    public void test_getOldBook_nullEmail() {
        // Test case for null email (original DFID003)
        Vector<Book> books = daoBook.getOldBook(null, "Old");
        assertTrue(books.isEmpty(), "Retrieved books for null email");
    }

    @Test
    public void test_getOldBook_trimWhiteSpaceEmail() {
        // Test case for email with only whitespace (original DFID004)
        Vector<Book> books = daoBook.getOldBook("   ", "Old");
        assertTrue(books.isEmpty(), "Retrieved books for email with only whitespace");
    }

    @Test
    public void test_getOldBook_maxLengthEmail() {
        // Test case for email with maximum allowed length (original DFID005)
        String maxLengthEmail = new String(new char[50]).replace('\0', 'a') + "@fpt.edu.vn";
        Vector<Book> books = daoBook.getOldBook(maxLengthEmail, "Old");
        assertTrue(books.isEmpty(), "Retrieved books for email exceeding maximum length");
    }

    @Test
    public void test_getOldBook_overMaxLengthEmail() {
        // Test case for email exceeding maximum allowed length (original DFID006) - Removed duplicate test
        String overMaxLengthEmail = new String(new char[51]).replace('\0', 'a') + "@fpt.edu.vn";
        Vector<Book> books = daoBook.getOldBook(overMaxLengthEmail, "Old");
        assertTrue(books.isEmpty(), "Retrieved books for email exceeding maximum length");
    }

    @Test
    public void test_getOldBook_validEmail_differentCategory() {
        // Test case for valid email with different category (original DFID007)
        Vector<Book> books = daoBook.getOldBook("email1@example.com", "New");
        assertTrue(books.isEmpty(), "Retrieved books for valid email with different category 'New'");
    }

    @Test
    public void test_getOldBook_invalidEmailFormat_differentCategory() {
        // Test case for invalid email format with different category (original DFID008)
        Vector<Book> books = daoBook.getOldBook("huy@example.com", "New");
        assertTrue(books.isEmpty(), "Retrieved books for invalid email not exited 'huy@example.com' with category 'New'");
    }

}


