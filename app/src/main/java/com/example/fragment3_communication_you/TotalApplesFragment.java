package com.example.fragment3_communication_you;

import android.content.Context;
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


public class TotalApplesFragment extends Fragment {
    private EditText etTotalApples;
    private TextView RemainingApples;
    private Button NextFragment;
    private Bundle bundle;
    private int item;
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
            item = getArguments().getInt("Apples1");
            //RemainingApples = view.findViewById(R.id.tvApplesAvailable);

            // age = getArguments().getInt("age");
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments() != null){
            RemainingApples = view.findViewById(R.id.tvApplesAvailable);
            RemainingApples.setText(item+" ");

        }
        initView(view);
    }

    private void initView(View view) {
        etTotalApples = view.findViewById(R.id.etEdit);
     //   RemainingApples = view.findViewById(R.id.tvApplesAvailable);
        NextFragment = view.findViewById(R.id.btnNextFragment);
        NextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int name = Integer.parseInt(etTotalApples.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putInt("Apples", name);
                if(bundle!=null) {
                     communication.setData(bundle);
                }
            }
        });

    }


}