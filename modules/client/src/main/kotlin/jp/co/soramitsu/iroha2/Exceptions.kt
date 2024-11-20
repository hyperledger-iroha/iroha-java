package jp.co.soramitsu.iroha2

import io.ktor.http.HttpStatusCode

/**
 * Throw if query payload can not be extracted
 */
class QueryPayloadExtractionException(message: String? = null, cause: Throwable? = null) : IrohaSdkException(message, cause)

/**
 * Throw if there is an unexpected state during WebSocket interaction
 */
class WebSocketProtocolException(message: String? = null, cause: Throwable? = null) : IrohaSdkException(message, cause)

/**
 * Throw if a peer is not available or status code not 2xx
 */
class IrohaClientException(
    message: String? = null,
    cause: Throwable? = null,
    val status: HttpStatusCode? = null,
) : IrohaSdkException(message, cause)

/**
 * Throw if a transaction was rejected by a peer
 */
class TransactionRejectedException(message: String? = null, cause: Throwable? = null) : IrohaSdkException(message, cause)

/**
 * Throw if there is an exception related to cryptography
 */
class CryptoException(message: String? = null, cause: Throwable? = null) : IrohaSdkException(message, cause)

/**
 * Throw if there is an exception during hex encoding/decoding
 */
class HexCodecException(message: String? = null, cause: Throwable? = null) : IrohaSdkException(message, cause)
