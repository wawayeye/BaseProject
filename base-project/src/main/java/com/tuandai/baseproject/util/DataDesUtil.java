package com.tuandai.baseproject.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class DataDesUtil {
    /**
     *  （ETL 数据加密）
     * AES-CBC加密
     *
     * @param sSrc:        密文
     * @param sKey:        密钥
     * @param ivParameter: iv矢量
     * @return
     * @throws Exception
     */
    private static String encrypt(String sSrc, String sKey, String ivParameter) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(StandardCharsets.UTF_8));
        String encodeBase64 = new BASE64Encoder().encode(encrypted);
        encodeBase64.replace("\n", "");
        encodeBase64.replace("\r", "");
        return encodeBase64;
    }

    /**
     * AES-CBC解密
     *
     * @param sSrc:        密文
     * @param sKey:        密钥
     * @param ivParameter: iv矢量
     * @return
     * @throws Exception
     */
    private static String decrypt(String sSrc, String sKey, String ivParameter) {
        try {
            byte[] raw = sKey.getBytes(StandardCharsets.US_ASCII);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, StandardCharsets.UTF_8);
            return originalString;
        } catch (Exception ex) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        String cSrc = "{\"begin_time\":\"2016-09-13T19:06:00+08:00\",\"end_time\":\"2016-10-29T19:06:00+08:00\",\"name\":\"testExam\",\"score\":[{\"score\":\"0\",\"qid\":\"1\"}],\"questions\":[{\"name\":\"A+B\",\"qid\":\"1\"}],\"eid\":\"1\"}";
        String sKey = "e10adc3949ba59ab";
        String ivParameter = "e10adc3949ba59ab";
        // 加密
        String enString = encrypt(cSrc, sKey, ivParameter);
        // 解密
        String DeString = decrypt(enString, sKey, ivParameter);
        System.out.println("明文: " + cSrc);
        System.out.println("密钥: " + sKey);
        System.out.println("密文: " + enString);
        System.out.println("解密: " + DeString);
    }
}
