package com.dalilandoulsi.basketme.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dalilandoulsi.basketme.Model.Player
import com.dalilandoulsi.basketme.R
import com.dalilandoulsi.basketme.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchLeagueTxt.setText("Looking for ${player.league} ${player.skill} league near to you...")

    }
}
