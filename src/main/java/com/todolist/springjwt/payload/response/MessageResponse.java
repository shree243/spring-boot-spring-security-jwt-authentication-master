/**
 * @author Shreepad Kulkarni
 *
 * ${tags}
 */


// This class represents Message response Object which is output from server to client.

package com.todolist.springjwt.payload.response;

public class MessageResponse {
  private String message;

  public MessageResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
