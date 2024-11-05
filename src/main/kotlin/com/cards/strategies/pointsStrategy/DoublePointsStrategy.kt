package com.cards.strategies.pointsStrategy

import com.cards.interfaces.IPointsStrategy

class DoublePointsStrategy : IPointsStrategy {
    override fun calculatePoints(amount: Double): Int {
        return (amount * 2).toInt()
    }
}
