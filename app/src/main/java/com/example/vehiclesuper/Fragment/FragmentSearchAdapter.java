package com.example.vehiclesuper.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.vehiclesuper.Search.FragmentSearchHyperCar;
import com.example.vehiclesuper.Search.FragmentSearchMotorcycle;
import com.example.vehiclesuper.Search.FragmentSearchSuperCar;

public class FragmentSearchAdapter extends FragmentStatePagerAdapter {
    private int numPage=3;


    public FragmentSearchAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FragmentSearchSuperCar();
//            case 1: return new FragmentSearchHyperCar();
//            case 2: return new FragmentSearchMotorcycle();
            default: return new FragmentSearchSuperCar();
        }
    }

    @Override
    public int getCount() {
        return numPage;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:return "SuperCar";
//            case 1:return "HyperCar";
//            case 2:return "Motorcycle";
            default:return "SuperCar";
        }
    }
}
