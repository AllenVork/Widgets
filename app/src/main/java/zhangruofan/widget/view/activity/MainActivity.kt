package zhangruofan.widget.view.activity

import android.graphics.Rect
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import zhangruofan.realm.adapter.MainAdapter

import zhangruofan.widget.R

class MainActivity : BaseActivity() {

    private lateinit var mAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        layout = R.layout.activity_main
        super.onCreate(savedInstanceState)

        initView()
    }

    private fun initView() {
        setSupportActionBar(toolbar)

        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(SpaceItemDecoration(10))

        mAdapter = MainAdapter(this)
        recyclerView.adapter = mAdapter

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }
    }

    class SpaceItemDecoration(val space: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
            outRect?.top = space
            outRect?.left = space
            outRect?.right = space
        }
    }
}
