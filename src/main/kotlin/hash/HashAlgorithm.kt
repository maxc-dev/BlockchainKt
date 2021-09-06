package hash

import model.Block

abstract class HashAlgorithm {
    abstract fun hash(block: Block): String

    abstract fun verify(previousProof: Long, proof: Long): Boolean
}