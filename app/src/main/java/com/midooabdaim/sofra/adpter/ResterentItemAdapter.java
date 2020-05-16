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
import com.midooabdaim.sofra.data.model.General.ResterentItem.ResterentItemData;
import com.midooabdaim.sofra.databinding.ItemCategoriesBinding;
import com.midooabdaim.sofra.databinding.ItemResterentListBinding;

import java.util.ArrayList;
import java.util.List;

import static com.midooabdaim.sofra.helper.MethodHelper.onLoadImageFromUrl;


public class ResterentItemAdapter extends RecyclerView.Adapter<ResterentItemAdapter.ViewHolder> {
    private Context context;
    private List<ResterentItemData> restaurantDataList = new ArrayList<>();


    public ResterentItemAdapter(Context context, List<ResterentItemData> restaurantDataList) {
        this.context = context;
        this.restaurantDataList = restaurantDataList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemResterentListBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext())
                        , R.layout.item_resterent_list, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResterentItemAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
        onLoadImageFromUrl(holder.listBinding.itemRestrentImImage, restaurantDataList.get(position).getPhotoUrl(), context);
        holder.listBinding.itemRestrentTvName.setText(restaurantDataList.get(position).getName());
        holder.listBinding.itemRestrentTvDes.setText(restaurantDataList.get(position).getDescription());
        if (restaurantDataList.get(position).getHasOffer()) {
            holder.listBinding.itemRestrentTvPrice.setText(restaurantDataList.get(position).getPrice());
            holder.listBinding.itemRestrentTvPriceoffer.setText(restaurantDataList.get(position).getOfferPrice());

        } else {
            holder.listBinding.itemRestrentTvPrice.setText(restaurantDataList.get(position).getPrice());
        }

    }

    private void setAction(ViewHolder holder, int position) {
        holder.listBinding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemResterentListBinding listBinding;

        public ViewHolder(ItemResterentListBinding binding) {
            super(binding.getRoot());
            listBinding = binding;

        }
    }
}
