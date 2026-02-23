package com.masood.springbootcarnet.modules.m_14;

public class PhpVariable {
    String name;
    PhpDocBlock docBlock;

    public PhpVariable(String name, PhpDocBlock docBlock) {
        this.name = name;
        this.docBlock = docBlock;
    }
    public String getName() { return name; }
    public PhpDocBlock getDocBlock() { return docBlock; }
}
