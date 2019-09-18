package com.example.coffeeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView show_quant,result;
    private CheckBox cream,chocolate;
    private Button plus,minus,get_total;
    private int total_cost,quantity,price=20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cream=findViewById(R.id.whipped_cream_checkbox);
        chocolate=findViewById(R.id.chocolate_checkbox);


        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        get_total=findViewById(R.id.total);

        show_quant=findViewById(R.id.quantity);
        result=findViewById(R.id.res) ;


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity<=0)
                {
                    quantity=0;
                    Toast.makeText(MainActivity.this, "No imaginary coffee", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    --quantity;
                    show_quant.setText(quantity+"");
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity>=10)
                {
                    quantity=10;
                    Toast.makeText(MainActivity.this, "Let others drink coffee", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    quantity++;
                    show_quant.setText(quantity+"");
                }
            }
        });

    get_total.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(cream.isChecked())
            {
                price+=10;
            }
            if(chocolate.isChecked())
            {
                price+=10;
            }
            total_cost=price*quantity;
            price=20;
            result.setText(total_cost+"");
        }
    });

    }
}
