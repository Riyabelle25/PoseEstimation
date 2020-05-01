package org.tensorflow.lite.examples.posenet;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

import org.tensorflow.lite.examples.posenet.lib.Posenet;
import org.tensorflow.lite.examples.posenet.lib.Person;

public class Sounds extends Service {

    public static final int[] transitionSounds = {R.raw.bass_l, R.raw.bass_r};
  //  private static int LHS,RHS;
    static MediaPlayer player,mediaPlayer;



  public int onStartCommand(Intent intent, int flags, int startId) {
      return Service.START_NOT_STICKY;
    }

    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
        stopSelf();
        super.onDestroy();
    }

    // If an array is passed, pick one at random to play.
    public static int playSound(Context context, int[] sounds, int RHS , int LHS) {
        int n=new Random().nextInt(sounds.length);
        int soundID = sounds[n];
       return playSound(context, soundID, n , RHS, LHS);
    }
    private static int playSound(Context context, int soundID, int n, int RHS, int LHS) {
        // Only play if the user has sounds enabled.
        try {
                mediaPlayer = MediaPlayer.create(context, soundID);
                mediaPlayer.start();
                if(n==0){
                   SystemClock.sleep(1000);
                   // LHS=person.getLeft_angle();
                    Log.d("zu: ", String.valueOf(LHS));
                    if(LHS<100){
                        Log.d("zu: ", "L1");
                        return 1 ;
                    }
                    else{
                        Log.d("zu: ", "L0");
                        return 0;
                    }
                }
                else if(n==1){
                    SystemClock.sleep(1000);
                  //  RHS=person.getRight_angle();
                    Log.d("zu: ", String.valueOf(RHS));
                    if(RHS<100){
                        Log.d("zu: ", "R1");
                        return 1 ;
                    }
                    else{  Log.d("zu: ", "R2");
                        return 0;
                    }

                }

            }
        catch (Exception e) {
                Log.d("zu: ", e.toString());
            }
        Log.i("", String.valueOf(n));

        return 0;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
