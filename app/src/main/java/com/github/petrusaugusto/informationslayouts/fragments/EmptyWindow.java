package com.github.petrusaugusto.informationslayouts.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.petrusaugusto.informationslayouts.R;

/**
 * Created by Petrus A. (R@G3), ESPE... On 03/05/2017.
 */

public class EmptyWindow extends BaseFragmentClass {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_empty_window, container, false);
    }
}
