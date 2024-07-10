/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class BookDAO extends DBConnect {
    private static final Logger LOGGER = Logger.getLogger(DAOBook.class.getName());
    private Connection conn;

    public BookDAO(Connection conn) {
        this.conn = conn;
    }

    public Book getBookById(int id) {
        Book book = null;
        String sql = "select bookId, bookname, author, price, bookCategory, status, img, email from books where bookId = ?";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt(1);
                String bookname = rs.getString(2);
                String author = rs.getString(3);
                double price = rs.getDouble(4);
                String bookCategory = rs.getString(5);
                String status = rs.getString(6);
                String img = rs.getString(7);
                String email = rs.getString(8);
                book = new Book();
                book.setBookId(bookId);
                book.setBookName(bookname);
                book.setAuthor(author);
                book.setPrice(price);
                book.setBookCategory(bookCategory);
                book.setStatus(status);
                book.setPhoto(img);
                book.setEmail(email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }

    public Vector<Book> getBookBySearch(String search) {
        Vector<Book> vector = new Vector<>();
        String sql = "select * from books where bookName LIKE ? OR author LIKE ? OR bookCategory LIKE ? AND status = ?";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, "%" + search + "%");
            pre.setString(2, "%" + search + "%");
            pre.setString(3, "%" + search + "%");
            pre.setString(4, "Active");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt(1);
                String bookname = rs.getString(2);
                String author = rs.getString(3);
                double price = rs.getDouble(4);
                String bookCategory = rs.getString(5);
                String status = rs.getString(6);
                String img = rs.getString(7);
                String email = rs.getString(8);
                Book book = new Book();
                book.setBookId(bookId);
                book.setBookName(bookname);
                book.setAuthor(author);
                book.setPrice(price);
                book.setBookCategory(bookCategory);
                book.setStatus(status);
                book.setPhoto(img);
                book.setEmail(email);
                vector.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public List<Book> getBookByPrice(String priceRange) {
        List<Book> vector = new ArrayList<>();
        String sql = "select * from books where price >= ? AND price <=?";
        PreparedStatement pre;
        double minPrice = 0;
        double maxPrice = Double.MAX_VALUE;
        switch (priceRange) {
            case "0-100":
                maxPrice = 100;
                break;
            case "100-200":
                minPrice = 100;
                maxPrice = 200;
                break;
            case "200-300":
                minPrice = 200;
                maxPrice = 300;
                break;
            case "300+":
                minPrice = 300;
                break;
            default:
                // Invalid price range
        }
        try {
            pre = conn.prepareStatement(sql);
            pre.setDouble(1, minPrice);
            pre.setDouble(2, maxPrice);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt(1);
                String bookname = rs.getString(2);
                String author = rs.getString(3);
                double price = rs.getDouble(4);
                String bookCategory = rs.getString(5);
                String status = rs.getString(6);
                String img = rs.getString(7);
                String email = rs.getString(8);
                Book book = new Book();
                book.setBookId(bookId);
                book.setBookName(bookname);
                book.setAuthor(author);
                book.setPrice(price);
                book.setBookCategory(bookCategory);
                book.setStatus(status);
                book.setPhoto(img);
                book.setEmail(email);
                vector.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<Book> getAllRecentBook() {
        Book book = null;
        String sql = "Select * from books where status = ? order by bookId DESC";
        Vector<Book> vector = new Vector<Book>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "Active");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt(1);
                String bookname = rs.getString(2);
                String author = rs.getString(3);
                double price = rs.getDouble(4);
                String bookCategory = rs.getString(5);
                String status = rs.getString(6);
                String img = rs.getString(7);
                String email = rs.getString(8);
                book = new Book();
                book.setBookId(bookId);
                book.setBookName(bookname);
                book.setAuthor(author);
                book.setPrice(price);
                book.setBookCategory(bookCategory);
                book.setStatus(status);
                book.setPhoto(img);
                book.setEmail(email);
                vector.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return vector;
    }

    public Vector<Book> getAllOldBook() {
        Book book = null;
        String sql = "Select * from books where bookCategory = ? and status = ?";
        Vector<Book> vector = new Vector<Book>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "Old");
            st.setString(2, "Active");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt(1);
                String bookname = rs.getString(2);
                String author = rs.getString(3);
                double price = rs.getDouble(4);
                String bookCategory = rs.getString(5);
                String status = rs.getString(6);
                String img = rs.getString(7);
                String email = rs.getString(8);
                book = new Book();
                book.setBookId(bookId);
                book.setBookName(bookname);
                book.setAuthor(author);
                book.setPrice(price);
                book.setBookCategory(bookCategory);
                book.setStatus(status);
                book.setPhoto(img);
                book.setEmail(email);
                vector.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return vector;
    }

    public Vector<Book> getNewBook() {
        Book book = null;
        String sql = "Select * from books where bookCategory = ? and status = ?";
        Vector<Book> vector = new Vector<>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "New");
            st.setString(2, "Active");
            ResultSet rs = st.executeQuery();
            int i = 1;
            while (rs.next() && i <= 4) {
                int bookId = rs.getInt(1);
                String bookname = rs.getString(2);
                String author = rs.getString(3);
                double price = rs.getDouble(4);
                String bookCategory = rs.getString(5);
                String status = rs.getString(6);
                String img = rs.getString(7);
                String email = rs.getString(8);
                book = new Book();
                book.setBookId(bookId);
                book.setBookName(bookname);
                book.setAuthor(author);
                book.setPrice(price);
                book.setBookCategory(bookCategory);
                book.setStatus(status);
                book.setPhoto(img);
                book.setEmail(email);
                vector.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return vector;
    }

}
