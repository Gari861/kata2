package com.cards.services

import com.cards.model.CreditCard

class FindCardUtil {
    fun findCard(creditCards: MutableList<CreditCard>, cardNumber: String): CreditCard? {
        return creditCards.find { it.number == cardNumber } ?: throw IllegalArgumentException("Tarjeta no encontrada: $cardNumber")
    }
}
