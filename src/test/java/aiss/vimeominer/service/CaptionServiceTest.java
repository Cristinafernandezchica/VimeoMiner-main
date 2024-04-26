package aiss.vimeominer.service;

import aiss.vimeominer.model.Caption.Caption;
import aiss.vimeominer.model.Channel.Channel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CaptionServiceTest {

    @Autowired
    CaptionService captionService;

    @Test
    void findOne() {
        // Caption caption = captionService.findOne();

        System.out.println();
    }
}
