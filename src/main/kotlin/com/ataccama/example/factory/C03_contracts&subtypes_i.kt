//region hidden
@file:Suppress("UNUSED_VARIABLE", "RemoveRedundantBackticks", "unused")
package com.ataccama.example.factory
//endregion

open class ScrewdriverFactory : ToolFactory() {
    /**
     * - _More specific_ class can have _more specific_ return type.
     * - *Subclass is **covariant** on return types*
     */
    override fun makeFrom(material: Metal): Screwdriver = Screwdriver()
}

fun main() {
    val factory = ScrewdriverFactory()

    val steelScrewdriver = factory.makeFrom(Steel())
    val aluminiumScrewdriver = factory.makeFrom(Aluminium())
    val absTool = factory.makeFrom(ABS())
    val clamp: Clamp = factory.makeFrom(Steel())
}

//region tool & toy
open class ToolAndToyFactory : ToolFactory() {
    /**
     * But we can't have a more generic output ¯\_(ツ)_/¯
     */
    override fun makeFrom(material: Metal): Product = randomProduct(material)
}
//endregion
