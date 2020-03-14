package com.example.livewallpaper.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.livewallpaper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyPolpularFregment extends Fragment {
    private static DailyPolpularFregment INSTANCE = null;
    public DailyPolpularFregment() {
        // Required empty public constructor
    }
    public static DailyPolpularFregment getInstance(){
        if(INSTANCE == null)
            INSTANCE = new DailyPolpularFregment();
        return INSTANCE;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily_polpular_fregment, container, false);
    }
}
