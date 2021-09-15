package blockchain

import hash.HashAlgorithm
import model.Block
import model.Transaction
import validators.Validator
import java.time.Instant

const val INITIAL_BLOCK_PROOF: Long = -1
const val INITIAL_BLOCK_PREVIOUS_HASH = "blockchainkt"

class Blockchain(private val validator: Validator, private val hashAlgorithm: HashAlgorithm) {
    private val chain: ArrayList<Block> = ArrayList()
    private val transactions: ArrayList<Transaction> = ArrayList()

    init {
        createBlock(INITIAL_BLOCK_PROOF, INITIAL_BLOCK_PREVIOUS_HASH)
    }

    fun createBlock(proof: Long, previousHash: String): Block {
        val block = Block(getNextBlockIndex(), Instant.now(), transactions.toList(), proof, previousHash)
        transactions.clear()
        chain.add(block)
        return block
    }

    fun createTransaction(sender: String, recipient: String, value: Double): Int {
        transactions.add(Transaction(sender, recipient, value))
        return getNextBlockIndex()
    }

    fun hashBlock(block: Block): String {
        return hashAlgorithm.hash(block)
    }

    fun getLastBlock(): Block? {
        if (chain.isEmpty()) {
            return null
        }
        return chain.last()
    }

    fun getNextBlockIndex(): Int {
        if (chain.isEmpty()) {
            return 0
        }
        return chain.lastIndex + 1
    }
}