package gr8.mrityunjay.simpleasynctask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mTextView: TextView
    private val TEXT_STATE = "currentText"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTextView = textview1

        if (savedInstanceState!=null){
            mTextView.text = savedInstanceState.getString(TEXT_STATE)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.w("save","savedState")
        outState?.putString(TEXT_STATE, mTextView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.w("restore", "restoreState")
        mTextView.text = savedInstanceState?.getString(TEXT_STATE)
    }

    fun startTask(v: View){
        Log.w("startTask", "startTask")
        mTextView.text = getString(R.string.task_progress_report)
        SimpleAsyncTask(mTextView).execute()
    }
}
