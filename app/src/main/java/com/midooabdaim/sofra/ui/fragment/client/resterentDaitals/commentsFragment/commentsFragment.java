package com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.commentsFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.adpter.ReviewResterentAdapter;
import com.midooabdaim.sofra.adpter.homeResterentRecyclreAdapter;
import com.midooabdaim.sofra.data.model.General.RestrentReview.ResterentReviewData;
import com.midooabdaim.sofra.data.model.General.Resturant.ResturantData;
import com.midooabdaim.sofra.databinding.FragmentCommentsBinding;
import com.midooabdaim.sofra.helper.OnEndLess;
import com.midooabdaim.sofra.ui.activity.homeActivity.homeActivity;
import com.midooabdaim.sofra.ui.fragment.BaseFragment;
import com.midooabdaim.sofra.ui.fragment.client.homeResterntFragment.viewModelItemFragment;
import com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.foodMenuFragment.viewModelFoodMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class commentsFragment extends BaseFragment {
    FragmentCommentsBinding commentsBinding;
    private LinearLayoutManager linearLayoutManager;
    private OnEndLess onEndLess;
    private viewModelComments viewModelComments;
    private ReviewResterentAdapter reviewResterentAdapter;
    private List<ResterentReviewData> resterentReviewData = new ArrayList<>();

    public commentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        // return inflater.inflate(R.layout.fragment_comments, container, false);
        ((homeActivity) getActivity()).removeResterntName();
        commentsBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_comments, container, false);
        View view = commentsBinding.getRoot();
        viewModelComments = ViewModelProviders.of(getActivity()).get(viewModelComments.class);

        initRecyclerView();

        viewModelComments.getResterentReviewList().observe(getActivity(), new Observer<List<ResterentReviewData>>() {
            @Override
            public void onChanged(List<ResterentReviewData> dataList) {
                praperRecycler(dataList);
            }
        });

        return view;
    }

    private void initRecyclerView() {
        linearLayoutManager = new LinearLayoutManager(getActivity());

        commentsBinding.fragmentCommentsRvComments.setLayoutManager(linearLayoutManager);

        onEndLess = new OnEndLess(linearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page <= viewModelComments.max) {
                    if (viewModelComments.max != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;

                        viewModelComments.getComments(current_page, getActivity());


                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }
                } else {
                    onEndLess.current_page = onEndLess.previous_page;
                }

            }
        };

        commentsBinding.fragmentCommentsRvComments.addOnScrollListener(onEndLess);

        viewModelComments.getComments(1, getActivity());

    }

    private void praperRecycler(List<ResterentReviewData> dataList) {
        this.resterentReviewData.addAll(dataList);
        reviewResterentAdapter = new ReviewResterentAdapter(getActivity(), this.resterentReviewData);
        commentsBinding.fragmentCommentsRvComments.setAdapter(reviewResterentAdapter);
        reviewResterentAdapter.notifyDataSetChanged();
    }


}
