package hash

import model.Block
import validators.verification.VerificationRule

abstract class HashAlgorithm(private val verificationRule: VerificationRule) {
    fun verify(previousProof: Long, proof: Long): Boolean {
        return verificationRule.verify(this, previousProof, proof)
    }

    abstract fun hash(block: Block): String

    abstract fun encode(input: String): String
}