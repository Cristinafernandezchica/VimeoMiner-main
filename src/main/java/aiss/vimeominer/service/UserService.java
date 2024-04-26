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
    public User findOne(String id){
        HttpHeaders headers = new HttpHeaders();
        String token = "57d3ef4edf7af59951007f17a0b0f200";
        String uri = "https://api.vimeo.com/users/" + id;
        headers.set("Authorization","Bearer " + token);
        User user = null;
        HttpEntity<User> request = new HttpEntity<>(null,headers);
        ResponseEntity<User> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,User.class);
        user = response.getBody();
        return user;
    }

    /*
    public User createUser(User user){

        String uri = "https://api.vimeo.com/users/";

        HttpEntity<User> request = new HttpEntity<>(user);
        ResponseEntity<User> responseEx = restTemplate.exchange("https://api.vimeo.com/users/" + user.getId(), HttpMethod.POST, request, User.class);
        User createdUser = responseEx.getBody();
        return createdUser;
    }
    */
}
