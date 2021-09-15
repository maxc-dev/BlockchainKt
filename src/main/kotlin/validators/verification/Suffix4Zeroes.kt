package validators.verification

import hash.HashAlgorithm

class Suffix4Zeroes : VerificationRule() {
    override fun verify(algorithm: HashAlgorithm, previousProof: Long, proof: Long): Boolean =
        algorithm.encode("$previousProof$proof").endsWith("0000")

}