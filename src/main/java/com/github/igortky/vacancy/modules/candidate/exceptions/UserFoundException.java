package com.github.igortky.vacancy.modules.candidate.exceptions;

public class UserFoundException extends RuntimeException{
  public UserFoundException() {
    super("User Already exists");
  }
}
