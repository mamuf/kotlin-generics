//region hidden
@file:Suppress("UNUSED_VARIABLE", "RemoveRedundantBackticks")
package com.ataccama.example.factory
//endregion


fun main() {
    val packedRaceCar: ProductBox<RaceCar> = ProductBox(RaceCar())
    val packedToy: ProductBox<Toy> = packedRaceCar


    /*

    - generic types are invariant?
    - what the heck does that even mean?
    - what do you mean by "covariance" and "contravariance"?

     */
}
