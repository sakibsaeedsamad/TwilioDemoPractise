package com.example.twiliodemopractise

import android.Manifest
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.PackageManager
import android.media.AudioManager

import androidx.core.content.ContextCompat
import androidx.core.app.ActivityCompat

import android.widget.Toast
import com.twilio.video.*


class MainActivity : AppCompatActivity(), Room.Listener {


    var CAMERA_MIC_PERMISSION_REQUEST_CODE = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectRoom("sssakib75")

    }

    private fun connectRoom(roomName: String){
        val configuration = NetworkQualityConfiguration(
            NetworkQualityVerbosity.NETWORK_QUALITY_VERBOSITY_MINIMAL,
            NetworkQualityVerbosity.NETWORK_QUALITY_VERBOSITY_MINIMAL
        )

        val connectOptions: ConnectOptions = ConnectOptions.Builder("261452")
            .roomName(roomName)
            .enableNetworkQuality(true)
            .networkQualityConfiguration(configuration)
            .build()


    }

    private fun checkPermissionForCameraAndMicrophone(): Boolean {
        val resultCamera = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        )
        val resultMic = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.RECORD_AUDIO
        )
        return resultCamera ==
                PackageManager.PERMISSION_GRANTED &&
                resultMic ==
                PackageManager.PERMISSION_GRANTED

    }

    private fun requestPermissionForCameraAndMicrophone() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CAMERA
            ) ||
            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.RECORD_AUDIO
            )
        ) {
            Toast.makeText(
                this,
                "Permission Needed",
                Toast.LENGTH_LONG
            ).show()
        } else {
            ActivityCompat.requestPermissions(
                this, arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.RECORD_AUDIO
                ),
                CAMERA_MIC_PERMISSION_REQUEST_CODE
            )
        }
    }

    override fun onConnected(room: Room) {
        TODO("Not yet implemented")
    }

    override fun onConnectFailure(room: Room, twilioException: TwilioException) {
        TODO("Not yet implemented")
    }

    override fun onReconnecting(room: Room, twilioException: TwilioException) {
        TODO("Not yet implemented")
    }

    override fun onReconnected(room: Room) {
        TODO("Not yet implemented")
    }

    override fun onDisconnected(room: Room, twilioException: TwilioException?) {
        TODO("Not yet implemented")
    }

    override fun onParticipantConnected(room: Room, remoteParticipant: RemoteParticipant) {
        TODO("Not yet implemented")
    }

    override fun onParticipantDisconnected(room: Room, remoteParticipant: RemoteParticipant) {
        TODO("Not yet implemented")
    }

    override fun onRecordingStarted(room: Room) {
        TODO("Not yet implemented")
    }

    override fun onRecordingStopped(room: Room) {
        TODO("Not yet implemented")
    }


}




