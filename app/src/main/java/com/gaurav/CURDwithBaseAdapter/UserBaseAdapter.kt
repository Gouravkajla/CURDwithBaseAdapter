package com.gaurav.CURDwithBaseAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText

data class UserBaseAdapter(var Userlist: ArrayList<UserModle>, val mainActivity: MainActivity):BaseAdapter() {
    override fun getCount(): Int {
        return Userlist.size;

    }

    override fun getItem(p0: Int): Any {
        return 1;
    }

    override fun getItemId(p0: Int): Long {
        return 1;
    }

    override fun getView(position: Int, convertView: View?, parant: ViewGroup?): View? {
        var view = LayoutInflater.from(parant?.context).inflate(R.layout.item_layout, parant, false)
        var etEmail = view.findViewById<EditText>(R.id.etEmail)
        var etName = view.findViewById<EditText>(R.id.etName)
        etName.setText(Userlist[position].Name)
        etEmail.setText(Userlist[position].Email)
        return view
     }
}
