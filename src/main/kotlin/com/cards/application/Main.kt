package com.cards.application

import com.cards.strategies.penaltyStrategy.InterestPenaltyStrategy
import com.cards.model.CreditCard
import com.cards.strategies.interestStrategy.BasicInterestStrategy
import com.cards.strategies.penaltyStrategy.FixedPenaltyStrategy
import com.cards.strategies.pointsStrategy.DoublePointsStrategy
import com.cards.strategies.interestStrategy.PremiumInterestStrategy
import com.cards.strategies.pointsStrategy.StandardPointsStrategy
import com.cards.strategies.pointsStrategy.TriplePointsStrategy
import com.cards.services.ProcessPaymentService
import com.cards.services.FindCardUtil
import com.cards.services.CheckLimitService
import com.cards.controllers.CheckLimitController
import com.cards.controllers.MakePaymentController

fun main() {
    val creditCards = mutableListOf<CreditCard>()

    val processPaymentService = ProcessPaymentService(creditCards)
    val checkLimitService = CheckLimitService(creditCards)

    val makePaymentController = MakePaymentController(processPaymentService)
    val checkLimitController = CheckLimitController(checkLimitService)

    // Agregar tarjetas de ejemplo
    val card1 = CreditCard("1234", 1000.0, 1000.0, 0, BasicInterestStrategy(), StandardPointsStrategy(), FixedPenaltyStrategy())
    val card2 = CreditCard("5678", 5000.0, 0.0, 0, PremiumInterestStrategy(), DoublePointsStrategy(), InterestPenaltyStrategy())
    val card3 = CreditCard("9012", 3000.0, 500.0, 0, BasicInterestStrategy(), TriplePointsStrategy(), FixedPenaltyStrategy())
    val card4 = CreditCard("3456", 2000.0, 500.0, 0, BasicInterestStrategy(), StandardPointsStrategy(), FixedPenaltyStrategy())
    val card5 = CreditCard("7890", 4000.0, 1500.0, 0, PremiumInterestStrategy(), TriplePointsStrategy(), InterestPenaltyStrategy())

    // Agregar las tarjetas a la lista
    creditCards.add(card1)
    creditCards.add(card2)
    creditCards.add(card3)
    creditCards.add(card4)
    creditCards.add(card5)

    // Ejemplo de uso con diferentes tarjetas y acumulación de puntos
    makePaymentController.makePayment("1234", 150.0)
    makePaymentController.makePayment("5678", 250.0)
    makePaymentController.makePayment("9012", 300.0)
    makePaymentController.makePayment("3456", 200.0)
    makePaymentController.makePayment("7890", 350.0)

    val withinLimit1 = checkLimitController.checkLimit("1234", 200.0)
    val withinLimit2 = checkLimitController.checkLimit("5678", 4500.0)
    val withinLimit3 = checkLimitController.checkLimit("9012", 100.0)
    val withinLimit4 = checkLimitController.checkLimit("3456", 1500.0)
    val withinLimit5 = checkLimitController.checkLimit("7890", 2500.0)

    println("Tarjeta 1234: ¿Dentro del límite? $withinLimit1")
    println("Tarjeta 5678: ¿Dentro del límite? $withinLimit2")
    println("Tarjeta 9012: ¿Dentro del límite? $withinLimit3")
    println("Tarjeta 3456: ¿Dentro del límite? $withinLimit4")
    println("Tarjeta 7890: ¿Dentro del límite? $withinLimit5")

    // Mostrar información de cada tarjeta incluyendo puntos de recompensa
    creditCards.forEach { card ->
        println("Tarjeta ${card.number}:")
        println("  Límite de crédito: ${card.creditLimit}")
        println("  Saldo: ${card.balance}")
        println("  Puntos de recompensa: ${card.rewardPoints}")
    }
}
