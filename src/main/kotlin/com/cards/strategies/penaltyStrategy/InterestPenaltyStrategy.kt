package com.cards.strategies.penaltyStrategy

import com.cards.interfaces.IPenaltyStrategy

class InterestPenaltyStrategy : IPenaltyStrategy {
    override fun applyPenalty(balance: Double): Double {
        // Si el balance es negativo, aplicar una penalización fija en lugar del interés
        return if (balance < 0) balance - 25 else balance * 1.05
    }
}
