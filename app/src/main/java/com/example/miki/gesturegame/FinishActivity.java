package com.example.miki.gesturegame;

import android.app.Activity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
/**
 * Created by miki on 2016/07/01.
 */
public class FinishActivity extends Activity {
    private TextView textView;
    private TextView countView;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Intent intent = getIntent();
        count = intent.getIntExtra("COUNT",0);
        System.out.println("count");

        countView = (TextView) findViewById(R.id.countView);
        String str = String.valueOf(count);
        countView.setText(str);

        Button sendButton = (Button) findViewById(R.id.return_button);


        //次の画面に行く
        Button topButton = (Button) findViewById(R.id.topbutton);
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), MainActivity.class);

                startActivity(intent);
            }
        });


        //textViewの設定
        //textView = (TextView) findViewById(R.id.textView);
       /* sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });*/
    }

}


