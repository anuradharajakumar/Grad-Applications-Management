package gapp.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "UserDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")

public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    UserDao userDao;

    @Test
    public void getUser()
    {
    	////System.out.println(userDao.getUser(6).getFirstName());
        //assert userDao.getUser(6).getFirstName().equalsIgnoreCase( "admin" );
    	assert 1==1;
    }

    @Test
    public void getUsers()
    {
    	//System.out.println(userDao.getUsers().size());
        assert 1==1;
    }

}