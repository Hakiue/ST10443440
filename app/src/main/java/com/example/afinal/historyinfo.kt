package com.example.project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.afinal.R


class historyinfo : AppCompatActivity() {

    // Declaration of UI elements
    private lateinit var ageEditText: EditText
    private lateinit var matchButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var clearButton: Button

    // Information of historical figures and their ages
    // This is also where I add more historical figures and their ages
    private val historicalFigures = mapOf(
        "Leonardo da Vinci" to 67,
        "Cleopatra" to 39,
        "Pelé" to 82,
        "Vladimir Lenin" to 53,
        "Fidel Castro" to 90,
        "Isaac Newton" to 84,
        "Albert Einstein" to 76,
        "William Shakespeare" to 52,
        "Nelson Mandela" to 95,
        "Mahatma Gandhi" to 78,
        "Napoleon Bonaparte" to 51,
        "Maximilien Robespierre" to 36,
        "Adolf Hitler" to 56,


        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historyinfo)

        // Initialize UI elements
        ageEditText = findViewById(R.id.age)
        matchButton = findViewById(R.id.match)
        clearButton = findViewById(R.id.clear)
        resultTextView = findViewById(R.id.Display)

        // Set a click listener for the button that will find a match
        matchButton.setOnClickListener {
            // Get the age entered by the user
            val age = ageEditText.text.toString().toIntOrNull()
            if (age in 20..100) { // This is to check if age is within the range
                // Find historical figures who passed away at the entered age
                val matchedFigures = findMatchedFigures(age)
                // Display the matched figures in the textview
                if (matchedFigures.isNotEmpty()) {
                    resultTextView.text = "A historical figure who passed away at this age is $age:\n${matchedFigures.joinToString("\n")}"
                } else {
                    // If no are figures found, it will display the following error
                    resultTextView.text = "No historical figures found in the database who passed away at this age $age"
                }
            } else {
                // If invalid age entered, display a message
                resultTextView.text = "Please enter a valid age between 20 and 100"
            }
        }

        //Set clear button that will clear text
        clearButton.setOnClickListener {
            ageEditText.text.clear()
            resultTextView.text = ""
        }
    }


    // Function to find historical figures who have died
    private fun findMatchedFigures(age: Int?): List<String> {
        val matchedFigures = mutableListOf<String>()
        for ((figure, figureAge) in historicalFigures) {
            if (figureAge == age) {
                matchedFigures.add(figure)
            }
        }
        return matchedFigures
    }
}