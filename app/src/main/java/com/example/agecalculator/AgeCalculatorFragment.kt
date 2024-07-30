package com.example.agecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.*

class AgeCalculatorFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_age_calculator, container, false)

        val editTextBirthDate = view.findViewById<EditText>(R.id.editTextBirthDate)
        val buttonCalculate = view.findViewById<Button>(R.id.buttonCalculate)
        val textViewResult = view.findViewById<TextView>(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            val birthDate = editTextBirthDate.text.toString()
            val age = calculateAge(birthDate)
            textViewResult.text = "Your age is: $age years"
        }

        return view
    }

    private fun calculateAge(birthDate: String): Int {
        // Assuming birthDate is in the format "dd/MM/yyyy"
        val parts = birthDate.split("/")
        val day = parts[0].toInt()
        val month = parts[1].toInt()
        val year = parts[2].toInt()

        val dob = Calendar.getInstance()
        dob.set(year, month - 1, day)

        val today = Calendar.getInstance()

        var age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--
        }

        return age
    }
}
