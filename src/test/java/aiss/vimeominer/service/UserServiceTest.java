package aiss.vimeominer.service;

import aiss.vimeominer.model.Comment.Comment;
import aiss.vimeominer.model.Comment.CommentList;
import aiss.vimeominer.model.User.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void findAll() {
        User user = userService.findOne("newyorker");
        System.out.println(user);
    }
}
