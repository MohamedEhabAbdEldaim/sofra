package com.midooabdaim.sofra.adpter.ordered.res;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.midooabdaim.sofra.R;

import com.midooabdaim.sofra.databinding.ItemOldResBinding;


public class oldResterentAdapter extends RecyclerView.Adapter<oldResterentAdapter.ViewHolder> {
    private Context context;
    private Activity activity;
//    private List<RestaurantClientData> restaurantDataList = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemOldResBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext())
                        , R.layout.item_old_res, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull oldResterentAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
        holder.oldResBinding.itemCurrentResLlCurrent.setVisibility(View.GONE);
        holder.oldResBinding.itemNewResLlNew.setVisibility(View.GONE);

    }

    private void setAction(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemOldResBinding oldResBinding;

        public ViewHolder(ItemOldResBinding binding) {
            super(binding.getRoot());
            oldResBinding = binding;

        }
    }
}
