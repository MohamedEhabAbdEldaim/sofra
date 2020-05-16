package com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.foodMenuFragment;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.midooabdaim.sofra.data.model.General.ResterentItem.ResterentItem;
import com.midooabdaim.sofra.data.model.General.ResterentItem.ResterentItemData;
import com.midooabdaim.sofra.data.model.General.categories.Categories;
import com.midooabdaim.sofra.data.model.General.categories.CatogrisData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.midooabdaim.sofra.data.api.RetrofitClient.getClient;
import static com.midooabdaim.sofra.helper.InternetState.isActive;
import static com.midooabdaim.sofra.helper.constant.RESTERENT_ID;

public class viewModelFoodMenu extends ViewModel {
    public int max = 0;
    private int page = 1;
    public MutableLiveData<List<CatogrisData>> categoriesList;
    public MutableLiveData<List<ResterentItemData>> ResterentItemList;
    public MutableLiveData<Integer> categries_id;

    public MutableLiveData<List<CatogrisData>> getCategoriesList() {
        if (categoriesList == null) {
            categoriesList = new MutableLiveData<List<CatogrisData>>();
        }
        return categoriesList;
    }

    public MutableLiveData<List<ResterentItemData>> getResterentItemList() {
        if (ResterentItemList == null) {
            ResterentItemList = new MutableLiveData<List<ResterentItemData>>();
        }
        return ResterentItemList;
    }

    public MutableLiveData<Integer> getCategries_id() {
        if (categries_id == null) {
            categries_id = new MutableLiveData<Integer>();
        }
        return categries_id;
    }

    public void getCategories(final Activity activity) {
        if (categoriesList == null) {
            categoriesList = new MutableLiveData<List<CatogrisData>>();
        }
        if (isActive(activity)) {
            getClient().getCategories(RESTERENT_ID).enqueue(new Callback<Categories>() {
                @Override
                public void onResponse(Call<Categories> call, Response<Categories> response) {
                    try {

                        if (response.body().getStatus() == 1) {
                            categoriesList.setValue(response.body().getData());
                        }

                    } catch (Exception e) {
                        Toast.makeText(activity, "catch", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Categories> call, Throwable t) {
                    Toast.makeText(activity, "asd", Toast.LENGTH_LONG).show();

                }
            });

        } else {
            Toast.makeText(activity, "please connect the internet", Toast.LENGTH_LONG).show();
        }

    }

    public void getFoods(final Activity activity, int current_page) {
        this.page = current_page;
        if (this.page == 1) {
            ResterentItemList = new MutableLiveData<List<ResterentItemData>>();
        }
        if (isActive(activity)) {
            getClient().getRestentitem(1, -1, page).enqueue(new Callback<ResterentItem>() {
                @Override
                public void onResponse(Call<ResterentItem> call, Response<ResterentItem> response) {
                    try {
                        Toast.makeText(activity, response.body().getMsg(), Toast.LENGTH_LONG).show();


                        if (response.body().getStatus() == 1) {

                            max = response.body().getData().getLastPage();

                            if (page == 1) {
                                ResterentItemList.setValue(response.body().getData().getData());
                            } else {
                                ResterentItemList.postValue(response.body().getData().getData());
                            }
                        }

                    } catch (Exception e) {
                        Toast.makeText(activity, "catch", Toast.LENGTH_LONG).show();

                    }
                }

                @Override
                public void onFailure(Call<ResterentItem> call, Throwable t) {
                    Toast.makeText(activity, "asd", Toast.LENGTH_LONG).show();
                    Log.i("asd", "onFailure: ", t);
                }
            });
        } else {
            Toast.makeText(activity, "please connect the internet", Toast.LENGTH_LONG).show();

        }
    }
}
