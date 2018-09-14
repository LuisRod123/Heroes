package mx.oxxo.heroes.view;

import android.view.View;

import java.util.List;

import mx.oxxo.heroes.model.Hero;


/**
 * This class represents the Hero view interface.
 * Created by LUIS.RODARTE on 13/09/2018.
 */

public interface HeroView {

    void heroesReady(List<Hero> heroes);

    void setAlertError(String error);

    void navigateToDescription(View view, int position);
}
