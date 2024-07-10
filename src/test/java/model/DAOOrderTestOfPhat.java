package model;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entity.Order;
import static org.junit.jupiter.api.Assertions.*;

class DAOOrderTestOfPhat {
    private DAOOrder dao;
    @BeforeEach
    void setUp() throws Exception {
        dao = new DAOOrder();
    }

    @AfterEach
    public void tearDown() {
        dao = null;
    }
    //UOS01
    @Test
    void uOSValid() {
        int result = dao.updateOrderStatus(29,1);
        assertEquals(1,result);
    }
    //UOS02
    @Test
    void uOSwithNotExOderid() {
        int result = dao.updateOrderStatus(99,1);
        assertEquals(1,result);
    }
    //UOS03
    @Test
    void uOSwithNegativeoderid() {
        int result = dao.updateOrderStatus(-99,1);
        assertEquals(1,result);
    }
    //UOS04
    @Test
    void uOSwithNonNumericOderid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int result = dao.updateOrderStatus(Integer.parseInt("abc"),29);
        });
        assertEquals("Id must be exist",exception.getMessage());
    }
    //UOS05
    @Test
    void uOSwithNegativeStatus() {
        int result = dao.updateOrderStatus(29,-99);
        assertEquals(1,result);
    }
    //UOS06
    @Test
    void uOSwithNotExistStatus() {
        int result = dao.updateOrderStatus(29,99);
        assertEquals(1,result);
    }
    //UOS07
    @Test
    void uOSwithNonNumericStatus() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int result = dao.updateOrderStatus(29,Integer.parseInt("abc"));
        });
        assertEquals("Id must be exist",exception.getMessage());

    }

}