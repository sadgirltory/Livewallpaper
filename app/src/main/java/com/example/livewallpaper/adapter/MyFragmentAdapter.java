package com.example.livewallpaper.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.livewallpaper.Fragment.CatagoryFragment;
import com.example.livewallpaper.Fragment.DailyPolpularFregment;
import com.example.livewallpaper.Fragment.ReccentFragment;

import java.util.Locale;

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private Context context;
    public MyFragmentAdapter(@NonNull FragmentManager fm,Context context) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       if(position == 0){
            return CatagoryFragment.getInstance();
       }else if(position == 1){
           return DailyPolpularFregment.getInstance();
       }else if(position==2){
           return ReccentFragment.getInstance();
       }else {
           return null;
       }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Category";

            case 1:
                return "Daily Popular";

            case 2:
                return "Recents";
        }
        return "";
    }
}
