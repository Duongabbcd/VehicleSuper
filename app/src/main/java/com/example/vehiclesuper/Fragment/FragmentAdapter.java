package com.example.vehiclesuper.Fragment;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private int numPage = 4;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0 : return  new FragmentSuperCar() ;
//            case 1 : return  new FragmentHyperCar() ;
//            case 2 : return new FragmentMotorcycle();
            case 3: return new FragmentSearch();

            default:return new FragmentSuperCar() ;
        }
    }

    @Override
    public int getCount() {
        return numPage;
    }

}
