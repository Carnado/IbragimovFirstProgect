package uz.sherzodibragimov.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed
import uz.sherzodibragimov.R
import uz.sherzodibragimov.core.GameController
import uz.sherzodibragimov.core.LocalStorage

class MainActivity : AppCompatActivity() {
    private var gameController: GameController?=null

    private var levelView:TextView?=null
    private var totalView:TextView?=null
    private var skipButton:Button?=null
    private var nextButton:Button?=null
    private var finishButton:Button?=null
    private var qustionText:TextView?=null
    private var variantGroup:RadioGroup?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadViews()
        startWork()
        setActionsToView()
        setDataToView()



    }

    /**
     * Bu method viewlar bosilganda kuzatish uchun kere
     */
    private fun setActionsToView() {
         variantGroup?.forEach {
             it.setOnClickListener {
                 variantCliced(it as RadioButton)
             }
         }
        nextButton?.setOnClickListener {
            if (nextButton?.text.toString()=="FINISH"){
                gameController.let {
                    if (it?.isFinished() == true){
                    val intent=Intent(this@MainActivity,FinishActivity::class.java)
                    val bundle=Bundle()
                    bundle.putInt(FinishActivity.TRUES,it.getTotalTruCount())
                    bundle.putInt(FinishActivity.WRONGS,it.getTotalWrongCount())
                    bundle.putInt(FinishActivity.SKIPS,it.getTotalSkipped())
                    intent.putExtras(bundle)
                    startActivity(intent)
//                    finish()
                } }

            }
            setDataToView()
        }
    }

    /**
     * Bu method Butonnlarni bosilishi uchun xizmat qiladi
     */
    private fun variantCliced(radioButton: RadioButton) {
        val variantText=radioButton.text.toString()
        gameController.let {
            it?.checkAnswer(variantText)
//            if (it?.isFinished() == true){
//                val intent=Intent(this@MainActivity,FinishActivity::class.java)
//                val bundle=Bundle()
//                bundle.putInt(FinishActivity.TRUES,it.getTotalTruCount())
//                bundle.putInt(FinishActivity.WRONGS,it.getTotalWrongCount())
//                bundle.putInt(FinishActivity.SKIPS,it.getTotalSkipped())
//                intent.putExtras(bundle)
//                startActivity(intent)
//                finish()
//            }else{
            nextButton?.isEnabled=true

//            }
        }
    }

    /**Bu methodDizaynda chizilgan viewlarni Activityda chaqrish uchun kerkak
     *
     */
    private fun loadViews() {
        levelView=findViewById(R.id.level_view)
        finishButton=findViewById(R.id.finish_button)
        totalView=findViewById(R.id.total_view)
        skipButton=findViewById(R.id.skip_button)
        qustionText=findViewById(R.id.question_view)
        variantGroup=findViewById(R.id.answerGroup_view)
        nextButton=findViewById(R.id.next_button)
    }

    /**
     * Bu metod controller obyektini yaratish uchun kerak va bundan tashqari malulomotni toldirib undan foydalanish uchun kerak
     */
    private fun startWork(){
        LocalStorage.fillData()
        gameController= GameController(LocalStorage.getData())
    }
    /**
     * bu method dizayn elementlariga ma'lumot berish uchun ishlatiladi
     */
    private fun setDataToView(){
        nextButton?.isEnabled=false
        gameController?.let {c->


            levelView?.text="Level :${c.getCurrentLeve()}"
            totalView?.text="Total :${c.getTotalLevel()}"

            qustionText?.text=c.getQuestion()
            val variants=c.getVariants()
            if(c.getTotalLevel()==c.getCurrentLeve()){
                nextButton?.setText("FINISH")
            }
            variantGroup?.forEachIndexed { i, v->
                if (i < c.totalVariants()) {
                    (v as RadioButton).text = variants[i]
                    (v as RadioButton).visibility=View.VISIBLE
                }else{
                    (v as RadioButton).visibility=View.INVISIBLE
                }
            }

        }

    }
    fun openLastActivity(view: View){

    }
}