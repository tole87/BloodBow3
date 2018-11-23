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

    static Partida partidaEnCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        partidaEnCurso = (Partida) getIntent().getSerializableExtra("partida");
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
            switch (position) {
                case 0:
                    FragmentEquipoA equipoA = new FragmentEquipoA();
                    Bundle argsEquipoA = new Bundle();
                    argsEquipoA.putString("equipo", partidaEnCurso.getEquipoA());
                    equipoA.setArguments(argsEquipoA);
                    return equipoA;

                case 1:
                    FragmentPartido partido = new FragmentPartido();
                    Bundle argsPartido = new Bundle();
                    argsPartido.putSerializable("partida", partidaEnCurso);
                    partido.setArguments(argsPartido);
                    return partido;
                case 2:
                    FragmentEquipoB equipoB = new FragmentEquipoB();
                    Bundle argsEquipoB = new Bundle();
                    argsEquipoB.putString("equipo", partidaEnCurso.getEquipoB());
                    equipoB.setArguments(argsEquipoB);
                    return equipoB;
                default:
                    return null;
            }
        }
    }
}


