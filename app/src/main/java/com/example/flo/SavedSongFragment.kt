package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flo.databinding.FragmentLockerSavedsongBinding

class SavedSongFragment : Fragment() {

    lateinit var binding: FragmentLockerSavedsongBinding
    private var albumDatas = ArrayList<Album>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLockerSavedsongBinding.inflate(inflater,container,false)

        albumDatas.apply {
            add(Album("i","이아람",R.drawable.img_album_exp5))
            add(Album("Lilac","아이유 (IU)",R.drawable.img_album_exp2))
            add(Album("Feeling of You","윤새 (Yunsae)",R.drawable.img_album_exp3))
            add(Album("Real Love","오마이걸 (OH MY GIRL)",R.drawable.img_album_exp4))
            add(Album("나만 알면 돼","Apink (에이핑크)",R.drawable.img_album_exp6))
            add(Album("Butter","방탄소년단 (BTS)",R.drawable.img_album_exp))
        }

        val savedsongRVAdapter = SavedsongRVAdapter(albumDatas)
        binding.lockerSavedsongRv.adapter = savedsongRVAdapter
        binding.lockerSavedsongRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        return binding.root
    }
}