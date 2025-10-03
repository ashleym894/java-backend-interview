package com.synchrony.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
@EnableAspectJAutoProxy
public class Run {
  public static void main(String[] args) {
    SpringApplication.run(Run.class, args);
  }
}