package com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.informationAboutResterent;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.data.model.General.RestrentDetails.DetailsData;
import com.midooabdaim.sofra.databinding.FragmentInfoAboutResterntBinding;
import com.midooabdaim.sofra.ui.activity.homeActivity.homeActivity;
import com.midooabdaim.sofra.ui.fragment.BaseFragment;
import com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.commentsFragment.viewModelComments;

/**
 * A simple {@link Fragment} subclass.
 */
public class infoAboutResterentFragment extends BaseFragment {

    FragmentInfoAboutResterntBinding binding;
    private viewModelInfoAboutResterent viewModelInfoAboutResterent;

    public infoAboutResterentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        //  return inflater.inflate(R.layout.fragment_info_about_resternt, container, false);
        ((homeActivity) getActivity()).removeResterntName();
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_info_about_resternt, container, false);
        View view = binding.getRoot();
        viewModelInfoAboutResterent = ViewModelProviders.of(getActivity()).get(viewModelInfoAboutResterent.class);

        viewModelInfoAboutResterent.getData(getActivity());

        viewModelInfoAboutResterent.resterentDetailsData.observe(getActivity(), new Observer<DetailsData>() {

            @Override
            public void onChanged(DetailsData detailsData) {
                setData(detailsData);
            }
        });


        return view;
    }

    private void setData(DetailsData detailsData) {
        binding.fragmentInfoThisMoment.setText(detailsData.getAvailability());
        binding.fragmentInfoCity.setText(detailsData.getRegion().getCity().getName());
        binding.fragmentInfoNeighborhood.setText(detailsData.getRegion().getName());
        binding.fragmentInfoLimits.setText(detailsData.getMinimumCharger());
        binding.fragmentInfoLinked.setText(detailsData.getDeliveryCost());
    }

}
