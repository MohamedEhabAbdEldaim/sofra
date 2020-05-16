package com.midooabdaim.sofra.ui.fragment.resterent.orderdResterent.oldOrderdFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.databinding.FragmentOrederdRecyclerBinding;
import com.midooabdaim.sofra.ui.fragment.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class oldOrderedResterentFragment extends BaseFragment {
    FragmentOrederdRecyclerBinding oldOrderedBinding;

    public oldOrderedResterentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        //    return inflater.inflate(R.layout.fragment_old_ordered, container, false);
        oldOrderedBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_orederd_recycler, container, false);
        View view = oldOrderedBinding.getRoot();

        return view;
    }

    @Override
    public void BackPressed() {
        super.BackPressed();
    }
}
