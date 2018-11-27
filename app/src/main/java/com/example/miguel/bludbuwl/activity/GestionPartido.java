package com.example.miguel.bludbuwl.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.miguel.bludbuwl.Partida;
import com.example.miguel.bludbuwl.R;
import com.example.miguel.bludbuwl.fragments.FragmentEquipoA;
import com.example.miguel.bludbuwl.fragments.FragmentEquipoB;
import com.example.miguel.bludbuwl.fragments.FragmentPartido;

public class GestionPartido extends AppCompatActivity {

    public static Partida partidaEnCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        partidaEnCurso = (Partida) getIntent().getSerializableExtra("partida");

        partidaEnCurso.setReRollsA(AlineacionesUtilidades.obtenerAlineacionPorNombre(partidaEnCurso.getEquipoA()).getReRolls());
        partidaEnCurso.setReRollsB(AlineacionesUtilidades.obtenerAlineacionPorNombre(partidaEnCurso.getEquipoB()).getReRolls());
        setContentView(R.layout.gestion_partido);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Equipo A"));
        tabLayout.addTab(tabLayout.newTab().setText("Partido"));
        tabLayout.addTab(tabLayout.newTab().setText("Equipo B"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = findViewById(R.id.view_pager);
        GestionPartidoTabsAdapter tabsAdapter = new GestionPartidoTabsAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * Created by tutlane on 19-12-2017.
     */

    public static class GestionPartidoTabsAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;


        public GestionPartidoTabsAdapter(FragmentManager fm, int NoofTabs) {
            super(fm);
            this.mNumOfTabs = NoofTabs;
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new FragmentEquipoA();
                    return fragment;
                case 1:
                    fragment = new FragmentPartido();
                    return fragment;
                case 2:
                    fragment = new FragmentEquipoB();
                    return fragment;

                default:
                    return null;
            }

        }
    }
}


