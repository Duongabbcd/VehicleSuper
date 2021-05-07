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
import com.example.vehiclesuper.MainActivity;
import com.example.vehiclesuper.R;
import com.example.vehiclesuper.model.Vehicle;

import java.util.ArrayList;
import java.util.List;


public class FragmentHyperCar extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner sp  ;
    private EditText name,price,subs,pub;
    private Button btn ;
    private RecyclerView rev ;
    private List<Vehicle> hpList = new ArrayList<>();
    private HyperCarAdapter hyperCarAdapter  ;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hyper_car, container, false);
    }


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

    private void init(View v){
        sp=v.findViewById(R.id.sp3) ;
        pub=v.findViewById(R.id.pub3);
        name=v.findViewById(R.id.name3);
        price=v.findViewById(R.id.price3);
        subs=v.findViewById(R.id.subs3);
        btn =v.findViewById(R.id.btn3);;
        rev=v.findViewById(R.id.re3);
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
        if(i==0) cat.setImage(R.drawable.h1);
        if(i==1) cat.setImage(R.drawable.h2);
        if(i==2) cat.setImage(R.drawable.h7);
        if(i==3) cat.setImage(R.drawable.h4);
        if(i==4) cat.setImage(R.drawable.h5);
        if(i==5) cat.setImage(R.drawable.h6);

        hyperCarAdapter.add(cat);
        hyperCarAdapter.notifyDataSetChanged();


    }

         public void add(){
             hyperCarAdapter = new HyperCarAdapter((MainActivity) getActivity());
             LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
             rev.setLayoutManager(layoutManager);
             hyperCarAdapter.add(new Vehicle(R.drawable.h1,"Lamborghini","Veneno",5000000,"Excellent"));
             hyperCarAdapter.add(new Vehicle(R.drawable.h2,"Lamborghini","Aventador",300000,"Excellent"));
             rev.setAdapter(hyperCarAdapter);
             hyperCarAdapter.notifyDataSetChanged();

   }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

