package com.cards.controllers

import com.cards.services.CheckLimitService

class CheckLimitController(private val creditCardService: CheckLimitService) {

    fun checkLimit(cardNumber: String, amount: Double): Boolean {
        return creditCardService.isWithinLimit(cardNumber, amount)
    }
}
