package mx.oxxo.heroes.presenter;


import java.util.List;

import mx.oxxo.heroes.model.Data;
import mx.oxxo.heroes.model.Hero;
import mx.oxxo.heroes.service.HeroService;
import mx.oxxo.heroes.view.HeroView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LUIS.RODARTE on 13/09/2018.
 */

public class HeroPresenter {
    private HeroView heroView;
    private HeroService heroService;

    public HeroPresenter(HeroView view) {
        this.heroView = view;

        if (this.heroService == null) {
            this.heroService = new HeroService();
        }
    }

    public void getHeroes() {
        heroService
                .getAPI()
                .getListHeroes()
                .enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        Data data = response.body();

                        if (data != null && data.getRestResponse() != null) {
                            List<Hero> result = data.getRestResponse().getResult();
                            heroView.heroesReady(result);
                        } else {
                            heroView.setAlertError("No data available!");
                        }
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        try {
                            throw new InterruptedException("Error calling API");
                        } catch (InterruptedException e) {
                            heroView.setAlertError("Data is not available!");
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void onDestroy() {
    }


}
