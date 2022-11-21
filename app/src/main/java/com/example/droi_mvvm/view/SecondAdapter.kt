package com.example.droi_mvvm.view//package com.example.droi_mvvm.ui
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.lifecycle.MutableLiveData
//import androidx.recyclerview.widget.RecyclerView
//import com.example.droi_mvvm.callback.OnItemClick
//import com.example.droi_mvvm.databinding.TodoItemBinding
//
//class SecondAdapter(
//    private val listener: OnItemClick
//    , var data: MutableLiveData<ArrayList<DTOS.recy>>
//    , private val clickListener: View.OnClickListener)
//    : RecyclerView.Adapter<SecondAdapter.TodoViewHolder>() {
//
//    private val mCallback = listener
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : TodoViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val binding = TodoItemBinding.inflate(layoutInflater)
//        return TodoViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int {
//        return data.value!!.size
//    }
//
//    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
//
//        data.value!![position].let {
//            holder.bind(it);
//        }
////        holder.bind(items[position])
//    }
//
//    inner class TodoViewHolder(private val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root){
//
//        fun bind(item: DTOS.recy){
//            binding.tvTodo.tag = adapterPosition
////            binding.tvTodo.setOnClickListener(clickListener)
//            binding.tvTodo.text = item.nums1
//            binding.tvTodo.setOnClickListener {
//                listener.onclic(it, adapterPosition)
//            }
//        }
//    }
//}