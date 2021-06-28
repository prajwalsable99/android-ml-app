package com.example.bmwcars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

    TextView op_textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        op_textview=(TextView)findViewById(R.id.textview_op);

        Intent obj=getIntent();

        int my_op=obj.getIntExtra(PredictActivity.op_key,0);

        if(my_op<0){

            String x="such car will not be not in state to sell/buy,check your info...";
            op_textview.setText(x);
        }
        else {

            String final_s=String.valueOf(my_op)+"\n"+"pounds";
            op_textview.setText(String.valueOf(final_s));

        }






    }
}