package eliu.gonzalez.asignacion4_calculadoraimc_gonzalezfierro

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight: EditText = findViewById(R.id.weight) as EditText
        val height: EditText = findViewById(R.id.height) as EditText
        val calculate: Button= findViewById(R.id.calculate) as Button

        var imc: TextView = findViewById(R.id.imc) as TextView
        var range: TextView = findViewById(R.id.range) as TextView

        calculate.setOnClickListener {
            val IMC: Float= (weight.text.toString().toFloat())/(height.text.toString().toFloat()*height.text.toString().toFloat())
            val status=checkRangeIMC(IMC)
            imc.setText(IMC.toString())
            range.setText(status)
            setColorIMC(IMC,range)
        }
    }

    fun checkRangeIMC(imc: Float): String{
         return when {
            imc < 18.5 ->   "Underweight"
            imc >= 18.5 && imc <= 24.9 ->   "Normal"
            imc >= 25 && imc <= 29.9 ->  "Overweight"
            imc >= 30 && imc <= 34.9 ->  "Obesity class 1"
            imc >= 35 && imc <= 39.9 ->  "Obesity class 2"
            imc >= 40 -> "Obesity class 3"
            else -> return "Illegal Number"
        }
    }

    fun setColorIMC(imc: Float, text: TextView){
         when {
            imc < 18.5 -> text.setBackgroundResource(R.color.colorGreenish)
            imc >= 18.5 && imc <= 24.9 ->   text.setBackgroundResource(R.color.colorGreen)
            imc >= 25 && imc <= 29.9 ->  text.setBackgroundResource(R.color.colorYellow)
            imc >= 30 && imc <= 34.9 ->  text.setBackgroundResource(R.color.colorOrange)
            imc >= 35 && imc <= 39.9 ->  text.setBackgroundResource(R.color.colorRed)
            imc >= 40 -> text.setBackgroundResource(R.color.colorBrown)
            else -> text.setBackgroundResource(R.color.black)
        }
    }



}