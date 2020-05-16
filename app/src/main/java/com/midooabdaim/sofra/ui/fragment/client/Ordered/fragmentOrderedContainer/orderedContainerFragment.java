package com.midooabdaim.sofra.ui.fragment.client.Ordered.fragmentOrderedContainer;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.adpter.ViewPagerWithFragmentAdapter;
import com.midooabdaim.sofra.databinding.FragmentOrederContainerBinding;
import com.midooabdaim.sofra.ui.fragment.BaseFragment;
import com.midooabdaim.sofra.ui.fragment.client.Ordered.currentOrderedFragment.currentOrederFragment;
import com.midooabdaim.sofra.ui.fragment.client.Ordered.newOrderedFragment.newOrderedFragment;
import com.midooabdaim.sofra.ui.fragment.client.Ordered.oldOrderedFragment.oldOrderedFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class orderedContainerFragment extends BaseFragment {
    FragmentOrederContainerBinding orederContainerBinding;
    ViewPagerWithFragmentAdapter vpadapter;

    public orderedContainerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        // return inflater.inflate(R.layout.fragment_oreder_container, container, false);
        orederContainerBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_oreder_container, container, false);
        View view = orederContainerBinding.getRoot();
        vpadapter = new ViewPagerWithFragmentAdapter(getChildFragmentManager(), 0);

        newOrderedFragment newOrderedFragment = new newOrderedFragment();
        currentOrederFragment currentOrederFragment = new currentOrederFragment();
        oldOrderedFragment oldOrderedFragment = new oldOrderedFragment();

        vpadapter.addPager(newOrderedFragment, getString(R.string.newordered));
        vpadapter.addPager(currentOrederFragment, getString(R.string.currentordered));
        vpadapter.addPager(oldOrderedFragment, getString(R.string.oldordered));

        orederContainerBinding.fragmentOrederViewPager.setAdapter(vpadapter);
        orederContainerBinding.fragmentOrederTabLayoutId.setupWithViewPager(orederContainerBinding.fragmentOrederViewPager);


        return view;
    }


    @Override
    public void BackPressed() {
        super.BackPressed();
    }
}
