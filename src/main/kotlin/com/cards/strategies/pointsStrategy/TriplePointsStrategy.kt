package com.cards.strategies.pointsStrategy

import com.cards.interfaces.IPointsStrategy

class TriplePointsStrategy : IPointsStrategy {
    override fun calculatePoints(amount: Double): Int {
        return (amount * 3).toInt()
    }
}
