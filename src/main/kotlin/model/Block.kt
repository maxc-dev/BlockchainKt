package model

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.time.Instant

data class Block(val index: Int, val timestamp: Instant, val transaction: List<Transaction>, val proof: Long, val previousHash: String) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}
