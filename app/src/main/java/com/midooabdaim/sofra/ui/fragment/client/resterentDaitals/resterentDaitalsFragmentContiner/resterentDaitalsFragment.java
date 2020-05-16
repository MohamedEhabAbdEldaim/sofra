package com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.resterentDaitalsFragmentContiner;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.adpter.ViewPagerWithFragmentAdapter;
import com.midooabdaim.sofra.databinding.FragmentResterentDaitalsBinding;
import com.midooabdaim.sofra.ui.fragment.BaseFragment;
import com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.commentsFragment.commentsFragment;
import com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.foodMenuFragment.foodMenuFragment;
import com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.informationAboutResterent.infoAboutResterentFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class resterentDaitalsFragment extends BaseFragment {

    public resterentDaitalsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        //   return inflater.inflate(R.layout.fragment_resterent_daitals, container, false);

        FragmentResterentDaitalsBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_resterent_daitals, container, false);
        View view = binding.getRoot();

   //     viewModelResterentDatils viewModelResterentDatils = ViewModelProviders.of(getActivity()).get(viewModelResterentDatils.class);
     //   binding.setLifecycleOwner(getActivity());


        ViewPagerWithFragmentAdapter vpadapter = new ViewPagerWithFragmentAdapter(getChildFragmentManager(), 0);


        foodMenuFragment foodMenuFragment = new foodMenuFragment();
        commentsFragment commentsFragment = new commentsFragment();
        infoAboutResterentFragment infoAboutResterentFragment = new infoAboutResterentFragment();

        vpadapter.addPager(foodMenuFragment, getString(R.string.foodmenu));
       vpadapter.addPager(commentsFragment, getString(R.string.comments));
        vpadapter.addPager(infoAboutResterentFragment, getString(R.string.infoaboutresternt));

        binding.homeViewPager.setAdapter(vpadapter);
        binding.homeTabLayoutId.setupWithViewPager(binding.homeViewPager);


        return view;
    }


    @Override
    public void BackPressed() {
        super.BackPressed();
    }
}
