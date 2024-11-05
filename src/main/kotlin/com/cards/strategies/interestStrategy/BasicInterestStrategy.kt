package com.cards.strategies.interestStrategy

import com.cards.interfaces.IInterestStrategy

class BasicInterestStrategy : IInterestStrategy {
    override fun calculateInterest(balance: Double): Double {
        return balance * 0.02
    }
}
