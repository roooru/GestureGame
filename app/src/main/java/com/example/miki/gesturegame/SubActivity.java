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
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.content.Intent;
import android.widget.Toast;


public class SubActivity extends Activity  {
    private TextView textView;
    private boolean flag = false;
    private TextView timerText;
    MediaPlayer mp = null;
    Gesturewords gw = new Gesturewords();

    Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        //タイマーの
        timerText = (TextView)findViewById(R.id.timer);
        timerText.setText("0:00.000");

        final CountDown countDown = new CountDown(30000, 100);
        //音楽設定
        mp = MediaPlayer.create(this, R.raw.fail);
        //ボタンの設定
        Button sendButton = (Button) findViewById(R.id.return_button);
        //textViewの設定
        textView = (TextView) findViewById(R.id.textView);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // finish();
                // 開始
                countDown.start();
                //timerText.setText("0:00.000");
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
    //カウントダウンしている
    class CountDown  extends CountDownTimer {


        public CountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            // 完了
            timerText.setText("0:00.000");
            //音楽鳴らす
            mp.start();
            //次の画面に
            Intent intent = new Intent(SubActivity.this, FinishActivity.class);
            startActivity(intent);
            /*Intent intent = new Intent(getApplication(), FinishActivity.class);
            startActivity(intent);*/
        }

        // インターバルで呼ばれる
        @Override
        public void onTick(long millisUntilFinished) {
            // 残り時間を分、秒、ミリ秒に分割
            long mm = millisUntilFinished / 1000 / 60;
            long ss = millisUntilFinished / 1000 % 60;
            long ms = millisUntilFinished - ss * 1000 - mm * 1000 * 60;

            timerText.setText(String.format("%1$02d:%2$02d.%3$03d", mm, ss, ms));
        }
    }

}
