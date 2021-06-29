import crypto.SHA256;

import java.security.NoSuchAlgorithmException;

import MerkleTree.MerkleNode;

public class Transaction extends MerkleNode {
    // private double amount;

    public Transaction(String hash) throws IllegalArgumentException {
        // this.amount = 0;
        this.hash = hash;
    }

    @Override
    public String hash() {
        return hash;
    }
    
    public static void main(String[] args) throws IllegalArgumentException, NoSuchAlgorithmException, Exception {
        Transaction tx = new Transaction(SHA256.hash("hello"));
        System.out.println(SHA256.hash("hello"));
        System.out.println(tx.hash());
    }
}
