package com.github.petrusaugusto.informationslayouts.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.petrusaugusto.informationslayouts.R;

public class LoadingWindow extends BaseFragmentClass {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_loading_window, container, false);
    }
}
