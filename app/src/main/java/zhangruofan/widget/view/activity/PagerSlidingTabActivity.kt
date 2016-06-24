package zhangruofan.widget.view.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pager_sliding_tab.*
import zhangruofan.widget.R
import zhangruofan.widget.constants.HomePagerEnum
import zhangruofan.widget.view.fragment.PagerSlidingTab.Fragment1
import zhangruofan.widget.view.fragment.PagerSlidingTab.Fragment2

class PagerSlidingTabActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        layout = R.layout.activity_pager_sliding_tab
        super.onCreate(savedInstanceState)

        initView()
    }

    fun initView() {
        viewpager.adapter = SlidingAdapter(supportFragmentManager)// HomePagerAdapter()
        tabs.setViewPager(viewpager)
    }

    inner class SlidingAdapter(val fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            var fragment: Fragment
            when (position) {
                0 -> fragment = Fragment1.newInstance("Fragment1 newInstance1")
                1 -> fragment = Fragment1.newInstance("Fragment1 newInstance2")
                else -> fragment = Fragment2.newInstance("Fragment2 newInstance$position")
            }
            //the fragment will be reused automatically when you scroll to the same position
            return fragment
        }

        override fun getCount(): Int {
            return HomePagerEnum.values().size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return HomePagerEnum.values().get(position).name
        }
    }
}
