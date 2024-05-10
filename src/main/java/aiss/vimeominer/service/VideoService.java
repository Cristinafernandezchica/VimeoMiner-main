package aiss.vimeominer.service;

import aiss.vimeominer.model.User.User;
import aiss.vimeominer.model.Video.Video;
import aiss.vimeominer.model.Video.VideoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class VideoService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CaptionService captionService;
    @Autowired
    CommentService commentService;


    // videos por channel
    public List<Video> findAll(String id_channel,Integer maxVideos, Integer maxComments){
        HttpHeaders headers = new HttpHeaders();
        String token = "57d3ef4edf7af59951007f17a0b0f200";
        String uri = "https://api.vimeo.com/channels/" + id_channel + "/videos";
        headers.set("Authorization","Bearer " + token);
        List<Video> videos = null;
        HttpEntity<String> request = new HttpEntity<>(null,headers);
        ResponseEntity<VideoList> response = restTemplate.exchange
                (uri, HttpMethod.GET,request, VideoList.class);
        videos = response.getBody().getData().stream().limit(maxVideos).toList();
        videos.stream().forEach(v -> v.setCaptions(captionService.findAll(v.getId(),id_channel).getData()));
        videos.stream().forEach(v -> v.setComments(commentService.findAll(v.getId(),id_channel).getData().stream().limit(maxComments).toList()));
        return videos;
    }

    // un video por channel

    public Video findOne(String id_channel, String id_video){
        HttpHeaders headers = new HttpHeaders();
        String token = "57d3ef4edf7af59951007f17a0b0f200";
        String uri = "https://api.vimeo.com/channels/" + id_channel + "/videos/" + id_video;
        headers.set("Authorization","Bearer " + token);
        Video video = null;
        HttpEntity<Video> request = new HttpEntity<>(null,headers);
        ResponseEntity<Video> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,Video.class);
        video = response.getBody();
        return video;
    }


}
