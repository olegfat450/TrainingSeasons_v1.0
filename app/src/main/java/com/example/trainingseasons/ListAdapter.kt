package com.example.trainingseasons

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter(context: Context,study: List<Sport>): ArrayAdapter<Sport> (context,R.layout.item,study) {

     override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView
         val study = getItem(position)
           if ( view == null) {view = LayoutInflater.from(context).inflate(R.layout.item,parent,false)}

         val image = view?.findViewById<ImageView>(R.id.image_item)
         val text = view?.findViewById<TextView>(R.id.text_item)

         if (study != null) {
             image?.setImageResource(study.image)
             text?.setText("${position+1}:    ${study.name}") }

         return view!!

    }


}