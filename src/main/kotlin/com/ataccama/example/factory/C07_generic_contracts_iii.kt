//region hidden
@file:Suppress(
    "UNUSED_VARIABLE", "RemoveRedundantBackticks", "unused",
    "JoinDeclarationAndAssignment", "UNUSED_PARAMETER"
)

package com.ataccama.example.factory
//endregion

/**
 * Generic types for both input and output.
 */
open class GenericFactory<in M : Material, out T : Product> {
    open fun makeFrom(material: M): T = randomTool(material)

    fun melt(tool: T): M {
        error("does not compute")
    }

    //region hidden
    fun maintain() = println("all tuned and fixed!")
    //endregion
}

fun main() {
    val metalToolFactory = GenericFactory<Metal, Tool>()

    val steelProductFactory: GenericFactory<Steel, Product> = metalToolFactory
}
