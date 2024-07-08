package model;

import entity.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DAOBookTest {

    //===================================== AddBook (HaiDuc) =================================================
    //===================================== Book Object =====================================================

    //AB01
    @Test
    void addBookWithBookObjectIsNull() {
        DAOBook daoBook = new DAOBook();
        Book book = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Cannot be empty",exception.getMessage());
    }

    //===================================== Book Name =====================================================

    //AB02
    @Test
    void addBookWithBookNameIsNull() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        Exception   exception = assertThrows(IllegalArgumentException.class,() -> {
            daoBook.AddBook(book);
        });
        assertEquals("Cannot be empty", exception.getMessage());
    }

    //AB03
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
        Exception   exception = assertThrows(IllegalArgumentException.class,() -> {
            daoBook.AddBook(book);
        });
        assertEquals("Cannot be empty",exception.getMessage());
    }

    //AB04
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
        int result = daoBook.AddBook(book);
        assertEquals(1,result);
    }

    //AB05
    @Test
    void addBookWithBookNameMax() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("E".repeat(50)); //50 characters
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        int result = daoBook.AddBook(book);
        assertEquals(1,result);
    }

    //AB06
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
        int result = daoBook.AddBook(book);
        assertEquals(1,result);
    }

    //AB07
    @Test
    void addBookWithBookNameMoreThan50Characters() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("E".repeat(51)); //51 characters
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Cannot exceed 50 characters",exception.getMessage());
    }

    //AB08
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
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Cannot be entirely numeric",exception.getMessage());
    }

    //========================================== Price ================================================

    //AB09
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
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            daoBook.AddBook(book);
        });
        assertEquals("Price must be positive", exception.getMessage());
    }

    //AB10
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
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            daoBook.AddBook(book);
        });
        assertEquals("Price must be positive", exception.getMessage());
    }

    //AB11
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
        int result = daoBook.AddBook(book);
        assertEquals(1,result);
    }

    //AB12
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
        int result = daoBook.AddBook(book);
        assertEquals(1,result);
    }

    //AB13
    @Test
    void addBookWithPriceBeyondMaxNumber() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(40000); // 5 digits
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Cannot exceed 4 digits",exception.getMessage());
    }

    //AB14
    @Test()
    void addBookWithPriceIsNonNumeric() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        String priceString = "abc";
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            book.setPrice(Double.parseDouble(priceString));
            daoBook.AddBook(book);
        });
        assertEquals("Price must be positive",exception.getMessage());

    }

    //========================================== Photo ================================================

    //AB15
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
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Invalid format", exception.getMessage());
    }

    //===================================== EditBook (HaiDuc) =================================================
    //===================================== Book Object =====================================================

    //EB01
    @Test
    void editBookWithBookNameIsNull() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookId(11);
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        Exception   exception = assertThrows(IllegalArgumentException.class,() -> {
            daoBook.editBook(book);
        });
        assertEquals("Cannot be empty", exception.getMessage());
    }

    //EB02
    @Test
    void editBookWithBookNameIsEmpty() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookId(11);
        book.setBookName("");
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        Exception   exception = assertThrows(IllegalArgumentException.class,() -> {
            daoBook.editBook(book);
        });
        assertEquals("Cannot be empty",exception.getMessage());
    }

    //EB03
    @Test
    void editBookWithBookNameMin() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookId(11);
        book.setBookName("E");
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        int result = daoBook.editBook(book);
        assertEquals(1,result);
    }

    //EB04
    @Test
    void editBookWithBookNameMax() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookId(11);
        book.setBookName("E".repeat(50)); //50 characters
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        int result = daoBook.editBook(book);
        assertEquals(1,result);
    }

    //EB05
    @Test
    void editBookWithBookObjectIsValid() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookId(11);
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        int result = daoBook.editBook(book);
        assertEquals(1,result);
    }

    //EB06
    @Test
    void editBookWithBookNameMoreThan50Characters() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookId(11);
        book.setBookName("E".repeat(51)); //51 characters
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.editBook(book);
        });
        assertEquals("Cannot exceed 50 characters",exception.getMessage());
    }

    //EB07
    @Test
    void editBookWithBookNameIsDigit() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookId(11);
        book.setBookName("1234567890");
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        int result = daoBook.editBook(book);
        assertEquals(0,result);
    }

    //EB08
    @Test
    void editBookWithBookNameContainWhiteSpace() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookId(11);
        book.setBookName("   "); // 3 spaces
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        int result = daoBook.editBook(book);
        assertEquals(0,result);
    }

    //========================================== Price ================================================

    //EB09
    @Test
    void editBookWithPriceIsNegativeNumber() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookId(11);
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(-1);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        int result = daoBook.editBook(book);
        assertEquals(0,result);
    }

    //EB10
    @Test
    void editBookWithPriceEqualZero() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookId(11);
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(0);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        int result = daoBook.editBook(book);
        assertEquals(0 ,result);
    }

    //EB11
    @Test
    void editBookWithPriceMinNumber() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookId(11);
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(1); // 1 digit
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        int result = daoBook.editBook(book);
        assertEquals(1,result);
    }

    //EB12
    @Test
    void editBookWithPriceMaxNumber() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookId(11);
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(1000); // 4 digits
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        int result = daoBook.editBook(book);
        assertEquals(1,result);
    }

    //EB13
    @Test
    void editBookWithPriceBeyondMaxNumber() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookId(11);
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(10000); // 5 digits
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.editBook(book);
        });
        assertEquals("Price must be 4 digits",exception.getMessage());
    }

    //EB14
    @Test()
    void editBookWithPriceIsNonNumeric() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookId(11);
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        String priceString = "abc";
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            book.setPrice(Double.parseDouble(priceString));
            daoBook.editBook(book);
        });
        assertEquals("Price must be positive",exception.getMessage());

    }

}
