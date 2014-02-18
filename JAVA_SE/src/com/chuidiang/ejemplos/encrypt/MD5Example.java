package com.chuidiang.ejemplos.encrypt;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

/**
 * Ejemplo para extraer MD5 de una cadena de texto. Como los bytes obtenidos no
 * son legibles, los escribimos tal cual, en hexadecimal y codificado base 64
 * con ayuda de la librer�a apache commons-codec.
 * 
 * @author Chuidiang
 * 
 */
public class MD5Example {
   public static void main(String[] args) throws Exception {

      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update("texto a cifrar".getBytes());
      byte[] digest = md.digest();

      // Se escribe tal cual
      System.out.println(digest);

      // Se escribe byte a byte en hexadecimal
      for (byte b : digest) {
         System.out.print(Integer.toHexString(0xFF & b));
      }
      System.out.println();

      // Se escribe codificado base 64. Se necesita la librer�a
      // commons-codec-x.x.x.jar de Apache
      byte[] encoded = Base64.encodeBase64(digest);
      System.out.println(new String(encoded));
   }
}