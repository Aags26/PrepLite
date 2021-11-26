package com.PrepLite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.PrepLite.adapters.postAdapter;
import com.PrepLite.dataBindings.postData;

import java.util.ArrayList;

public class Company_Preview extends AppCompatActivity {

    private RecyclerView recyclerView;
    private postAdapter postAdapter;
    private ArrayList<postData> post_List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_preview);
        getSupportActionBar().setTitle(getIntent().getStringExtra("name"));
        getSupportActionBar().setHomeButtonEnabled(false);

        buildrecyclerView();
    }

    private void buildrecyclerView()
    {
        post_List = new ArrayList<>();
        post_List.add(new postData("Ashwin","Amazon","24-11-2021","13:02","Hello 1"));
        post_List.add(new postData("Aagam","Cisco","25-11-2021","13:02","Hello 2"));
        post_List.add(new postData("Harsh","GE","26-11-2021","13:02","Hello 3"));
        postAdapter = new postAdapter(post_List,this);
        recyclerView = findViewById(R.id.company_post_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postAdapter);

    }

}