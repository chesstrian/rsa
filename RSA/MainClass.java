package RSA;

import java.math.BigInteger;

/**
 *
 * @author chesstrian
 */
public class MainClass {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
      
    String mText = "La casa del Laberinto ubicada en la colina es imposible de encontrar";
    GenerateRSAKeys Claves = new GenerateRSAKeys(31);
    BigInteger e = Claves.getE();
    BigInteger d = Claves.getD();
    BigInteger n = Claves.getN();
     
    System.out.println("Texto Plano : " + mText);
    System.out.println("Encriptado : " + RSA.encryptString(mText, e, n));
    System.out.println("Desencriptado : " + RSA.decryptString(RSA.encryptString(mText, e, n), d, n));
  }
}
