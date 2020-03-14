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
public class ReccentFragment extends Fragment {
    private static ReccentFragment INSTANCE = null;
    public ReccentFragment() {
        // Required empty public constructor
    }
    public static ReccentFragment getInstance(){
        if(INSTANCE == null)
            INSTANCE = new ReccentFragment();
        return INSTANCE;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reccent, container, false);
    }
}
