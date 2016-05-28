package com.hack.gymtonic;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by thepr on 17/10/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Dashboard> dash;

    private int rowLayout;
    private Context mContext;

    public MyAdapter(ArrayList<Dashboard> list, int rowLayout, Context context) {

        this.dash = list;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }

    @Override
    public long getItemId(int item) {

        return item;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Dashboard currentDash = dash.get(position);

        //TODO SET IMAGE TO CARD

        viewHolder.cronoImage.setImageDrawable(mContext.getDrawable(currentDash.getCronoImage()));
        viewHolder.activityImage.setImageDrawable(mContext.getDrawable(currentDash.getActivityImage()));

        viewHolder.teamName.setText(currentDash.getName());
        viewHolder.stats.setText(currentDash.getStats());
        viewHolder.best.setText(currentDash.bestName);



    }

    @Override
    public int getItemCount() {

        return dash == null ? 0 : dash.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView cronoImage;
        public ImageView activityImage;

        public TextView teamName;
        public TextView stats;
        public TextView best;


        public ViewHolder(View itemView) {

            super(itemView);

            cronoImage = (ImageView) itemView.findViewById(R.id.cronoImage);
            activityImage = (ImageView) itemView.findViewById(R.id.activityImage);
            teamName = (TextView) itemView.findViewById(R.id.group);
            stats = (TextView) itemView.findViewById(R.id.stats);
            best = (TextView) itemView.findViewById(R.id.best);



        }

    }
}
