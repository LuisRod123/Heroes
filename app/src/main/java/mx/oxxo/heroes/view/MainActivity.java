package mx.oxxo.heroes.view;

import android.app.ActionBar;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import mx.oxxo.heroes.R;
/**
 * This class represents the MainActivity.
 * Created by LUIS.RODARTE on 13/09/2018.
 */

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        TextView titleTextView = new TextView(getSupportActionBar().getThemedContext());
        titleTextView.setText(getResources().getString(R.string.app_name));
        Typeface face;
        face = Typeface.createFromAsset(this.getAssets(), "quicksand.ttf");
        titleTextView.setTypeface(face);
        titleTextView.setTextSize(18);
        getSupportActionBar().setCustomView(titleTextView);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HeroesFragment.newInstance());
        transaction.commit();
    }

  
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
