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

public class TimeActivity extends AppCompatActivity {

    final String[] valuesArray = new String[]{"Select Unit","MilliSecond","Second","Minute","Hour","Day","Week",
            "Month","Year","Decade","Century"};

    Spinner fromSpinnerView;
    Spinner toSpinnerView;
    EditText fromEditTextView;
    TextView toTextView;
    CardView cv_convert;
    String fromSelectedText;
    String toSelectedText;
    Double fromText;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

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
                //MilliSecond
                if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 0.001));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText* 1.6667E-5));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText* 2.7778E-7));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText* 1.1574E-8));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText*1.6534E-9));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText *3.8052E-10));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *3.171E-11));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *3.171E-12));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *3.171E-13));
                }

                //Second
                if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText* 1000));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText* 0.166667));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*0.000277778));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*1.1574E-5));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText *1.6534E-6));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*3.8052E-7));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *3.171E-8));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *3.171E-9));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *3.171E-10));
                }

                //Minute
                if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText* 60000));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText*60));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0166667));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*0.000694444));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText * 9.9206E-5));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText *2.2831E-5));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *1.9026E-6));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText*1.9026E-7));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *1.9026E-8));
                }


                //Hour
                if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText* 3.6E+6));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 3600));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*60));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0416667));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText *0.00595238));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*0.00136986));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText*0.000114155));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *1.1416E-5));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *1.1416E-6));
                }


                //Day
                if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*8.64E+7));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 86400));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*1440));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*24));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText * 0.142857));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0328767));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText*0.00273973));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *0.000273973));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *2.7397E-5));
                }


                // Week
                if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText* 6.048E+8));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 604800));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText* 10080));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText* 168));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*7));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*0.230137));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0191781));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *0.00191781));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *0.000191781));
                }

                // Month
                if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*2.628E+9));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 2.629E+6));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*43800));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*730.001));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*30.4167));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText*4.34524));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *0.0833334));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText*0.00833334));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText*0.000833334));
                }


                // Year
                if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*3.154E+10));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText*3.154E+7));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*525600));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*8760));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*365));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText*52.1429));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*12));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText*0.1));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *0.01));
                }


                // Decade
                if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*3.154E+11));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText*3.154E+8));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*5.26E+6));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*87600));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*3650));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText*521.429));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText *120));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText*10));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *0.1));
                }


                // Century
                if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*3.154E+12));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 3.154E+9));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*5.256E+7));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*876000));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*36500));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText *5214.29));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText *1200));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *100));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *10));
                }

            }


        });



    }

}