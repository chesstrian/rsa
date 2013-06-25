package RSA;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author chesstrian
 */
public class PrimeNumber{
    public static BigInteger genPrime(int bits) {
        BigInteger prime;
        
        do
            prime = new BigInteger(bits, 10, new Random());
        while(!PrimeNumber.isPrime(prime));
        
        return prime;
    }
    
    public static boolean isPrime(int n) {
        if(n == 2) return true;
        else if(n % 2 == 0) return false;
        
        for(int i = 3; i*i <= n; i+=2)
            if(n % i == 0)
                return false;
        
        return true;
    }
    
    public static boolean isPrime(BigInteger n) {
        long aux = n.longValue();
        if(aux == 2) return true;
        else if(aux % 2 == 0) return false;
        
        for(int i = 3; i*i <= aux; i+=2)
            if(aux % i == 0)
                return false;
        
        return true;
    }
}
