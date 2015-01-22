package demo;

import demo.jpa.User;
import demo.repository.UserRepository;
import demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceMockTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Before
    public void init() {
        userService = new UserService();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShouldCallUserRepositoryFindByName() {
        // given
        final String userLastName = "userLastName";
        // when
        userService.findUserByName(userLastName);
        // then
        verify(userRepository).findByName(userLastName);
    }

    @Test
    public void testShouldDeleteUser() {
        // given
        final long userIdToDelete = 1L;
        final User user = mock(User.class);
        when(userRepository.findOne(anyLong())).thenReturn(user);
        when(user.isActive()).thenReturn(true);
        // when
        userService.deleteUserById(userIdToDelete);
        // then
        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(userRepository).findOne(longArgumentCaptor.capture());
        assertEquals(userIdToDelete, longArgumentCaptor.getValue().longValue());
    }

    @Test(expected = RuntimeException.class)
    public void testShouldThrowValidationExceptionOnDeleteUser() {
        // given
        final long userIdToDelete = 1L;
        final User user = mock(User.class);
        when(userRepository.findOne(anyLong())).thenReturn(user);
        when(user.isActive()).thenReturn(false);
        // when
        userService.deleteUserById(userIdToDelete);
        // then
        fail("test should fail there");
    }
}
