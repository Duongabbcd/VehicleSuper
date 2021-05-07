package com.example.vehiclesuper.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vehiclesuper.MainActivity;
import com.example.vehiclesuper.R;
import com.example.vehiclesuper.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class HyperCarAdapter extends RecyclerView.Adapter<HyperCarAdapter.HyperCarViewHolder>{
    private List<Vehicle> hyperCar ;
    private MainActivity mainActivity;

    public HyperCarAdapter(MainActivity m) {
        this.mainActivity = m;
        hyperCar = new ArrayList<>();
    }

    public List<Vehicle> getHyperCar(){return hyperCar;
    }

    @NonNull
    @Override
    public HyperCarAdapter.HyperCarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vehicle,parent,false) ;
        return new HyperCarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HyperCarAdapter.HyperCarViewHolder holder, int position) {
        Vehicle h = hyperCar.get(position);
        if (h != null) {
            holder.img.setImageResource(hyperCar.get(position).getImage());
            holder.pub.setText(hyperCar.get(position).getPublisher());
            holder.name.setText(hyperCar.get(position).getName());
            holder.price.setText(Integer.toString(hyperCar.get(position).getPrice()));
            holder.sub.setText(hyperCar.get(position).getSubscription());
            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hyperCar.remove(position);
                    notifyDataSetChanged();
                    mainActivity.list = hyperCar;
                }
            });
        } else return;
    }

    @Override
    public int getItemCount() {
        if(hyperCar != null) {
            return hyperCar.size();
        }
        return  0 ;
    }

    public void add( Vehicle h){
        hyperCar.add(h);
        notifyDataSetChanged();
        mainActivity.list=hyperCar;
    }

    public class HyperCarViewHolder extends RecyclerView.ViewHolder {
        private ImageView img ;
        private TextView pub,name,price,sub ;
        private Button add ;

        public HyperCarViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.hp_img) ;
            pub=itemView.findViewById(R.id.hp_pub);
            name=itemView.findViewById(R.id.hp_name);
            price = itemView.findViewById(R.id.hp_price);
            sub=itemView.findViewById(R.id.hp_sub);
            add=itemView.findViewById(R.id.hp_btn);
        }
    }
}

