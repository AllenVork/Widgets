package zhangruofan.widget.view.activity

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheets_main.*

import zhangruofan.widget.R

class BottomSheetActivity : BaseActivity() {

    private lateinit var mBottomSheetBehavior: BottomSheetBehavior<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        layout = R.layout.activity_bottom_sheet
        super.onCreate(savedInstanceState)
        initView()
        initBottomSheet()
    }

    fun initView() {
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            if (mBottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                mBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                mBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
    }

    fun initBottomSheet() {
        mBottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)
//        bottomSheetBehavior.peekHeight = 150
        mBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }
}
