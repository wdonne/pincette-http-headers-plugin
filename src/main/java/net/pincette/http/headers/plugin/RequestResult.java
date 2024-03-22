package net.pincette.http.headers.plugin;

import java.net.http.HttpHeaders;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

/**
 * The result that the plugin <code>request</code> method returns.
 *
 * @author Werner Donné
 */
public class RequestResult {

  /** If this is set then the request will be forwarded with the modified headers. */
  public final HttpHeaders request;

  /**
   * If this is set then the request will not be forwarded. Instead, this response is sent back
   * immediately to the sender of the request.
   */
  public final Response response;

  /**
   * If this is set it will be called with the result of the plugin <code>response</code> method.
   * Use it to transfer data from the plugin <code>request</code> method to the plugin <code>
   * response</code> method.
   */
  public final Function<HttpHeaders, CompletionStage<HttpHeaders>> responseWrapper;

  public RequestResult() {
    this(null, null, null);
  }

  private RequestResult(
      final HttpHeaders request,
      final Response response,
      final Function<HttpHeaders, CompletionStage<HttpHeaders>> responseWrapper) {
    this.request = request;
    this.response = response;
    this.responseWrapper = responseWrapper;
  }

  public String toString() {
    return (request != null ? ("request: " + request + "\n") : "")
        + (response != null ? ("response: " + response) : "");
  }

  public RequestResult withRequest(final HttpHeaders request) {
    return new RequestResult(request, response, responseWrapper);
  }

  public RequestResult withResponse(final Response response) {
    return new RequestResult(request, response, responseWrapper);
  }

  public RequestResult withResponseWrapper(
      final Function<HttpHeaders, CompletionStage<HttpHeaders>> responseWrapper) {
    return new RequestResult(request, response, responseWrapper);
  }
}
