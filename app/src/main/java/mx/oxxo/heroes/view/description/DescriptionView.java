package mx.oxxo.heroes.view.description;

import mx.oxxo.heroes.model.Hero;


/**
 * This class represents the Hero view interface.
 * Created by LUIS.RODARTE on 13/09/2018.
 */

public interface DescriptionView {

    void heroesReady(Hero heroe);

    void setAlertError(String error);

    void navigateToHome();
}
