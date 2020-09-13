package com.gadsphasetwoproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gadsphasetwoproject.R
import com.gadsphasetwoproject.model.User


/*class RecyclerViewAdapter(context: Context, User: List<User>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val userList: List<User> = User

    val context = context


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var no_of_hours: TextView
        var address: TextView
        var badgeImage: ImageView

        init {
            name = itemView.findViewById(R.id.name_tv)
            no_of_hours = itemView.findViewById(R.id.no_hours_tv)
            address = itemView.findViewById(R.id.address_tv)
            badgeImage = itemView.findViewById(R.id.badge_imageView)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.leader_board_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {

        val item = userList[position]
        holder.name.text = item.name
        holder.no_of_hours.text = item.hours.toString()
        holder.address.text = item.country
        val badgeUrl = item.badgeUrl

        Glide.with(context)
            .load(badgeUrl)
            .placeholder(R.drawable.empty_img)
            .error(R.drawable.empty_img)
            .into(holder.badgeImage)
    }

    override fun getItemCount() = userList.size
}*/

class RecyclerAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private var userList: List<User> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.leader_board_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = userList[position]
        holder.name.text = item.name
        holder.no_of_hours.text = item.hours.toString()
        holder.address.text = item.country
        val badgeUrl = item.badgeUrl

        Glide.with(context)
            .load(badgeUrl)
            .placeholder(R.drawable.empty_img)
            .error(R.drawable.empty_img)
            .into(holder.badgeImage)
    }

    fun setUserListItems(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        var name: TextView = itemView!!.findViewById(R.id.name_tv)
        var no_of_hours: TextView = itemView!!.findViewById(R.id.no_hours_tv)
        var address: TextView = itemView!!.findViewById(R.id.address_tv)
        var badgeImage: ImageView = itemView!!.findViewById(R.id.badge_imageView)

    }
}
