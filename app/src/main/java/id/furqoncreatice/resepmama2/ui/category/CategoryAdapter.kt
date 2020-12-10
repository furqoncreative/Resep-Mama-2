package id.furqoncreatice.resepmama2.ui.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.furqoncreatice.resepmama2.R
import id.furqoncreatice.resepmama2.data.model.Category
import id.furqoncreatice.resepmama2.databinding.ItemRowViewBinding

class CategoryAdapter(private val listener: onItemClickListener) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var items = ArrayList<Category>()

    fun setItems(items: ArrayList<Category>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    interface onItemClickListener {
        fun onClick(item: Category)
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
        private lateinit var item: Category

        init {
            itemBinding.root.setOnClickListener(this)
        }

        fun bindView(item: Category) {
            this.item = item
            itemBinding.title.text = item.name
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