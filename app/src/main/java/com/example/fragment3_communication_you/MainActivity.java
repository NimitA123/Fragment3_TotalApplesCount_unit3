package com.example.fragment3_communication_you;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements Communication {
    private FragmentManager  fragmentManager;
    private Intent intent;
    private TextView data1;
    private Bundle bundle;
    private TextView tv;
    private int apples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        initView();
      //  data1 = findViewById(R.id.tvApplesAvailable);
    //    intent = getIntent();
     //   int data =intent.getIntExtra("remaining", 0);
      //  data1.setText(data+" ");

    }

    private void initView() {
       FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       TotalApplesFragment totalApplesFragment = new TotalApplesFragment();
        fragmentTransaction.add(R.id.flContainer, totalApplesFragment, "totalApplesFragment").commit();
    }


    @Override
    public void setData(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BuyApplesFragment buyApplesFragment = new BuyApplesFragment();
        buyApplesFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.flContainer, buyApplesFragment, "buyApplesFragment").addToBackStack("Buy").commit();
    }

   @Override
    public void setData1(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TotalApplesFragment totalApplesFragment = new TotalApplesFragment();
        if(bundle!= null){
           totalApplesFragment.setArguments(bundle);
        }

        fragmentTransaction.replace(R.id.flContainer, totalApplesFragment, "totalApplesFragment").commit();

    }

}