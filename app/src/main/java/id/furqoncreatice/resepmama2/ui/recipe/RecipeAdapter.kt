package id.furqoncreatice.resepmama2.ui.recipe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.furqoncreatice.resepmama2.R
import id.furqoncreatice.resepmama2.data.model.Recipe
import id.furqoncreatice.resepmama2.databinding.ItemRowViewBinding

class RecipesAdapter(private val listener: onItemClickListener) :
    RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {

    private var items = ArrayList<Recipe>()

    fun setItems(items: ArrayList<Recipe>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setFilter(newList: ArrayList<Recipe>) {
        items = newList
        notifyDataSetChanged()
    }

    interface onItemClickListener {
        fun onClick(item: Recipe)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRowViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bindView(items[position])

    override fun getItemCount() = items.size

    class ViewHolder(
        private val itemBinding: ItemRowViewBinding,
        private val listener: onItemClickListener
    ) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {
        private lateinit var item: Recipe
        lateinit var contex: Context

        init {
            itemBinding.root.setOnClickListener(this)
        }

        fun bindView(item: Recipe) {
            this.item = item
            itemBinding.title.text = item.title

            Picasso.get()
                .load(item.image)
                .placeholder(R.drawable.empty)
                .error(R.drawable.empty)
                .into(itemBinding.thumbnail)
        }

        override fun onClick(v: View?) {
            listener.onClick(item)
        }

    }
}