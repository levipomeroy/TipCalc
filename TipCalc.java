package com.levip.first_go;

import android.icu.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.RoundingMode;

import static java.lang.System.exit;

public class Test extends AppCompatActivity {

    Button ten;
    Button fifteen;
    Button twenty;
    Button twentyfive;
    EditText bill;
    EditText numPeople;
    TextView EachPerson;
    TextView showTip;
    TextView showTotal;

    float tip_percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ten =(Button) findViewById(R.id.ten);
        fifteen = (Button) findViewById(R.id.fifteen);
        twenty = (Button) findViewById(R.id.twenty);
        twentyfive = (Button) findViewById(R.id.twentyfive);
        bill = (EditText) findViewById(R.id.bill_amount);
        showTip = (TextView) findViewById(R.id.showTip);
        showTotal = (TextView) findViewById(R.id.showtotal);
        EachPerson = (TextView) findViewById(R.id.eachPerson);
        numPeople = (EditText) findViewById(R.id.Enumpeople);
        numPeople.setText("1");


            ten.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tip_percent = .1f;
                    CalculateTip();
                }
            });

            fifteen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tip_percent = .15f;
                    CalculateTip();
                }
            });

            twenty.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tip_percent = .20f;
                    CalculateTip();
                }
            });

            twentyfive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tip_percent = .25f;
                    CalculateTip();
                }
            });

        }


    public void CalculateTip()
    {
        float bill_amount = Float.valueOf(bill.getText().toString());
        float tip = bill_amount * tip_percent;
        float total = bill_amount + tip;
        float num_people = Float.valueOf(numPeople.getText().toString());
        float each = total / num_people;
        showTip.setText(("$" + (Float.toString(tip))).format("%.2f",tip));
        showTotal.setText(("$" + (Float.toString(total))).format("%.2f",total));
        EachPerson.setText(("$" + (Float.toString(each))).format("%.2f",each));
    }

}
