package com.midooabdaim.sofra.ui.fragment.resterent.registerResterentFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.ui.fragment.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class registerResterentFragment extends BaseFragment {


    public registerResterentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        return inflater.inflate(R.layout.fragment_register_resterent, container, false);
    }

    @Override
    public void BackPressed() {
        super.BackPressed();
    }
}
