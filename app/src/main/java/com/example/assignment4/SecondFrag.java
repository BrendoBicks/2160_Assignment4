package com.example.assignment4;


import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class SecondFrag extends Fragment implements AdapterView.OnItemSelectedListener {

    private Button btn;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView resultText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container,false);

        Spinner spinnerQuantity;
        spinnerQuantity = view.findViewById(R.id.spinnerQuantity);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.spinnerValues, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQuantity.setAdapter(adapter);
        spinnerQuantity.setOnItemSelectedListener(this);

        btn = view.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                radioGroup = view.findViewById(R.id.radioGroup);
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = view.findViewById(radioId);
                Spinner spinnerQuantity = view.findViewById(R.id.spinnerQuantity);

                String selectedRadio = (String) radioButton.getText();

                long quantity = spinnerQuantity.getSelectedItemId();

                double cost = 0;



                if(quantity > 0) {
                    if(selectedRadio.equals("Coffee")){
                        cost = 1.5;
                    }
                    else if(selectedRadio.equals("Muffin")){
                        cost = 2;
                    }
                    else if(selectedRadio.equals("Apple Juice")){
                        cost = 1.75;
                    }
                    else if(selectedRadio.equals("Donut")){
                        cost = 1.25;
                    }

                    cost = (double) cost*quantity;
                    resultText = (TextView) view.findViewById(R.id.txtResult);

                    DecimalFormat df = new DecimalFormat("0.00");

                    resultText.setText("Your total is: $" + df.format(cost));

                }
                else
                    Toast.makeText(getActivity().getBaseContext(), "Select Quantity", Toast.LENGTH_SHORT).show();
            }

        });


        return view;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}