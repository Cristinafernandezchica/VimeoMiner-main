package aiss.vimeominer.service;

import aiss.vimeominer.model.Channel.Channel;
import aiss.vimeominer.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    String token = "57d3ef4edf7af59951007f17a0b0f200";

    public User findOne(String id){
        HttpHeaders headers = new HttpHeaders();
        String uri = "https://api.vimeo.com/users/" + id;
        headers.set("Authorization","Bearer " + token);
        User user = null;
        HttpEntity<User> request = new HttpEntity<>(null,headers);
        ResponseEntity<User> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,User.class);
        user = response.getBody();
        return user;
    }

}
