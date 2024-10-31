@file:Suppress("RemoveRedundantBackticks", "unused", "UNUSED_PARAMETER", "UNCHECKED_CAST")

package com.ataccama.example.factory

import kotlin.random.Random

// input

interface Material

interface Metal : Material
class Steel : Metal
class Aluminium : Metal

interface Timber : Material
class OakTimber : Timber
class PineTimber : Timber

interface Plastic : Material
class HDPE : Plastic // jugs, pipes
class ABS : Plastic // tools, toys, computer peripherals

// output

interface Product

interface Toy : Product
class ActionFigure : Toy
class RaceCar : Toy
class DollHouse : Toy

interface Tool : Product
class Screwdriver : Tool
class Clamp : Tool

// packaging

/**
 * Box of things
 */
class ProductBox<T : Product>(var product: T? = null) : Product

fun <T : Product> randomProduct(material: Material): T =
    if (Random.nextBoolean()) randomTool(material) as T
    else randomToy(material) as T

fun <T : Tool> randomTool(material: Material = Steel()): T =
    if (Random.nextBoolean()) Screwdriver() as T
    else Clamp() as T

fun <T : Toy> randomToy(material: Material = ABS()): T =
    when (Random.nextInt(0, 3)) {
        0 -> ActionFigure()
        1 -> RaceCar()
        2 -> DollHouse()
        else -> error("wut")
    } as T
