//region hidden
@file:Suppress("RemoveRedundantBackticks", "unused", "JoinDeclarationAndAssignment")

package com.ataccama.example.factory
//endregion

fun service(factory: GenericFactory<*, *>) {
    factory.maintain()
}

fun main() {
    val metalToolFactory = GenericFactory<Metal, Tool>()
    val woodenToyFactory = GenericFactory<Timber, Toy>()

    service(metalToolFactory)
    service(woodenToyFactory)
}
