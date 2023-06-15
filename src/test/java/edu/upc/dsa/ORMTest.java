package edu.upc.dsa;

import edu.upc.dsa.models.Usuario;
import edu.upc.eetac.dsa.IUserDAO;
import edu.upc.eetac.dsa.UserDAOImpl;
import edu.upc.eetac.dsa.model.User;
import org.junit.Assert;
import org.junit.Test;

public class ORMTest {

    @Test
    public void getUserTest() {
        IUserDAO userDAO = new UserDAOImpl();
        User user5 = userDAO.getUser(1);
        Assert.assertEquals("jose@gmail.com", user5.getEmail());
        User user2 = userDAO.getUser(2);
        Assert.assertEquals("jose2@gmail.com", user2.getEmail());
    }

    @Test
    public void getUserTest2() {
        IUserDAO userDAO = new UserDAOImpl();
        User user5 = userDAO.getUserByEmail("jose2@gmail.com");
        Assert.assertEquals("Jose", user5.getName());
    }

}
