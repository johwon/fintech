package com.zerobase.api.com.zerobase.api.loan.encrypt

import org.springframework.stereotype.Component
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

@Component
class EncryptComponent {
    companion object {
        private const val secretKey = "123456789012345678123456"
    }

    private val encoder = Base64.getEncoder()
    private val decoder = Base64.getDecoder()

    fun encryptString(encryptString: String) : String {

        val encryptString =
            cipherPkcs5(Cipher.ENCRYPT_MODE, secretKey)
                .doFinal(encryptString.toByteArray(Charsets.UTF_8))

        return String(encoder.encode(encryptString))

    }

    fun decryptString(decryptString: String) : String {

        val byteString = decoder.decode(decryptString.toByteArray(Charsets.UTF_8))

        return String(cipherPkcs5(Cipher.DECRYPT_MODE, secretKey).doFinal(byteString))

    }

    fun cipherPkcs5(opMode: Int, secretKey: String) : Cipher {

        val c = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val sk = SecretKeySpec(secretKey.toByteArray(Charsets.UTF_8), "AES")
        val iv = IvParameterSpec(secretKey.substring(0, 16).toByteArray(Charsets.UTF_8))
        c.init(opMode, sk, iv)
        return c

    }
}