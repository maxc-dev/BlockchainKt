package validators.verification

import hash.HashAlgorithm

abstract class VerificationRule {
    abstract fun verify(algorithm: HashAlgorithm, previousProof: Long, proof: Long): Boolean
}