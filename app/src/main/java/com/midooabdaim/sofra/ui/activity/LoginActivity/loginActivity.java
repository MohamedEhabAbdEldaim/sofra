package com.midooabdaim.sofra.ui.activity.LoginActivity;


import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.databinding.ActivityLoginBinding;
import com.midooabdaim.sofra.ui.activity.BaseActivity;

public class loginActivity extends BaseActivity {
    ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginBinding.setLifecycleOwner(this);

    }
}
