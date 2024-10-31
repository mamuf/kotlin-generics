//region hidden
@file:Suppress("UNUSED_VARIABLE", "RemoveRedundantBackticks", "unused")

package com.ataccama.example.factory
//endregion

/**
 * Generic output type.
 */
open class GenericToolFactory<T : Tool> {
    open fun makeFrom(material: Metal): T = randomTool(material)
}

fun main() {
    val clampFactory = GenericToolFactory<Clamp>()

    // makes Clamps instead of more generic Tools
    val steelClamp = clampFactory.makeFrom(Steel())
    val aluminiumClamp = clampFactory.makeFrom(Aluminium())

    // but cannot be assigned to a "more generic" generic type. Unless...
    val toolFactory: GenericToolFactory<Tool> = clampFactory
}
