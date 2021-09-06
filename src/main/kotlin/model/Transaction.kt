package model

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

data class Transaction(val sender: String, val recipient: String, val value: Double) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}
