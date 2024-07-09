package model;

import entity.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DAOUserTest {
    private DAOUser dao;


    @BeforeEach
    void setUp() throws Exception {
        dao = new DAOUser(); // Sử dụng constructor mới
    }

    @AfterEach
    public void tearDown() {
       // System.setOut(outContent);
        dao = null; // Đảm bảo rằng đối tượng dao đã được giải phóng sau khi phương thức kiểm tra kết thúc
    }

    @Test
    void userRegister_UTCID01() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> dao.userRegister(null));
        assertEquals("User cannot be null", exception.getMessage());
    }

    @Test
    void userRegister_UTCID02() {
        User user = new User();
        user.setName(null);
        user.setEmail("a@gmail.com");
        user.setPhonenumber("01234567890");
        user.setPassword("123456789");

        int result = dao.userRegister(user);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> dao.userRegister(user));
        assertEquals("User cannot be null", exception.getMessage());
    }

    @Test
    void userRegister_UTCID03() {
        User user = new User();
        user.setName("     ");
        user.setEmail("     ");
        user.setPhonenumber("    ");
        user.setPassword("    ");

        int result = dao.userRegister(user);

        assertEquals(0, result);
    }
    @Test
    void userRegister_UTCID04() {
        User user = new User();
        user.setName("");
        user.setEmail("");
        user.setPhonenumber("");
        user.setPassword("");

        int result = dao.userRegister(user);

        assertEquals(0, result);
    }
    @Test
    void userRegister_UTCID05() {
        User user = new User();
        user.setName("aaa");
        user.setEmail("a@.com");
        user.setPhonenumber("0123456789");
        user.setPassword("12345678");

        int result = dao.userRegister(user);

        assertEquals(1, result);
    }
    @Test
    void userRegister_UTCID06() {
        User user = new User();
        user.setName("a".repeat(50));
        user.setEmail("a".repeat(46) + "@.com");
        user.setPhonenumber("012345678912");
        user.setPassword("a".repeat(50));

        int result = dao.userRegister(user);

        assertEquals(1, result);
    }
    @Test
    void userRegister_UTCID07() {
        User user = new User();
        user.setName("quannv");
        user.setEmail("a@gmail.com");
        user.setPhonenumber("01234567890");
        user.setPassword("123456789");

        int result = dao.userRegister(user);

        assertEquals(1, result);
    }
    @Test
    void userRegister_UTCID08() {
        User user = new User();
        user.setName("quannv");
        user.setEmail(null);
        user.setPhonenumber("01234567890");
        user.setPassword("123456789");

        int result = dao.userRegister(user);

        assertEquals(0, result);
    }
    @Test
    void userRegister_UTCID09() {
        User user = new User();
        user.setName("quannv");
        user.setEmail("a@gmail.com");
        user.setPhonenumber(null);
        user.setPassword("123456789");

        int result = dao.userRegister(user);

        assertEquals(0, result);
    }
    @Test
    void userRegister_UTCID010() {
        User user = new User();
        user.setName("quannv");
        user.setEmail("a@gmail.com");
        user.setPhonenumber("01234567890");
        user.setPassword(null);

        int result = dao.userRegister(user);

        assertEquals(0, result);
    }
    @Test
    void Login_UTCID01() {

        User user = dao.login(null, "123456789");


        assertNull(user);

    }
    @Test
    void Login_UTCID02() {

        User user = dao.login("nguhoangvn123@gmail.com", null);
        assertNull(user);
    }

    @Test
    void Login_UTCID03() {

        User user = dao.login(null, null);
        assertNull(user);
    }
    @Test
    void Login_UTCID04() {

        User user = dao.login("aa@gmai.com", "123456789");
        assertNull(user);
    }
    @Test
    void Login_UTCID05() {

        User user = dao.login("aa@gmai.com", "123456789@");
        assertNull(user);
    }
    @Test
    void Login_UTCID06() {

        User user = dao.login("nguhoangvn123@gmail.com", "123456789");
        assertNull(user);
    }
    @Test
    void Login_UTCID07() {

        User user = dao.login("nguhoangvn123@gmail.com", "123456789@");
        assertNotNull(user);
    }
}
