package com.example.tiago.gamestudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void paginaRegistar(View v){
        Intent intent = new Intent(this, RegistarAlunoActivity.class);
        startActivity(intent);
    }



}
