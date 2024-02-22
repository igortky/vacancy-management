package com.github.igortky.vacancy.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String name;

  @Pattern(regexp = "^\\S+", message = "Field [username] must not contain empty space")
  private String username;

  @Length(min = 10, max = 100, message = "password lentgh must be between 10 and 100 characteres")
  private String password;

  private String description;

  @NotBlank
  @Email(message = "Field [email] must contain valid email")
  private String email;
  private String curriculum;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
