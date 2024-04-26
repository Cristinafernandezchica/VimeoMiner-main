package aiss.vimeominer.service;

import aiss.vimeominer.model.Channel.Channel;
import aiss.vimeominer.model.Comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommentService {

    @Autowired
    RestTemplate restTemplate;

    public Comment findOne(String id){
        HttpHeaders headers = new HttpHeaders();
        String token = "57d3ef4edf7af59951007f17a0b0f200";
        String uri = "https://api.vimeo.com/videos/" + id +"/comments";
        Comment comment = null;
        headers.set("Authorization","Bearer " + token);
        HttpEntity<Comment> request = new HttpEntity<>(null,headers);
        ResponseEntity<Comment> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,Comment.class);
        comment = response.getBody();


        return comment;
    }
}