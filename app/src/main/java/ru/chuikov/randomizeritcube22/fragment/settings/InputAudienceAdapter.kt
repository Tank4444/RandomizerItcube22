package ru.chuikov.randomizeritcube22.fragment.settings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.chuikov.randomizeritcube22.R
import ru.chuikov.randomizeritcube22.dao.Audience
import ru.chuikov.randomizeritcube22.dao.Station

class InputAudienceAdapter(private val list: MutableList<Audience>): RecyclerView.Adapter<InputAudienceAdapter.InputAudienceHolder>() {
    class InputAudienceHolder(itemView: View) : ViewHolder(itemView) {
        val nameText:EditText = itemView.findViewById(R.id.input_audience_item_name)
        val countText:EditText = itemView.findViewById(R.id.input_audience_item_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InputAudienceHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.input_audience_item,parent,false)
        return InputAudienceHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: InputAudienceHolder, position: Int) {
        holder.nameText.setText(list[position].name)
        holder.nameText.doAfterTextChanged {
            list[position].name = it.toString()
        }
        holder.countText.setText(list[position].stations.count().toString())
        holder.countText.doOnTextChanged { text, start, before, count ->
            var l:String = text.toString()
            if(l.equals("") || l.equals("0")) holder.countText.setText("1")
        }
        holder.countText.doAfterTextChanged {
            if(!it.toString().equals("")){
                list[position].stations = MutableList(it.toString().toInt(), init = {
                    Station(it,true)
                })
            }

        }

    }

    fun getList() = list

    fun add(){
        list.add(Audience("A", MutableList(1, init = { Station(it,true) })))
        notifyItemRangeInserted(list.size,1)
    }
    fun removeLast(){
        list.removeLast()
        notifyItemRemoved(list.size)
    }
}