/*
 * Copyright (c) 2015. Created by PopUp Team. All right Reserved
 */

package com.wikiunipd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by odnal on 20/06/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Activity mActivity;
    private ArrayList<Room> rooms;
    private static LayoutInflater inflater;

    private int rowLayout;
    private Context mContext;


    public MyAdapter(ArrayList<Room> list, int rowLayout, Context context) {

        this.rooms = list;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }


    @Override
    public long getItemId(int item) {
        // TODO Auto-generated method stub
        return item;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Room currentRoom = rooms.get(position);

        viewHolder.title.setText(currentRoom.getName());

        switch(currentRoom.getKind()) {

            //biblioteca
            case 0:
                viewHolder.info.setText(Double.toString(currentRoom.getDistance()) + " Km");
                break;
            //mensa
            case 1:
                viewHolder.info.setText(Double.toString(currentRoom.getDistance()) + " Km");
                break;
            //aula studio
            case 2:
                viewHolder.info.setText(Integer.toString(currentRoom.getSeats()) + " Posti");
                break;
           //aula libera
            case 3:
                viewHolder.info.setText(Integer.toString(currentRoom.getSeats()) + " Posti");
                break;

            default:
                break;

        }


        viewHolder.setIsRecyclable(false);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent openRoom = new Intent(mContext, RoomActivity.class);
                openRoom.putExtra("title", rooms.get(position).getName());
                openRoom.putExtra("kind", rooms.get(position).getKind());
                openRoom.putExtra("address", rooms.get(position).getAddress());
                openRoom.putExtra("floor", rooms.get(position).getFloor());
                openRoom.putExtra("link", rooms.get(position).getLink());
                openRoom.putExtra("seats", rooms.get(position).getSeats());
                openRoom.putExtra("scores", rooms.get(position).getScore());
                openRoom.putExtra("distance", rooms.get(position).getDistance());
                openRoom.putExtra("facilities", rooms.get(position).getFacilities());
                openRoom.putExtra("driving", rooms.get(position).getDrivingIstr());
                openRoom.putExtra("hours", rooms.get(position).getHours());
                openRoom.putExtra("comment", rooms.get(position).getComments());
                openRoom.putExtra("latitude", rooms.get(position).getLatitude());
                openRoom.putExtra("longitude", rooms.get(position).getLongitude());
                openRoom.putExtra("image", rooms.get(position).getImage());

                mContext.startActivity(openRoom);

            }


        });

    }

    @Override
    public int getItemCount() {

        return rooms == null ? 0 : rooms.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView info;


        public ViewHolder(View itemView) {

            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            info = (TextView) itemView.findViewById(R.id.info);

        }

    }

}