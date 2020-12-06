package com.zanastasios.knightemulator


/**
 * fun [calculateKnightMoves]
 * @param sizeOfChessBoard needed to calculate knight possible moves
 * @param currentPosition needed as an indicator to where knight is at the current calculation
 *
 */

class Knight {

    val knightLegalMoves = mutableListOf<Int>()
    var knightPosition: Int = 0

    fun calculateKnightMoves(sizeOfChessBoard: Int, currentPosition: Int) {
        knightPosition = currentPosition
        //POSSIBLE MOVES FOR 1ST COLUMN SQUARES
        if (currentPosition % sizeOfChessBoard == 1) {
            if (currentPosition > sizeOfChessBoard.timesTwo() && currentPosition < sizeOfChessBoard - sizeOfChessBoard.timesTwo()) {
                //down right
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) + 1)
                //right up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard + 2)
                //right down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard + 2)
                //up right
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) + 1)
            } else if (currentPosition < sizeOfChessBoard) {
                //up right
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) + 1)
                //right up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard + 2)
            } else if (currentPosition == sizeOfChessBoard + 1) {
                //up right
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) + 1)
                //right up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard + 2)
                //right down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard + 2)
            } else if (currentPosition == (sizeOfChessBoard.squared()) - (sizeOfChessBoard.timesTwo()) + 1) {
                //right up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard + 2)
                //right down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard + 2)
                //up right
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) + 1)
            } else {
                //right down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard + 2)
                //up right
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) + 1)
            }
            //POSSIBLE MOVES FOR 1ST ROW SQUARES
        } else if (currentPosition < sizeOfChessBoard) {
            if (currentPosition == 2) {
                //up left
                knightLegalMoves.add(currentPosition + sizeOfChessBoard.timesTwo() - 1)
                //up right
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) + 1)
                //right up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard + 2)
            } else if (currentPosition == sizeOfChessBoard - 1) {
                //up left
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) - 1)
                //up right
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) + 1)
                //left up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard - 2)
            } else {
                //left up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard - 2)
                //up left
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) - 1)
                //up right
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) + 1)
                //right up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard + 2)
            }
            //POSSIBLE MOVES FOR LAST COLUMN SQUARES
        } else if (currentPosition % sizeOfChessBoard == 0) {
            if (currentPosition == sizeOfChessBoard) {
                //left up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard - 2)
                //up left
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) - 1)
            } else if (currentPosition == sizeOfChessBoard.timesTwo()) {
                //left down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard - 2)
                //left up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard - 2)
                //up left
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) - 1)
            } else if (currentPosition == sizeOfChessBoard.squared()) {
                //left down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard - 2)
                //down left
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) - 1)
            } else if (currentPosition == currentPosition * currentPosition - currentPosition) {
                //left down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard - 2)
                //left up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard - 2)
                //down left
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) - 1)
            } else {
                //left down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard - 2)
                //left up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard - 2)
                //down left
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) - 1)
                //up left
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) - 1)
            }
            //POSSIBLE MOVES FOR LAST ROW SQUARES
        } else if (currentPosition in (sizeOfChessBoard.squared() - sizeOfChessBoard + 2) until (sizeOfChessBoard.squared())) {
            if (currentPosition % sizeOfChessBoard == 2) {
                //down left
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) - 1)
                //down right
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) + 1)
                //right down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard + 2)
            } else if (currentPosition == sizeOfChessBoard.squared() - 1) {
                //down left
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) - 1)
                //down right
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) + 1)
                //left down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard - 2)
            } else {
                //down left
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) - 1)
                //down right
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) + 1)
                //right down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard + 2)
                //left down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard - 2)
            }
            //POSSIBLE MOVES 2ND COLUMN SQUARES EXCLUDING 1ST AND LAST
        } else if (currentPosition % sizeOfChessBoard == 2 && currentPosition > sizeOfChessBoard && currentPosition < sizeOfChessBoard.squared() - sizeOfChessBoard) {
            if (currentPosition in sizeOfChessBoard..sizeOfChessBoard.timesTwo()) {
                //right up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard + 2)
                //right down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard + 2)
                //up left
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) - 1)
                //up right
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) + 1)
            } else if (currentPosition in sizeOfChessBoard.squared() - sizeOfChessBoard.timesTwo()..sizeOfChessBoard.squared()) {
                //right up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard + 2)
                //right down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard + 2)
                //down left
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) - 1)
                //down right
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) + 1)
            } else {
                //right up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard + 2)
                //right down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard + 2)
                //down left
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) - 1)
                //down right
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) + 1)
                //up left
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) - 1)
                //up right
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) + 1)
            }
            //POSSIBLE MOVES 2ND ROW SQUARES EXCLUDING 1ST AND LAST
        } else if (currentPosition % sizeOfChessBoard > 2 && currentPosition % sizeOfChessBoard < sizeOfChessBoard - 1 && currentPosition in sizeOfChessBoard..sizeOfChessBoard.timesTwo()) {
            //left down
            knightLegalMoves.add(currentPosition - sizeOfChessBoard - 2)
            //left up
            knightLegalMoves.add(currentPosition + sizeOfChessBoard - 2)
            //up left
            knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) - 1)
            //up right
            knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) + 1)
            //right up
            knightLegalMoves.add(currentPosition + sizeOfChessBoard + 2)
            //right down
            knightLegalMoves.add(currentPosition - sizeOfChessBoard + 2)
        } else if (currentPosition % sizeOfChessBoard == sizeOfChessBoard - 1 && currentPosition > sizeOfChessBoard && currentPosition < sizeOfChessBoard.squared() - sizeOfChessBoard) {
            if (currentPosition in sizeOfChessBoard..sizeOfChessBoard.timesTwo()) {
                //left down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard - 2)
                //left up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard - 2)
                //up left
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) - 1)
                //up right
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) + 1)
            } else if (currentPosition in sizeOfChessBoard.squared() - sizeOfChessBoard.timesTwo()..sizeOfChessBoard.squared()) {
                //left down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard - 2)
                //left up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard - 2)
                //down left
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) - 1)
                //down right
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) + 1)
            } else {
                //left down
                knightLegalMoves.add(currentPosition - sizeOfChessBoard - 2)
                //left up
                knightLegalMoves.add(currentPosition + sizeOfChessBoard - 2)
                //down left
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) - 1)
                //down right
                knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) + 1)
                //up left
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) - 1)
                //up right
                knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) + 1)
            }
        } else if (currentPosition % sizeOfChessBoard > 2 && currentPosition % sizeOfChessBoard < sizeOfChessBoard - 1 && currentPosition in sizeOfChessBoard.squared() - sizeOfChessBoard.timesTwo()..sizeOfChessBoard.squared()) {
            //down left
            knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) - 1)
            //down right
            knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) + 1)
            //left down
            knightLegalMoves.add(currentPosition - sizeOfChessBoard - 2)
            //left up
            knightLegalMoves.add(currentPosition + sizeOfChessBoard - 2)
            //right up
            knightLegalMoves.add(currentPosition + sizeOfChessBoard + 2)
            //right down
            knightLegalMoves.add(currentPosition - sizeOfChessBoard + 2)
        } else {
            //down left
            knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) - 1)
            //down right
            knightLegalMoves.add(currentPosition - (sizeOfChessBoard.timesTwo()) + 1)
            //left down
            knightLegalMoves.add(currentPosition - sizeOfChessBoard - 2)
            //left up
            knightLegalMoves.add(currentPosition + sizeOfChessBoard - 2)
            //up left
            knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) - 1)
            //up right
            knightLegalMoves.add(currentPosition + (sizeOfChessBoard.timesTwo()) + 1)
            //right up
            knightLegalMoves.add(currentPosition + sizeOfChessBoard + 2)
            //right down
            knightLegalMoves.add(currentPosition - sizeOfChessBoard + 2)
        }
    }
}

//Extension function int^2
fun Int.squared(): Int = this * this

//Extension function int * 2
fun Int.timesTwo(): Int = this * 2