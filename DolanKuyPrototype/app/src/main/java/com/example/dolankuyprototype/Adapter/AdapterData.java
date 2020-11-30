package com.example.dolankuyprototype.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dolankuyprototype.Model.DataModel;
import com.example.dolankuyprototype.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private Context ctx;
    private List<DataModel> listWisata;

    public AdapterData(Context ctx, List<DataModel> listWisata) {
        this.ctx = ctx;
        this.listWisata = listWisata;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listWisata.get(position);

        holder.card_id.setText(String.valueOf(dm.getId()));
        holder.card_name.setText(dm.getName());
        holder.card_address.setText(dm.getAddress());
        holder.card_description.setText(dm.getDescription());
    }

    @Override
    public int getItemCount() {
        return listWisata.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView card_name,card_address,card_description,card_id;


        public HolderData(@NonNull View itemView) {
            super(itemView);

            card_id = itemView.findViewById(R.id.card_id);
            card_name = itemView.findViewById(R.id.card_name);
            card_address = itemView.findViewById(R.id.card_address);
            card_description = itemView.findViewById(R.id.card_description);
        }
    }
}
