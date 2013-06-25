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
        //GenerateRSAKeys Keys = new GenerateRSAKeys(BigInteger.valueOf(131), BigInteger.valueOf(157), e);
        
        //String cText = RSA.encryptString(mText, Claves.getE(), Claves.getN());
        //System.out.println("E y N : " + Claves.getE() + " ---- " + Claves.getN());
        /*int k = RSA.calculateK(n);
        System.out.println("k : " + k);
        System.out.println("E, D, N : " + e + " - " + d + " - " + n);
    
        mText = RSA.fillString(mText, k);
        
        //BigInteger numero = new BigInteger("3147");
        
        String[] Bloques = RSA.getBlocks(mText, k);
                
        
        //System.out.println("Longitud mText : " + mText.length());
        //System.out.println("Texto Encriptado : " + cText);
        //System.out.println("Longitud cText : " + cText.length());
        for(int i = 0; i < Bloques.length; i++) {
            BigInteger RSA1 = RSA.getValueforBlock(Bloques[i], n);
            BigInteger RSA2 = RSA.EncryptDecryptNumber(RSA1, e, n);
            String RSA3 = RSA.BigInteger2BaseN(RSA2, n, 0);
            BigInteger RSA4 = RSA.BaseN2BigInteger(RSA3);
            BigInteger RSA5 = RSA.EncryptDecryptNumber(RSA4,d, n);
            String RSA6 = RSA.BigInteger2BaseN(RSA5, n, 1);
            
            System.out.print("Bloque[" + i + "] = " + Bloques[i]);
            System.out.print(" : " + RSA1);
            System.out.print(" : " + RSA2);
            System.out.print(" : " + RSA3);
            System.out.print(" : " + RSA4);
            System.out.print(" : " + RSA5);
            System.out.println(" : " + RSA6);
        }*/
         
        System.out.println("Texto Plano : " + mText);
        System.out.println("Encriptado : " + RSA.encryptString(mText, e, n));
        System.out.println("Desencriptado : " + RSA.decryptString(RSA.encryptString(mText, e, n), d, n));
        
        ///////////////////////////////
        /*
        BigInteger a = new BigInteger("194307816642456112");
        BigInteger n = new BigInteger("3107700899197420607");
        System.out.println("a : " + a);
        System.out.println("BaseN : " + RSA.BigInteger2BaseN(a, n, 0));
        */
        ///////////////////////////////
        

        
        ///// Exponenciación Rápida o Binaria
/*        int base = 2;
        int exp = 23;
        
        String expbin = NTLibrary.int2bin(exp);
        int len = expbin.length();
        
        int bin;*/
        
        /*for(int i = 0; i < len; i++) {
            if(expbin.substring(i, i+1).equals("1")) {
                System.out.print(base + "^(2^" + (len - i - 1) + ")" );
                if(i < len - 1)
                    System.out.print("*");
            }
        }
        System.out.println("");*/
            
        
/*        System.out.println("Exponente: " + expbin);
        
        System.out.println("Con Math " + Math.pow(base, exp));*/
        ////////////////
    }    
}