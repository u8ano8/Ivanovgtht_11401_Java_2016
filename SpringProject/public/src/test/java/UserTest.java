import mvc.common.UsersInfo;
import mvc.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {

    UserService service;

    @Before
    public void setUp(){
        UsersInfo user = new UsersInfo("andrewivanov97@mail.ru","123456","andrewivanov97@mail.ru","Andrew","ROLE_ADMIN");
        service = mock(UserService.class);
        when(service.getByLogin("andrewivanov97@mail.ru")).thenReturn(user);
    }

    @Test
    public void usernameTest(){
        UsersInfo user = service.getByLogin("andrewivanov97@mail.ru");
        Assert.assertEquals("andrewivanov97@mail.ru",user.getLogin());
    }

    @Test
    public void emailTest(){
        UsersInfo user = service.getByLogin("andrewivanov97@mail.ru");
        Assert.assertEquals("andrewivanov97@mail.ru",user.getEmail());
    }

    @Test
    public void nameTest(){
        UsersInfo user = service.getByLogin("andrewivanov97@mail.ru");
        Assert.assertEquals("Andrew",user.getName());
    }

    @Test
    public void roleTest(){
        UsersInfo user = service.getByLogin("andrewivanov97@mail.ru");
        Assert.assertEquals("ROLE_ADMIN",user.getRole());
    }

}
