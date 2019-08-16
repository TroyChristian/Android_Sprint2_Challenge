package layout


import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.lambdaschool.sprint2_challenge.GroceryItem

class GroceryListAdapter(val groceryList: MutableList<GroceryItem>: RecyclerView.Adapter<GroceryListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): RecyclerView.ViewHolder

}