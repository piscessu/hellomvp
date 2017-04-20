package com.youche.ycsaas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.youche.ycsaas.module.movie.MovieListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        startActivity(new Intent(this, MovieListActivity.class));
    }
}
