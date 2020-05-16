package com.midooabdaim.sofra.ui.fragment.NotificationFragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class viewModelNotificationFragment extends ViewModel {
    public MutableLiveData<Boolean> noData;


    public MutableLiveData<Boolean> getNoData() {
        if (noData == null) {
            noData = new MutableLiveData<Boolean>();
        }
        return noData;

    }

}
