package com.gaurav.CURDwithBaseAdapter

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gaurav.CURDwithBaseAdapter.databinding.ActivityMainBinding
import com.gaurav.CURDwithBaseAdapter.databinding.CustomdialogAddBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var userBaseAdapter:UserBaseAdapter
    var userModleList=ArrayList<UserModle>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
          setContentView(binding.root)
        userBaseAdapter=UserBaseAdapter(userModleList,this)
        binding.lv.adapter=userBaseAdapter


        binding.ftButton.setOnClickListener{
            var customDialog=Dialog(this)
            var DialogBinding=CustomdialogAddBinding.inflate(layoutInflater)
            customDialog.setContentView(DialogBinding.root)
            DialogBinding.btnAdd.setOnClickListener {
                if (DialogBinding.etEmail.text.isEmpty()){
                    DialogBinding.etEmail.error="Enter Your Email"
                }else if(DialogBinding.etName.text.isEmpty()) {
                    DialogBinding.etName.error="Enter Your Name"

                }else{
                    userModleList.add(UserModle(DialogBinding.etEmail.text.toString(),DialogBinding.etName.text.toString()))
                    userBaseAdapter.notifyDataSetChanged()
                    customDialog.dismiss()

                }

            }
            customDialog.show()
            }

        }
    }

