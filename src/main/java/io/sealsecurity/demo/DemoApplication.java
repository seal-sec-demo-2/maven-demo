package io.sealsecurity.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Seal Security Maven Demo Application
 * 
 * This application demonstrates how Seal Security automatically remediates 
 * vulnerabilities in open-source dependencies during the CI/CD pipeline.
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("==============================================");
        System.out.println("  Demo Application Started!");
        System.out.println("==============================================");
    }
}
