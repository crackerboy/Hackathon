/*
 * Copyright (c) 2015. Created by PopUp Team. All right Reserved
 */

package com.wikiunipd;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.heinrichreimersoftware.materialdrawer.DrawerView;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerItem;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerProfile;


public class MainActivity extends ActionBarActivity {

    private DrawerView drawer;
    private ListView mDrawerList;
    private String[] menuTitles;

    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer = (DrawerView) findViewById(R.id.drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getTitle();
        menuTitles = getResources().getStringArray(R.array.string_array_menu);


        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        ) {

            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };

        drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.primary_dark));
        drawerLayout.setDrawerListener(drawerToggle);

        //navigation drawer creation
        populateDrawer();

        if (savedInstanceState == null) {


            Fragment fragment = new FragmentHome();

            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.frame_container, fragment)
                    .commit();


            drawer.selectItem(0);

        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

 /*   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
//add items to navigation drawer
    private void populateDrawer() {

        //header
        drawer.addProfile(new DrawerProfile()
                        .setId(1)

                        .setBackground(getResources().getDrawable(R.drawable.logo_unipd_formatted))

        );


        //home
        drawer.addItem(
                new DrawerItem()
                        // .setImage(getResources().getDrawable(R.drawable.ic_home_grey600_48dp))
                        .setTextPrimary(getString(R.string.navdrawer_item_home))

                        .setOnItemClickListener(new DrawerItem.OnItemClickListener() {
                            @Override
                            public void onClick(DrawerItem drawerItem, long id, int position) {
                                Fragment fragment = new FragmentHome();

                                FragmentManager frgManager = getFragmentManager();
                                frgManager.beginTransaction().replace(R.id.frame_container, fragment)
                                        .commit();

                                setTitle(R.string.navdrawer_item_home);
                                drawerLayout.closeDrawer(drawer);

                                drawer.selectItem(0);

                            }
                        })
        );

        drawer.addDivider();

        //biblioteca
        drawer.addItem(
                new DrawerItem()
                        //.setImage(getResources().getDrawable(R.drawable.ic_cellphone_android_grey600_48dp))
                        .setTextPrimary(getString(R.string.navdrawer_item_biblio))

                        .setOnItemClickListener(new DrawerItem.OnItemClickListener() {
                            @Override
                            public void onClick(DrawerItem drawerItem, long id, int position) {
                                Fragment fragment = new BlankFragment();

                                FragmentManager frgManager = getFragmentManager();
                                frgManager.beginTransaction().replace(R.id.frame_container, fragment)
                                        .commit();

                                setTitle(R.string.navdrawer_item_biblio);
                                drawerLayout.closeDrawer(drawer);
                                drawer.selectItem(2);
                            }
                        })
        );

        //mense
        drawer.addItem(
                new DrawerItem()
                        // .setImage(getResources().getDrawable(R.drawable.ic_cellphone_link_grey600_48dp))
                        .setTextPrimary(getString(R.string.navdrawer_item_mense))

                        .setOnItemClickListener(new DrawerItem.OnItemClickListener() {
                            @Override
                            public void onClick(DrawerItem drawerItem, long id, int position) {
                                Fragment fragment = new BlankFragment();

                                FragmentManager frgManager = getFragmentManager();
                                frgManager.beginTransaction().replace(R.id.frame_container, fragment)
                                        .commit();

                                setTitle(R.string.navdrawer_item_mense);
                                drawerLayout.closeDrawer(drawer);
                                drawer.selectItem(3);
                            }
                        })
        );


        //aule studio
        drawer.addItem(
                new DrawerItem()
                        // .setImage(getResources().getDrawable(R.drawable.ic_android_grey600_48dp))
                        .setTextPrimary(getString(R.string.navdrawer_item_studio))

                        .setOnItemClickListener(new DrawerItem.OnItemClickListener() {
                            @Override
                            public void onClick(DrawerItem drawerItem, long id, int position) {
                                Fragment fragment = new BlankFragment();

                                FragmentManager frgManager = getFragmentManager();
                                frgManager.beginTransaction().replace(R.id.frame_container, fragment)
                                        .commit();

                                setTitle(R.string.navdrawer_item_studio);
                                drawerLayout.closeDrawer(drawer);
                                drawer.selectItem(4);
                            }
                        })
        );

        //aule libere
        drawer.addItem(
                new DrawerItem()
                        // .setImage(getResources().getDrawable(R.drawable.ic_apple_grey600_48dp))
                        .setTextPrimary(getString(R.string.navdrawer_item_libere))

                        .setOnItemClickListener(new DrawerItem.OnItemClickListener() {
                            @Override
                            public void onClick(DrawerItem drawerItem, long id, int position) {
                                Fragment fragment = new BlankFragment();

                                FragmentManager frgManager = getFragmentManager();
                                frgManager.beginTransaction().replace(R.id.frame_container, fragment)
                                        .commit();

                                setTitle(R.string.navdrawer_item_libere);
                                drawerLayout.closeDrawer(drawer);
                                drawer.selectItem(5);
                            }
                        })
        );

        drawer.addDivider();

        //Preferiti
        drawer.addItem(
                new DrawerItem()
                        //   .setImage(getResources().getDrawable(R.drawable.ic_windows_grey600_48dp))
                        .setTextPrimary(getString(R.string.navdrawer_item_prefs))

                        .setOnItemClickListener(new DrawerItem.OnItemClickListener() {
                            @Override
                            public void onClick(DrawerItem drawerItem, long id, int position) {
                                Fragment fragment = new BlankFragment();

                                FragmentManager frgManager = getFragmentManager();
                                frgManager.beginTransaction().replace(R.id.frame_container, fragment)
                                        .commit();

                                setTitle(R.string.navdrawer_item_prefs);
                                drawerLayout.closeDrawer(drawer);
                                drawer.selectItem(7);
                            }
                        })
        );

        //Impostazioni
        drawer.addItem(
                new DrawerItem()
                        //   .setImage(getResources().getDrawable(R.drawable.ic_blackberry_grey600_48dp))
                        .setTextPrimary(getString(R.string.navdrawer_item_settings))

                        .setOnItemClickListener(new DrawerItem.OnItemClickListener() {
                            @Override
                            public void onClick(DrawerItem drawerItem, long id, int position) {
                                Fragment fragment = new BlankFragment();

                                FragmentManager frgManager = getFragmentManager();
                                frgManager.beginTransaction().replace(R.id.frame_container, fragment)
                                        .commit();

                                setTitle(R.string.navdrawer_item_settings);
                                drawerLayout.closeDrawer(drawer);
                                drawer.selectItem(8);
                            }
                        })
        );


    }



}
