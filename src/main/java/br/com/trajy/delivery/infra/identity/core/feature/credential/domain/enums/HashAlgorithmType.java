package br.com.trajy.delivery.infra.identity.core.feature.credential.domain.enums;

public enum HashAlgorithmType {

    /**
     * BCrypt Password Hashing Function.
     */
    BCRYPT,

    /**
     * Argon2id - Recommended variant for password hashing.
     */
    ARGON2ID,

    /**
     * Argon2i - Optimized against side-channel attacks.
     */
    ARGON2I,

    /**
     * Argon2d - Optimized against GPU attacks.
     */
    ARGON2D,

    /**
     * SCrypt Password Hashing Function.
     */
    SCRYPT,

    /**
     * PBKDF2 (Password-Based Key Derivation Function 2).
     */
    PBKDF2


}
