package net.pincette.http.headers.plugin;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.concurrent.CompletionStage;

/**
 * Implement this interface in a module if you want to add extensions to the JSON HTTP Headers
 * runtime.
 *
 * @author Werner Donné
 */
public interface Plugin {
  /**
   * @param headers the request headers.
   * @return The data that indicates what should happen with the request.
   */
  CompletionStage<RequestResult> request(HttpHeaders headers);

  /**
   * @param headers the request headers.
   * @param uri the request URI.
   * @return The data that indicates what should happen with the request.
   * @since 1.1.0
   */
  default CompletionStage<RequestResult> request(HttpHeaders headers, URI uri) {
    return request(headers);
  }

  /**
   * @param headers the response headers.
   * @return The modified response headers.
   */
  CompletionStage<HttpHeaders> response(HttpHeaders headers);
}
