package br.com.alura.aluvery.model

import java.math.BigDecimal

class Product(
    val name: String,
    val price: BigDecimal,
    val image: String? = null,
    val description: String? = null
)
