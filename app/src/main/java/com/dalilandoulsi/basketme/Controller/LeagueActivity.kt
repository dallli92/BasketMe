package com.dalilandoulsi.basketme.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dalilandoulsi.basketme.Model.Player
import com.dalilandoulsi.basketme.R
import com.dalilandoulsi.basketme.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun leagueNextClicked(view: View) {
        if (!player.league.contentEquals("")) {
            val intenttoLeagueActivity = Intent(this, SkillActivity::class.java)
            intenttoLeagueActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(intenttoLeagueActivity)
        } else {

            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }


    }

    fun onMenClick(view: View) {
        womenBtn.isChecked = false
        coedBtn.isChecked = false
        player.league = "men"
    }

    fun womenClicked(view: View) {
        coedBtn.isChecked = false
        menBtn.isChecked = false
        player.league = "women"

    }

    fun ciedClicked(view: View) {
        womenBtn.isChecked = false
        menBtn.isChecked = false
        player.league = "coed"


    }
}
