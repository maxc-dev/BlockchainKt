package validators

import hash.HashAlgorithm

class ProofOfWork(hashAlgorithm: HashAlgorithm) : Validator(hashAlgorithm) {
    override fun execute(lastProof: Long): Long {
        var proof: Long = 0
        while (!hashAlgorithm.verify(lastProof, proof)) {
            proof += 1
        }
        return proof
    }
}