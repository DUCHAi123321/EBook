package model;

import entity.Book;
import entity.OrderItem;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DAOOrderItemTest {
    private DAOOrderItem dao;
    @BeforeEach
    void setUp() throws Exception {
        dao = new DAOOrderItem(); // Sử dụng constructor mới
    }

    @AfterEach
    public void tearDown() {
        // System.setOut(outContent);
        dao = null; // Đảm bảo rằng đối tượng dao đã được giải phóng sau khi phương thức kiểm tra kết thúc
    }
    //COI01
    @Test
    void createOrdersItemIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> dao.createOrderItem(null));
        assertEquals("orderItem cannot be null", exception.getMessage());
    }
    //COI02
    @Test
    void createOIwithminPrice() {
        OrderItem oi = new OrderItem();
        oi.setOrderId(29);
        oi.setBookId(11);
        oi.setListPrice(1);
        oi.setQuantity(1);
        int result = dao.createOrderItem(oi);
        assertEquals(1,result);
    }
    //COI03
    @Test
    void createOIwithNotExOderid() {
        OrderItem oi = new OrderItem();
        oi.setOrderId(99);
        oi.setBookId(11);
        oi.setListPrice(1111);
        oi.setQuantity(1111);
        int result = dao.createOrderItem(oi);
        assertEquals(1,result);
    }
    //COI04
    @Test
    void createOIwithNegativeoderid() {
        OrderItem oi = new OrderItem();
        oi.setOrderId(-99);
        oi.setBookId(11);
        oi.setListPrice(1);
        oi.setQuantity(1111);
        int result = dao.createOrderItem(oi);
        assertEquals(1,result);
    }
    //COI05
    @Test
    void createOIwithNullOderid() {
        OrderItem oi = new OrderItem();
        oi.setBookId(11);
        oi.setListPrice(1111);
        oi.setQuantity(1);
        int result = dao.createOrderItem(oi);
        assertEquals(1,result);
    }
    //COI06
    @Test
    void createOIwithNonNumericOderid() {
        OrderItem oi = new OrderItem();
        String oiString = "abc";
        oi.setBookId(11);
        oi.setListPrice(1111);
        oi.setQuantity(1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            oi.setOrderId(Integer.parseInt(oiString));
            dao.createOrderItem(oi);
        });
        assertEquals("Id must be positive",exception.getMessage());
    }
    //COI07
    @Test
    void createOIwithmaxPrice() {
        OrderItem oi = new OrderItem();
        oi.setOrderId(29);
        oi.setBookId(11);
        oi.setListPrice(9999);
        oi.setQuantity(1);
        int result = dao.createOrderItem(oi);
        assertEquals(1,result);
    }
    //COI08
    @Test
    void createOIwithNotExBookid() {
        OrderItem oi = new OrderItem();
        oi.setOrderId(29);
        oi.setBookId(99);
        oi.setListPrice(11111);
        oi.setQuantity(9999);
        int result = dao.createOrderItem(oi);
        assertEquals(1,result);
    }
    //COI09
    @Test
    void createOIwithNegativeBook() {
        OrderItem oi = new OrderItem();
        oi.setOrderId(29);
        oi.setBookId(-99);
        oi.setListPrice(111);
        oi.setQuantity(0);
        int result = dao.createOrderItem(oi);
        assertEquals(1,result);
    }
    //COI010
    @Test
    void createOIwithNullBook() {
        OrderItem oi = new OrderItem();
        oi.setOrderId(29);
        oi.setListPrice(1111);
        oi.setQuantity(11111);
        int result = dao.createOrderItem(oi);
        assertEquals(1,result);
    }
    //COI011
    @Test
    void createOIwithNonNumericBook() {
        OrderItem oi = new OrderItem();
        String bookidString = "abc";
        oi.setOrderId(29);
        oi.setListPrice(1111);
        oi.setQuantity(1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            oi.setOrderId(Integer.parseInt(bookidString));
            dao.createOrderItem(oi);
        });
        assertEquals("Id must be positive",exception.getMessage());
    }
    //COI12
    @Test
    void createOIwithValidAll() {
        OrderItem oi = new OrderItem();
        oi.setOrderId(29);
        oi.setBookId(11);
        oi.setListPrice(333);
        oi.setQuantity(333);
        int result = dao.createOrderItem(oi);
        assertEquals(1,result);
    }
    //COI13
    @Test
    void createOIwithNagativeTwo() {
        OrderItem oi = new OrderItem();
        oi.setOrderId(29);
        oi.setBookId(11);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {

            oi.setListPrice(-99);
            oi.setQuantity(-99);
            dao.createOrderItem(oi);
        });
        assertEquals("this cannot be negative",exception.getMessage());
    }
    //COI14
    @Test
    void createOIwithNonNumericPrice() {
        OrderItem oi = new OrderItem();
        String PriceString = "abc";
        oi.setOrderId(29);
        oi.setBookId(11);
        oi.setQuantity(1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            oi.setOrderId(Integer.parseInt(PriceString));
            dao.createOrderItem(oi);
        });
        assertEquals("Price must be positive",exception.getMessage());
    }
    //COI15
    @Test
    void createOIwithNonNumericQuantity() {
        OrderItem oi = new OrderItem();
        String QuantityString = "abc";
        oi.setOrderId(29);
        oi.setBookId(11);
        oi.setListPrice(333);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            oi.setOrderId(Integer.parseInt(QuantityString));
            dao.createOrderItem(oi);
        });
        assertEquals("Quantity must be positive",exception.getMessage());
    }



}