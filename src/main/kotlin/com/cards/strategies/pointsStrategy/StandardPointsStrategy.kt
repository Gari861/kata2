package com.cards.strategies.pointsStrategy

import com.cards.interfaces.IPointsStrategy

class StandardPointsStrategy : IPointsStrategy {
    override fun calculatePoints(amount: Double): Int {
        return (amount * 1).toInt()
    }
}
