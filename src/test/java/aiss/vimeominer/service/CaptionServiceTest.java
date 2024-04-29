package aiss.vimeominer.service;

import aiss.vimeominer.model.Caption.Caption;
import aiss.vimeominer.model.Caption.CaptionList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CaptionServiceTest {

    @Autowired
    CaptionService captionService;

    @Test
    void findOne() {
        Caption caption = captionService.findOne("781632604","61396481");

        System.out.println(caption);
    }

    @Test
    void findAll(){
        CaptionList caption = captionService.findAll("781632604","newyorker");

        System.out.println(caption.getData());
    }
}
