package com.everestadvanced.digitalstructure;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button btnSign = null;
    public  ImageView imgSingImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgSingImage= (ImageView) findViewById(R.id.myddImage);

        btnSign =(Button) findViewById(R.id.signature);
        btnSign.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i1 = new Intent(MainActivity.this, NotePad.class);
                startActivity(i1);
            }
        });

        try
        {
            Bundle extras = getIntent().getExtras();
            byte[] byteArray = extras.getByteArray("picture");
            Bitmap mSignBitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

            Bitmap rotated = Bitmap.createBitmap(mSignBitmap, 0, 0, mSignBitmap.getWidth(), mSignBitmap.getHeight());
            imgSingImage.setImageBitmap(rotated);
        }
        catch (Exception e)
        {

        }
    }
}