package aiss.vimeominer.model.Channel;



import aiss.vimeominer.model.Video.Video;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {

        @JsonProperty("uri")
        private String uri;

        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("description")
        private String description;

        @JsonProperty("created_time")
        private String createdTime;

        @JsonProperty("videos")
        private List<Video> videos;

        // Constructor
        public Channel() {
        videos = new ArrayList<>();
        }


        @JsonProperty("id")
        public String getId(){
            String[] id = getUri().split("/");

        return id[2];
    }

        @JsonProperty("uri")
        public String getUri() {
            return uri;
        }

        @JsonProperty("uri")
        public void setUri(String uri) {
            this.uri = uri;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        @JsonProperty("created_time")
        public String getCreatedTime() {
            return createdTime;
        }

        @JsonProperty("created_time")
        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        @JsonProperty("videos")
        public List<Video> getVideos(){return videos;}

        @JsonProperty("videos")
        public void setVideos(List<Video> videos) {
        this.videos = videos;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Channel.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
            sb.append("created_time");
            sb.append('=');
            sb.append(((this.createdTime == null)?"<null>":this.createdTime));
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }



    }