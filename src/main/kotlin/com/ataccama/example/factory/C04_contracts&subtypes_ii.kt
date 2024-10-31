//region hidden
@file:Suppress("UNUSED_VARIABLE", "RemoveRedundantBackticks", "unused")

package com.ataccama.example.factory
//endregion

open class AnyMaterialToolFactory : ToolFactory() {
    /**
     * - We could have a _more generic_ input in a _more specific_ class.
     * - *Subclass is **contravariant** on input types.*
     *
     * A more generic input not possible because of overloading.
     */
    override fun makeFrom(material: Material): Tool = randomTool(material)

    //region unless...
    /**
     * It works with fields of function type, tho...
     *
     * **DO NOT TRY THIS AT HOME** (it's weird ¯\_(ツ)_/¯)
     */
    override val makeFromField: (material: Material) -> Tool = { randomTool(it) }
    //endregion
}

fun main() {
    val factory = AnyMaterialToolFactory()

    val aluminiumTool = factory.makeFrom(Aluminium())
    val oakTool = factory.makeFromField(OakTimber())
}

//region just steel?
open class SteelToolFactory : ToolFactory() {
    /**
     * It works with fields of function type, tho...
     *
     * **DO NOT TRY THIS AT HOME** (it's weird ¯\_(ツ)_/¯)
     */
    override val makeFromField: (material: Steel) -> Tool = { randomTool(it) }
}
//endregion
