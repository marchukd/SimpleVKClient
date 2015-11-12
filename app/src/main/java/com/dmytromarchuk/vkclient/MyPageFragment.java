package com.dmytromarchuk.vkclient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Dmytro on 10.11.2015.
 */
public class MyPageFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_page_fragment, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        return view;
    }
}
