package aiss.vimeominer.service;

import aiss.vimeominer.exception.MaxCommentsException;
import aiss.vimeominer.exception.MaxVideosException;
import aiss.vimeominer.exception.NotFoundException;
import aiss.vimeominer.model.Caption.Caption;
import aiss.vimeominer.model.Channel.Channel;
import aiss.vimeominer.model.Video.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChannelService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    VideoService videoService;

    String token = "57d3ef4edf7af59951007f17a0b0f200";


    public Channel findOne(String id,Integer maxVideos, Integer maxComments) throws MaxCommentsException, MaxVideosException ,
            NotFoundException {
        HttpHeaders headers = new HttpHeaders();
        String uri = "https://api.vimeo.com/channels/" + id;
        Channel channel = null;
        headers.set("Authorization","Bearer " + token);
        HttpEntity<Channel> request = new HttpEntity<>(null,headers);
        try {
            ResponseEntity<Channel> response = restTemplate.exchange
                    (uri, HttpMethod.GET, request, Channel.class);
            channel = response.getBody();
        }catch (Exception e){
            throw new NotFoundException();
        }
        channel.setVideos(videoService.findAll(channel.getId(),maxVideos, maxComments));

        return channel;
    }



}
