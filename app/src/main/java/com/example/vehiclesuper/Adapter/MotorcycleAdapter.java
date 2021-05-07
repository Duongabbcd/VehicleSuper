package com.example.vehiclesuper.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vehiclesuper.MainActivity;
import com.example.vehiclesuper.R;
import com.example.vehiclesuper.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MotorcycleAdapter extends RecyclerView.Adapter<MotorcycleAdapter.MotorcycleViewHolder>{
    private List<Vehicle>  motorcycle;
    private MainActivity mainActivity;

    public MotorcycleAdapter(MainActivity m) {
        this.mainActivity = m;
        motorcycle = new ArrayList<>();
    }

    public MotorcycleAdapter() {

    }

    public List<Vehicle> getMotorcycle(){return motorcycle;
    }

    @NonNull
    @Override
    public MotorcycleAdapter.MotorcycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vehicle,parent,false) ;
        return new MotorcycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MotorcycleViewHolder holder, int position) {
        Vehicle h = motorcycle.get(position);
        if (h != null) {
            holder.img.setImageResource(motorcycle.get(position).getImage());
            holder.pub.setText(motorcycle.get(position).getPublisher());
            holder.name.setText(motorcycle.get(position).getName());
            holder.price.setText(Integer.toString(motorcycle.get(position).getPrice()));
            holder.sub.setText(motorcycle.get(position).getSubscription());
            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    motorcycle.remove(position);
                    notifyDataSetChanged();
                    mainActivity.motorList = motorcycle;
                }
            });
        } else return;
    }


    @Override
    public int getItemCount() {
        if(motorcycle != null) {
            return motorcycle.size();
        }
        return  0 ;
    }

    public void add( Vehicle h){
        motorcycle.add(h);
        notifyDataSetChanged();
        mainActivity.motorList=motorcycle;
    }
    public class MotorcycleViewHolder extends RecyclerView.ViewHolder {
        private ImageView img ;
        private TextView pub,name,price,sub ;
        private Button add ;

        public MotorcycleViewHolder(@NonNull View itemView) {
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

