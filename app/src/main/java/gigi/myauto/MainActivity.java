package gigi.myauto;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import gigi.myauto.models.Offer;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Offers");
        }

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NewOfferActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame2, new OfferListFragment())
                .commit();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }if (id == R.id.sort_by_price) {
            Collections.sort(OfferListFragment.getOffers());
            OfferListFragment.notifyDataSetChangedOffers();

            OfferListFragment.sortByPrice();
            return true;

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.about) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("About");
            }
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame2
                            , new AboutActivity())
                    .commit();
        } else if (id == R.id.help) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("Help");
            }
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame2
                            , new Help())
                    .commit();
            } else if (id == R.id.bug_report) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("Bug Report");
            }
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame2
                                , new Bug())
                        .commit();
        }else if (id == R.id.offers) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("Offers");
            }
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame2
                            , new OfferListFragment())
                    .commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void hideFab() {
        fab.hide();
    }

    public void showFab() {
        fab.show();
    }
}
