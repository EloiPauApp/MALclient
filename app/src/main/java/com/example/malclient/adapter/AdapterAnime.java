package com.example.malclient.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.malclient.R;
import com.example.malclient.models.Anime;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterAnime extends RecyclerView.Adapter<AdapterAnime.AnimeHolder> {
    private List<Anime> animes;
    private Context context;
    public AdapterAnime(List<Anime> animes) {
        this.animes = animes;
    }

    public void setAnimes(List<Anime> animes) {
        this.animes = animes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AnimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.anime_view, parent, false);
        return new AnimeHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeHolder holder, int position) {
//        holder.imatge.setImageDrawable(Drawable.createFromPath(animes.get(position).getImage_url()));
        Picasso.with(context).load(animes.get(position).getImage_url()).into(holder.imatge);
        holder.nom.setText(animes.get(position).getTitle());
        holder.tag.setText(animes.get(position).getScore()+"");

    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public static class AnimeHolder extends RecyclerView.ViewHolder{
        ImageView imatge;
        TextView nom;
        TextView tag;


        public AnimeHolder(@NonNull View itemView) {
            super(itemView);
            imatge = itemView.findViewById(R.id.imatge);
            nom = itemView.findViewById(R.id.nom);
            tag = itemView.findViewById(R.id.tag);
        }
    }
}
