package org.tensorflow.lite.examples.posenet

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.FrameLayout

class WelcomeScreen: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_screen)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, CameraActivity())
            .commit()



    }
}


