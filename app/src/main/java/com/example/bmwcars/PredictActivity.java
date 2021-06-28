package com.example.bmwcars;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.String;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


public class PredictActivity extends AppCompatActivity {

    public static final String op_key="prajwal";
    Spinner car_name_spinner;

    Button get_price;

    EditText inp_year,inp_mileage,inp_mpg,inp_enginesize;

    RadioButton rb1,rb2,rb3;

    TextView op_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict);


//    1
        car_name_spinner=(Spinner)findViewById(R.id.model_name_spinner);
        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(PredictActivity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.car_names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        car_name_spinner.setAdapter(myAdapter);



//2-5
        inp_year=(EditText)findViewById(R.id.model_inp_year);
        inp_mileage=(EditText)findViewById(R.id.model_inp_mileage);
        inp_mpg=(EditText)findViewById(R.id.model_inp_mpg);
        inp_enginesize=(EditText)findViewById(R.id.model_inp_enginesize);

//  6-8
        rb1=(RadioButton) findViewById(R.id.radioButton1);
        rb2=(RadioButton) findViewById(R.id.radioButton2);
        rb3=(RadioButton) findViewById(R.id.radioButton3);

//   button

        get_price=(Button)findViewById(R.id.get_price_button);





        get_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //inp1
                float txt_inp_1=car_name_spinner.getSelectedItemPosition();

//--------------------------------------------------------------
            //inp2


                if(inp_year.getText().toString().isEmpty()){

                    inp_year.setError("plz fill year");
                    inp_year.requestFocus();
                    return;
                }


                float txt_inp_2=Float.parseFloat(inp_year.getText().toString());


                if(txt_inp_2<1996 || txt_inp_2>2020){

                    inp_year.setError("year range:1996-2020 ! ");
                    inp_year.requestFocus();

                    return;
                }

//===========================----------------------------------------------------------------

                //inp 3
                if(inp_mileage.getText().toString().isEmpty()){

                    inp_mileage.setError("plz fill running");
                    inp_mileage.requestFocus();
                    return;
                }

                float txt_inp_3=Float.parseFloat(inp_mileage.getText().toString());

                if(txt_inp_3<0 || txt_inp_3>214000){

                    inp_mileage.setError("out of range(0,214000) ! ");
                    inp_mileage.requestFocus();

                    return;
                }
//---------------------------------------------------------------------------------------------

//                inp4

                if(inp_mpg.getText().toString().isEmpty()){

                    inp_mpg.setError("plz fill mpg");
                    inp_mpg.requestFocus();
                    return;
                }
                float txt_inp_4=Float.parseFloat(inp_mpg.getText().toString());

                if(txt_inp_4<5 || txt_inp_4>500){

                    inp_mpg.setError("mpg range:5--500 ! ");
                    inp_mpg.requestFocus();

                    return;
                }

//                -----------------------------------------------------------------------

//                inp5

                if(inp_enginesize.getText().toString().isEmpty()){

                    inp_enginesize.setError("plz fill engine size");
                    inp_enginesize.requestFocus();
                    return;
                }

                float txt_inp_5=Float.parseFloat(inp_enginesize.getText().toString());

                if(txt_inp_5<0.2 || txt_inp_5>7){

                    inp_enginesize.setError("range for engine size is 0.2-7 ! ");
                    inp_enginesize.requestFocus();

                    return;
                }






//           inp 6 7 8    -------------------------------------------------------------

                int txt_inp_6=0,txt_inp_7=0,txt_inp_8=0;

                if(rb1.isChecked()){

                    txt_inp_6=1;
                }

                if(rb2.isChecked()){

                    txt_inp_7=1;
                }
                if(rb3.isChecked()){

                    txt_inp_8=1;
                }


                // validation





//
                String mess="car id: "+txt_inp_1+ "year : "+txt_inp_2+ "mileage : "+txt_inp_3+ "mpg : "+txt_inp_4+ "engine : "+txt_inp_5+" "+txt_inp_6+"; "+txt_inp_7+";"+txt_inp_8;

                double []my_inp={txt_inp_1,txt_inp_2,txt_inp_3,txt_inp_4,txt_inp_5,txt_inp_6,txt_inp_7,txt_inp_8};
                double price=Model.score(my_inp);

                int price_1=(int) price;


                Intent output_intent=new Intent(getApplicationContext(),OutputActivity.class);

                output_intent.putExtra(op_key,price_1);

                startActivity(output_intent);



            }
        });





    }
}