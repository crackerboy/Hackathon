/*
 * Copyright (c) 2015. Created by PopUp Team. All right Reserved
 */

package com.wikiunipd;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by odnal on 20/06/2015.
 */
public class FragmentHome extends Fragment {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MyAdapter mAdapter;
    ArrayList<Room> rooms;

    public FragmentHome() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment_layout, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);


        rooms = populateDatabase(rooms);


        mAdapter = new MyAdapter (rooms, R.layout.row, getActivity());
        mRecyclerView.setAdapter(mAdapter);

        return view;

    }

    private ArrayList<Room> populateDatabase(ArrayList<Room> list) {

        list = new ArrayList<Room>();
        Room tempRoom = new Room(0,"Biblioteca di Ateneo \"F. Metelli\"", "Psicologia", "Via Venezia 12/2", 5, "http://bibliotecapsicologia.cab.unipd.it", 134);
        tempRoom.setDistance(1.0);
        tempRoom.setLatitude(45.411005);
        tempRoom.setLongitude(11.893756);
        tempRoom.setHours("Lunedi-Venerdi 8.30-22.00 \nSabato 9.00-14.00");
        tempRoom.setImage(R.drawable.metelli_map);
        list.add(tempRoom);

        Room tempRoom2 = new Room(2,"Aula Studio \"Jappelli\"", "Ateneo", "Via Jappelli 9", 0, "https://www.facebook.com/groups/46801716712/?fref=ts", 184);
        tempRoom2.setDistance(3.1);
        tempRoom2.setLatitude(45.408543);
        tempRoom2.setLongitude(11.884983);
        tempRoom2.setHours("Lunedi-Venerdi 8.30-23.00 \nSabato 9.00-20.00 \nDomenica 14.00-19.00");
        tempRoom2.setImage(R.drawable.japelli_map);
        list.add(tempRoom2);

        Room tempRoom3 = new Room(1,"Mensa \"San Francesco\"", "Ateneo", "Via S. Francesco 122", 0, "http://www.esupd.gov.it/it", 200);
        tempRoom3.setDistance(1.8);
        tempRoom3.setLatitude(45.404625);
        tempRoom3.setLongitude(11.881642);
        tempRoom3.setHours("Lunedi-Venerdi 11.30-14.30");
        tempRoom3.setImage(R.drawable.francesco_map);
        list.add(tempRoom3);

        Room tempRoom4 = new Room(3,"Aula \"P6\"", "Ingegneria", "Via Belzoni 7", 2, "https://aulario.dmsa.unipd.it/", 25);
        tempRoom4.setDistance(1.8);
        tempRoom4.setLatitude(45.408122);
        tempRoom4.setLongitude(11.886629);
        tempRoom4.setHours("Dal 3 giugno al 25 luglio: \nLunedi-Venerdi 8.00-18.30");
        tempRoom4.setImage(R.drawable.paolotti_map);
        list.add(tempRoom4);

        return list;
    }
}