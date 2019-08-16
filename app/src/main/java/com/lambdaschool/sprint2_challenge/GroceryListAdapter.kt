package layout


import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.lambdaschool.sprint2_challenge.GroceryItem
import com.lambdaschool.sprint2_challenge.R
import kotlinx.android.synthetic.main.grocery_list_item.view.*

class GroceryListAdapter(val groceryList: MutableList<GroceryItem>) : RecyclerView.Adapter<GroceryListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.grocery_list_item, parent, false) as View)

}

override fun getItemCount(): Int {
    return groceryList.size
}

override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val groceryitem = groceryList[position]
    holder.bindModel(groceryitem)

    holder.groceryImageView.setOnClickListener {
        groceryitem.isSelected = !groceryitem.isSelected
        notifyItemChanged(position)
    }


}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val groceryImageView: ImageView = view.grocery_image_view
    val groceryNameView: TextView = view.grocery_name_view
    val groceryItemParent: LinearLayout = view.grocery_item_ancestor

    fun bindModel(groceryitem: GroceryItem) {
        groceryImageView.setImageResource(groceryitem.imageID)
        groceryNameView.text = groceryitem.name
        if (groceryitem.isSelected)
            groceryImageView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorAccent))
        else
            groceryImageView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorPrimaryDark))
    }
}

}