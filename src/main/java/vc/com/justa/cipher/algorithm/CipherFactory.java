package vc.com.justa.cipher.algorithm;

import vc.com.justa.cipher.ICipher;

/**
 * Factory method pattern to generate {@link ICipher} implementations to encrypt or decrypt some data.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Factory_method_pattern">Factory Pattern</a>
 * @see <a href="https://justapagamentos.atlassian.net/wiki/spaces/TEC/pages/199720961/Design+Patterns#Factory">If you are partner of Justa.</a>
 */
public class CipherFactory {

    /**
     * Synchronized helper locker to avoid parallelism.
     */
    private static final String LOCK = "CipherFactory::LOCK";

    /**
     * Singleton factory instance.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Singleton_pattern">The Singleton Pattern</a>
     */
    private static CipherFactory INSTANCE;

    /**
     * Algorithms.
     */
    public enum Algorithm {
        AES
    }

    private CipherFactory() {
    }

    /**
     * Get factory instance.
     *
     * @return Factory instance.
     */
    public static CipherFactory getInstance() {
        synchronized (LOCK) {
            if (INSTANCE == null)
                INSTANCE = new CipherFactory();

            return INSTANCE;
        }
    }

    /**
     * Get {@link ICipher} implement based on an {@link Algorithm}.
     *
     * @param algorithm Algorithm implementation.
     * @return Cipher implementation.
     */
    public ICipher get(Algorithm algorithm) {
        if (algorithm == Algorithm.AES) {
            return new AESCipher();
        }
        return null;
    }

}
