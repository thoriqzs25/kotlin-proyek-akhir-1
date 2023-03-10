package com.mykicks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mykicks.databinding.ItemSkCardBinding

class ListWishlistSkAdapter (private val listSneaker: ArrayList<Sneaker>, private val onClick: (Sneaker) -> Unit) : RecyclerView.Adapter<ListWishlistSkAdapter.ListViewHolder>() {
    inner class ListViewHolder(var binding: ItemSkCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sk: Sneaker) {
            itemView.setOnClickListener {
                onClick(sk)
            }
            binding.tvName.text = sk.name
            binding.tvJoinedDate.text = sk.date
            binding.tvPrice.text = sk.price
            binding.ivSk.setImageResource(sk.photo)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListWishlistSkAdapter.ListViewHolder {
        val binding = ItemSkCardBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listSneaker[position])
    }

    override fun getItemCount(): Int = listSneaker.size
}