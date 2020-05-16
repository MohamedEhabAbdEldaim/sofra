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
import com.midooabdaim.sofra.data.model.General.categories.CatogrisData;
import com.midooabdaim.sofra.databinding.ItemCategoriesBinding;
import com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.foodMenuFragment.foodMenuFragment;
import com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.foodMenuFragment.viewModelFoodMenu;

import java.util.ArrayList;
import java.util.List;

import static com.midooabdaim.sofra.helper.MethodHelper.onLoadImageFromUrl;


public class CategoriesaResterentAdapter extends RecyclerView.Adapter<CategoriesaResterentAdapter.ViewHolder> {

    private Context context;
    private foodMenuFragment foodMenuFragment;
    private List<CatogrisData> catogrisData = new ArrayList<>();

    public CategoriesaResterentAdapter(Context context, com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.foodMenuFragment.foodMenuFragment foodMenuFragment, List<CatogrisData> catogrisData) {
        this.context = context;
        this.foodMenuFragment = foodMenuFragment;
        this.catogrisData = catogrisData;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCategoriesBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext())
                        , R.layout.item_categories, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesaResterentAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
        onLoadImageFromUrl(holder.categoriesBinding.itemCategoriesImageViewImg, catogrisData.get(position).getPhotoUrl(), context);
        holder.categoriesBinding.itemCategoriesTvName.setText(catogrisData.get(position).getName());
    }

    private void setAction(ViewHolder holder, final int position) {
        holder.categoriesBinding.itemCategoriesLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodMenuFragment.viewModelFoodMenu.categries_id.postValue(catogrisData.get(position).getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return catogrisData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemCategoriesBinding categoriesBinding;

        public ViewHolder(ItemCategoriesBinding binding) {
            super(binding.getRoot());
            categoriesBinding = binding;

        }
    }
}
