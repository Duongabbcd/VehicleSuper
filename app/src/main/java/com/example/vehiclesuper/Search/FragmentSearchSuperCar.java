package com.example.vehiclesuper.Search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.vehiclesuper.MainActivity;
import com.example.vehiclesuper.R;
import com.example.vehiclesuper.model.Vehicle;
import java.util.ArrayList;
import java.util.List;


public class FragmentSearchSuperCar extends Fragment {
    private RecyclerView revView;
    private EditText eName;
    private Button btSearch;
    private List<Vehicle> list;
    List<Vehicle> tList=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_search_super_car,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull final View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intView(view);
        btSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name=eName.getText().toString();
                for(Vehicle p:list){
                    if(p.getName().equals(name))
                        tList.add(p);
                }
                SearchSuperCarAdapter adapter=new SearchSuperCarAdapter(tList, getContext());
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                revView.setLayoutManager(layoutManager);
                revView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void intView(View v) {
        revView=v.findViewById(R.id.rec1);
        eName=v.findViewById(R.id.n1);
        btSearch=v.findViewById(R.id.b1);
    }

    @Override
    public void onResume() {
        super.onResume();
        list = ((MainActivity)getActivity()).list;
    }
}