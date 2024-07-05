package model;

import entity.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddBookOfDAOBookTest {

    //===================================== Book Object =====================================================

    @Test
    void addBookWithBookObjectIsNull() {
        DAOBook daoBook = new DAOBook();
        Book book = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Book cannot be null",exception.getMessage());
    }

    @Test
    void addBookWithBookObjectIsEmpty() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        int result = daoBook.AddBook(book);
        assertEquals(0,result);
    }

    //===================================== Book Name =====================================================


    @Test
    void addBookWithBookNameIsNull() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception   exception = assertThrows(IllegalArgumentException.class,() -> {
            daoBook.AddBook(book);
        });
        assertEquals("Book fields cannot be empty", exception);
    }

    @Test
    void addBookWithBookNameIsEmpty() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("");
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(0,result);
    }


    @Test
    void addBookWithBookNameMin() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("E");
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(1,result);
    }

    @Test
    void addBookWithBookNameMax() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"); //51 characters
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(1,result);
    }

    @Test
    void addBookWithBookObjectIsValid() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(1,result);
    }

    @Test
    void addBookWithBookNameMoreThan50Characters() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"); //51 characters
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(0,result);
    }


    @Test
    void addBookWithBookNameIsDigit() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("1234567890");
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(0,result);
    }

    @Test
    void addBookWithBookNameContainWhiteSpace() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("   "); // 3 spaces
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(0,result);
    }


    //========================================== Author ================================================
    @Test
    void addBookWithAuthorIsNull() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception   exception = assertThrows(IllegalArgumentException.class,() -> {
            daoBook.AddBook(book);
        });
        assertEquals("Book fields cannot be empty", exception);
    }

    @Test
    void addBookWithAuthorIsEmpty() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(0,result);
    }


    @Test
    void addBookWithAuthorMin() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("Hai");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(1,result);
    }

    @Test
    void addBookWithAuthorMax() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English"); //51 characters
        book.setAuthor("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"); // 50 characters
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(1,result);
    }

    @Test
    void addBookWithAuthorMoreThan50Characters() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English"); //51 characters
        book.setAuthor("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"); // 51 characters
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(0,result);
    }


    @Test
    void addBookWithAuthorIsDigit() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("1234567890");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(0,result);
    }

    @Test
    void addBookWithAuthorContainWhiteSpace() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("   "); // 3 spaces
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(0,result);
    }


    //========================================== Price ================================================

    @Test
    void addBookWithPriceIsNull() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Book fields cannot be empty",exception);
    }

    @Test
    void addBookWithPriceIsEmpty() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(Double.parseDouble("abc"));
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Price must be positive",exception);
    }

    @Test
    void addBookWithPriceIsNegativeNumber() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(-1);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Price must be positive",exception);
    }

    @Test
    void addBookWithPriceEqualZero() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(0);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Price must be positive",exception);
    }

    @Test
    void addBookWithPriceMinNumber() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(1); // 1 digit
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(1,result);
    }

    @Test
    void addBookWithPriceMaxNumber() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(1000); // 4 digits
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.AddBook(book);
        assertEquals(1,result);
    }

    @Test
    void addBookWithPriceBeyondMaxNumber() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(10000); // 5 digits
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Price must be 4 digits",exception);
    }

    @Test()
    void addBookWithPriceIsNonNumeric() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        String priceInput = "abc";
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            book.setPrice(Double.parseDouble(priceInput));
            daoBook.AddBook(book);
        });
        assertEquals("Price must be positive",exception);

    }

    @Test
    void addBookWithPriceWithSpaces() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(Double.parseDouble("   "));
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Price must be positive", exception);

    }

    //========================================== BookCategory ================================================

    @Test
    void addBookWithCategoryIsEmpty() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(20);
        book.setBookCategory("");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Book fields cannot be empty", exception);
    }

    //========================================== Status ================================================

    @Test
    void addBookWithStatusIsEmpty() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(20);
        book.setBookCategory("New book");
        book.setStatus("");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Book fields cannot be empty", exception);
    }

    //========================================== Photo ================================================

    @Test
    void addBookWithPhotoIsEmpty() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(20);
        book.setBookCategory("New book");
        book.setStatus("Active");
        book.setPhoto("");
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Book fields cannot be empty", exception);
    }

    @Test
    void addBookWithPhotoInvalidFormat() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(20);
        book.setBookCategory("New book");
        book.setStatus("Active");
        book.setPhoto("English.docx");   // sai dinh dang
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Book fields cannot be empty", exception);
    }
}
