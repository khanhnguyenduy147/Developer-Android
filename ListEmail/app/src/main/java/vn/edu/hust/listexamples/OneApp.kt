package vn.edu.hust.listexamples

import kotlin.random.Random

data class OneApp (var name: String, val imageThumb: Int) {
    val rating: Int = Random.nextInt(0, 10)
}