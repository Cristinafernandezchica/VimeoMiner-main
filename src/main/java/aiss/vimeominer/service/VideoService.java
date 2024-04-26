package aiss.vimeominer.service;

import aiss.vimeominer.model.User.User;
import aiss.vimeominer.model.Video.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VideoService {

    @Autowired
    RestTemplate restTemplate;

    /*
    public Video findOne(String id){
        HttpHeaders headers = new HttpHeaders();
        String token = "57d3ef4edf7af59951007f17a0b0f200";
        String uri = "https://api.vimeo.com/videos/" + id;
        headers.set("Authorization","Bearer " + token);
        Video video = null;
        HttpEntity<Video> request = new HttpEntity<>(null,headers);
        ResponseEntity<Video> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,Video.class);
        video = response.getBody();
        return video;
    }
    */

    // videos por channel
    public Video findAll(String id_channel){
        HttpHeaders headers = new HttpHeaders();
        String token = "57d3ef4edf7af59951007f17a0b0f200";
        String uri = "https://api.vimeo.com/channels/" + id_channel + "/videos";
        headers.set("Authorization","Bearer " + token);
        Video video = null;
        HttpEntity<Video> request = new HttpEntity<>(null,headers);
        ResponseEntity<Video> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,Video.class);
        video = response.getBody();
        return video;
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

    // POST  -->  PREGUNTAR AL PROFESOR POR ESTO!!!!!!!
    // Esto solo envia los videos a VideoMiner, habria que enviar
    // todo por separado y hacer solicitudes desde VideoMiner por separado
    /*
    public void postDataVideoMiner(Video video){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Video> request = new HttpEntity<>(video, headers);
        restTemplate.postForObject("http://videominer/api/path", request, Video.class);
    }
    */


}
