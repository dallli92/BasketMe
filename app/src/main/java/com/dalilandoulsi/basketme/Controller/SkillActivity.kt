package com.dalilandoulsi.basketme.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.dalilandoulsi.basketme.Model.Player
import com.dalilandoulsi.basketme.R
import com.dalilandoulsi.basketme.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {


    lateinit var player: Player
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun beginnerClicked(view: View) {
        ballerBtn.isChecked = false
        player.skill = "Beginner"
    }

    fun ballerClicked(view: View) {
        beginnerBtn.isChecked = false
        player.skill = "Baller"
    }

    fun finishClicked(view: View) {
        if (!player.skill.contentEquals("")) {
            val intentToFinish = Intent(this, FinishActivity::class.java)
            intentToFinish.putExtra(EXTRA_PLAYER, player)
            startActivity(intentToFinish)
        } else {
            Toast.makeText(this, "Please select a level", Toast.LENGTH_SHORT).show()
        }
    }


}
