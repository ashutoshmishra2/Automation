package utils;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.aspectj.weaver.NewMethodTypeMunger;


public class CryptNNG {

	public static String md5(String plaintext) throws Exception{
		//Creating and Initializing a md5 message digest instance.
		MessageDigest m = MessageDigest.getInstance("MD5");
		//Reset initial digest, if any.
		m.reset();
		//Updating the digest with the provided string PLAIN_TEXT.
		m.update(plaintext.getBytes());
		//getting bytes of this digest message.
		byte[] digest = m.digest();
		BigInteger a = new BigInteger(1, digest);
		System.out.println("Big Integer HC >>>>>>>" + String.valueOf((a.hashCode())) );
		BigInteger bigInt = new BigInteger(1,digest);
		String hashtext = bigInt.toString(16);
		 
		// Now we need to zero pad it if you actually want the full 32 chars.
		while(hashtext.length() < 32 ){
			hashtext = "0"+hashtext;
		}
		return hashtext;
	}
	
	
}
