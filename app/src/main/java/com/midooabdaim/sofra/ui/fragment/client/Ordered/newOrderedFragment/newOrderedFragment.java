package com.midooabdaim.sofra.ui.fragment.client.Ordered.newOrderedFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.databinding.FragmentOrederdRecyclerBinding;
import com.midooabdaim.sofra.ui.fragment.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class newOrderedFragment extends BaseFragment {
    FragmentOrederdRecyclerBinding newOrderdBinding;

    public newOrderedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        //   return inflater.inflate(R.layout.fragment_new_orderd, container, false);
        newOrderdBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_orederd_recycler, container, false);
        View view = newOrderdBinding.getRoot();

        return view;
    }

    @Override
    public void BackPressed() {
        super.BackPressed();
    }
}
