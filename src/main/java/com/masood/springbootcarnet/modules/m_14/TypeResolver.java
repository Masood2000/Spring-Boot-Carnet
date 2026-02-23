package com.masood.springbootcarnet.modules.m_14;

import java.util.ArrayList;
import java.util.List;



public class TypeResolver {

    public PhpType inferTypeFromDoc(PhpVariable variable) {

        //Get the documentation block
        PhpDocBlock docBlock = variable.getDocBlock();

        //If there is no doc block, return "mixed"
        if (docBlock == null) return TypeFactory.createType("mixed");


        //Get all tags named "@var"
        List<DocTag> tags = docBlock.getTagsByName("@var");

        // If the tags list is empty, return "mixed"
        if (tags.isEmpty()) return TypeFactory.createType("mixed");


        //Loop through every tag to find the right one
        for (DocTag tag : tags) {

            String content = tag.getValue();

            // Split the string by simple space
            String[] parts = content.split(" ");

            String typePart = "";
            String namePart = null;

            // Loop through the parts to find the Type and the Variable Name
            for (String part : parts) {

                // Skip empty spaces (in case there are two spaces in a row)
                if (part.isEmpty()) continue;

                if (part.startsWith("$")) namePart = part;
                else typePart = part;

            }

            // Checking if this tag matches our variable
            boolean isMatch = false;

            // If the tag has NO name (e.g. "@var User"), it automatically matches
            if (namePart == null) isMatch = true;
            // If the tag has a name, it must match our variable
            else if (namePart.equals(variable.getName())) isMatch = true;

            // If we found a match, create the type and return it
            if (isMatch) {

                // Check if it is a Union Type (has a "|")
                if (typePart.contains("|")) {

                    // It is a union (e.g., "string|int")
                    String[] unionParts = typePart.split("\\|");
                    List<PhpType> typeList = new ArrayList<>();

                    for (String t : unionParts) typeList.add(TypeFactory.createType(t));

                    return TypeFactory.createUnionType(typeList);

                }
                // It is a standard type (e.g., "User")
                else return TypeFactory.createType(typePart);

            }
        }

        // If we finish the loop and find nothing, return "mixed"
        return TypeFactory.createType("mixed");
    }
}


class PhpType {
    String typeName;
    public PhpType(String name) { this.typeName = name; }
    @Override
    public String toString() { return typeName; } // For printing results
}

class TypeFactory {
    public static PhpType createType(String name) {
        return new PhpType(name);
    }
    public static PhpType createUnionType(List<PhpType> types) {
        // Join them with "|" for display purposes
        StringBuilder sb = new StringBuilder("Union<");
        for (PhpType t : types) {
            sb.append(t.toString()).append("|");
        }
        return new PhpType(sb.toString() + ">");
    }
}


