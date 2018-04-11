package gr8.mrityunjay.simpleasynctask

import android.os.AsyncTask
import android.widget.TextView
import java.util.*

internal class SimpleAsyncTask constructor(tv: TextView) : AsyncTask<Void, Void, String>() {
    val mTextView: TextView = tv

    override fun doInBackground(vararg params: Void?): String {
        val r = Random()
        val n = r.nextInt(11)
        val s: Long = (n * 200).toLong()

        try {
            Thread.sleep(s)
        }catch (e:InterruptedException){ e.printStackTrace() }
        return "Awake at last after sleeping for ${s.toInt()} seconds"
    }

    override fun onPostExecute(result: String) {
        mTextView.text = result
    }

}