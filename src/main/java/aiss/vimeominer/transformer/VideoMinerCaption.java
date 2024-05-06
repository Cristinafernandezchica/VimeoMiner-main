package aiss.vimeominer.transformer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoMinerCaption {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("language")
    private String language;

    public VideoMinerCaption(Integer id, String name,String language){
        this.id = String.valueOf(id);
        this.name = name;
        this.language = language;

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Caption{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                '}';
    }


}
