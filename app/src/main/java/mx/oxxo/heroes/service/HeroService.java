package mx.oxxo.heroes.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LUIS.RODARTE on 13/09/2018.
 * This class represents the Hero service.
 */


public class HeroService {
    private Retrofit retrofit = null;

    /**
     * This method creates a new instance of the API interface.
     * https://gateway.marvel.com/v1/public/characters?apikey=f9a3b54c9e36c412ca92e59a350b57b0&hash=a99a177a4879b1f1db73e9fa1972339d&ts=9
     *
     * @return The API interface
     */
    public HeroAPI getAPI() {
        String BASE_URL = "https://gateway.marvel.com/v1/public/";
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(HeroAPI.class);
    }
}