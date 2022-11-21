package com.example.droi_mvvm.view

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.droi_mvvm.callback.OnItemClick
import com.example.droi_mvvm.databinding.ItemFirstBinding
import com.example.droi_mvvm.model.GDTO
import com.example.droi_mvvm.util.DiffCallback
import com.example.droi_mvvm.util.Logger

class FirstAdapter(
    private val listener: OnItemClick,
    val activity: Activity?
) : RecyclerView.Adapter<FirstAdapter.TodoViewHolder>(), Filterable {
    val data : ArrayList<GDTO.Processing>  = ArrayList()
    val arr : ArrayList<GDTO.Processing>  = ArrayList()
//    init {
//        data.addAll(files.value!!)
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFirstBinding.inflate(layoutInflater)
        return TodoViewHolder(binding)
    }

    fun diff(arr: ArrayList<GDTO.Processing>, str: String) {
        val tileDiffUtilCallback = DiffCallback(this.arr, arr)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(tileDiffUtilCallback)
        diffResult.dispatchUpdatesTo(this)
        setNewTiles(arr)
        val handler = Handler(Looper.getMainLooper())
        if (str != "") {
            handler.postDelayed({
                filter?.filter(str)
            }, 500)
        }
        notifyDataSetChanged()
    }

    private fun setNewTiles(newTiles: MutableList<GDTO.Processing>) {
        this.arr.run {
            clear()
            addAll(newTiles)
        }
        this.data.run {
            clear()
            addAll(newTiles)
        }
    }


    override fun getItemCount(): Int {
        return arr.size
    }
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
//        Logger.loge("${files.value!![position]}")
        arr[position].let {
            holder.bind(it);
        }
//        holder.bind(items[position])
    }

    inner class TodoViewHolder(private val binding: ItemFirstBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GDTO.Processing) {
            Logger.loge("item  :  ${item}")
//            binding.tvTodo.tag = adapterPosition
//            binding.tvTodo.text = "${item.country}   :   ${item.name}"
//            binding.tvTodo.setOnClickListener {
//                listener.onclic(it, adapterPosition)
//            }
//            if (activity != null) {
//                Glide.with(activity).load("").into(binding.ivTodo)
//            }
        }
    }

    override fun getFilter(): Filter? {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val charString = constraint.toString()
                arr.clear()
                if (charString.length < 2) {
//                    Logger.loge("performFiltering    ${data}")
                    arr.addAll(data)
                } else {
                    val filteredList = ArrayList<GDTO.Processing>()
//                    for (dto in data) {
////                        if (dto.buyAdvertisingStatus != "") {
////                            if (dto.buyAdvertisingStatus?.contains(charString) == true) {
////                                filteredList.add(dto);
////                            }
////                        } else {
////                            if (dto.buyAdvertisingStatusName?.contains(charString) == true) {
////                                filteredList.add(dto);
////                            }
////                        }
//                    }
                    arr.addAll(filteredList)
                }
                val filterResults = FilterResults()
                filterResults.values = arr
                return filterResults
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults) {
//                Logger.loge("${results.values}")
                notifyDataSetChanged()
            }
        }
    }

}