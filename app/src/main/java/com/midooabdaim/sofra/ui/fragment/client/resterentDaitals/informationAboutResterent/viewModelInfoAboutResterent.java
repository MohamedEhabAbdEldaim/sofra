package com.midooabdaim.sofra.ui.fragment.client.resterentDaitals.informationAboutResterent;

import android.app.Activity;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.midooabdaim.sofra.data.model.General.RestrentDetails.DetailsData;
import com.midooabdaim.sofra.data.model.General.RestrentDetails.RestrentDetails;
import com.midooabdaim.sofra.data.model.General.RestrentReview.ResterentReviewData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.midooabdaim.sofra.data.api.RetrofitClient.getClient;
import static com.midooabdaim.sofra.helper.InternetState.isActive;
import static com.midooabdaim.sofra.helper.constant.RESTERENT_ID;

public class viewModelInfoAboutResterent extends ViewModel {

    public MutableLiveData<DetailsData> resterentDetailsData = new MutableLiveData<>();


    public void getData(final Activity activity) {
        resterentDetailsData = new MutableLiveData<>();
        if (isActive(activity)) {
            getClient().getDetails(RESTERENT_ID).enqueue(new Callback<RestrentDetails>() {
                @Override
                public void onResponse(Call<RestrentDetails> call, Response<RestrentDetails> response) {
                    try {
                        if (response.body().getStatus() == 1) {
                            resterentDetailsData.setValue(response.body().getData());
                        }

                    } catch (Exception e) {
                        Toast.makeText(activity, "catch", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<RestrentDetails> call, Throwable t) {
                    Toast.makeText(activity, "asd", Toast.LENGTH_LONG).show();

                }
            });
        } else {
            Toast.makeText(activity, "please connect the internet", Toast.LENGTH_LONG).show();

        }

    }

}
