package aiss.vimeominer.service;

import aiss.vimeominer.model.Video.Video;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class VideoServiceTest {

    @Autowired
    VideoService videoService;
    @Test
    @DisplayName("Get all videos")
    void findAll() {
        List<Video> videos = videoService.findAll("newyorker",2,3);
        for(Video v : videos) {
            System.out.println(v.toString());
        }
    }
}
