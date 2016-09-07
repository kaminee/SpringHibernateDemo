/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.journaldev.spring.UserController;
import com.journaldev.spring.dao.UserDAO;
import com.journaldev.spring.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:test-servlet.xml"})
public class UserControllerTest {

    private UserDAO userDAO;

    private UserController userController;

    public UserControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        userController = new UserController();

    }

    @After
    public void tearDown() {

    }

    /**
     * Test of getUser method, of class UserController.
     */
  /*  @Test
    public void testGetInvalidUser() throws Exception {
        String userType = "";
        Map expResult = new HashMap();
        expResult.put("data", "No record found");
        Map result = userController.getUser(userType);
        verifyZeroInteractions(userServiceMock);
        assertEquals(result, expResult);
    }
*/
    @Test
    public void testGetEmployeeUser() throws Exception {
        //http://docs.mockito.googlecode.com/hg/org/mockito/Mockito.html#3
        String userType = "employee";
        long id=2l;
        Map expResult = new HashMap();
//        ResponseEntity<User> expResult1=new ResponseEntity<User>(HttpStatus.OK);
        User user = new User();
        user.setAddress("asdasd");
        user.setUsername("KIran");
        user.setEmail("adas@mail.com");
        expResult.put("data", user);
        Map result = (Map) userController.fetchUserById(id);

//        verify(userServiceMock, times(1)).getEmployeeDetails();
//        verifyNoMoreInteractions(userServiceMock);

        assertEquals(result, expResult);
    }

}
