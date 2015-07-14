package com.example.user.recall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    TextView title, subTitle, word;
    Animation animFadein;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (TextView)findViewById(R.id.title);
        subTitle = (TextView)findViewById(R.id.subtitle);
        word = (TextView)findViewById(R.id.word);

        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        animFadein.setFillAfter(true
        );
        animFadein.setAnimationListener(this);

        title.setVisibility(View.VISIBLE);
        title.startAnimation(animFadein);


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
}
