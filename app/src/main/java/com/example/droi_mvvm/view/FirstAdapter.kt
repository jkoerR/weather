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
import com.example.droi_mvvm.databinding.ItemFirstcBinding
import com.example.droi_mvvm.databinding.ItemFirsttBinding
import com.example.droi_mvvm.model.GDTO
import com.example.droi_mvvm.util.DiffCallback
import com.example.droi_mvvm.util.Logger

class FirstAdapter(
    private val listener: OnItemClick,
    val activity: Activity?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {
    val data: ArrayList<GDTO.Processing> = ArrayList()
    val arr: ArrayList<GDTO.Processing> = ArrayList()

    //    init {
//        data.addAll(files.value!!)
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
//        return TodoViewHolder(binding)
        return when (viewType) {
            0 -> {
                val binding = ItemFirsttBinding.inflate(layoutInflater, parent, false)
                TodoViewHolderT(binding)
            }
            1 -> {
                val binding = ItemFirstcBinding.inflate(layoutInflater, parent, false)
                TodoViewHolderC(binding)
            }else -> {
                val binding = ItemFirsttBinding.inflate(layoutInflater, parent, false)
                TodoViewHolderT(binding)
            }
        }
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

    override fun getItemViewType(position: Int): Int {
        return arr[position].type
    }


    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        Logger.loge("${files.value!![position]}")
//        arr[position].let {
//            holder.bind(it);
//        }
//        holder.bind(items[position])
        when (arr[position].type) {
            0 -> {
                arr[position].let {
                    (holder as TodoViewHolderT).bind(it)
                }
            }
            1 -> {
                arr[position].let {
                    (holder as TodoViewHolderC).bind(it)
                }
            }
        }
    }

    inner class TodoViewHolderT(private val binding: ItemFirsttBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GDTO.Processing) {
            binding.tvTodo.text = "${item.city}"
        }
    }
    inner class TodoViewHolderC(private val binding: ItemFirstcBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GDTO.Processing) {
            binding.tvDate.text = "${item.date}"
            binding.tvWeather.text = "${item.weather}"
            binding.tvMax.text = "Max : ${item.max}"
            binding.tvMin.text = "Min : ${item.min}"
//            if (activity != null) {
//                Glide.with(activity).load(item.tierRank.imageUrl).into(binding.ivTier)
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