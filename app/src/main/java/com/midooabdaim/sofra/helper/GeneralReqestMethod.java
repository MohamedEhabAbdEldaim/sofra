package com.midooabdaim.sofra.helper;

import android.widget.AdapterView;
import android.widget.Spinner;

import com.midooabdaim.sofra.adpter.SpinnerAdpter;
import com.midooabdaim.sofra.data.model.General.cityAndRegion.CitiesAndRegion;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeneralReqestMethod {
    public static void getDataSpinners(Call<CitiesAndRegion> call, final SpinnerAdpter adpter, final String hint, final Spinner spinner) {
        call.enqueue(new Callback<CitiesAndRegion>() {
            @Override
            public void onResponse(Call<CitiesAndRegion> call, Response<CitiesAndRegion> response) {
                try {
                    if (response.body().getStatus() == 1) {
                        adpter.setData(response.body().getData(), hint);
                        spinner.setAdapter(adpter);
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<CitiesAndRegion> call, Throwable t) {

            }
        });

    }

    public static void getDataSpinners(Call<CitiesAndRegion> call, final SpinnerAdpter adpter, final String hint, final Spinner spinner, final AdapterView.OnItemSelectedListener listener) {
        call.enqueue(new Callback<CitiesAndRegion>() {
            @Override
            public void onResponse(Call<CitiesAndRegion> call, Response<CitiesAndRegion> response) {
                try {
                    if (response.body().getStatus() == 1) {
                        adpter.setData(response.body().getData(), hint);
                        spinner.setAdapter(adpter);
                        spinner.setOnItemSelectedListener(listener);
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<CitiesAndRegion> call, Throwable t) {

            }
        });

    }


}
