package mx.oxxo.heroes.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.oxxo.heroes.R;
import mx.oxxo.heroes.model.Hero;
import mx.oxxo.heroes.presenter.HeroPresenter;
import mx.oxxo.heroes.view.description.DescriptionFragment;

/**
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link HeroesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeroesFragment extends Fragment implements HeroView {

    private View myFragmentView;
    private RecyclerView recyclerViewHeroes;
    private HeroAdapter heroeAdapter;
    private List<Hero> listHeroes;
    private HeroPresenter heroPresenter;
    private GridLayoutManager gridLayoutManager;

    public HeroesFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HeroesFragment.
     */
    public static HeroesFragment newInstance() {
        HeroesFragment fragment = new HeroesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        heroPresenter = new HeroPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragmentView = inflater.inflate(R.layout.fragment_heroes, container, false);
        recyclerViewHeroes = myFragmentView.findViewById(R.id.recycleViewHeroes);
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewHeroes.setLayoutManager(gridLayoutManager);
        recyclerViewHeroes.setHasFixedSize(true);
        heroPresenter.getHeroes();
        recyclerViewHeroes.addOnItemTouchListener(
                new RecyclerItemClickListener(container.getContext(), recyclerViewHeroes, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        navigateToDescription(view, position);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );

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
        heroPresenter.onDestroy();
    }

    @Override
    public void heroesReady(List<Hero> heroes) {
        listHeroes = new ArrayList<>(heroes);
        heroeAdapter = new HeroAdapter(getContext(), listHeroes);
        recyclerViewHeroes.setAdapter(heroeAdapter);
    }

    @Override
    public void setAlertError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToDescription(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putString("hero_id", listHeroes.get(position).getId());
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DescriptionFragment descriptionFragment = new DescriptionFragment();
        descriptionFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.frame_layout, descriptionFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.addToBackStack(descriptionFragment.getTag());
        fragmentTransaction.commit();
    }
}
