package id.furqoncreatice.resepmama2.ui.recipe

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso
import id.furqoncreatice.resepmama2.R
import id.furqoncreatice.resepmama2.data.model.Recipe
import id.furqoncreatice.resepmama2.databinding.ActivityRecipeDetailBinding

class RecipeDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecipeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        setData()


    }

    fun setData() {
        val item = intent.getParcelableExtra<Recipe>("ITEM")
        if (item != null) {
            findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = item.title
            Picasso.get()
                .load(item.image)
                .placeholder(R.drawable.empty)
                .error(R.drawable.empty)
                .into(binding.thumbnail)
//            binding.content.textContent.text = item.content
            binding.content.webview.settings.javaScriptEnabled = true
            binding.content.webview.loadData(item.content, "text/html; charset=utf-8", "UTF-8")
        } else {
            Toast.makeText(this, "DATA NULL", Toast.LENGTH_SHORT).show()
        }

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val url = item.source
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}