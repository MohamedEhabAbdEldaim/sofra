package com.midooabdaim.sofra.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.ui.fragment.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class emptyFragment extends BaseFragment {


    public emptyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        return inflater.inflate(R.layout.fragment_empty, container, false);
    }

    @Override
    public void BackPressed() {
        super.BackPressed();
    }
}
