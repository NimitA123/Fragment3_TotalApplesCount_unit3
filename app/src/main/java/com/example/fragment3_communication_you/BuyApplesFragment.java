package com.example.fragment3_communication_you;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class BuyApplesFragment extends Fragment {
    private EditText et;
    private Button btn;
    private int item;
    private int Remaining_Apples;
  //  private TextView Remaining_Apples;
  private Communication communication;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        communication = (Communication)context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = getArguments().getInt("Apples");
           // age = getArguments().getInt("age");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    private void initView(View view) {
        et = view.findViewById(R.id.SecondEditText);
      //  Remaining_Apples = view.findViewById(R.id.tvApplesAvailable);
       // Remaining_Apples.setText("11");

     //   int Remaining_item = Integer.parseInt(et.getText().toString());
        btn = view.findViewById(R.id.SecondBtn);
        btn.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View view) {
              if(Integer.parseInt(et.getText().toString()) > item){
                  Toast.makeText(getContext(), "Please Enter No less than "+""+ item , Toast.LENGTH_LONG).show();
              }
              else {
                  Remaining_Apples = item - Integer.parseInt(et.getText().toString());

                  Bundle bundle = new Bundle();
                  bundle.putInt("Apples1", Remaining_Apples);
                  if(bundle!=null) {
                      communication.setData1(bundle);
                  }
              }
            }
        });
 //      if(Integer.parseInt(et.getText().toString())> item){
//          Toast.makeText(getContext(), "Please Enter less than"+" "+item+""+ "Apples", Toast.LENGTH_LONG).show();
 //     }
//       else{
 //       }
    }
}