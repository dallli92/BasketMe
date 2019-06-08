package com.dalilandoulsi.basketme

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun leagueNextClicked(view: View) {
        if (!selectedLeague.contentEquals("")) {
            val intent = Intent(this, SkillActivity::class.java)
            intent.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(intent)
        } else {

            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }


    }

    fun onMenClick(view: View) {
        womenBtn.isChecked = false
        coedBtn.isChecked = false
        selectedLeague = "men"
    }

    fun womenClicked(view: View) {
        coedBtn.isChecked = false
        menBtn.isChecked = false
        selectedLeague = "women"

    }

    fun ciedClicked(view: View) {
        womenBtn.isChecked = false
        menBtn.isChecked = false
        selectedLeague = "coed"


    }
}
