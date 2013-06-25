package RSA;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author chesstrian
 */
public class GenerateRSAKeys {
    
  private BigInteger p,q; // Primes p and q.
  private BigInteger n,f; // n = p*q; f = phi(n) = (p-1)*(q-1).
  private BigInteger e,d; // gdc(e,f) = 1; d = e^-1 mod n.

  public BigInteger getP() {
    return this.p;
  }

  public BigInteger getQ() {
    return this.q;
  }
  
  public BigInteger getN() {
    return this.n;
  }

  public BigInteger getF() {
    return this.f;
  }

  public BigInteger getE() {
    return this.e;
  }

  public BigInteger getD() {
    return this.d;
  }

  public GenerateRSAKeys(int bits) {
    this.p = PrimeNumber.genPrime(bits);
    do
      this.q = PrimeNumber.genPrime(bits);
    while(this.q.compareTo(this.p) == 0);

    this.n = this.p.multiply(this.q);
    this.f = this.p.subtract(BigInteger.ONE).multiply(this.q.subtract(BigInteger.ONE));

    do
      this.e = new BigInteger(bits-4, new Random());
    while(this.e.compareTo(this.f) != -1 || this.e.gcd(this.f).compareTo(BigInteger.ONE) != 0);
    
    this.d = e.modInverse(this.f);
  }

  public GenerateRSAKeys(BigInteger p, BigInteger q) {
    this.p = p;
    this.q = q;
    
    this.n = this.p.multiply(this.q);
    this.f = this.p.subtract(BigInteger.ONE).multiply(this.q.subtract(BigInteger.ONE));
    
    do
      this.e = new BigInteger(15, new Random());
    while(this.e.compareTo(this.f) != -1 || this.e.gcd(this.f).compareTo(BigInteger.ONE) != 0);        
    
    this.d = e.modInverse(this.f);
  }

  public GenerateRSAKeys(BigInteger p, BigInteger q, BigInteger e) {
    this.p = p;
    this.q = q;
    
    this.e = e;
    
    this.n = this.p.multiply(this.q);
    this.f = this.p.subtract(BigInteger.ONE).multiply(this.q.subtract(BigInteger.ONE));
    
    this.d = e.modInverse(this.f);
  }
}
