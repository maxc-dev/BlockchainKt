package hash

import model.Block
import java.security.MessageDigest

class SHA256 : HashAlgorithm() {
    override fun hash(block: Block): String {
        return encode(block.toString())
    }

    /**
     * Verifies that the encoded proof ends in '0000'
     */
    override fun verify(previousProof: Long, proof: Long): Boolean {
        return encode("$previousProof$proof").endsWith("0000")
    }

    private fun encode(input: String): String {
        val hexChars = "0123456789ABCDEF"
        val bytes = MessageDigest
            .getInstance("SHA-256")
            .digest(input.toByteArray())
        val result = StringBuilder(bytes.size * 2)

        bytes.forEach {
            val i = it.toInt()
            result.append(hexChars[i shr 4 and 0x0f])
            result.append(hexChars[i and 0x0f])
        }

        return result.toString()
    }
}