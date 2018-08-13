package com.example.miguel.bludbuwl.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miguel.bludbuwl.R;

/**
 * Created by tutlane on 09-01-2018.
 */

public class FragmentPartido extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.partido_en_curso, viewGroup, false);
    }
}
