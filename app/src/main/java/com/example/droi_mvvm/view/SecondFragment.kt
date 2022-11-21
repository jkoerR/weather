package com.example.droi_mvvm.view//package com.example.droi_mvvm.ui
//
//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
//import androidx.fragment.app.activityViewModels
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.droi_mvvm.retrofit.Retrofit_Presenter
//import com.example.droi_mvvm.BaseFragment
//import com.example.droi_mvvm.R
//import com.example.droi_mvvm.databinding.FragmentSecondBinding
//import com.example.droi_mvvm.model.DTOS
//import com.example.droi_mvvm.util.Util
//import com.example.droi_mvvm.viewmodel.MainViewModel
//import com.google.gson.JsonArray
//import com.google.gson.JsonObject
//
//class SecondFragment : BaseFragment() {
//    lateinit var binding: FragmentSecondBinding
//    lateinit var secondAdapter: SecondAdapter
//
//    var data = MutableLiveData<ArrayList<DTOS.recy>>()
//    private val model: MainViewModel by activityViewModels()
////    private lateinit var model:MainViewModel
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
////        return super.onCreateView(inflater, container, savedInstanceState)
//        return binding.root
//    }
//
//    override fun onclic(v: View, position: Int) {
//        Log.e("onclic", "${v.id}  :  ${position}")
//        when (v.id) {
//            R.id.tv_todo -> {
////                model.modi(position)
////                adapter.notifyDataSetChanged()
//            }
//        }
//    }
//
//    override fun _init() {
////        retrofit_Presenter = Retrofit_Presenter(this, activity)
////        binding.lifecycleOwner = this
////        model = ViewModelProvider(activity as FragmentActivity)[MainViewModel::class.java]
////        model = ViewModelProvider(requireActivity())[MainViewModel::class.java]
//
//
//
//        binding.btnSadd.setOnClickListener(this)
//
////        request_winning("", "")
//        initRecyclerView()
//    }
//
////    private fun initRecyclerView() {
////
////        binding.rvSecond.layoutManager = LinearLayoutManager(activity)
////        val adapterobsever: Observer<ArrayList<DTOS.recy>> =
////            Observer {
////                data.value = it
////                secondAdapter = SecondAdapter(this, data, this)
////                binding.rvSecond.adapter = secondAdapter
////            }
////        model.liveData.observe(this, adapterobsever)
////    }
//
//    private fun request_winning(
//        snum: String,
//        enum: String
//    ) {
//        val jsonObject = Util.baseJson()
//        jsonObject.addProperty("snum", snum)
//        jsonObject.addProperty("enum", enum)
////        Logger.loge("" + jsonObject)
////        retrofit_Presenter?.winning(jsonObject)
//    }
//
//    private fun setData(list: JsonArray, week_sgamenum: String, week_lotto_day: String) {
//
////        dtos.clear()
////        var dto: DTO_InLotto.Winnum = DTO_InLotto.Winnum()
//////        dto.sgamenum = week_sgamenum
//////        dto.pdate = week_lotto_day
//////        dtos.add(dto)
////        for (i in 0..list.size() - 1 step 1) {
////            dto = gson.fromJson(list[i], DTO_InLotto.Winnum::class.java)
////            dtos.add(dto)
////        }
////        adapterWinnum.notifyDataSetChanged()
////
////        val tweek = "이번주 ${week_sgamenum}회 구매번호 분석"
////        tv_winnum_thisweek.text = tweek
////
////        if (firstIn == "Y" && dtos.size > 2) {
////            onFirst(activity!!, dtos[0])
////        } else {
////            binding.llWinnumTop.visibility = View.GONE
////            sv_winnum.visibility = View.GONE
////            binding.rlWinnumCon.visibility = View.VISIBLE
////        }
//
//    }
//
//    override fun onClick(v: View) {
//        super.onClick(v)
//        var cPosition: Int?
//        var cIntent: Intent?
////        var dto: DTO_InLotto.Winnum
//        when (v.id) {
//            R.id.btn_sadd -> {
////                model.call_DTO()
//            }
////            R.id.rl_item_winnum_root -> {
////                cPosition = v.tag as Int?
//////                dto = dtos[cPosition!!]
////                onFirst(activity!!, dtos[cPosition!!])
//////                customdialog_winnum = CustomDialog_winnum(
//////                        activity,
//////                        this,
//////                        dto
//////
//////                )
//////                if (customdialog_winnum.isShowing()) return
//////                customdialog_winnum.show()
//////                dto.open = !dto.open
//////                dtos[cPosition!!] = dto
//////                adapterWinnum.notifyDataSetChanged()
////            }
//
//
////            R.id.rl_winnum_seach -> {
////                mSnum = et_winnum_snum.text.toString()
////                mEnum = et_winnum_enum.text.toString()
////                request_winning(mSnum!!, mEnum!!)
////            }
////            R.id.rl_winnum_golist -> {
////                binding.llWinnumTop.visibility = View.GONE
////                sv_winnum.visibility = View.GONE
////                rl_winnum_golist.visibility = View.GONE
////                binding.rlWinnumCon.visibility = View.VISIBLE
////                firstIn = "N"
////            }
////            R.id.rl_winnum_close -> {
////                binding.llWinnumTop.visibility = View.GONE
////                sv_winnum.visibility = View.GONE
////                binding.rlWinnumCon.visibility = View.VISIBLE
////                rl_winnum_golist.visibility = View.GONE
////                firstIn = "N"
////            }
////            R.id.rl_winnum_top -> {
////                cIntent = Intent(activity, AnalysisActivity::class.java)
////                Util.goIntent(activity, cIntent, false)
////            }
////            R.id.iv_mainBg -> {
////                Logger.loge("iv_mainBg")
////            }
//            else -> {
//
//            }
//        }
//    }
//
//    override fun jk_result(result: JsonObject?, from: String?) {
//        super.jk_result(result, from)
////        Logger.loge("jk_result    :   $result   from   :  $from")
//        val code = result!!["rst_cd"].asString
//        when (code) {
////            Const.API_SUC -> {
////                when (from) {
//////                    Const.WINNING -> {
//////                        val list: JsonArray = result!!["lotto_list"].asJsonArray
//////                        val week_sgamenum: String = result!!["week_sgamenum"].asString
//////                        val week_lotto_day: String = result!!["week_lotto_day"].asString
//////                        if (mEnum == null) mEnum = (Integer.parseInt(week_sgamenum) - 1).toString()
//////                        if (mSnum == null) mSnum = (Integer.parseInt(mEnum!!) - 40).toString()
//////                        et_winnum_snum.setText(mSnum)
//////                        et_winnum_enum.setText(mEnum)
////////                        Logger.loge("list   :    $list")
//////                        setData(list, week_sgamenum, week_lotto_day)
////////                        val list: JsonArray = gson.fromJson(result!!["lotto_list"],JsonArray::class.java)
////////                        Logger.loge("list   :  $list")
////////                        var jsonArray: JsonArray = gson.fromJson<JsonObject>(box_res, JsonObject::class.java)
//////                    }
////                    else -> {
////
////                    }
////                }
////            }
//            else -> {
//
//            }
//        }
//
//    }
//
//
//}