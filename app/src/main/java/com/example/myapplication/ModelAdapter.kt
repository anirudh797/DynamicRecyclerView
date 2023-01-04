package com.example.myapplication

import android.content.Context
import android.graphics.Point
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ModelAdapter( var modelList: MutableList<Model>, var  mainActivity: MainActivity) :
    RecyclerView.Adapter<ModelAdapter.EventViewHolder>() {



    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.findViewById<TextView>(R.id.title)
        val desc = itemView.findViewById<TextView>(R.id.description)
    }
    var currentItemHeight =0;
    var highestHeight =0;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(mainActivity)
            .inflate(R.layout.list_item, parent, false)

        val myViewHolder = EventViewHolder(itemView)
        for (m in modelList) {
            currentItemHeight = getHeightOfLargestDescription(
                mainActivity,
                m.desc,
                myViewHolder.desc
            )
            if (currentItemHeight > highestHeight) {
                highestHeight = currentItemHeight
            }
        }
        return myViewHolder
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val data = modelList[position]
        holder.title.text = data.title
        holder.desc.text = data.desc
        holder.desc.height = highestHeight
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    fun getHeightOfLargestDescription(
        context: Context,
        text: CharSequence?,
        textView: TextView
    ): Int {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displaySize = Point()
        wm.defaultDisplay.getSize(displaySize)
        val deviceWidth = displaySize.x
        textView.typeface = Typeface.DEFAULT
        textView.setText(text, TextView.BufferType.SPANNABLE)
        val widthMeasureSpec =
            View.MeasureSpec.makeMeasureSpec(deviceWidth, View.MeasureSpec.AT_MOST)
        val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        textView.measure(widthMeasureSpec, heightMeasureSpec)
        Log.d("Height", textView.measuredHeight.toString())
        return textView.measuredHeight
    }
}
