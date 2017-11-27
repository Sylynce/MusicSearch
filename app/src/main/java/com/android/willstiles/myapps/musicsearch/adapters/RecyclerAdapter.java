package com.android.willstiles.myapps.musicsearch.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.willstiles.myapps.musicsearch.Models.Results;
import com.android.willstiles.myapps.musicsearch.R;

import java.util.List;

/**
 * Created by Will Stiles on 11/18/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private List<Results> results;

    public RecyclerAdapter(List<Results> results){
        this.results = results;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_entry, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.artist.setText(results.get(position).getArtistName());
        holder.song.setText(results.get(position).getTrackName());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView artist;
        TextView song;

        public ViewHolder(View itemView) {
            super(itemView);
            artist = itemView.findViewById(R.id.artist);
            song = itemView.findViewById(R.id.song);
        }

    }
}
