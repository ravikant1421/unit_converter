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

public class AreaActivity extends AppCompatActivity {

    final String[] valuesArray = new String[]{"Select Unit","Square Kilometre","Square Meter","Square Centimeter","Square Millimetre",
            "Hectare", "Acre","Square Mile","Square Yard","Square Foot","Square Inch"};

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
        setContentView(R.layout.activity_area);

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
                //Square Kilometre
                if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 1000*1000));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText* 100000*100000));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText* 1.0E+6*1.0E+6));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText* 100));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText*247.105));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText *0.621*0.621));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *1093.61*1093.61));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *3280.84*3280.84));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *39370.1*39370.1));
                }

                //Square Meter
                if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText* 0.001*0.001));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText* 100*100));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*1000*1000));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*1.0E+6*1.0E+6));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText *1.0E+9*1.0E+9));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*0.00062*0.00062));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *1.093*1.093));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *3.28*3.28));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *39.37*39.37));
                }

                // Square Centimeter
                if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText* 1.0E-5*1.0E-5));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText*0.01*0.01));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*10*10));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText* 10000*10000));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText * 1e+7*1e+7));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText *6.2137E-6*6.2137E-6));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *0.0109*0.0109));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText*0.033*0.033));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *.0393*.0393));
                }


                //Square Millimetre
                if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText* 1.0E-6*1.0E-6));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 0.001*0.001));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*0.1*0.1));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*1000*1000));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText *1.0E+6*1.0E+6));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*6.2137E-7*6.2137E-7));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText*0.00109*0.00109));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *0.00328*0.00328));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *0.0393*0.0393));
                }


                //Hectare
                if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText* 1.0E-9*1.0E-9));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 1E-6*1E-6));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*1E-4*1E-4));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*0.001*0.001));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText * 1000*1000));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*6.2137E-10*6.2137E-10));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText*1.0936E-6*1.0936E-6));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *3.2808E-6*3.2808E-6));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *3.937E-5*3.937E-5));
                }


                //Acre
                if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText* 1E-12*1E-12));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 1E-9*1E-9));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText* 1E-7*1E-7));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText* 1E-6*1E-6));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*0.001*0.001));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*6.2137E-13*6.2137E-13));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText*1.0936E-9*1.0936E-9));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *3.2808E-9*3.2808E-9));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *3.937E-8*3.937E-8));
                }

                // Square Mile
                if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*1.6093*1.6093));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 1609.34*1609.34));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*160934*160934));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*1.609E+6*1.609E+6));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*1.609E+9*1.609E+9));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText*1.609E+12*1.609E+12));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *1760*1760));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText*5280*5280));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText*63360*63360));
                }


                // Square Yard
                if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText* 0.000914*0.000914));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 0.09144*0.09144));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*91.44*91.44));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*914.4*914.4));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*914400*914400));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText*9.144E+8*9.144E+8));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*0.000568*0.000568));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText*3*3));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *36*36));
                }


                //Square Foot
                if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*0.000304*0.000304));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText*0.304*0.304));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*30.48*30.48));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*304.8*304.8));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*304800*304800));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText*3.048E+8*3.048E+8));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText *0.000189*0.000189));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText*0.3333*0.3333));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *12*12));
                }


                // Square Inch
                if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText* 2.54E-5*2.54E-5));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 0.0254*0.0254));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*2.54*2.54));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*25.4*25.4));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*25400*25400));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText *2.54E+7*2.54E+7));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText *1.5783E-5*1.5783E-5));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *0.02777*0.02777));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *0.08333*0.08333));
                }

            }


        });




    }
}