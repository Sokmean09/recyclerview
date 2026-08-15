package com.example.recyclerview.Networking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.adapters.IOnPropertyItemListener;
import com.example.recyclerview.adapters.PropertyAdapter;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<UserModel> data;
    private final IOnPropertyItemListener listener;

    public UserAdapter(List<UserModel> data, IOnPropertyItemListener listener) {
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        var itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_user,  parent, false);
        return new UserViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivAvatar;
        private TextView tvEmail;
        private TextView tvFirstName;
        private TextView tvLastName;

        public UserViewHolder(@NonNull View itemView, IOnPropertyItemListener listener) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvFirstName = itemView.findViewById(R.id.tvFirstName);
            tvLastName = itemView.findViewById(R.id.tvLastName);

//            MaterialCardView rootView = itemView.findViewById(R.id.root);
//            rootView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    listener.onItemClick(getBindingAdapterPosition());
//                }
//            });
        }

        public void setData(UserModel item) {
            tvEmail.setText(item.email);
            tvFirstName.setText(item.firstName);
            tvLastName.setText(item.lastName);
        }
    }
}
