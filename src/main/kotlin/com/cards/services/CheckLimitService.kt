package com.cards.services

import com.cards.model.CreditCard

class CheckLimitService(private val creditCards: MutableList<CreditCard>) {

    fun isWithinLimit(cardNumber: String, amount: Double): Boolean {
        val card = FindCardUtil().findCard(creditCards, cardNumber)
        return card?.let { amount <= it.creditLimit - it.balance } ?: false
    }
}
