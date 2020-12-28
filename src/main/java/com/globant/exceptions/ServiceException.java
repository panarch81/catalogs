package com.globant.exceptions;

public class ServiceException extends RuntimeException {
  private int code;

  public ServiceException(int code, String message){
    super(message);
    this.code = code;
  }
}
