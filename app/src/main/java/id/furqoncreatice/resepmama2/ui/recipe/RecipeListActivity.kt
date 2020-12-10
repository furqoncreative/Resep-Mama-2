package id.furqoncreatice.resepmama2.ui.recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import id.furqoncreatice.resepmama2.R
import id.furqoncreatice.resepmama2.data.model.Category
import id.furqoncreatice.resepmama2.data.model.Recipe
import id.furqoncreatice.resepmama2.databinding.ActivityRecipeListBinding
import java.util.*

class RecipeListActivity : AppCompatActivity(), RecipesAdapter.onItemClickListener {
    lateinit var binding: ActivityRecipeListBinding
    lateinit var adapter: RecipesAdapter
    lateinit var items: ArrayList<Recipe>
    var category = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    fun initView(){
        val item = intent.getParcelableExtra<Category>("ITEM")
        category = item.id
        supportActionBar?.apply {
            title = item.name
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
        setRecycleview()
        setData()
        filter(category,"")
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        val searchItem: MenuItem? = menu?.findItem(R.id.action_search)
        val searchView: SearchView = searchItem?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filter(category,query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filter(category,newText)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun filter(category: Int, text: String) {
        val newList = ArrayList<Recipe>()
        for (item in items) {
            if (item.category == category && item.title.toLowerCase().contains(text)) {
                newList.add(item)
            }
        }
        adapter.setFilter(newList)
    }

    fun setRecycleview() {
        adapter = RecipesAdapter(this)
        binding.rvRecipe.adapter = adapter
        binding.rvRecipe.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    fun setData() {
        items = ArrayList()
        items.add(
            Recipe(
                "Oseng Tempe Kacang Panjang",
                "https://www.dapurumami.com/uploads/recipe/5XjRp/oseng-tempe-kacang-panjang.jpg",
                resources.getString(
                    R.string.recipe_1
                ),
                "https://www.dapurumami.com/resep/oseng-tempe-kacang-panjang-5XjRp",
                1
            )
        )
        items.add(
            Recipe(
                "Ayam Taliwang AJI‑NO‑MOTO®",
                "https://www.dapurumami.com/uploads/recipe/jMfYZ/1508136197.png",
                resources.getString(
                    R.string.recipe_2
                ),
                "https://www.dapurumami.com/resep/ayam-taliwang-aji-no-moto-jMfYZ",
                1
            )
        )
        items.add(
            Recipe(
                "Daging Asam Padeh Sajiku®",
                "https://www.dapurumami.com/uploads/recipe/LfnTn/1507514126.png",
                resources.getString(
                    R.string.recipe_3
                ),
                "https://www.dapurumami.com/resep/daging-asam-padeh-sajiku-LfnTn",
                1
            )
        )
        items.add(
            Recipe(
                "Ayam Pop AJI‑NO‑MOTO®",
                "https://www.dapurumami.com/uploads/recipe/6zBuB/1500959043.png",
                resources.getString(
                    R.string.recipe_4
                ),
                "https://www.dapurumami.com/resep/ayam-pop-aji-no-moto-6zBuB",
                1
            )
        )
        items.add(
            Recipe(
                "Coto Makassar AJI‑NO‑MOTO®",
                "https://www.dapurumami.com/uploads/recipe/qrjkJ/1500021967.png",
                resources.getString(
                    R.string.recipe_5
                ),
                "https://www.dapurumami.com/resep/coto-makassar-aji-no-moto-qrjkJ",
                1
            )
        )

        items.add(
            Recipe(
                "Roti Panggang Pedas Ala Mayumi®",
                "https://www.dapurumami.com/uploads/recipe/Ijg35/RPP-Cover_940x576px.jpg",
                resources.getString(
                    R.string.recipe_6
                ),
                "https://www.dapurumami.com/resep/roti-panggang-pedas-ala-mayumi-Ijg35",
                2
            )
        )

        items.add(
            Recipe(
                "Pisang Nugget Ala Sajiku®",
                "https://www.dapurumami.com/uploads/recipe/jfdvG/Pisang%20Nugget-Image_940x576px.jpg",
                resources.getString(
                    R.string.recipe_7
                ),
                "https://www.dapurumami.com/resep/pisang-nugget-ala-sajiku-jfdvG",
                2
            )
        )

        items.add(
            Recipe(
                "Bakwan Tahu Udang Ala Sajiku®",
                "https://www.dapurumami.com/uploads/recipe/Yuo3X/BTU-Cover_940x576px.jpg",
                resources.getString(
                    R.string.recipe_8
                ),
                "https://www.dapurumami.com/resep/bakwan-tahu-udang-ala-sajiku-Yuo3X",
                2
            )
        )

        items.add(
            Recipe(
                "Sosis Gulung Mie Ala Sajiku®",
                "https://www.dapurumami.com/uploads/recipe/AQXX7/21-Februari_banner.png",
                resources.getString(
                    R.string.recipe_9
                ),
                "https://www.dapurumami.com/resep/sosis-gulung-mie-ala-sajiku-AQXX7",
                2
            )
        )

        items.add(
            Recipe(
                "Telur Gulung Ala AJI‑NO‑MOTO®",
                "https://www.dapurumami.com/uploads/recipe/BGR7v/WhatsApp%20Image%202020-03-20%20at%201.10.08%20PM.jpeg",
                resources.getString(
                    R.string.recipe_10
                ),
                "https://www.dapurumami.com/resep/telur-gulung-ala-aji-no-moto-BGR7v",
                2
            )
        )

        items.add(
            Recipe(
                "Spaghetti Aglio Olio Sambal Matah Ala Delito®",
                "https://www.dapurumami.com/uploads/recipe/W6830/April-2019-WEBSITE2.jpg",
                resources.getString(
                    R.string.recipe_11
                ),
                "https://www.dapurumami.com/resep/spaghetti-aglio-olio-sambal-matah-ala-delito-W6830",
                3
            )
        )

        items.add(
            Recipe(
                "Pizza Mie Goreng Ala Sajiku®",
                "https://www.dapurumami.com/uploads/recipe/QA77k/28-Februari_banner.png",
                resources.getString(
                    R.string.recipe_12
                ),
                "https://www.dapurumami.com/resep/pizza-mie-goreng-ala-sajiku-QA77k",
                3
            )
        )

        items.add(
            Recipe(
                "Burger Mie Ayam Crispy Ala Sajiku®",
                "https://www.dapurumami.com/uploads/recipe/VlkfV/6-April-2019-WEBSITE.jpg",
                resources.getString(
                    R.string.recipe_13
                ),
                "https://www.dapurumami.com/resep/burger-mie-ayam-crispy-ala-sajiku-VlkfV",
                3
            )
        )

        items.add(
            Recipe(
                "Makaroni Goreng Mayo",
                "https://www.dapurumami.com/uploads/recipe/Z5lTN/1504917439.png",
                resources.getString(
                    R.string.recipe_14
                ),
                "https://www.dapurumami.com/resep/makaroni-goreng-mayo-Z5lTN",
                3
            )
        )

        items.add(
            Recipe(
                "Mie Pizza Daging Asap",
                "Mie Pizza Daging Asap",
                resources.getString(
                    R.string.recipe_15
                ),
                "https://www.dapurumami.com/resep/mie-pizza-daging-asap-7y4kB",
                3
            )
        )
        adapter.setItems(items)
    }

    override fun onClick(item: Recipe) {
        val intent = Intent(this, RecipeDetailActivity::class.java)
        intent.putExtra("ITEM", item)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}