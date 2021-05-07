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

public class SuperCarAdapter extends RecyclerView.Adapter<SuperCarAdapter.SuperCarViewHolder> {


    private List<Vehicle> list;
    private MainActivity mainActivity;

    public SuperCarAdapter(MainActivity m) {
        this.mainActivity = m;
        list = new ArrayList<>();
    }


    public List<Vehicle> getSuperCar(){return list;
    }

    @NonNull
    @Override
    public SuperCarAdapter.SuperCarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vehicle,parent,false) ;
        return new SuperCarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperCarAdapter.SuperCarViewHolder holder, int position) {
        Vehicle h = list.get(position);
        if (h != null) {
            holder.img.setImageResource(list.get(position).getImage());
            holder.pub.setText(list.get(position).getPublisher());
            holder.name.setText(list.get(position).getName());
            holder.price.setText(Integer.toString(list.get(position).getPrice()));
            holder.sub.setText(list.get(position).getSubscription());
            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    notifyDataSetChanged();
                    mainActivity.list= list;
                }
            });
        } else return;
    }


    @Override
    public int getItemCount() {
        if(list!= null) {
            return list.size();
        }
        return  0 ;
    }

    public void add( Vehicle h){
        list.add(h);
        notifyDataSetChanged();
        mainActivity.list =list;
    }
    public class SuperCarViewHolder extends RecyclerView.ViewHolder {
        private ImageView img ;
        private TextView pub,name,price,sub ;
        private Button add ;


        public SuperCarViewHolder(@NonNull View itemView) {
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
