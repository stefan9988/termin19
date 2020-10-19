package com.ftninformatika.myapplication0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyrecAdapter.OnElementClickListener {

    RecyclerView rvLits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpReciclerView();
    }

    private void setUpReciclerView(){
        rvLits = findViewById(R.id.rvlist);
        rvLits.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        rvLits.setLayoutManager(layoutManager);
        MyrecAdapter adapter=new MyrecAdapter(this,getData());
        rvLits.setAdapter(adapter);


    }

    private List<String>getData(){
        List<String>data=new ArrayList<>();
        for (int i=0;i<20;i++){
            data.add("element "+i);
        }
        return data;
    }

    @Override
    public void onElementClicked(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}