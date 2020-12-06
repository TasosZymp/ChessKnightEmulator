package com.zanastasios.knightemulator


/**
 * GOT STUCK ON CALCULATING POSSIBLE PATHS
 * [calculateAllPossiblePaths] is called from MainActivity when button is pressed
 * provides all needed params to calculate possible paths
 * [calculatePossiblePaths] will be the main function calculating if knight's path
 * is correct and will adding that path to the @param [listOfAcceptedPaths]
 */

class Solution {

    companion object {
        const val MAX_MOVES_TO_REACH_END_POSITION = 3
        var movesCalculated = 0
        val listOfAcceptedPaths = mutableListOf<MutableList<Int>>()
        var endPosition: Int = 0
        var startPosition: Int = 0
        var chessBoardSize: Int = 0
    }

    private fun calculatePossiblePaths(currentPosition: Int, knight: Knight) {

        knight.calculateKnightMoves(currentPosition, chessBoardSize)
        var listOfPaths =
            knight.knightLegalMoves // INITIAL KNIGHTS LEGAL MOVES FROM STARTING POSITION
        //TODO CALCULATE POSSIBLE PATHS
    }


    fun calculateAllPossiblePaths(
        start_end_positions: Array<Int>,
        sizeOfChessBoard: Int
    ): MutableList<MutableList<Int>> {
        startPosition = start_end_positions[0]
        endPosition = start_end_positions[1]
        val knight = Knight()
        chessBoardSize = sizeOfChessBoard
        calculatePossiblePaths(startPosition, knight)
        return listOfAcceptedPaths
    }


}