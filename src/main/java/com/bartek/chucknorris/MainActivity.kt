package com.bartek.chucknorris

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.category_item.view.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryAdapter

    @Inject
    lateinit var apiService: ApiService

    private val disposables = CompositeDisposable()

    companion object {

        const val EXTRA_STRING = "category"

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerApp
            .instance
            .injector
            .inject( this )


        adapter = CategoryAdapter(emptyList()) { clickedCategory ->

            val intent = Intent(this, DetailActivity::class.java)

            intent.putExtra("category", clickedCategory.title)
            intent.putExtra(EXTRA_STRING, clickedCategory.title)
            startActivity(intent)

        }

        val layoutManager = GridLayoutManager(this, 2)

        val decorator = DividerItemDecoration(this, layoutManager.orientation)

        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter
        recycler_view.addItemDecoration(decorator)

    }

    override fun onResume() {
        super.onResume()

        val disposable = apiService
            .getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { strings ->
                    val items = strings.map { Category(it) }
                    adapter.updateItems(items)
                },
                {
                    print(it)
                }
            )

        disposables.add(disposable)
    }

    class CategoryAdapter(
        private var items: List<Category>,
        private val onClick: (item: Category) -> Unit
    ) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

        fun updateItems(newItems: List<Category>) {
            items = newItems
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int {
            return items.count()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]

            holder.view.setOnClickListener { onClick(item) }
            holder.title.text = item.title
        }

        class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

            val title: TextView = view.category_item_title

        }

    }

}
