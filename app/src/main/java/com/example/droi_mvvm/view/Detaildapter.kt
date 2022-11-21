package com.example.droi_mvvm.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.target.Target
import com.example.droi_mvvm.Const
import com.example.droi_mvvm.callback.OnItemClick
import com.example.droi_mvvm.databinding.ItemDetailBinding
import com.example.droi_mvvm.model.GDTO
import com.example.droi_mvvm.util.GlideApp
import com.example.droi_mvvm.util.Logger

class Detaildapter(
    private val listener: OnItemClick,
    val files: MutableLiveData<ArrayList<GDTO.weather>>,
) : RecyclerView.Adapter<Detaildapter.TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemDetailBinding.inflate(layoutInflater)
        return TodoViewHolder(binding,parent.context)
    }
    override fun getItemCount(): Int {
        return files.value!!.size
    }
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
//        Logger.loge("${files.value!![position]}")
        files.value!![position].let {
            holder.bind(it);
        }
//        holder.bind(items[position])
    }

    inner class TodoViewHolder(private val binding: ItemDetailBinding, context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        var con = context
        fun bind(item: GDTO.weather) {
            binding.tvDetailMain.text = item.main
            binding.tvDetailDescription.text = item.description
            val url = Const.OPENWEATHERMAP_ICON_URL+item.icon+Const.OPENWEATHERMAP_ICON_extension
            Logger.loge("$url")
            GlideApp.with(con).load(url).override(Target.SIZE_ORIGINAL).into(binding.ivDetailIcon)
        }
    }



}