package com.cards.interfaces

interface IPenaltyStrategy {
    fun applyPenalty(balance: Double): Double
}
