package RSA;

import java.math.BigInteger;

/**
*
* @author chesstrian
*/
public class RSA {
  
  private static String chars = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  
  public static BigInteger EncryptDecryptNumber(BigInteger Text, BigInteger ed, BigInteger n) {
    return Text.modPow(ed, n);
  }
      
  public static String encryptBlock(String mBlock, BigInteger e, BigInteger n) {
    BigInteger sum = RSA.getValueforBlock(mBlock, n);
    return RSA.BigInteger2BaseN(sum.modPow(e, n), n, 0);
  }
  
  public static String decryptBlock(String mBlock, BigInteger d, BigInteger n) {
    BigInteger sum = RSA.BaseN2BigInteger(mBlock);
     return RSA.BigInteger2BaseN(sum.modPow(d, n), n, 1);
  }
  
  public static BigInteger getValueforBlock(String mBlock, BigInteger n) {
    int k = RSA.calculateK(n);
    BigInteger N;
    N= BigInteger.valueOf(chars.length());
    
    Long auxLong;
    BigInteger prod;
    BigInteger sum = BigInteger.ZERO;
    
    for(int i = 0; i < k; i++) {
      auxLong = (long)chars.indexOf(mBlock.charAt(i));
      prod = BigInteger.valueOf(auxLong).multiply(N.pow(k-i-1));
      sum = sum.add(prod);
    }
    
    return sum;
  }
  
  public static String BigInteger2BaseN(BigInteger a, BigInteger n, int op) {
    BigInteger N;
    N = BigInteger.valueOf(chars.length());
    int k = RSA.calculateK(n);
    
    if(a.compareTo(N) == -1) {
      Integer auxInteger = new Integer(a.toString());
      return chars.substring(auxInteger, auxInteger+1);
    }
    
    String auxString = "";
    BigInteger Module;
    BigInteger Cocient = new BigInteger(a.toString());
                    
    do {
      Module = Cocient.mod(N);
      Cocient = Cocient.divide(N);
      
      auxString = auxString.concat(chars.substring(Module.intValue(), Module.intValue()+1));
    }while(Cocient.compareTo(N) >= 0);

    auxString = auxString.concat(chars.substring(Cocient.intValue(), Cocient.intValue()+1));
    
    while(op == 0 && auxString.length() < k+1)
      auxString = auxString.concat(chars.substring(0,1));
    while(op == 1 && auxString.length() < k)
      auxString = auxString.concat(chars.substring(0,1));
    
    String result = new StringBuffer(auxString).reverse().toString();
    
    return result;
  }
  
  public static BigInteger BaseN2BigInteger(String number) {
    BigInteger N;
    N = BigInteger.valueOf(chars.length());
    int len = number.length();
    
    Long auxLong;
    BigInteger prod;
    BigInteger sum = BigInteger.ZERO;
    
    for(int i = 0; i < len; i++) {
      auxLong = (long)chars.indexOf(number.charAt(i));
      prod = BigInteger.valueOf(auxLong).multiply(N.pow(len-i-1));
      sum = sum.add(prod);
    }
    
    return sum;
  }
  
  public static String[] getBlocks(String Text, int k) {
    int ind = 0;
    String[] Blocks = new String[Text.length() / k];
        
    for(int i = 0; i < Text.length(); i += k)
      Blocks[ind++] = Text.substring(i, i + k);
    
    return Blocks;
  }
  
  public static String encryptString(String Text, BigInteger e, BigInteger n) {
    int k = RSA.calculateK(n);
    Text = RSA.fillString(Text, k);
    String[] auxString = RSA.getBlocks(Text, k);
    String result = "";

    for(int i = 0; i < auxString.length; i++)
      result = result.concat(RSA.encryptBlock(auxString[i], e, n));
    
    return result;
  }
  
  public static String decryptString(String Text, BigInteger d, BigInteger n) {
    int k = RSA.calculateK(n);
    Text = RSA.fillString(Text, k+1);
    String[] auxString = RSA.getBlocks(Text, k+1);
    String result = "";

    for(int i = 0; i < auxString.length; i++)
      result = result.concat(RSA.decryptBlock(auxString[i], d, n));
    
    return result;
  }
  
  public static String fillString(String Text, int k) {
    int Fill = Text.length() % k;
    
    if(Fill == 0) return Text;
    
    int spaces = k - Fill;
    for(int i = 0; i < spaces; i++)
      Text = Text.concat(" ");
    
    return Text;
  }
  
  public static int calculateK(BigInteger n) {
    return (int)Math.floor(Math.log(n.longValue())/Math.log(chars.length()));
  }  
}
