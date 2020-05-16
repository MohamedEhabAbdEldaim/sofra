package com.midooabdaim.sofra.ui.fragment.client.homeResterntFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.adpter.SpinnerAdpter;
import com.midooabdaim.sofra.adpter.homeResterentRecyclreAdapter;
import com.midooabdaim.sofra.data.model.General.Resturant.ResturantData;
import com.midooabdaim.sofra.databinding.FragmentItemResterentBinding;
import com.midooabdaim.sofra.helper.OnEndLess;
import com.midooabdaim.sofra.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import static com.midooabdaim.sofra.data.api.RetrofitClient.getClient;
import static com.midooabdaim.sofra.helper.GeneralReqestMethod.getDataSpinners;


/**
 * A simple {@link Fragment} subclass.
 */
public class homeItemFragment extends BaseFragment {
    FragmentItemResterentBinding binding;
    private LinearLayoutManager linearLayoutManager;
    private OnEndLess onEndLess;
    private viewModelItemFragment viewModelItemFragment;
    private homeResterentRecyclreAdapter resterentRecyclreAdapter;
    private List<ResturantData> dataList = new ArrayList<>();
    private SpinnerAdpter adpterCity;

    public homeItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        // return inflater.inflate(R.layout.fragment_item_resterent, container, false);

        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_item_resterent, container, false);
        View view = binding.getRoot();
        viewModelItemFragment = ViewModelProviders.of(getActivity()).get(viewModelItemFragment.class);
        binding.setLifecycleOwner(getActivity());
        viewModelItemFragment.noData = new MutableLiveData<>();
        viewModelItemFragment.noData.setValue(false);
        viewModelItemFragment.swipe = new MutableLiveData<>();
        viewModelItemFragment.swipe.setValue(false);
        initRecyclerView();
        setAction();


        viewModelItemFragment.getRestaurantDataLiveList().observe(getActivity(), new Observer<List<ResturantData>>() {
            @Override
            public void onChanged(List<ResturantData> resturantData) {
                praperRecycler(resturantData);
            }
        });

        viewModelItemFragment.getNoData().observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                try {
                    binding.fragmentItemSrlListRefresh.setRefreshing(false);
                } catch (Exception e) {
                }
                if (aBoolean == false) {
                    binding.fragmentItemTvNoResultsOrItem.setVisibility(View.GONE);
                } else {
                    binding.fragmentItemTvNoResultsOrItem.setVisibility(View.VISIBLE);
                    binding.fragmentItemTvNoResultsOrItem.setText(getString(R.string.noresult));
                }

            }
        });

        viewModelItemFragment.getSwipe().observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                try {
                    binding.fragmentItemSrlListRefresh.setRefreshing(false);

                } catch (Exception e) {
                }
            }
        });


        return view;
    }

    private void initRecyclerView() {
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    viewModelItemFragment.Filter = true;
                    viewModelItemFragment.regionId = adpterCity.itemselected;
                    dataList = new ArrayList<>();
                    viewModelItemFragment.getResterent(1, getActivity());
                } else {
                    viewModelItemFragment.Filter = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        adpterCity = new SpinnerAdpter(getActivity());
        getDataSpinners(getClient().getCity(), adpterCity, getString(R.string.city), binding.fragmentItemSpinnerCity, onItemSelectedListener);

        linearLayoutManager = new LinearLayoutManager(getActivity());

        binding.fragmentItemRecyclerFragmentRcv.setLayoutManager(linearLayoutManager);

        onEndLess = new OnEndLess(linearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page <= viewModelItemFragment.max) {
                    if (viewModelItemFragment.max != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;

                        viewModelItemFragment.getResterent(current_page, getActivity());


                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }
                } else {
                    onEndLess.current_page = onEndLess.previous_page;
                }

            }
        };

        binding.fragmentItemRecyclerFragmentRcv.addOnScrollListener(onEndLess);


        viewModelItemFragment.getResterent(1, getActivity());

        binding.fragmentItemSrlListRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.current_page = 1;
                onEndLess.previousTotal = 0;
                onEndLess.previous_page = 1;
                viewModelItemFragment.max = 0;

                dataList = new ArrayList<>();
                viewModelItemFragment.getResterent(1, getActivity());
            }
        });
    }

    private void setAction() {
        binding.fragmentItemImSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelItemFragment.keyword = binding.fragmentItemEtResternt.getText().toString().trim();
                if (adpterCity.itemselected == 0 && viewModelItemFragment.keyword.equals("")) {
                    if (viewModelItemFragment.Filter) {
                        viewModelItemFragment.Filter = false;
                        onEndLess.current_page = 1;
                        onEndLess.previous_page = 1;
                        onEndLess.previousTotal = 0;
                        onEndLess.totalItemCount = 0;
                        viewModelItemFragment.max = 0;

                        dataList = new ArrayList<>();
                        viewModelItemFragment.getResterent(1, getActivity());
                    }

                } else {
                    viewModelItemFragment.Filter = true;
                    onEndLess.current_page = 1;
                    onEndLess.previous_page = 1;
                    onEndLess.previousTotal = 0;
                    onEndLess.totalItemCount = 0;
                    viewModelItemFragment.max = 0;

                    viewModelItemFragment.regionId = adpterCity.itemselected;
                    dataList = new ArrayList<>();
                    viewModelItemFragment.getResterent(1, getActivity());
                }
            }
        });
    }


    private void praperRecycler(List<ResturantData> dataList) {
        this.dataList.addAll(dataList);
        resterentRecyclreAdapter = new homeResterentRecyclreAdapter(getActivity(), this.dataList);
        binding.fragmentItemRecyclerFragmentRcv.setAdapter(resterentRecyclreAdapter);
        resterentRecyclreAdapter.notifyDataSetChanged();
    }

    @Override
    public void BackPressed() {
        super.BackPressed();
    }
}
