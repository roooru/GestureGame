package com.example.miki.gesturegame;

/**
 * Created by miki on 2016/06/30.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;


public class SubActivity extends Activity  {
    private TextView textView;
    private boolean flag = false;
    Gesturewords gw = new Gesturewords();

    Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        //ボタンの設定
        Button sendButton = (Button) findViewById(R.id.return_button);
        //textViewの設定
        textView = (TextView) findViewById(R.id.textView);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // finish();
                if(flag) {
                    int r = rnd.nextInt(gw.words.size());
                    textView.setText(gw.words.get(r));
                    flag = false;
                }else{
                    int r = rnd.nextInt(gw.words.size());
                    textView.setText(gw.words.get(r));
                    flag = true;
                }

            }
        });
    }
}
