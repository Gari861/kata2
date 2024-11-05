package com.cards.model

import com.cards.interfaces.IPointsStrategy
import com.cards.interfaces.IPenaltyStrategy
import com.cards.interfaces.IInterestStrategy

data class CreditCard(
    val number: String,
    var creditLimit: Double,
    var balance: Double = 0.0,
    var rewardPoints: Int = 0,
    val IInterestStrategy: IInterestStrategy,
    val IPointsStrategy: IPointsStrategy,
    val IPenaltyStrategy: IPenaltyStrategy
)
