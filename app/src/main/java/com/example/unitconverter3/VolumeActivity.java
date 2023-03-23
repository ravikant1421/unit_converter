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

public class VolumeActivity extends AppCompatActivity {

    final String[] valuesArray = new String[]{"Select Unit","Gallon","Quart","Pint","Cup","Fluid Ounce",
            "Tablespoon","Teaspoon","Cubic meter","Liter","Milliliter","Cubic Foot","Cubic Inch"};

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
        setContentView(R.layout.activity_volume);

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
                //Gallon
                if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 4));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText* 8));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText* 15.7725));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*128));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText*256));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText *768));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *0.00378541));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *3.78541));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *3785.41));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[11]))
                {
                    toTextView.setText(String.valueOf(fromText*0.133681));
                }
                else if(fromSelectedText.equals(valuesArray[1])&&toSelectedText.equals(valuesArray[12]))
                {
                    toTextView.setText(String.valueOf(fromText *231));
                }

                //Quart
                if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText* 0.25));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText* 2));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*3.94314));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*32));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText *64));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*192));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *0.000946353));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *0.946353));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *946.353));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[11]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0334201));
                }
                else if(fromSelectedText.equals(valuesArray[2])&&toSelectedText.equals(valuesArray[12]))
                {
                    toTextView.setText(String.valueOf(fromText *57.75));
                }

                //Pint
                if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*0.125));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText*0.5));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*1.97157));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText* 16));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText * 32));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText *96));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *0.000473176));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText*0.473176));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *473.176));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[11]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0167101));
                }
                else if(fromSelectedText.equals(valuesArray[3])&&toSelectedText.equals(valuesArray[12]))
                {
                    toTextView.setText(String.valueOf(fromText *28.875));
                }


                //Cup
                if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0634013));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText*0.253605));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*0.50721));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*8.11537));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText *16.2307));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*48.6922));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText*0.00024));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *0.24));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *240));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[11]))
                {
                    toTextView.setText(String.valueOf(fromText*0.00847552));
                }
                else if(fromSelectedText.equals(valuesArray[4])&&toSelectedText.equals(valuesArray[12]))
                {
                    toTextView.setText(String.valueOf(fromText *14.6457));
                }


                //Fluid Ounce
                if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0078125));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 0.03125));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0625));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*0.123223));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText * 2));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*6));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText*2.9574E-5));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *0.0295735));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *29.5735));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[11]))
                {
                    toTextView.setText(String.valueOf(fromText*0.00104438));
                }
                else if(fromSelectedText.equals(valuesArray[5])&&toSelectedText.equals(valuesArray[12]))
                {
                    toTextView.setText(String.valueOf(fromText *1.80469));
                }


                //Tablespoon
                if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*0.00390625));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText*0.015625));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*0.03125));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0616115));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*0.5));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*3));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText*1.4787E-5));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *0.0147868));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *14.7868));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[11]))
                {
                    toTextView.setText(String.valueOf(fromText*0.00052219));
                }
                else if(fromSelectedText.equals(valuesArray[6])&&toSelectedText.equals(valuesArray[12]))
                {
                    toTextView.setText(String.valueOf(fromText *0.902344));
                }

                // Teaspoon
                if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*0.00130208));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 0.00520833));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0104167));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0205372));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*0.166667));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText*0.333333));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *4.9289E-6));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText*0.00492892));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText*4.92892));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[11]))
                {
                    toTextView.setText(String.valueOf(fromText*0.000174063));
                }
                else if(fromSelectedText.equals(valuesArray[7])&&toSelectedText.equals(valuesArray[12]))
                {
                    toTextView.setText(String.valueOf(fromText *0.300781));
                }


                // Cubic Meter
                if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText* 264.172));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 1056.69));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*2113.38));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*4166.67));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*33814));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText*67628));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*202884));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText*1000));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *1.0E+6));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[11]))
                {
                    toTextView.setText(String.valueOf(fromText*35.3147));
                }
                else if(fromSelectedText.equals(valuesArray[8])&&toSelectedText.equals(valuesArray[12]))
                {
                    toTextView.setText(String.valueOf(fromText *61023.7));
                }


                //Liter
                if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*0.264172));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText*1.05669));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*2.11338));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*4.16667));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*33.814));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText*67.628));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText *202.884));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText*0.001));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText *1000));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[11]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0353147));
                }
                else if(fromSelectedText.equals(valuesArray[9])&&toSelectedText.equals(valuesArray[12]))
                {
                    toTextView.setText(String.valueOf(fromText *61.0237));
                }


                // Milliliter
                if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*0.000264172));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 0.00105669));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*0.00211338));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*0.00416667));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*0.033814));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText *0.067628));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText *0.202884));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText *1.0E-6));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *0.001));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[11]))
                {
                    toTextView.setText(String.valueOf(fromText*3.5315E-5));
                }
                else if(fromSelectedText.equals(valuesArray[10])&&toSelectedText.equals(valuesArray[12]))
                {
                    toTextView.setText(String.valueOf(fromText *0.0610237));
                }


                // Cubic Foot
                if(fromSelectedText.equals(valuesArray[11])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*7.48052));
                }
                else if(fromSelectedText.equals(valuesArray[11])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 29.9221));
                }
                else if(fromSelectedText.equals(valuesArray[11])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*59.8442));
                }
                else if(fromSelectedText.equals(valuesArray[11])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*117.987));
                }
                else if(fromSelectedText.equals(valuesArray[11])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*957.506));
                }
                else if(fromSelectedText.equals(valuesArray[11])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText*1915.01));
                }
                else if(fromSelectedText.equals(valuesArray[11])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*5745.04));
                }
                else if(fromSelectedText.equals(valuesArray[11])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0283168));
                }
                else if(fromSelectedText.equals(valuesArray[11])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *28.3168));
                }
                else if(fromSelectedText.equals(valuesArray[11])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText*28316.8));
                }
                else if(fromSelectedText.equals(valuesArray[11])&&toSelectedText.equals(valuesArray[12]))
                {
                    toTextView.setText(String.valueOf(fromText*1728));
                }




                // Cubic Inch
                if(fromSelectedText.equals(valuesArray[12])&&toSelectedText.equals(valuesArray[1]))
                {
                    toTextView.setText(String.valueOf(fromText*0.004329));
                }
                else if(fromSelectedText.equals(valuesArray[12])&&toSelectedText.equals(valuesArray[2]))
                {
                    toTextView.setText(String.valueOf(fromText* 0.017316));
                }
                else if(fromSelectedText.equals(valuesArray[12])&&toSelectedText.equals(valuesArray[3]))
                {
                    toTextView.setText(String.valueOf(fromText*0.034632));
                }
                else if(fromSelectedText.equals(valuesArray[12])&&toSelectedText.equals(valuesArray[4]))
                {
                    toTextView.setText(String.valueOf(fromText*0.0682794));
                }
                else if(fromSelectedText.equals(valuesArray[12])&&toSelectedText.equals(valuesArray[5]))
                {
                    toTextView.setText(String.valueOf(fromText*0.554113));
                }
                else if(fromSelectedText.equals(valuesArray[12])&&toSelectedText.equals(valuesArray[6]))
                {
                    toTextView.setText(String.valueOf(fromText*1.10823));
                }
                else if(fromSelectedText.equals(valuesArray[12])&&toSelectedText.equals(valuesArray[7]))
                {
                    toTextView.setText(String.valueOf(fromText*3.32468));
                }
                else if(fromSelectedText.equals(valuesArray[12])&&toSelectedText.equals(valuesArray[8]))
                {
                    toTextView.setText(String.valueOf(fromText*1.6387E-5));
                }
                else if(fromSelectedText.equals(valuesArray[12])&&toSelectedText.equals(valuesArray[9]))
                {
                    toTextView.setText(String.valueOf(fromText *0.0163871));
                }
                else if(fromSelectedText.equals(valuesArray[12])&&toSelectedText.equals(valuesArray[10]))
                {
                    toTextView.setText(String.valueOf(fromText*16.3871));
                }
                else if(fromSelectedText.equals(valuesArray[12])&&toSelectedText.equals(valuesArray[11]))
                {
                    toTextView.setText(String.valueOf(fromText *0.000578704));
                }

            }

        });




    }
}