package aiss.vimeominer.service;

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

    public Channel findOne(String id){
        HttpHeaders headers = new HttpHeaders();
        String token = "57d3ef4edf7af59951007f17a0b0f200";
        String uri = "https://api.vimeo.com/channels/" + id;
        Channel channel = null;
        headers.set("Authorization","Bearer " + token);
        HttpEntity<Channel> request = new HttpEntity<>(null,headers);
        ResponseEntity<Channel> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,Channel.class);
        channel = response.getBody();


        return channel;
    }

    // PREGUNTAR AL PROFESOR!!!!
    // CAMBIAR EL API PATH
    public void postDataVideoMiner(Channel channel){
        // Mirar si habria que cambiar el formato de envio de datos a JSON
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Channel> request = new HttpEntity<>(channel, headers);
        restTemplate.postForObject("http://videominer/api/path", request, Channel.class);
    }

    // Otras formas
    public Channel createChannel2(Channel channel){
        String uri = "http://localhost:8080/videominer/channels";

        HttpEntity<Channel> request = new HttpEntity<>(channel);
        ResponseEntity<Channel> responseEx =
                restTemplate.exchange(uri, HttpMethod.POST, request, Channel.class);
        Channel createdChannel = responseEx.getBody();
        return createdChannel;
    }

    public Channel createChannel(Channel channel){
        String uri = "https://api.vimeo.com/channels/" + channel.getId();

        String token = "57d3ef4edf7af59951007f17a0b0f200";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<Channel> request = new HttpEntity<>(channel);
        ResponseEntity<Channel> response = restTemplate.exchange(uri, HttpMethod.POST, request, Channel.class);
        Channel createdChannel = response.getBody();
        return createdChannel;
    }


}
