//region hidden
@file:Suppress("UNUSED_VARIABLE", "RemoveRedundantBackticks", "unused", "JoinDeclarationAndAssignment")

package com.ataccama.example.factory
//endregion

fun <T : Product> moveProduct(from: ProductBox<out T>, to: ProductBox<in T>) {
    to.product = from.product
}

fun <T: Product> replaceProduct(box: ProductBox<in T>, newProduct: T) {
    box.product = newProduct
}

fun main() {
    val screwdrivers = mutableListOf(Screwdriver())
    val raceCars = mutableListOf(RaceCar())
    val list: MutableList<Product> = mutableListOf()
    list.addAll(raceCars)



    val screwdriverBox: ProductBox<Screwdriver> = ProductBox(Screwdriver())
    val toolBox = ProductBox<Tool>()

    moveProduct(screwdriverBox, toolBox)
    replaceProduct(screwdriverBox, Clamp())
    replaceProduct(toolBox, Clamp())
}
