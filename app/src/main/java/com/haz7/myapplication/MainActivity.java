package com.haz7.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String BUNDLE_INDEX = "BUNDLE_INDEX";
    private Random mrandom;
    ImageView whereImage;
    TextView myPlaceName;
    Button   next;
    Button   Previous;

    int[] mpalcesPhoto = {
            R.drawable.gym,
            R.drawable.coffe_shop,
            R.drawable.garden,
            R.drawable.mall,
            R.drawable.resturant,
            R.drawable.disny
    };
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whereImage = findViewById(R.id.ImgWhere);
        myPlaceName = findViewById(R.id.placeName);
        next   = findViewById(R.id.buttonNext);
        Previous = findViewById(R.id.buttonPrevious);
        mrandom = new Random();


    }

    public void showPlace(View view) {


            Log.d(TAG,"daiplay = "+ index);
              index = mrandom.nextInt(6);


              showResult();


    }

    public void showNext(View view){
        if (index <5){
            index ++;
            showResult();
        } else{
            Toast.makeText(this, "Press previous", Toast.LENGTH_SHORT).show();
        }

    }
    public void showPrevious(View view){
        if (index >0){
            index --;
            showResult();
        } else{
            Toast.makeText(this, "Press next", Toast.LENGTH_SHORT).show();
        }

    }


    private void showResult(){
        Drawable placeToGo = ContextCompat.getDrawable(this, mpalcesPhoto[index]);
        whereImage.setImageDrawable(placeToGo);
        if (index == 0){
            myPlaceName.setText("Gym");
        }else if (index ==1){
            myPlaceName.setText("Coffe Shop");
        }else if (index ==2){
            myPlaceName.setText("Garden");
        }else if (index ==3){
            myPlaceName.setText("Mall");
        }else if (index ==4){
            myPlaceName.setText("restaurant");
        }else if (index ==5){
            myPlaceName.setText("Disny Land");
        }else { myPlaceName.setText("The Place Name");}

        }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"onSaveInstanceState");
        outState.putInt(BUNDLE_INDEX,index);
    }

    @Override
    protected void onRestoreInstanceState( Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            Log.d(TAG,"display = "+index);
            index = savedInstanceState.getInt(BUNDLE_INDEX);
            if (index != -1){
               showResult();
                Log.i(TAG,"onRestoreInstanceState");
            }
        }
    }
}
