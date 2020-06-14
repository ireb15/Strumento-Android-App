package com.example.instrument_app;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopPicksAdapter extends RecyclerView.Adapter<TopPicksAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Instrument> topPicks;
    private OnTopPickListener mOnTopPickListener;

    public TopPicksAdapter(Context context, ArrayList<Instrument> topPicks,
                           OnTopPickListener onTopPickListener) {
        this.context = context;
        this.topPicks = topPicks;
        this.mOnTopPickListener = onTopPickListener;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_picks_item,
                parent, false);
        return new ViewHolder(view, mOnTopPickListener);
    }

    //BindViewHolder is reusing old view holders and binding new data in place of the old data.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder vh, int position) {
        vh.topPickCategory.setText(topPicks.get(position).getCategory());
        vh.topPickImage.setImageResource(topPicks.get(position).getImages()[0]);
    }

    @Override
    public int getItemCount() {
        return topPicks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView topPickImage;
        private TextView topPickCategory;
        OnTopPickListener onTopPickListener;

        public ViewHolder(View view, OnTopPickListener onTopPickListener) {
            super(view);
            topPickImage = view.findViewById(R.id.topPickImage);
            topPickCategory = view.findViewById(R.id.topPickCategory);
            this.onTopPickListener = onTopPickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onTopPickListener.onTopPickClick(getAdapterPosition());
        }
    }

    public interface OnTopPickListener {
        void onTopPickClick(int position);
    }
}
