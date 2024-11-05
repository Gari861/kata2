package com.cards.controllers

import com.cards.services.ProcessPaymentService

class MakePaymentController(private val creditCardService:ProcessPaymentService) {

    fun makePayment(cardNumber: String, amount: Double) {
        creditCardService.processPayment(cardNumber, amount)
    }
}
