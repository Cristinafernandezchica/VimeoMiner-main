package aiss.vimeominer.transformer;

import aiss.vimeominer.model.Caption.Caption;
import aiss.vimeominer.model.Channel.Channel;
import aiss.vimeominer.model.Comment.Comment;
import aiss.vimeominer.model.User.User;
import aiss.vimeominer.model.Video.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


public class ChannelTransformer {

    @Autowired
    RestTemplate restTemplate;



    public VideoMinerChannel transform(Channel channel){
        VideoMinerChannel videoChannel = new VideoMinerChannel();
        videoChannel.setId(channel.getId());
        videoChannel.setVideos(transfromVideos(channel.getVideos()));
        videoChannel.setName(channel.getName());
        videoChannel.setDescription(channel.getDescription());
        videoChannel.setCreatedTime(channel.getCreatedTime());

        return videoChannel;
    }

    public ChannelTransformer(){


    }

    private List<VideoMinerVideo> transfromVideos(List<Video> lVideo){
        List<VideoMinerVideo> res = new ArrayList<>();
        for(Video video : lVideo){
            List<VideoMinerComment> vMc = transfromComments(video.getComments());
            List<VideoMinerCaption> vMcap = transfromCaptions(video.getCaptions());
            VideoMinerVideo vMv = new VideoMinerVideo(
                    video.getId(),
                    video.getName(),
                    video.getDescription(),
                    video.getRelease_time(),
                    vMc,
                    vMcap
            );

            res.add(vMv);

        }


        return res;
    }

    private List<VideoMinerCaption> transfromCaptions(List<Caption> captions) {
        List<VideoMinerCaption> res = new ArrayList<>();
        for(Caption caption : captions){
            VideoMinerCaption vMcap = new VideoMinerCaption(
                    caption.getId(),
                    caption.getName(),
                    caption.getLanguage()


            );
            res.add(vMcap);

        }

        return  res;

    }

    private List<VideoMinerComment> transfromComments(List<Comment> comments) {
        List<VideoMinerComment> res = new ArrayList<>();
        for (Comment comment : comments){
            VideoMinerUser vMu = transformUser(comment.getUser());
            VideoMinerComment vMc = new VideoMinerComment(
                    comment.getId(),
                    comment.getText(),
                    comment.getCreatedOn(),
                    vMu

            );

            res.add(vMc);
        }

        return  res;
    }

    private VideoMinerUser transformUser(User user) {
        VideoMinerUser res = new VideoMinerUser(
                user.getName(),
                user.getLink(),
                user.getPictureLink());

        return  res;

    }
}
