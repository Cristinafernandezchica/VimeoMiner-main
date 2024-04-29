package aiss.vimeominer.service;

import aiss.vimeominer.model.Caption.Caption;
import aiss.vimeominer.model.Comment.Comment;
import aiss.vimeominer.model.Comment.CommentList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentServiceTest {
    @Autowired
    CommentService commentService;
    @Test
    public void findOne(){
        CommentList comment = commentService.findAll("781632604","newyorker");

        System.out.println(comment.getData().get(0).getUser());


    }
}
