package validators

import hash.HashAlgorithm

abstract class Validator(protected val hashAlgorithm: HashAlgorithm) {
    abstract fun execute(lastProof: Long): Long
}