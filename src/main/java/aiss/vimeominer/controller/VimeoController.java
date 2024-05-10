package aiss.vimeominer.controller;

import aiss.vimeominer.exception.MaxCommentsException;
import aiss.vimeominer.exception.MaxVideosException;
import aiss.vimeominer.exception.NotFoundException;
import aiss.vimeominer.model.Channel.Channel;
import aiss.vimeominer.service.ChannelService;
import aiss.vimeominer.transformer.ChannelTransformer;
import aiss.vimeominer.transformer.VideoMinerChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/vimeo/channels")
public class VimeoController {

    @Autowired
    ChannelService channelService;
    @Autowired
    RestTemplate restTemplate;

    ChannelTransformer channelTransformer = new ChannelTransformer();

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public VideoMinerChannel create(@PathVariable String id,
                                     @RequestParam(required = false, defaultValue = "10") Integer maxVideos,
                                     @RequestParam(required = false, defaultValue = "10") Integer maxComments)
            throws MaxCommentsException, MaxVideosException, NotFoundException {
        Channel newChannel = channelService.findOne(id, maxVideos, maxComments);
        VideoMinerChannel videoChannel = channelTransformer.transform(newChannel);
        String uri = "http://localhost:8080/videominer/channels";
        HttpEntity<VideoMinerChannel> request = new HttpEntity<>(videoChannel);
        ResponseEntity<VideoMinerChannel> responseEx =
                restTemplate.exchange(uri, HttpMethod.POST, request, VideoMinerChannel.class);
        VideoMinerChannel createdChannel = responseEx.getBody();
        
        return createdChannel;
    }

    @GetMapping("/{id}")
    public Channel getChannel(@PathVariable String id, @RequestParam(required = false, defaultValue = "10") Integer maxVideos,
                              @RequestParam(required = false, defaultValue = "10") Integer maxComments) throws MaxCommentsException, MaxVideosException, NotFoundException {
        Channel channel = channelService.findOne(id, maxVideos, maxComments);
        return channel;
    }

}
