package com.example.miki.gesturegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity   {
    private Spinner nSpinner;
    private String spinnerItems[] = {"30秒", "1分", "1分30秒", "2分","3分"};
    private TextView textView;
    int time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        nSpinner = (Spinner)findViewById(R.id.spinner1);
        // ArrayAdapter
        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // spinner に adapter をセット
        nSpinner.setAdapter(adapter);

        // リスナーを登録
        nSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            //　アイテムが選択された時
            public void onItemSelected(AdapterView<?> parent, View viw, int arg2, long arg3) {
                Spinner spinner = (Spinner) parent;
                String item = (String) spinner.getSelectedItem();

                if (item.equals("30秒")) {
                    //textView.setText("Android");
                    time = 30;
                } else if (item.equals("1分")) {
                   time = 60;
                } else if (item.equals("1分30秒")) {
                   time = 90;
                } else if (item.equals("2分")){
                  time = 120;
                }else if (item.equals("3分")){
                  time = 180;
                }
            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //次の画面に行く
        Button sendButton = (Button) findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SubActivity.class);
                intent.putExtra("TIME",time);
                startActivity(intent);
            }
        });
    }

}
