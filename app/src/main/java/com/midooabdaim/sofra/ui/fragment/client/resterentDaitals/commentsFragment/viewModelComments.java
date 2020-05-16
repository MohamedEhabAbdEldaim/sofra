package com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.commentsFragment;

import android.app.Activity;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.midooabdaim.sofra.data.model.General.RestrentReview.ResterentReviewData;
import com.midooabdaim.sofra.data.model.General.RestrentReview.RestrentReview;
import com.midooabdaim.sofra.data.model.General.Resturant.ResturantData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.midooabdaim.sofra.data.api.RetrofitClient.getClient;
import static com.midooabdaim.sofra.helper.InternetState.isActive;
import static com.midooabdaim.sofra.helper.constant.RESTERENT_ID;

public class viewModelComments extends ViewModel {
    public int max = 0;
    private int page = 1;
    String apiToken = "";
    public MutableLiveData<List<ResterentReviewData>> resterentReviewList;

    public MutableLiveData<List<ResterentReviewData>> getResterentReviewList() {
        if (resterentReviewList == null) {
            resterentReviewList = new MutableLiveData<List<ResterentReviewData>>();
        }
        return resterentReviewList;
    }

    public void getComments(int current_page, final Activity activity) {
        this.page = current_page;
        if (this.page == 1) {
            resterentReviewList = new MutableLiveData<List<ResterentReviewData>>();
        }
        if (isActive(activity)) {
            getClient().getRestaurantReviews(apiToken, RESTERENT_ID, page).enqueue(new Callback<RestrentReview>() {
                @Override
                public void onResponse(Call<RestrentReview> call, Response<RestrentReview> response) {

                    try {
                        if (response.body().getStatus() == 1) {

                            max = response.body().getData().getLastPage();
                            if (page == 1) {
                                resterentReviewList.setValue(response.body().getData().getData());
                            } else {
                                resterentReviewList.getValue().addAll(response.body().getData().getData());
                            }

                        }

                    } catch (Exception e) {
                        Toast.makeText(activity, "catch", Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<RestrentReview> call, Throwable t) {
                    Toast.makeText(activity, "asd", Toast.LENGTH_LONG).show();

                }
            });
        } else {
            Toast.makeText(activity, "please connect the internet", Toast.LENGTH_LONG).show();

        }

    }

}
