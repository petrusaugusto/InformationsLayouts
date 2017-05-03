package com.github.petrusaugusto.informationslayouts.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by Petrus A. (R@G3), ESPE... On 03/05/2017.
 */

public class BaseFragmentClass extends Fragment {
    protected final String TAG = getClass().getName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
