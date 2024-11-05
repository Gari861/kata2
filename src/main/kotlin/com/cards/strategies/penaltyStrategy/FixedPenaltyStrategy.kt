package com.cards.strategies.penaltyStrategy

import com.cards.interfaces.IPenaltyStrategy

class FixedPenaltyStrategy : IPenaltyStrategy {
    override fun applyPenalty(balance: Double): Double {
        // Si el balance es negativo, aplicar una penalización fija en lugar de la penalización estándar
        return if (balance < 0) balance - 25 else balance + 25
    }
}
