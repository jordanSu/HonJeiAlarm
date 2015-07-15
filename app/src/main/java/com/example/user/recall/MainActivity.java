package com.example.user.recall;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener, CompoundButton.OnCheckedChangeListener {

    TextView title, subTitle, word;
    Switch clockSwitch;

    Animation animFadein;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (TextView)findViewById(R.id.title);
        subTitle = (TextView)findViewById(R.id.subtitle);
        word = (TextView)findViewById(R.id.word);
        clockSwitch = (Switch)findViewById(R.id.switch1);
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        animFadein.setFillAfter(true);
        animFadein.setAnimationListener(this);

        title.setVisibility(View.VISIBLE);
        title.startAnimation(animFadein);

        clockSwitch.setOnCheckedChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        title.clearAnimation();
        if (count == 0) {
            count++;
            subTitle.setVisibility(View.VISIBLE);
            subTitle.startAnimation(animFadein);
        }
        else if (count == 1) {
            count++;
            word.setVisibility(View.VISIBLE);
            word.startAnimation(animFadein);
            subTitle.clearAnimation();
            //ok
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    //if switch is turn on
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (clockSwitch.isChecked()) {
            clockSwitch.setEnabled(false);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("夯姐的鬧鐘即將開啟")
                    .setIcon(R.mipmap.alarmclock_icon)
                    .setMessage("請確認是否開啟？")
                    .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "即將進入夯姐的鬧鐘!", Toast.LENGTH_LONG)
                            .show();
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "你以為你逃得掉嗎？\n即將進入夯姐的鬧鐘!", Toast.LENGTH_LONG)
                            .show();
                        }
                    })
                    .show();
        }
    }
}
