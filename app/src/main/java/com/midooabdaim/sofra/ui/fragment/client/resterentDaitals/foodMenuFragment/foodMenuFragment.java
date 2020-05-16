package com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.foodMenuFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.adpter.CategoriesaResterentAdapter;
import com.midooabdaim.sofra.adpter.ResterentItemAdapter;
import com.midooabdaim.sofra.adpter.homeResterentRecyclreAdapter;
import com.midooabdaim.sofra.data.model.General.ResterentItem.ResterentItemData;
import com.midooabdaim.sofra.data.model.General.Resturant.ResturantData;
import com.midooabdaim.sofra.data.model.General.categories.CatogrisData;
import com.midooabdaim.sofra.databinding.FragmentFoodMenuBinding;
import com.midooabdaim.sofra.helper.OnEndLess;
import com.midooabdaim.sofra.ui.activity.homeActivity.homeActivity;
import com.midooabdaim.sofra.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import static com.midooabdaim.sofra.helper.constant.RESTERENT_NAME;

/**
 * A simple {@link Fragment} subclass.
 */
public class foodMenuFragment extends BaseFragment {

    FragmentFoodMenuBinding foodMenuBinding;
    private LinearLayoutManager linearLayoutManager;
    private OnEndLess onEndLess;
    public viewModelFoodMenu viewModelFoodMenu;
    private CategoriesaResterentAdapter categoriesaResterentAdapter;
    private LinearLayoutManager linearLayoutManagerfilter;
    private ResterentItemAdapter resterentItemAdapter;
    private List<CatogrisData> catogrisData = new ArrayList<>();
    private List<ResterentItemData> resterentItemData = new ArrayList<>();

    public foodMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        //return inflater.inflate(R.layout.fragment_food_menu, container, false);
        ((homeActivity) getActivity()).setResterntName(RESTERENT_NAME);
        foodMenuBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_food_menu, container, false);
        foodMenuBinding.setLifecycleOwner(getActivity());
        View view = foodMenuBinding.getRoot();
        viewModelFoodMenu = ViewModelProviders.of(getActivity()).get(viewModelFoodMenu.class);
        viewModelFoodMenu.categries_id = new MutableLiveData<>();
        viewModelFoodMenu.categries_id.setValue(-1);

        initRecyclerView();

        viewModelFoodMenu.getCategoriesList().observe(getActivity(), new Observer<List<CatogrisData>>() {
            @Override
            public void onChanged(List<CatogrisData> catogrisData) {
                try {
                    foodMenuBinding.fragmentFoodMenuSrlRefresh.setRefreshing(false);
                } catch (Exception e) {

                }
                praperRecyclerFilter(catogrisData);
            }
        });
        viewModelFoodMenu.getResterentItemList().observe(getActivity(), new Observer<List<ResterentItemData>>() {
            @Override
            public void onChanged(List<ResterentItemData> resterentItemData) {
                try {
                    foodMenuBinding.fragmentFoodMenuSrlRefresh.setRefreshing(false);
                } catch (Exception e) {

                }
                praperRecyclerFood(resterentItemData);
            }
        });
        viewModelFoodMenu.getCategries_id().observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                resterentItemData = new ArrayList<>();
                viewModelFoodMenu.getFoods(getActivity(),
                        1);
            }
        });


        return view;
    }

    private void initRecyclerView() {
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        foodMenuBinding.fragmentFoodMenuRvFilter.setLayoutManager(linearLayoutManager);

        linearLayoutManagerfilter = new LinearLayoutManager(getActivity());
        foodMenuBinding.fragmentFoodMenuRvFoods.setLayoutManager(linearLayoutManagerfilter);
        onEndLess = new OnEndLess(linearLayoutManagerfilter, 1) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page <= viewModelFoodMenu.max) {
                    if (viewModelFoodMenu.max != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;

                        viewModelFoodMenu.getFoods(getActivity(),
                                current_page);
                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }
                } else {
                    onEndLess.current_page = onEndLess.previous_page;
                }

            }
        };
        foodMenuBinding.fragmentFoodMenuRvFoods.addOnScrollListener(onEndLess);


        foodMenuBinding.fragmentFoodMenuSrlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onEndLess.current_page = 1;
                onEndLess.previousTotal = 0;
                onEndLess.previous_page = 1;
                viewModelFoodMenu.max = 0;

                catogrisData = new ArrayList<>();
                viewModelFoodMenu.getCategories(getActivity());

                resterentItemData = new ArrayList<>();
                viewModelFoodMenu.getFoods(getActivity(), 1);

            }
        });

        viewModelFoodMenu.getCategories(getActivity());
        viewModelFoodMenu.getFoods(getActivity(),
                1);

    }

    private void praperRecyclerFilter(List<CatogrisData> catogrisData) {
        this.catogrisData.addAll(catogrisData);
        categoriesaResterentAdapter = new CategoriesaResterentAdapter(getActivity(), foodMenuFragment.this, this.catogrisData);
        foodMenuBinding.fragmentFoodMenuRvFilter.setAdapter(categoriesaResterentAdapter);
        categoriesaResterentAdapter.notifyDataSetChanged();
    }

    private void praperRecyclerFood(List<ResterentItemData> resterentItemData) {
        this.resterentItemData.addAll(resterentItemData);
        resterentItemAdapter = new ResterentItemAdapter(getActivity(), this.resterentItemData);
        foodMenuBinding.fragmentFoodMenuRvFoods.setAdapter(resterentItemAdapter);
        resterentItemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStop() {
        ((homeActivity) getActivity()).removeResterntName();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        ((homeActivity) getActivity()).removeResterntName();
        super.onDestroy();
    }

    @Override
    public void BackPressed() {
        super.BackPressed();
    }
}
