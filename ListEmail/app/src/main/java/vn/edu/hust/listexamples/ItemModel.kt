package vn.edu.hust.listexamples

import kotlin.random.Random

data class ItemModel(var caption: String, val imageThumb: Int, val imageLarge: Int = 0) {
    var selected: Boolean = false
    val rating: Int = Random.nextInt(0, 10)
}
