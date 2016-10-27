package com.example.marthakat.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //The "Welcome page". It includes the play button in order to start a game.
        Button play = (Button)findViewById(R.id.play);
        play.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //method called -> OnClickListener
        //when button clicked, the game activity starts
        if(view.getId()==R.id.play){
            Intent playIntent = new Intent(this, GameActivity.class);
            startActivity(playIntent);
        }
    }
}
