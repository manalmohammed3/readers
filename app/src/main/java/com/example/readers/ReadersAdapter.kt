package com.example.readers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.readers.data.ItemsItem
import com.example.readers.databinding.ItemBinding


class ReadersAdapter : ListAdapter<ItemsItem,
        ReadersAdapter.MoviePhotosViewHolder>(DiffCallback)  {



    class MoviePhotosViewHolder(
        private var binding:
        ItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(moviesPhoto: ItemsItem) {
            binding.result = moviesPhoto
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<ItemsItem>() {
        override fun areItemsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): ReadersAdapter.MoviePhotosViewHolder {
        return ReadersAdapter.MoviePhotosViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ReadersAdapter.MoviePhotosViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)}
}