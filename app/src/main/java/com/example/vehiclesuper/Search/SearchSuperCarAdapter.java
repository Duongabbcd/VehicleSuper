package com.example.vehiclesuper.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vehiclesuper.R;
import com.example.vehiclesuper.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class SearchSuperCarAdapter extends RecyclerView.Adapter<SearchSuperCarAdapter.SearchViewHolder>{
    private List<Vehicle> superCarList= new ArrayList<>();
    Context context;

    public  SearchSuperCarAdapter(List<Vehicle> superCarList, Context context) {
        this.superCarList = superCarList;
        this.context = context;

        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public SearchSuperCarAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_vehicle,parent,false);
        return new SearchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchSuperCarAdapter.SearchViewHolder holder, int position) {
        Vehicle p=superCarList.get(position);

            holder.img.setImageResource(p.getImage());
            holder.pub.setText(p.getPublisher());
            holder.name.setText(p.getName());
            holder.price.setText(p.getPrice() + "");
            holder.subs.setText(p.getSubscription());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
    private TextView pub,name,subs,price ;
    private ImageView img ;
    private Button btn;
        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.hp_img);
            pub = itemView.findViewById(R.id.hp_pub);
            name= itemView.findViewById(R.id.hp_name) ;
            price=itemView.findViewById(R.id.hp_price) ;
            subs =itemView.findViewById(R.id.hp_sub) ;
            btn = itemView.findViewById(R.id.hp_btn);
        }
    }
}
