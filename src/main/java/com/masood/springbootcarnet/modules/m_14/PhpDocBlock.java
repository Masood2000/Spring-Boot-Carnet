package com.masood.springbootcarnet.modules.m_14;

import java.util.ArrayList;
import java.util.List;

public class PhpDocBlock {
    List<DocTag> tags = new ArrayList<>();

    public void addTag(DocTag tag) { tags.add(tag); }

    public List<DocTag> getTagsByName(String tagName) {
        // Simple filter to return only tags matching the name
        List<DocTag> result = new ArrayList<>();
        for (DocTag t : tags) {
            if (t.getName().equals(tagName)) {
                result.add(t);
            }
        }
        return result;
    }
}
