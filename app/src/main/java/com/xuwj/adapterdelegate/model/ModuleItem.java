package com.xuwj.adapterdelegate.model;

/**
 * Created by weijiang on 16/6/19.
 */

public class ModuleItem implements DisplayableItem{

    private String name;

    public ModuleItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
