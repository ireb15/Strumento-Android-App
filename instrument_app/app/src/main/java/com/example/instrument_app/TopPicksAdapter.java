package com.example.instrument_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TopPicksAdapter extends RecyclerView.Adapter<TopPicksAdapter.TopPicksViewHolder> {
    private Context context;
    private ArrayList<Instrument> topPicks;


    public TopPicksAdapter(Context context, ArrayList<Instrument> topPicks) {
        this.context = context;
        this.topPicks = topPicks;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public TopPicksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         TopPicksViewHolder vh = new TopPicksViewHolder(LayoutInflater.from(context).inflate(R.layout.top_picks_item,
                parent, false));
         return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TopPicksViewHolder vh, int position) {
        vh.topPickCategory.setText(topPicks.get(position).getCategory());
        vh.topPickImage.setImageResource(topPicks.get(position).getImages()[0]);
    }

    @Override
    public int getItemCount() {
        return topPicks.size();
    }

    public class TopPicksViewHolder extends RecyclerView.ViewHolder {
        private ImageView topPickImage;
        private TextView topPickCategory;

        public TopPicksViewHolder(View view) {
            super(view);
            topPickImage = view.findViewById(R.id.topPickImage);
            topPickCategory = view.findViewById(R.id.topPickCategory);
        }
    }
}
