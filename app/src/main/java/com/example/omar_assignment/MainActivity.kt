package com.example.omar_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ItemsNumber: EditText = findViewById(R.id.NumberOfItems)
        val add: Button = findViewById(R.id.AddItem)
        val calc: Button = findViewById(R.id.Calculate)
        val resultTV: TextView = findViewById(R.id.TotalItems)

        var flag : String = "Burger"
        val spinnerVal : Spinner = findViewById(R.id.Items)
        var options = arrayOf("Burger","Pizza","Shwerma")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        var Total = 0

        add.setOnClickListener{ view ->
            Total=addNItem(Total, flag, ItemsNumber.toString().toInt())
        }

        calc.setOnClickListener{ view ->
            resultTV.text = Total.toString()
        }

    }
}
public fun addNItem(Total: Int, Item: String,NumOfItems:Int): Int {
    if(Item =="Burger")
        return Total+(5*NumOfItems)
    if(Item =="Pizza")
        return Total+(10*NumOfItems)
    if(Item =="Shawerma")
        return Total+(8*NumOfItems)
    return 0
}


