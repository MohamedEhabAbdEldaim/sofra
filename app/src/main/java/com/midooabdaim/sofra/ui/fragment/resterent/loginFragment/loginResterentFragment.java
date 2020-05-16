package com.midooabdaim.sofra.ui.fragment.resterent.loginFragment;


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
public class loginResterentFragment extends BaseFragment {


    public loginResterentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void BackPressed() {
        super.BackPressed();
    }
}
