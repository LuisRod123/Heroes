package mx.oxxo.heroes.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LUIS.RODARTE on 13/09/2018.
 */

public class Data {
 @SerializedName("data")
 private RestResponse data;

    public RestResponse getRestResponse() {
        return data;
    }


}
