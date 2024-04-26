package aiss.vimeominer.service;

import aiss.vimeominer.model.Channel.Channel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChannelServiceTest {

    @Autowired
    ChannelService channelService;

    @Test
    void findOne() {
        Channel channel = channelService.findOne("newyorker");
        System.out.println(channel.getVideos());
    }
}
