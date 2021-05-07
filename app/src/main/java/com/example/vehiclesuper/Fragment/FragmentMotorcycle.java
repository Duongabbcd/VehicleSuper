package com.example.vehiclesuper.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.vehiclesuper.Adapter.HyperCarAdapter;
import com.example.vehiclesuper.Adapter.MotorcycleAdapter;
import com.example.vehiclesuper.MainActivity;
import com.example.vehiclesuper.R;
import com.example.vehiclesuper.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class FragmentMotorcycle extends Fragment  implements AdapterView.OnItemSelectedListener{
    private Spinner sp  ;
    private EditText name,price,subs,pub;
    private Button btn ;
    private RecyclerView rev ;
    private List<Vehicle> hpList = new ArrayList<>();
    private MotorcycleAdapter motorcycleAdapter  ;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        add();
        initSpinner();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCat();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_motorcycle, container, false);
    }

    private void init(View v){
        sp=v.findViewById(R.id.sp2) ;
        pub=v.findViewById(R.id.pub2);
        name=v.findViewById(R.id.name2);
        price=v.findViewById(R.id.price2);
        subs=v.findViewById(R.id.subs2);
        btn =v.findViewById(R.id.btn2);;
        rev=v.findViewById(R.id.re2);
    }

    private void initSpinner() {
        List<String> catSpin = new ArrayList<>();
        catSpin.add("1");
        catSpin.add("2");
        catSpin.add("3");
        catSpin.add("4");
        catSpin.add("5");
        catSpin.add("6");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,catSpin);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
    }

    private void addCat(){
        Vehicle cat = new Vehicle(1,"","",10,"");
        cat.setPublisher(pub.getText().toString());
        cat.setName(name.getText().toString());
        cat.setPrice(Integer.parseInt(price.getText().toString()));
        cat.setSubscription(subs.getText().toString());
        sp.setOnItemSelectedListener(this);

        int i  = sp.getSelectedItemPosition();
        if(i==0) cat.setImage(R.drawable.m1);
        if(i==1) cat.setImage(R.drawable.m2);
        if(i==2) cat.setImage(R.drawable.m3);
        if(i==3) cat.setImage(R.drawable.m4);
        if(i==4) cat.setImage(R.drawable.m5);
        if(i==5) cat.setImage(R.drawable.m6);

        motorcycleAdapter.add(cat);
        motorcycleAdapter.notifyDataSetChanged();


    }

    public void add(){
        motorcycleAdapter = new MotorcycleAdapter((MainActivity) getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rev.setLayoutManager(layoutManager);
        motorcycleAdapter.add(new Vehicle(R.drawable.m1,"Harley-Davidson","Iron 48",500000,"Excellent"));
        motorcycleAdapter.add(new Vehicle(R.drawable.m2,"Harley-Davidson","Forty eight",30000,"Excellent"));
        rev.setAdapter(motorcycleAdapter);
        motorcycleAdapter.notifyDataSetChanged();

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}