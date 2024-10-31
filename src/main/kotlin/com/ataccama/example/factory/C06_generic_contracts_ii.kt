//region hidden
@file:Suppress("UNUSED_VARIABLE", "RemoveRedundantBackticks", "unused")

package com.ataccama.example.factory
//endregion

/**
 * Generic input type.
 */
open class GenericMaterialFactory<M : Material> {
    open fun makeFrom(material: M): Tool = randomTool(material)
}

fun main() {
    val metalToolFactory = GenericMaterialFactory<Metal>()

    // can make tools from any kind of Metal
    val aluminiumTool = metalToolFactory.makeFrom(Aluminium())
    val steelTool = metalToolFactory.makeFrom(Steel())

    // but cannot be assigned to a "more specific" generic type. Unless...
    val steelToolFactory: GenericMaterialFactory<Material> = metalToolFactory
}
