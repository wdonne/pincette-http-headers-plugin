package net.pincette.http.headers.plugin;

import java.net.http.HttpHeaders;

/**
 * A response that is returned immediately to the sender of the request.
 *
 * @author Werner Donné
 */
public class Response {
  public final HttpHeaders headers;
  public final int statusCode;

  public Response() {
    this(null, -1);
  }

  private Response(final HttpHeaders headers, final int statusCode) {
    this.headers = headers;
    this.statusCode = statusCode;
  }

  public String toString() {
    return "headers: " + headers + "\nstatusCode: " + statusCode;
  }

  public Response withHeaders(final HttpHeaders headers) {
    return new Response(headers, statusCode);
  }

  public Response withStatusCode(final int statusCode) {
    return new Response(headers, statusCode);
  }
}
