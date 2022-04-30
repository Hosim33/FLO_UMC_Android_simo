package com.example.flo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flo.databinding.ItemSongBinding

class SavedsongRVAdapter (private val albumList: ArrayList<Album>): RecyclerView.Adapter<SavedsongRVAdapter.ViewHolder>() {

    interface MyItemClickListener{
        fun onItemClick(album: Album)
        fun onRemoveAlbum(position: Int)
    }

    private lateinit var mItemClickListener: MyItemClickListener
    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    fun addItem(album: Album){
        albumList.add(album)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        albumList.removeAt(position)
        notifyDataSetChanged()
    }


    //ViewHolder 생성해줘야할 때 호출되는 함수
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SavedsongRVAdapter.ViewHolder {
        val binding: ItemSongBinding = ItemSongBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)

        return ViewHolder(binding)
    }

    //ViewHolder에 데이터를 바인딩해줘야 할 때 마다 호출되는 함수, 클릭 이벤트 작성 위치
    override fun onBindViewHolder(holder: SavedsongRVAdapter.ViewHolder, position: Int) {
        holder.bind(albumList[position])
        holder.itemView.setOnClickListener { mItemClickListener.onItemClick(albumList[position]) }
//        holder.binding.itemAlbumTitleTv.setOnClickListener { mItemClickListener.onRemoveAlbum(position) }

    }

    //album 리스트 크기 넣어주면 된다.
    override fun getItemCount(): Int = albumList.size

    inner class ViewHolder(val binding: ItemSongBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(album: Album){
            binding.itemSongTitleTv.text = album.title
            binding.itemSongSingerTv.text =album.singer
            binding.itemSongCoverImgIv.setImageResource(album.coverImg!!)
        }

    }
}