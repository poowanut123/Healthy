package com.poowanut59070140.healthy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BmiFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_bmi,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button bmiCalculate = getView().findViewById(R.id.bmi_calculate_btn);
        bmiCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText _bmiHeight = getView().findViewById(R.id.bmi_height);
                EditText _bmiWeight = getView().findViewById(R.id.bmi_weight);
                TextView _bmi = getView().findViewById(R.id.bmi_result);

                TextView _textview = getView().findViewById(R.id.textView);

                if(_bmiHeight.getText().toString().isEmpty() || _bmiWeight.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(),"Please fill Height or Weight.",Toast.LENGTH_SHORT).show();
                } else {
                    float bmiHeight = Float.parseFloat(_bmiHeight.getText().toString())/100;
                    float bmiWeight = Float.parseFloat(_bmiWeight.getText().toString());
                    float BMI = bmiWeight/(bmiHeight*bmiHeight);
                    if(BMI>30){
                        _bmi.setTextColor(Color.rgb(255, 63, 63));
                    }

                    if(BMI>18.5 && BMI <22.9){
                        _bmi.setTextColor(Color.rgb(31, 176, 14));
                    }

                    if(BMI<18.5){
                        _bmi.setTextColor(Color.rgb(247, 243, 5));
                    }

                    _bmi.setText(String.format("%.2f", BMI));
                    _textview.setText(String.format("Your BMI"));

                }

            }
        });

        onClickBackBtn();
    }

    private void onClickBackBtn(){
        Button backBtn = getView().findViewById(R.id.bmi_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
//                getActivity().getSupportFragmentManager()
//                        .beginTransaction().replace(R.id.main_view, new MenuFragment())
//                        .addToBackStack(null)
//                        .commit();
            }
        });
    }
}