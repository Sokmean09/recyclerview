package com.example.recyclerview.activities;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.adapters.IOnPropertyItemListener;
import com.example.recyclerview.adapters.PropertyAdapter;
import com.example.recyclerview.models.PropertyModel;

import java.util.List;

public class PropertyListActivity extends AppCompatActivity {
    private List<PropertyModel> data = PropertyModel.generateItem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_property_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView rvProperty = findViewById(R.id.rvProperty);
        var propertyAdapter = new PropertyAdapter(data, new IOnPropertyItemListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(PropertyListActivity.this, "Prop Name: " + data.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PropertyListActivity.this, PropertyActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
        rvProperty.setLayoutManager(new LinearLayoutManager(this));
        rvProperty.setAdapter(propertyAdapter);

    }
}