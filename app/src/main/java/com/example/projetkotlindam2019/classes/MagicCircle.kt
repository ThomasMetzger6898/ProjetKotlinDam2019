package com.example.projetkotlindam2019.classes

import kotlin.random.Random


data class MagicCircle(val maxX:Int ,val maxY:Int) {
    var spawnX: Float = 0 +  Random.nextFloat() * (maxX)
    var spawnY: Float = 0 +  Random.nextFloat() * (maxY)

    var rad: Float= 40F

    var dx = CustomView.DELTA
    var dy = CustomView.DELTA

    fun move() {
        when {
            spawnX !in 0 .. maxX -> dx = -dx
            spawnY !in 0 .. maxY -> dy = -dy
        }
        spawnX += dx
        spawnY += dy
    }
}