package com.example.user.recall;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends AppCompatActivity {
    Button listen1Button;
    Button listen2Button;
    Button timesetButton;
    Button frequencyButton;
    Button aboutButton;
    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listen1Button = (Button)findViewById(R.id.listen1Button);
        listen2Button = (Button)findViewById(R.id.listen2Button);
        timesetButton = (Button)findViewById(R.id.timesetButton);
        frequencyButton = (Button)findViewById(R.id.frequencyButton);
        aboutButton = (Button)findViewById(R.id.aboutButton);
        exitButton = (Button)findViewById(R.id.exitButton);

        //setonLongClickListener
        listen1Button.setOnLongClickListener(getinfo);
        listen2Button.setOnLongClickListener(getinfo);
        timesetButton.setOnLongClickListener(getinfo);
        frequencyButton.setOnLongClickListener(getinfo);
    }

    Button.OnLongClickListener getinfo = new Button.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                    builder.setTitle("說明");
                    builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            switch(v.getId()) {
                case R.id.listen1Button:
                    builder.setMessage("讓您試聽鈴聲一\n此亦為FaceBook聊天室中用之提示聲");
                    break;
                case R.id.listen2Button:
                    builder.setMessage("讓您試聽鈴聲二\n此亦為Messenger聊天室中用之提示聲");
                    break;
                case R.id.timesetButton:
                    builder.setMessage("讓您能選擇鈴聲並設定你的鬧鐘");
                    break;
                case R.id.frequencyButton:
                    builder.setMessage("讓夯姐上身,提示聲不斷,還可以調整夯的程度!!!");
                    break;
            }
            AlertDialog instruction = builder.create();
            instruction.show();
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
}
