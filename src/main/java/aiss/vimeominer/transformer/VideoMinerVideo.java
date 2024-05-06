package aiss.vimeominer.transformer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class VideoMinerVideo {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("releaseTime")
    private String releaseTime;

    @JsonProperty("comments")
    private List<VideoMinerComment> comments;

    @JsonProperty("captions")
    private List<VideoMinerCaption> captions;

    public VideoMinerVideo(String Pid, String pName, String pDescription,
                           String pReleaseTime, List<VideoMinerComment> pComments, List<VideoMinerCaption> pCaptions){

        this.id = Pid;
        this.name = pName;
        this.description = pDescription;
        this.releaseTime = pReleaseTime;
        this.comments = pComments;
        this.captions = pCaptions;



    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public List<VideoMinerComment> getComments() {
        return comments;
    }

    public void setComments(List<VideoMinerComment> comments) {
        this.comments = comments;
    }

    public List<VideoMinerCaption> getCaptions() {
        return captions;
    }

    public void setCaptions(List<VideoMinerCaption> captions) {
        this.captions = captions;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", comments=" + comments +
                ", captions=" + captions +
                '}';
    }

}
