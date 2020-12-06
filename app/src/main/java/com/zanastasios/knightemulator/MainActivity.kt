package com.zanastasios.knightemulator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar


/**
 *fun [initChessBoard] initializes chess board creating each row as a LinearLayout
 * each square of the chess board is a button
 * [chessBoardSize] chooses random size for chess board (Range 6 to 16)
 *[pairStartingEndingPosition] holds the pair of start-end position selected from the user for caclulation
 * [isItStartOrEndPosition] checking whether chessboard swuare should be marked as a starting or ending position
 */


class MainActivity : AppCompatActivity() {

    val chessBoardSize = (6..16).random()
    var isItStartOrEndPosition = 0
    var pairStartingEndingPosition = arrayOf(0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewStartingPosition = findViewById<TextView>(R.id.textViewStartingPosition)
        textViewStartingPosition.text = getString(R.string.knights_starting_position_en, 0)
        val textViewEndingPosition = findViewById<TextView>(R.id.textViewEndingPosition)
        textViewEndingPosition.text = getString(R.string.knights_ending_position_en, 0)

        initChessBoard()

        val execute: Button = findViewById(R.id.button_execute_culculations)

        execute.setOnClickListener {
            val solution = Solution()
            Snackbar.make(it, R.string.feature_not_implemented_en, Snackbar.LENGTH_SHORT)
                .show()
            //TODO AFTER SUCCESSFULLY CALCULATING PATHS SHOW USER ALL POSSIBLE PATHS
            //println(solution.calculateAllPossiblePaths(pairStartingEndingPosition,chessBoardSize))
        }

    }

    //TODO USE COROUTINES TO HANDLE INFLATING THE LAYOUT SO MAIN THREAD DOES NOT FREEZE
    //TODO OR EVEN ADD VIEWMODEL TO HANDLE THIS
    private fun initChessBoard() {
        val chessboard = findViewById<LinearLayout>(R.id.linearLayoutChessBoard)
        //INFLATE CHESSBOARD ROWS
        for (i in 0 until chessBoardSize) {
            val linearLayoutChessRow = LinearLayout(this)
            linearLayoutChessRow.id = View.generateViewId()
            //SETTING LAYOUT PARAMS FOR LINEAR LAYOUT ROW
            val params = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            linearLayoutChessRow.orientation = LinearLayout.HORIZONTAL
            linearLayoutChessRow.layoutParams = params
            //INFLATE CHESSBOARD SQUARES
            for (j in 0 until chessBoardSize) {
                val chessRect = Button(this)
                chessRect.id = ((j + 1) + i * chessBoardSize)
                val params = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                chessRect.setOnClickListener {

                    if (isItStartOrEndPosition % 2 == 0) {
                        pairStartingEndingPosition[0] = it.id
                        //TODO MARK STARING POSITION MAKING BUTTON COLOR GREEN OR ADDING INDICATIVE BACKGROUND TO IT
                        val textViewStartingPosition =
                            findViewById<TextView>(R.id.textViewStartingPosition)
                        textViewStartingPosition.text =
                            getString(R.string.knights_starting_position_en, it.id)


                    } else {
                        //TODO MARK STARING POSITION MAKING BUTTON COLOR RED OR ADDING INDICATIVE BACKGROUND TO IT
                        pairStartingEndingPosition[1] = it.id
                        val textViewEndingPosition =
                            findViewById<TextView>(R.id.textViewEndingPosition)
                        textViewEndingPosition.text =
                            getString(R.string.knights_ending_position_en, it.id)
                    }
                    isItStartOrEndPosition++
                }
                chessRect.layoutParams = params
                when (chessBoardSize) {
                    //CHECKING SIZE OF CHESSBOARD TO INFLATE BUTTONS HAT FIT ON THE SCREEN !!! DOES NOT SUPPORT MULTIPLE SCREEN SIZES BECAUSE VIEWS ARE ADDED PROGRAMMATICALLY
                    in 6..7 -> {
                        chessRect.layoutParams.height = 128
                        chessRect.layoutParams.width = 128
                    }
                    in 8..10 -> {
                        chessRect.layoutParams.height = 96
                        chessRect.layoutParams.width = 96
                    }
                    in 11..12 -> {
                        chessRect.layoutParams.height = 80
                        chessRect.layoutParams.width = 80
                    }
                    in 13..16 -> {
                        chessRect.layoutParams.height = 64
                        chessRect.layoutParams.width = 64
                    }

                }
                //Check tile "position" to set right color
                if ((i + j) % 2 == 0) {
                    chessRect.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.colorWhite
                        )
                    )
                } else {
                    chessRect.setBackgroundColor(
                        ContextCompat.getColor(
                            this,
                            R.color.colorBlack
                        )
                    )
                }
                //ADDING EACH "SQUARE" BUTTON TO THE LINEARLAYOUT ROW
                linearLayoutChessRow.addView(chessRect)
            }
            // ADDING EACH ROW TTO THE MAIN LINEARLAYOUT THAT "HOLDS" THE CHESSBOARD
            chessboard.addView(linearLayoutChessRow)
        }
    }
}