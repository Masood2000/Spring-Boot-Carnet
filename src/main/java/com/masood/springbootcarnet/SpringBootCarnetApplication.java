package com.masood.springbootcarnet;

import com.masood.springbootcarnet.modules.m_14.DocTag;
import com.masood.springbootcarnet.modules.m_14.PhpDocBlock;
import com.masood.springbootcarnet.modules.m_14.PhpVariable;
import com.masood.springbootcarnet.modules.m_14.TypeResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(
        exclude = DataSourceAutoConfiguration.class
)
public class SpringBootCarnetApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootCarnetApplication.class, args);

        TypeResolver resolver = new TypeResolver();

        // TEST CASE 1: Standard Match
        // Scenario: $user has doc "User $user"
        System.out.println("--- Test 1: Standard Match ---");
        PhpDocBlock doc1 = new PhpDocBlock();
        doc1.addTag(new DocTag("@var", "User $user"));
        PhpVariable var1 = new PhpVariable("$user", doc1);

        System.out.println("Expected: User");
        System.out.println("Actual:   " + resolver.inferTypeFromDoc(var1));
        System.out.println();


    }



}


