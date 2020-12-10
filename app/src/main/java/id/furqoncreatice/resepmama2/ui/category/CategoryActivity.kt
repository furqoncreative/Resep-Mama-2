package id.furqoncreatice.resepmama2.ui.category

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.furqoncreatice.resepmama2.R
import id.furqoncreatice.resepmama2.data.model.Category
import id.furqoncreatice.resepmama2.databinding.ActivityCategoryBinding
import id.furqoncreatice.resepmama2.ui.recipe.RecipeListActivity

class CategoryActivity : AppCompatActivity(),CategoryAdapter.onItemClickListener {
    lateinit var binding: ActivityCategoryBinding
    lateinit var adapter: CategoryAdapter
    lateinit var items: ArrayList<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycleview()
        setData()
    }

    fun setRecycleview() {
        adapter = CategoryAdapter(this)
        binding.rvCategory.adapter = adapter
        binding.rvCategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    fun setData() {
        items = ArrayList()
        items.add(
            Category(
                1,
                "Hidangan Utama",
                "https://www.dapurumami.com/uploads/recipe/5XjRp/oseng-tempe-kacang-panjang.jpg",
            )
        )

        items.add(
            Category(
                2,
                "Camilan",
                "https://www.dapurumami.com/uploads/recipe/Ijg35/RPP-Cover_940x576px.jpg",
            )
        )
        items.add(
            Category(
                3,
                "Pasta",
                "https://www.dapurumami.com/uploads/recipe/W6830/April-2019-WEBSITE2.jpg",
            )
        )
        adapter.setItems(items)
    }

    override fun onClick(item: Category) {
        val intent = Intent(this, RecipeListActivity::class.java)
        intent.putExtra("ITEM", item)
        startActivity(intent)
    }
}