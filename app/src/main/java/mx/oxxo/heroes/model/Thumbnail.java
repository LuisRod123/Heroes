package mx.oxxo.heroes.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LUIS.RODARTE on 13/09/2018.
 */

public class Thumbnail {
    @SerializedName("path")
    private String path;
    @SerializedName("extension")
    private String extension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getAboslutePath() {
        return path + "/standard_xlarge." + extension;
    }
}
