package com.example.recyclerview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.models.PropertyModel;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder> {

    private List<PropertyModel> data;
    private final IOnPropertyItemListener listener;

    public PropertyAdapter(List<PropertyModel> data, IOnPropertyItemListener listener) {
        this.data = data;
        this.listener = listener;

    }

    @NonNull
    @Override
    public PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        var itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_property,  parent, false);
        return new PropertyViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyViewHolder holder, int position) {
        holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class PropertyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImg;
        private TextView tvName;
        private TextView tvPrice;
        private TextView tvLocation;
        private TextView tvSize;

        public PropertyViewHolder(@NonNull View itemView, IOnPropertyItemListener listener) {
            super(itemView);
            ivImg = itemView.findViewById(R.id.ivImg);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvSize = itemView.findViewById(R.id.tvSize);

            MaterialCardView rootView = itemView.findViewById(R.id.root);
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getBindingAdapterPosition());
                }
            });
        }

        public void setData(PropertyModel item) {
            ivImg.setImageResource(item.getImg());
            tvName.setText(item.getName());
            tvPrice.setText(item.getPrice());
            tvLocation.setText(item.getLocation());
            tvSize.setText(item.getSize());
        }
    }
}
