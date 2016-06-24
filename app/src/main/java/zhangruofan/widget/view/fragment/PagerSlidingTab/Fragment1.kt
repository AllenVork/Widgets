package zhangruofan.widget.view.fragment.PagerSlidingTab

import android.annotation.TargetApi
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_pager_sliding_1.*
import zhangruofan.widget.R

/**
 * Created by zhangruofan on 16-6-24.
 */
class Fragment1 : Fragment() {

    companion object {
        var mInstance: Fragment1 ? = null

        @TargetApi(21)
        fun newInstance(text: String): Fragment1 {
//            if (mInstance == null) {
            mInstance = Fragment1()

            val bundle = Bundle()
            bundle.putString("msg", text)
            mInstance!!.arguments = bundle
//            }
            return mInstance!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_pager_sliding_1, container, false)
        return view
    }

    @TargetApi(21)
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv.text = arguments.getString("msg")
    }
}