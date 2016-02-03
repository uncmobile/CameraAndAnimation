package edu.unc.nirjon.classcam;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Function to open camera and display the image taken in the ImageView
     * @param v
     */
    public void camera(View v)
    {
        Log.v("NIRJON", "Button got clicked");
        Intent x = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(x, 1);
    }

    /**
     * Function to play the animation
     * @param V
     */
    public void anim(View V){
        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setBackgroundResource(R.drawable.mylist);
        img.setImageBitmap(null);
        ((AnimationDrawable)img.getBackground()).start();
    }

    @Override
    protected void onActivityResult(int rc, int resc, Intent data)
    {
        ImageView iv = null;
        Bitmap bm = (Bitmap) data.getExtras().get("data");
        iv = ((ImageView)findViewById(R.id.imageView));
        iv.setBackgroundResource(0);
        iv.setImageBitmap(bm);
    }

}
