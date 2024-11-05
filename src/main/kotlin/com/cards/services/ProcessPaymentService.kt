package com.cards.services

import com.cards.model.CreditCard

class ProcessPaymentService(private val creditCards: MutableList<CreditCard>) {

    fun processPayment(cardNumber: String, amount: Double) {
        val card = FindCardUtil().findCard(creditCards, cardNumber)
        card?.let {
            // Mostrar saldo inicial
            println("Saldo inicial de la tarjeta ${card.number}: ${card.balance}")

            // Primero calcula el interés
            val interest = it.IInterestStrategy.calculateInterest(it.balance)
            it.balance += interest
            println("Saldo después de agregar interés (${interest}): ${it.balance}")

            // Aplica el pago después de agregar los intereses
            it.balance -= amount
            println("Saldo después de aplicar el pago de ${amount}: ${it.balance}")

            // Acumula puntos de recompensa
            val points = it.IPointsStrategy.calculatePoints(amount)
            it.rewardPoints += points
            println("Puntos acumulados después del pago de ${amount}: ${it.rewardPoints}")

            // Aplica la penalización si es necesario
            val penalty = it.IPenaltyStrategy.applyPenalty(it.balance)
            println("Penalización aplicada: ${penalty}")
            it.balance += penalty

            // Mostrar saldo final
            println("Saldo final de la tarjeta ${card.number}: ${card.balance}")
        }
    }
}
