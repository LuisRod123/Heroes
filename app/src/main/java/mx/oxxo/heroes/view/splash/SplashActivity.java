package mx.oxxo.heroes.view.splash;

/**
 * This class represents the Splash Screen Activity.
 * Created by LUIS.RODARTE on 13/09/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

import mx.oxxo.heroes.view.MainActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new CountDownTimer(1000, 1000) {
            public void onFinish() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }

            public void onTick(long millisUntilFinished) {
            }
        }.start();

    }
}