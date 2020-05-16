package com.midooabdaim.sofra.adpter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.databinding.ItemCategoriesBinding;


public class EmptyAdapter extends RecyclerView.Adapter<EmptyAdapter.ViewHolder> {
    private Context context;
    private Activity activity;
//    private List<RestaurantClientData> restaurantDataList = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCategoriesBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext())
                        , R.layout.item_categories, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmptyAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {

    }

    private void setAction(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemCategoriesBinding categoriesBinding;

        public ViewHolder(ItemCategoriesBinding binding) {
            super(binding.getRoot());
            categoriesBinding = binding;
            //   view = itemView;
            //     ButterKnife.bind(this, view);
        }
    }
}
