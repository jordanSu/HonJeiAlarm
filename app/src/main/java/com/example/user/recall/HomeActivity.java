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

        //setOnLongClickListener
        listen1Button.setOnLongClickListener(getInfo);
        listen2Button.setOnLongClickListener(getInfo);
        timesetButton.setOnLongClickListener(getInfo);
        frequencyButton.setOnLongClickListener(getInfo);

       //setOnClickListener
        listen1Button.setOnClickListener(buttonClick);
        listen2Button.setOnClickListener(buttonClick);
        timesetButton.setOnClickListener(buttonClick);
        frequencyButton.setOnClickListener(buttonClick);
    }

    Button.OnLongClickListener getInfo = new Button.OnLongClickListener() {
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

    Button.OnClickListener buttonClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.listen1Button:
                    //TODO: play chatroom.ogg
                    break;
                case R.id.listen2Button:
                    //TODO: play messenger.ogg
                    break;
                case R.id.timesetButton:
                    //TODO: let user set their Alarm Clock time
                    break;
                case R.id.frequencyButton:
                    //TODO: let user set their frequency
                    break;
                case R.id.aboutButton:
                    //TODO: AlertDialog to show the info of this app and inventor
                    break;
                case R.id.exitButton:
                    //TODO: AlertDialog to double check exit
                    break;
            }
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
