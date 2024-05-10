
package aiss.vimeominer.model.Video;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import aiss.vimeominer.model.Caption.Caption;
import aiss.vimeominer.model.Comment.Comment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Video {

    @JsonProperty("uri")
    private String uri;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("release_time")
    private String release_time;

    @JsonProperty("comments")
    private List<Comment> comments;

    @JsonProperty("captions")
    private List<Caption> captions;

    public Video() {
        comments = new ArrayList<>();
        captions = new ArrayList<>();
    }

    public String getUri(){
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelease_time() {
        return release_time;
    }

    public void setRelease_time(String release_time) {
        this.release_time = release_time;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Caption> getCaptions() {
        return captions;
    }

    public void setCaptions(List<Caption> captions) {
        this.captions = captions;
    }

    public String getId(){

        String[] id = getUri().split("videos/");

        return id[1];
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Video.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.getId() == null)?"<null>":this.getId()));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("release_time");
        sb.append('=');
        sb.append(((this.release_time == null)?"<null>":this.release_time));
        sb.append(',');
        sb.append("comments");
        sb.append('=');
        sb.append(((this.comments.toString() == null)?"<null>":this.comments.toString()));
        sb.append(',');
        sb.append("captions");
        sb.append('=');
        sb.append(((this.captions.toString() == null)?"<null>":this.captions.toString()));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
