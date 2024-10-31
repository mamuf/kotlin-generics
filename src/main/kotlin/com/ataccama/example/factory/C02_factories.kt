//region hidden
@file:Suppress("UNUSED_VARIABLE", "RemoveRedundantBackticks", "unused")

package com.ataccama.example.factory
//endregion

open class ToolFactory {
    open fun makeFrom(material: Metal): Tool = randomTool(material)

    //region hidden
    open val makeFromField: (material: Metal) -> Tool
        get() = { randomTool(it) }
    //endregion
}

fun main() {
    val factory = ToolFactory()

    val steelTool = factory.makeFrom(Steel())
    val aluminiumTool = factory.makeFrom(Aluminium())
    val absTool = factory.makeFrom(ABS())
    val clamp: Clamp = factory.makeFrom(Steel())
}

