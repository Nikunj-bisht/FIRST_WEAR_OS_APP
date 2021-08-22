package com.animesafar.myapplication;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.animesafar.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends Activity implements View.OnClickListener , callback {

    private TextView mTextView;
    private ActivityMainBinding binding;
private Button button;
NotificationCompat.BigTextStyle bigTextStyle;
NotificationManagerCompat notificationManagerCompat;
TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
    @Override
    public void onInit(int i) {

        textToSpeech.setLanguage(Locale.ENGLISH);



    }
});
        mTextView = binding.text;
 notificationManagerCompat = NotificationManagerCompat.from(this);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        bigTextStyle = new NotificationCompat.BigTextStyle()
                           .setBigContentTitle("Hello")
                .setSummaryText("Nikunj");

    }


    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.button){

           // showotification();
Requestclass.sendrequest(this,this);

        }

    }




    private void showotification(){


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        {
            NotificationChannel notificationChannel = new NotificationChannel(
                    "channelid","My",NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("This is a notification");
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder noti = new NotificationCompat.Builder(this,"channelid");

        Notification notification = noti.setStyle(bigTextStyle)
              .setContentTitle("Hello")
              .setContentText("Nikunj")
              .setSmallIcon(R.drawable.ic_cc_clear)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_cc_checkmark))
        .setDefaults(NotificationCompat.DEFAULT_ALL)
             .setColor(ContextCompat.getColor(getApplicationContext(),R.color.black_86p))
              .setCategory(Notification.CATEGORY_REMINDER)
              .setPriority(NotificationCompat.PRIORITY_HIGH)

                .build();
        notificationManager.notify(2000,noti.build());
    }

    @Override
    public void speak(ArrayList<Data> arr) {

//        PackageManager packageManager = getPackageManager();
//        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//        if(packageManager.hasSystemFeature(PackageManager.FEATURE_AUDIO_OUTPUT)){
//
//            AudioDeviceInfo[] deviceInfos = audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS);
//            for(AudioDeviceInfo a : deviceInfos){
//
//                if(a.getType() == AudioDeviceInfo.TYPE_BUILTIN_SPEAKER){
//
//                    Toast.makeText(this,"exists",Toast.LENGTH_LONG).show();
//
//                }
//
//            }
//
//        }

     //   Toast.makeText(this,"not exists",Toast.LENGTH_LONG).show();

//        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.good);
//        mediaPlayer.start();
//if(mediaPlayer.isPlaying()){
//
//    Toast.makeText(this,"playing",Toast.LENGTH_LONG).show();
//
//}

        Intent intent = new Intent(this , Showjobs.class);
        intent.putExtra("<?>",arr);
        startActivity(intent);

    }



}