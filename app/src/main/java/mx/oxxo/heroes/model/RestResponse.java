package mx.oxxo.heroes.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by LUIS.RODARTE on 13/09/2018.
 */

public class RestResponse {

    @SerializedName("results")
    private List<Hero> result;

    public List<Hero> getResult() {
        return result;
    }
}
