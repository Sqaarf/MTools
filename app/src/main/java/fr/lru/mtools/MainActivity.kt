package fr.lru.mtools

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    private lateinit var volume_seekbar: SeekBar
    private lateinit var minus_button: Button
    private lateinit var mute_button: Button
    private lateinit var plus_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val am = getSystemService(AUDIO_SERVICE) as AudioManager

        volume_seekbar = findViewById(R.id.volume_sb)
        minus_button = findViewById(R.id.minus_bt)
        mute_button = findViewById(R.id.mute_bt)
        plus_button = findViewById(R.id.plus_bt)

        volume_seekbar.max = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        volume_seekbar.progress = am.getStreamVolume(AudioManager.STREAM_MUSIC)

        volume_seekbar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        minus_button.setOnClickListener {
           am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamVolume(AudioManager.STREAM_MUSIC)-1,0)
        }

        mute_button.setOnClickListener {
            am.setStreamVolume(AudioManager.STREAM_MUSIC, 0,0)
        }

        plus_button.setOnClickListener {
            am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamVolume(AudioManager.STREAM_MUSIC)+1,0)
        }

    }
}

