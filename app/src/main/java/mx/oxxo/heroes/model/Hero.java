package mx.oxxo.heroes.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LUIS.RODARTE on 13/09/2018.
 */

public class Hero {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("modified")
    private String modified;
    @SerializedName("thumbnail")
    private Thumbnail thumbnail;

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

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getThumbnail() {
        return thumbnail.getAboslutePath();
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

}
