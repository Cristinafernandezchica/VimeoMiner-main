package aiss.vimeominer.model.Comment;

import aiss.vimeominer.model.Caption.Caption;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentList {

    @JsonProperty("data")
    private List<Comment> data;

    @JsonProperty("data")
    public List<Comment> getData(){
        return data;
    }
}
