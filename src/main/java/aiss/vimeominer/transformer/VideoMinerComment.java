package aiss.vimeominer.transformer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

public class VideoMinerComment {

    @JsonProperty("id")
    private String id;

    @JsonProperty("text")
    private String text;

    @JsonProperty("createdOn")
    private String createdOn;

    @JsonProperty("author")
    private VideoMinerUser author;

    public VideoMinerComment(String id, String text, String createdOn, VideoMinerUser author){

        this.id = id;
        this.text = text;
        this.createdOn = createdOn;
        this.author = author;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public VideoMinerUser getAuthor() {
        return author;
    }

    public void setAuthor(VideoMinerUser author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", author=" + author +
                '}';
    }
}
