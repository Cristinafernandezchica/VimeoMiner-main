package aiss.vimeominer.service;

import aiss.vimeominer.exception.MaxCommentsException;
import aiss.vimeominer.exception.MaxVideosException;
import aiss.vimeominer.model.Channel.Channel;
import aiss.vimeominer.transformer.ChannelTransformer;
import aiss.vimeominer.transformer.VideoMinerUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class ChannelServiceTest {


    @Autowired
    ChannelService channelService;
    
    ChannelTransformer channelTransformer = new ChannelTransformer();




    @Test
    void findOne() throws MaxCommentsException, MaxVideosException {
        Channel channel = channelService.findOne("newyorker",5, 2);
        System.out.println(channel);

    }
}
