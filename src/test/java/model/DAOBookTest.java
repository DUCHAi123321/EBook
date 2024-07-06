package model;

import entity.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DAOBookTest {

    //===================================== AddBook (HaiDuc) =================================================
    //===================================== Book Object =====================================================

    @Test
    void addBookWithBookObjectIsNull() {
        DAOBook daoBook = new DAOBook();
        Book book = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Cannot be empty",exception.getMessage());
    }

    @Test
    void addBookWithBookObjectIsEmpty() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });

        assertEquals("Cannot be empty",exception.getMessage());
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
        Exception   exception = assertThrows(IllegalArgumentException.class,() -> {
            daoBook.AddBook(book);
        });
        assertEquals("Cannot be empty", exception.getMessage());
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
        Exception   exception = assertThrows(IllegalArgumentException.class,() -> {
            daoBook.AddBook(book);
        });
        assertEquals("Cannot be empty",exception.getMessage());
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
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Cannot exceed 50 characters",exception.getMessage());
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
        assertEquals("Cannot be empty", exception.getMessage());
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
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.AddBook(book);
        });
        assertEquals("Cannot be empty", exception.getMessage());
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
        int result = daoBook.AddBook(book);
        assertEquals(0,result);
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
        int result = daoBook.AddBook(book);
        assertEquals(0 ,result);
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
        assertEquals("Price must be 4 digits",exception.getMessage());
    }

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
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            book.setPrice(Double.parseDouble(priceString));
            daoBook.AddBook(book);
        });
        assertEquals("Price must be positive",exception.getMessage());

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
        assertEquals("Cannot be empty", exception.getMessage());
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
        assertEquals("Cannot be empty", exception.getMessage());
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
        assertEquals("Cannot be empty", exception.getMessage());
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
        assertEquals("Cannot be empty", exception.getMessage());
    }

    //===================================== EditBook (HaiDuc) =================================================
    //===================================== Book Object =====================================================

    @Test
    void editBookWithBookNameIsNull() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
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

    @Test
    void editBookWithBookNameIsEmpty() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
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


    @Test
    void editBookWithBookNameMin() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("E");
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.editBook(book);
        assertEquals(1,result);
    }

    @Test
    void editBookWithBookNameMax() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"); //51 characters
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.editBook(book);
        assertEquals(1,result);
    }

    @Test
    void editBookWithBookObjectIsValid() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.editBook(book);
        assertEquals(1,result);
    }

    @Test
    void editBookWithBookNameMoreThan50Characters() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"); //51 characters
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.editBook(book);
        });
        assertEquals("Cannot exceed 50 characters",exception.getMessage());
    }


    @Test
    void editBookWithBookNameIsDigit() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("1234567890");
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.editBook(book);
        assertEquals(0,result);
    }

    @Test
    void editBookWithBookNameContainWhiteSpace() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("   "); // 3 spaces
        book.setAuthor("HaiDuc");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.editBook(book);
        assertEquals(0,result);
    }

    //========================================== Author ================================================

    @Test
    void editBookWithAuthorIsNull() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception   exception = assertThrows(IllegalArgumentException.class,() -> {
            daoBook.editBook(book);
        });
        assertEquals("Cannot be empty", exception.getMessage());
    }

    @Test
    void editBookWithAuthorIsEmpty() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            daoBook.editBook(book);
        });
        assertEquals("Cannot be empty", exception.getMessage());
    }


    @Test
    void editBookWithAuthorMin() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("Hai");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.editBook(book);
        assertEquals(1,result);
    }

    @Test
    void editBookWithAuthorMax() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English"); //51 characters
        book.setAuthor("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"); // 50 characters
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.editBook(book);
        assertEquals(1,result);
    }

    @Test
    void editBookWithAuthorMoreThan50Characters() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English"); //51 characters
        book.setAuthor("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"); // 51 characters
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.editBook(book);
        assertEquals(0,result);
    }


    @Test
    void editBookWithAuthorIsDigit() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("1234567890");
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.editBook(book);
        assertEquals(0,result);
    }

    @Test
    void editBookWithAuthorContainWhiteSpace() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("   "); // 3 spaces
        book.setPrice(10);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.editBook(book);
        assertEquals(0,result);
    }

    //========================================== Price ================================================

    @Test
    void editBookWithPriceIsNegativeNumber() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(-1);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.editBook(book);
        assertEquals(0,result);
    }

    @Test
    void editBookWithPriceEqualZero() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(0);
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.editBook(book);
        assertEquals(0 ,result);
    }

    @Test
    void editBookWithPriceMinNumber() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(1); // 1 digit
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.editBook(book);
        assertEquals(1,result);
    }

    @Test
    void editBookWithPriceMaxNumber() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        book.setPrice(1000); // 4 digits
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        int result = daoBook.editBook(book);
        assertEquals(1,result);
    }

    @Test
    void editBookWithPriceBeyondMaxNumber() {
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
            daoBook.editBook(book);
        });
        assertEquals("Price must be 4 digits",exception.getMessage());
    }

    @Test()
    void editBookWithPriceIsNonNumeric() {
        DAOBook daoBook = new DAOBook();
        Book book = new Book();
        book.setBookName("English");
        book.setAuthor("HaiDuc");
        String priceString = "abc";
        book.setBookCategory("old book");
        book.setStatus("active");
        book.setPhoto("english.jpg");
        book.setEmail("haiduc@gmail.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            book.setPrice(Double.parseDouble(priceString));
            daoBook.editBook(book);
        });
        assertEquals("Price must be positive",exception.getMessage());

    }

    //========================================== Status ================================================

    @Test
    void editBookWithStatusIsEmpty() {
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
            daoBook.editBook(book);
        });
        assertEquals("Cannot be empty", exception.getMessage());
    }
}
