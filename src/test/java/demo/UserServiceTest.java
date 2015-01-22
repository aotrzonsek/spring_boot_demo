package demo;

import demo.jpa.User;
import demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserServiceTest {

    @Autowired
    private UserService userService;

	@Test
	public void testShouldFindUserByName() {
        // given
        final String userName = "Kowalski";
        // when
        User user = userService.findUserByName(userName);
        //then
        assertNotNull(user);
        assertEquals(userName, user.getLastName());
	}
}
