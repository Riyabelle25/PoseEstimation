package org.tensorflow.lite.examples.posenet;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import java.util.Random;

import org.tensorflow.lite.examples.posenet.lib.Posenet;
import org.tensorflow.lite.examples.posenet.lib.Person;

public class Sounds {

    public static final int[] transitionSounds = {R.raw.left, R.raw.right};

    private static Person person;
    private static int RHS,LHS;

    // If an array is passed, pick one at random to play.
    public static int playSound(Context context, int[] sounds) {
        int n=new Random().nextInt(sounds.length);
        int soundID = sounds[n];
       return playSound(context, soundID,n);
    }

    private static int playSound(Context context, int soundID, int n) {
        // Only play if the user has sounds enabled.
        try {
                MediaPlayer mediaPlayer = MediaPlayer.create(context, soundID);
                mediaPlayer.start();
                if(n==0){
                    LHS=person.getLeft_angle();
                    if(LHS>80){
                        return 1 ;
                    }
                    else{
                        return 0;
                    }

                }
                else if(n==1){
                    RHS=person.getRight_angle();
                    if(RHS>80){
                        return 1 ;
                    }
                    else{
                        return 0;
                    }

                }

            }
        catch (Exception e) {
                Log.d("zu: ", e.toString());
            }
        return 0;
    }
}
