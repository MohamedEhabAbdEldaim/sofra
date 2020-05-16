package com.midooabdaim.sofra.adpter.ordered.client;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.databinding.ItemClientOrderdBinding;


public class newClientAdapter extends RecyclerView.Adapter<newClientAdapter.ViewHolder> {
    private Context context;
    private Activity activity;
//    private List<RestaurantClientData> restaurantDataList = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemClientOrderdBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext())
                        , R.layout.item_client_orderd, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull newClientAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
        holder.newBinding.itemOldClientLlOld.setVisibility(View.GONE);
        holder.newBinding.itemCurrentClientBtOkAndCancle.setText(R.string.canceldeliver);
        holder.newBinding.itemCurrentClientBtOkAndCancle.setBackgroundResource(R.drawable.shap_botton_move);

    }

    private void setAction(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemClientOrderdBinding newBinding;

        public ViewHolder(ItemClientOrderdBinding binding) {
            super(binding.getRoot());
            newBinding = binding;

        }
    }
}
