package com.midooabdaim.sofra.ui.activity.mainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.databinding.ActivityMainBinding;
import com.midooabdaim.sofra.ui.activity.BaseActivity;
import com.midooabdaim.sofra.ui.activity.LoginActivity.loginActivity;
import com.midooabdaim.sofra.ui.activity.homeActivity.homeActivity;

import static com.midooabdaim.sofra.helper.constant.USER_TYPE_RESTERENT;

public class MainActivity extends BaseActivity {
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setLifecycleOwner(this);

        mainBinding.activityMainBtnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                USER_TYPE_RESTERENT = false;
                Intent intent = new Intent(MainActivity.this, homeActivity.class);
                startActivity(intent);


            }
        });

        mainBinding.activityMainBtnSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                USER_TYPE_RESTERENT = true;
                Intent intent = new Intent(MainActivity.this, loginActivity.class);
                startActivity(intent);

            }
        });


    }

}
