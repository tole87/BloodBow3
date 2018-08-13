package com.example.miguel.bludbuwl.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.miguel.bludbuwl.R;

/**
 * Created by tutlane on 09-01-2018.
 */

public class FragmentEquipoA extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        String equipoANombre = getArguments().getString("equipo");
        View equipoAView = inflater.inflate(R.layout.equipo_a, viewGroup, false);

        ((TextView)equipoAView.findViewById(R.id.textView)).setText(equipoANombre);
        return equipoAView;

    }


}

