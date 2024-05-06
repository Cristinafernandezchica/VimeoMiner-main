package aiss.vimeominer.service;

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
    void findOne() {
        Channel channel = channelService.findOne("newyorker",2, 2);
        // VideoMinerUser user = channelTransformer.transform(channel).getVideos().get(0).getComments().get(0).getAuthor();
        System.out.println(channel.getVideos().get(0).getComments().get(0).getUser());
       //  System.out.println(user);
    }
}
