package mx.oxxo.heroes.presenter;


import mx.oxxo.heroes.model.Data;
import mx.oxxo.heroes.model.Hero;
import mx.oxxo.heroes.service.HeroService;
import mx.oxxo.heroes.view.description.DescriptionView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LUIS.RODARTE on 13/09/2018.
 */

public class DescriptionPresenter {
    private DescriptionView descriptionView;
    private HeroService heroService;

    public DescriptionPresenter(DescriptionView view) {
        this.descriptionView = view;

        if (this.heroService == null) {
            this.heroService = new HeroService();
        }
    }

    public void getHeroeById(String id) {
        heroService
                .getAPI()
                .getHeroById(id)
                .enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        Data data = response.body();

                        if (data != null && data.getRestResponse() != null) {
                            Hero result = data.getRestResponse().getResult().get(0);
                            descriptionView.heroesReady(result);
                        } else {
                            descriptionView.setAlertError("No data available!");
                        }

                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        try {
                            throw new InterruptedException("Error calling API!");
                        } catch (InterruptedException e) {
                            descriptionView.setAlertError("Data is not available!");
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void onDestroy() {

    }


}
