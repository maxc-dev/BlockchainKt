import blockchain.Blockchain
import hash.SHA256
import validators.ProofOfWork
import validators.verification.Suffix4Zeroes

fun main() {
    val hashAlgorithm = SHA256(Suffix4Zeroes())
    val proofOfWork = ProofOfWork(hashAlgorithm)
    val blockchain = Blockchain(proofOfWork, hashAlgorithm)
}