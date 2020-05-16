package com.midooabdaim.sofra.ui.fragment.client.homeResterntFragment;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.midooabdaim.sofra.R;

import com.midooabdaim.sofra.data.model.General.Resturant.ResturantData;
import com.midooabdaim.sofra.data.model.General.Resturant.ResturantList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.midooabdaim.sofra.data.api.RetrofitClient.getClient;
import static com.midooabdaim.sofra.helper.InternetState.isActive;
import static com.midooabdaim.sofra.helper.MethodHelper.customToast;
import static com.midooabdaim.sofra.helper.MethodHelper.dismissProgressDialog;
import static com.midooabdaim.sofra.helper.MethodHelper.showProgressDialog;

public class viewModelItemFragment extends ViewModel {

    public int max = 0;
    private int page = 1;
    public boolean Filter = false;
    public String keyword = "";
    public int regionId = 1;

    public MutableLiveData<List<ResturantData>> RestaurantDataLiveList;
    public MutableLiveData<Boolean> noData;
    public MutableLiveData<Boolean> swipe;

    public MutableLiveData<Boolean> getNoData() {
        if (noData == null) {
            noData = new MutableLiveData<Boolean>();
        }
        return noData;

    }

    public MutableLiveData<Boolean> getSwipe() {
        if (swipe == null) {
            swipe = new MutableLiveData<Boolean>();
        }
        return swipe;
    }

    public MutableLiveData<List<ResturantData>> getRestaurantDataLiveList() {
        if (RestaurantDataLiveList == null) {
            RestaurantDataLiveList = new MutableLiveData<List<ResturantData>>();
        }
        return RestaurantDataLiveList;
    }

    public void getResterent(int page, Activity activity) {
        this.page = page;
        showProgressDialog(activity, activity.getString(R.string.wait));
        if (this.page == 1) {
            RestaurantDataLiveList = new MutableLiveData<List<ResturantData>>();
        }

        if (Filter) {
            Call<ResturantList> call = getClient().getResterentWithFilter(page, keyword, regionId);
            getData(activity, call);
        } else {
            Call<ResturantList> call = getClient().getRestaurants(page);
            getData(activity, call);
        }

    }


    private void getData(final Activity activity, Call<ResturantList> call) {
        if (isActive(activity)) {
            call.enqueue(new Callback<ResturantList>() {
                @Override
                public void onResponse(Call<ResturantList> call, Response<ResturantList> response) {
                    try {
                        dismissProgressDialog();
                        swipe.postValue(true);
                        customToast(activity, response.body().getMsg(), false);

                        if (response.body().getStatus() == 1) {

                            max = response.body().getData().getLastPage();

                            if (page == 1) {
                                if (response.body().getData().getTotal() > 0) {
                                } else {
                                    noData.postValue(true);
                                }

                                RestaurantDataLiveList.setValue(response.body().getData().getData());
                            } else {
                                RestaurantDataLiveList.postValue(response.body().getData().getData());
                            }
                        }

                    } catch (Exception e) {
                        customToast(activity, e.getMessage(), true);
                    }

                }

                @Override
                public void onFailure(Call<ResturantList> call, Throwable t) {
                    swipe.postValue(true);
                    dismissProgressDialog();
                    customToast(activity, t.getMessage(), true);

                }
            });

        } else {
            customToast(activity, activity.getString(R.string.nointernet), true);
            swipe.postValue(true);
            dismissProgressDialog();

        }

    }


}
