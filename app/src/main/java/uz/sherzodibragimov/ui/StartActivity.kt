package uz.sherzodibragimov.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import uz.sherzodibragimov.R

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }

    fun startTest(view: View) {
        val intent=Intent(this@StartActivity,MainActivity::class.java)
        startActivity(intent)
    }
    fun openLastResult(view: View) {
     val intent=Intent(this@StartActivity,FinishActivity::class.java)
        startActivity(intent)
    }
    fun openSettings(view: View) {

    }
}