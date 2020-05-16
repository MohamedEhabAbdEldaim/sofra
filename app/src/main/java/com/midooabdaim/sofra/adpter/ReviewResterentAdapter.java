package com.midooabdaim.sofra.adpter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.midooabdaim.sofra.R;

import com.midooabdaim.sofra.data.model.General.RestrentReview.ResterentReviewData;
import com.midooabdaim.sofra.databinding.ItemCommentBinding;

import java.util.ArrayList;
import java.util.List;


public class ReviewResterentAdapter extends RecyclerView.Adapter<ReviewResterentAdapter.ViewHolder> {

    private Context context;

    private List<ResterentReviewData> resterentReviewData = new ArrayList<>();

    public ReviewResterentAdapter(Context context, List<ResterentReviewData> resterentReviewData) {
        this.context = context;
        this.resterentReviewData = resterentReviewData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCommentBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext())
                        , R.layout.item_comment, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewResterentAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
        holder.commentBinding.itemCommentTvUserName.setText(
                resterentReviewData.get(position).getClient().getName()
        );
        holder.commentBinding.itemCommentTvComment.setText(
                resterentReviewData.get(position).getComment()
        );
        holder.commentBinding.itemCommentRbRestaurant.setRating(
                Float.parseFloat(resterentReviewData.get(position).getRate())
        );
    }

    private void setAction(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return resterentReviewData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemCommentBinding commentBinding;

        public ViewHolder(ItemCommentBinding binding) {
            super(binding.getRoot());
            commentBinding = binding;

        }
    }
}
