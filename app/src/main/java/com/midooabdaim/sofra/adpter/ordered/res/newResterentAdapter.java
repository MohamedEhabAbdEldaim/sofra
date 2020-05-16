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


public class newResterentAdapter extends RecyclerView.Adapter<newResterentAdapter.ViewHolder> {
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
    public void onBindViewHolder(@NonNull newResterentAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
       holder.newResBinding.itemOldResLlOld.setVisibility(View.GONE);
       holder.newResBinding.itemCurrentResLlCurrent.setVisibility(View.GONE);
    }

    private void setAction(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemOldResBinding newResBinding;

        public ViewHolder(ItemOldResBinding binding) {
            super(binding.getRoot());
            newResBinding = binding;

        }
    }
}
