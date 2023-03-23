package com.example.unitconverter3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class TemperatureActivity extends AppCompatActivity {

        final String[] valuesArray = new String[]{"Select Unit","Celsius","Fahrenheit","Kalvin"};
        Spinner fromSpinnerView;
        Spinner toSpinnerView;
        EditText fromEditTextView;
        TextView toTextView;
        CardView cv_convert;
        String fromSelectedText;
        String toSelectedText;
        Double fromText;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        fromSpinnerView=findViewById(R.id.fromSpinnerView);
        toSpinnerView=findViewById(R.id.toSpinnerView);
        fromEditTextView=findViewById(R.id.fromEditTextView);
        toTextView=findViewById(R.id.toTextview);
        cv_convert=findViewById(R.id.cv_convert);


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_text_item,valuesArray)
        {
            @Override
            public boolean isEnabled(int position) {
                return position != 0;
            }
            @Override
            public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        fromSpinnerView.setAdapter(adapter);
        ArrayAdapter<String>adapter2=new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_text_item,valuesArray)
        {
            @Override
            public boolean isEnabled(int position) {
                return position != 0;
            }
            @Override
            public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        toSpinnerView.setAdapter(adapter2);

        cv_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromSelectedText=fromSpinnerView.getSelectedItem().toString();
                toSelectedText=toSpinnerView.getSelectedItem().toString();

                if(fromSelectedText.equals("Select Unit")||toSelectedText.equals("Select Unit"))
                {
                    Toast.makeText(getApplicationContext(), "Units are not Selected", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    fromText=Double.parseDouble(fromEditTextView.getText().toString());
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Enter Value to Convert", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(fromSelectedText.equals(toSelectedText))
                {
                    toTextView.setText(String.valueOf(fromText));
                }
                else
                {
                    converterMethod(fromSelectedText,toSelectedText);
                }
            }

            private void converterMethod(String fromSelectedText, String toSelectedText) {
                //Celsius
                if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf((fromText*9/5)+32));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText+273.15));
                }

                //Fahrenheit
                if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf((fromText-32)*5/9));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf((fromText-32)*5/9+273.15));
                }

                //Kalvin
                if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText-273.15));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf((fromText-273.15)*9/5+32));
                }
            }


        });

    }

}
