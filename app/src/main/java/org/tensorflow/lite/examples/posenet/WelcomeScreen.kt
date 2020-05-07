package org.tensorflow.lite.examples.posenet

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.appcompat.app.AppCompatActivity
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


