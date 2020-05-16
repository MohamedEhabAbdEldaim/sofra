package com.midooabdaim.sofra.ui.activity.homeActivity;


import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.databinding.ActivityHomeBinding;
import com.midooabdaim.sofra.ui.activity.BaseActivity;
import com.midooabdaim.sofra.ui.fragment.client.homeResterntFragment.homeItemFragment;

import static com.midooabdaim.sofra.helper.MethodHelper.replaceFragment;
import static com.midooabdaim.sofra.helper.constant.USER_TYPE_RESTERENT;

public class homeActivity extends BaseActivity {
    ActivityHomeBinding homeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        homeBinding.setLifecycleOwner(this);
        init();
        if (USER_TYPE_RESTERENT) {

        } else {
            replaceFragment(getSupportFragmentManager(), R.id.home_activity_fl_fragment, new homeItemFragment());
        }

    }

    private void init() {
        homeBinding.homeImgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (USER_TYPE_RESTERENT) {

                } else {
                    replaceFragment(getSupportFragmentManager(), R.id.home_activity_fl_fragment, new homeItemFragment());
                }
            }
        });




    }

    public void setResterntName(String resterntName) {
        homeBinding.homeAppBarTextViewChange.setText(resterntName);
    }

    public void removeResterntName() {
        homeBinding.homeAppBarTextViewChange.setText("");
    }


}
