package mx.oxxo.heroes.model;

import com.google.gson.annotations.SerializedName;

/**
 * * Created by LUIS.RODARTE on 13/09/2018.
 */

public class Comics {
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
