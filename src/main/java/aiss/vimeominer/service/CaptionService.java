package aiss.vimeominer.service;

import aiss.vimeominer.model.Caption.Caption;
import aiss.vimeominer.model.Caption.CaptionList;
import aiss.vimeominer.model.Comment.CommentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CaptionService {

    String token = "57d3ef4edf7af59951007f17a0b0f200";

    @Autowired
    RestTemplate restTemplate;
    public Caption findOne(String videoId,String captionId){
        HttpHeaders headers = new HttpHeaders();
        String uri = "https://api.vimeo.com/videos/"+ videoId +
                "/texttracks/"+ captionId;
        Caption caption = null;
        headers.set("Authorization","Bearer " + token);
        HttpEntity<Caption> request = new HttpEntity<>(null,headers);
        ResponseEntity<Caption> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,Caption.class);
        caption = response.getBody();

        return caption;
    }

    public CaptionList findAll(String videoId, String channelId){
        HttpHeaders headers = new HttpHeaders();
        String uri = "https://api.vimeo.com/channels/"+ channelId +
                "/videos/"+ videoId + "/texttracks";
        CaptionList captions = null;
        headers.set("Authorization","Bearer " + token);
        HttpEntity<Caption> request = new HttpEntity<>(null,headers);
        ResponseEntity<CaptionList> response = restTemplate.exchange
                (uri, HttpMethod.GET,request, CaptionList.class);
        if(response.hasBody()){
            return response.getBody();
        } else{
            return new CaptionList();
        }
    }



}
