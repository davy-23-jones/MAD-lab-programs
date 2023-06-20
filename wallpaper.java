package com.example.exp4;

import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    Button btnChangeWallpaper;
    boolean running;
    int[] ia = new int[]{
            R.drawable.zz,
            R.drawable.zzz,
            R.drawable.zzzz,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChangeWallpaper = (Button) findViewById(R.id.btn_wallpaper);
        btnChangeWallpaper.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!running) {
            new Timer().schedule(new MyTimer(), 0, 3000);
            running = true;
        }
    }

    class MyTimer extends TimerTask {
        public void run() {
            try {
                WallpaperManager wallpaperManager =
                        WallpaperManager.getInstance(getBaseContext());
                Random random = new Random();
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(), ia[
                        random.nextInt(5)]));
            } catch (Exception e) {
            }
        }
    }
}



