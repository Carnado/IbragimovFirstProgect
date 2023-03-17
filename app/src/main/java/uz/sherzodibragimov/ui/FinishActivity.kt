package uz.sherzodibragimov.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import uz.sherzodibragimov.R
import uz.sherzodibragimov.core.LocalStorage

class FinishActivity : AppCompatActivity() {
    companion object{
        val TRUES="answer_trues"
        val WRONGS="answer_wrongs"
        val SKIPS="answer_skips"

    }
    private var totalTrue=0
    private var totalWrong=0
    private var totalSkip=0

    private lateinit var trueView:TextView
    private lateinit var wrongView:TextView
    private lateinit var skipView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        trueView=findViewById(R.id.trues_finish)
        wrongView=findViewById(R.id.total_wrongs)
        skipView=findViewById(R.id.total_skipped)

        val receivedIntent=intent
        val bundle=receivedIntent.extras

        bundle?.let {
            totalTrue=it.getInt(FinishActivity.TRUES,0)
            totalWrong=it.getInt(FinishActivity.WRONGS,0)
            totalSkip=it.getInt(FinishActivity.SKIPS,0)
            Log.d("TOTALS","TOGRI:${TRUES}")
            Log.d("TOTALS","XATO:${WRONGS}")
            Log.d("TOTALS","SKIP:${SKIPS}")
        }
        if (totalTrue!=0 || totalWrong!=0 || totalSkip!=0){
            trueView.setText("Total TRUES: ${totalTrue}")
            wrongView.setText("Total WRONG: ${totalWrong}")
            skipView.setText("Total SKIPED: ${totalSkip}")
            LocalStorage.trueCountSave=totalTrue
            LocalStorage.wrongCountSave=totalWrong
            LocalStorage.skippedCountSave=totalSkip
        }else{
            trueView.setText("Total TRUES: ${LocalStorage.trueCountSave}")
            wrongView.setText("Total WRONG: ${LocalStorage.wrongCountSave}")
            skipView.setText("Total SKIPED: ${LocalStorage.skippedCountSave}")
        }

    }

}