package org.tensorflow.lite.examples.posenet;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;

import org.tensorflow.lite.examples.posenet.lib.Person;

import java.util.Random;

public class Sounds extends Service {

    public static final int[] transitionSounds = {R.raw.bass_l, R.raw.bass_r};
    //  note: first sound in
    static MediaPlayer player, mediaPlayer;

    private static final String TAG = "SOUNDS_TAG";

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
    public static int playSound(Context context, int[] sounds,Person person) {
        int n = new Random().nextInt(sounds.length);
        int soundID = sounds[n];
        return playSound(context, soundID, n, person);
    }

    private static int playSound(Context context, int soundID, int n, Person person) {
        // Only play if the user has sounds enabled.
        try {

            mediaPlayer = MediaPlayer.create(context, soundID);
            mediaPlayer.start();

            if (n == 0) {

                SystemClock.sleep(1000);
                Log.d("state obtained: ", String.valueOf(person.getState()));

                         if(person.getState()==ConstantsKt.LEFT_HAND_RAISED){
                            Log.d("correct hand raised: ", "Left");
                            return 1;
                }
                             else {
                             Log.d("wrong hand raised: ", "Right");
                            return 0;
                }
            }

            else if (n == 1) {

                SystemClock.sleep(1000);
                Log.d("state obtained : ", String.valueOf(person.getState()));

                if(person.getState()==ConstantsKt.RIGHT_HAND_RAISED){
                    Log.d("correct hand raised: ", "Right");
                    return 1;
                } else {
                    Log.d("wrong hand raised: ", "Left");
                    return 0;
                }

            }
            mediaPlayer.stop();
            mediaPlayer.release();
        } catch (Exception e) {
            Log.e(TAG, "ERROR! " + e.toString());
        }
        Log.i(TAG, String.valueOf(n) + " Sound Played");

        return 0;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
