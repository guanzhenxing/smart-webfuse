package cn.webfuse.framework.tool;


import com.vip.vjtools.vjkit.base.ExceptionUtil;
import com.vip.vjtools.vjkit.security.CryptoUtil;
import com.vip.vjtools.vjkit.text.EncodeUtil;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 继承了vjtools的CryptoUtil
 */
public class CryptoTools extends CryptoUtil {
    /**
     * encryptHMac256 加密
     *
     * @param content
     * @param key
     * @return
     */
    public static byte[] encryptHMac256(String content, String key) {

        String hmacSHA256 = "HmacSHA256";
        try {
            if (key == null || content == null) {
                throw new NullPointerException();
            }
            final Mac hMacSHA256 = Mac.getInstance(hmacSHA256);
            byte[] hmacKeyBytes = key.getBytes(StandardCharsets.UTF_8);
            final SecretKeySpec secretKey = new SecretKeySpec(hmacKeyBytes, hmacSHA256);
            hMacSHA256.init(secretKey);
            byte[] dataBytes = content.getBytes(StandardCharsets.UTF_8);
            return hMacSHA256.doFinal(dataBytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw ExceptionUtil.unchecked(e);
        }
    }


}
