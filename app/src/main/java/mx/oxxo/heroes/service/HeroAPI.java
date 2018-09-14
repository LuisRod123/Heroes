package mx.oxxo.heroes.service;


import mx.oxxo.heroes.model.Data;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by LUIS.RODARTE on 13/09/2018.
 *  * This class represents the Hero API.
 */

public interface HeroAPI {
    @GET("characters?apikey=f9a3b54c9e36c412ca92e59a350b57b0&hash=a99a177a4879b1f1db73e9fa1972339d&ts=9")
    Call<Data> getListHeroes();

    @GET("https://gateway.marvel.com:443/v1/public/characters/{id}?apikey=f9a3b54c9e36c412ca92e59a350b57b0&hash=a99a177a4879b1f1db73e9fa1972339d&ts=9")
    Call<Data> getHeroById(@Path("id") String id);
}
