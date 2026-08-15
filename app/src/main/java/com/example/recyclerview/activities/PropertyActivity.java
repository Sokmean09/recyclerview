package com.example.recyclerview.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.recyclerview.R;
import com.example.recyclerview.models.PropertyModel;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class PropertyActivity extends AppCompatActivity {
    private List<PropertyModel> data =  PropertyModel.generateItem();
    private PropertyModel item;
    private int position;
    private ImageView ivImg;
    private TextView tvPrice;
    private TextView tvName;
    private TextView tvLocation;
    private TextView tvSize;
    private MaterialButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_property);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent receivedIntent = getIntent();
        position = receivedIntent.getIntExtra("position", 0);
        item = data.get(position);

        ivImg = findViewById(R.id.ivImg);
        tvPrice = findViewById(R.id.tvPrice);
        tvName = findViewById(R.id.tvName);
        tvLocation = findViewById(R.id.tvLocation);
        tvSize = findViewById(R.id.tvSize);
        backBtn = findViewById(R.id.backBtn);

        ivImg.setImageResource(item.getImg());
        tvName.setText(item.getName());
        tvPrice.setText(item.getPrice());
        tvLocation.setText(item.getLocation());
        tvSize.setText(item.getSize());

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}