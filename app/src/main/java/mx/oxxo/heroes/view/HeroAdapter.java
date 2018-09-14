package mx.oxxo.heroes.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import mx.oxxo.heroes.R;
import mx.oxxo.heroes.model.Hero;

/**
 * Created by LUIS.RODARTE on 9/13/18.
 */

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder> {
    private Context mcontext;
    private List<Hero> heroesList;

    public HeroAdapter(Context mcontext, List<Hero> heroesList) {
        this.mcontext = mcontext;
        this.heroesList = heroesList;
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_heroes, parent, false);
        HeroViewHolder holder = new HeroViewHolder(layoutView);
        return holder;
    }


    @Override
    public void onBindViewHolder(HeroViewHolder holder, int position) {
        Hero hero = heroesList.get(position);
        Glide.with(mcontext)
                .load(hero.getThumbnail())
                .apply(new RequestOptions().override(250, 150).placeholder(R.drawable.alpha_gradient).error(R.drawable.alpha_gradient).centerCrop())
                .into(holder.photo);
        Typeface face;
        face = Typeface.createFromAsset(mcontext.getAssets(), "quicksand.ttf");
        holder.name.setTypeface(face);
        holder.name.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return heroesList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView name;

        public HeroViewHolder(View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.img_hero);
            name = itemView.findViewById(R.id.hero_name);
        }
    }
}
