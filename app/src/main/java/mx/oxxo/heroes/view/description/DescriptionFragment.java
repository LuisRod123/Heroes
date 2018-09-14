package mx.oxxo.heroes.view.description;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import mx.oxxo.heroes.R;
import mx.oxxo.heroes.model.Hero;
import mx.oxxo.heroes.presenter.DescriptionPresenter;

/**
 * Created by LUIS.RODARTE on 13/09/2018.
 */
public class DescriptionFragment extends Fragment implements DescriptionView {

    private View myFragmentView;
    private String hero_id;
    private TextView tvHeroName;
    private TextView tvHeroDescription;
    private ImageView imgHero;
    private ListView lvComics;
    private DescriptionPresenter descriptionPresenter;

    public DescriptionFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HeroesFragment.
     */
    public static DescriptionFragment newInstance() {
        DescriptionFragment fragment = new DescriptionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        descriptionPresenter = new DescriptionPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        hero_id = bundle.getString("hero_id");
        myFragmentView = inflater.inflate(R.layout.fragment_description, container, false);
        descriptionPresenter.getHeroeById(hero_id);
        Typeface face;
        face = Typeface.createFromAsset(container.getContext().getAssets(), "quicksand.ttf");
        tvHeroName = myFragmentView.findViewById(R.id.hero_name);
        tvHeroDescription = myFragmentView.findViewById(R.id.hero_description);
        tvHeroName.setTypeface(face);
        tvHeroDescription.setTypeface(face);
        imgHero = myFragmentView.findViewById(R.id.img_hero);


        return myFragmentView;
    }

    @Override
    public void onStart() {
        super.onStart();

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        descriptionPresenter.onDestroy();
    }

    @Override
    public void heroesReady(Hero hero) {

        if (hero != null) {
            tvHeroName.setText(hero.getName());
            tvHeroDescription.setText(hero.getDescription());
            Glide.with(getContext())
                    .load(hero.getThumbnail())
                    .apply(new RequestOptions().override(250, 150).placeholder(R.drawable.alpha_gradient).error(R.drawable.alpha_gradient).centerCrop())
                    .into(imgHero);
        }

    }

    @Override
    public void setAlertError(String error) {
        Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {

    }
}
