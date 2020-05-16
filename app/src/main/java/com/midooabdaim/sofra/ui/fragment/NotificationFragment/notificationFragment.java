package com.midooabdaim.sofra.ui.fragment.NotificationFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.databinding.FragmentNotificationBinding;
import com.midooabdaim.sofra.ui.fragment.BaseFragment;
import com.midooabdaim.sofra.ui.fragment.client.homeResterntFragment.viewModelItemFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class notificationFragment extends BaseFragment {
    FragmentNotificationBinding binding;
    viewModelNotificationFragment viewModelNotificationFragment;
    private LinearLayoutManager linearLayoutManager;

    public notificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        //return inflater.inflate(R.layout.fragment_notification, container, false);
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_notification, container, false);
        View view = binding.getRoot();
        viewModelNotificationFragment = ViewModelProviders.of(getActivity()).get(viewModelNotificationFragment.class);
        binding.setLifecycleOwner(getActivity());

        viewModelNotificationFragment.noData = new MutableLiveData<>();
        viewModelNotificationFragment.noData.setValue(false);

        inti();

        return view;
    }

    private void inti() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        binding.fragmentNotificationRv.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void BackPressed() {
        super.BackPressed();
    }
}
