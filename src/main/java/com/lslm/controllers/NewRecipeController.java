package com.lslm.controllers;

import com.lslm.ui.NewRecipeWindow;
import com.lslm.ui.ScreenCallback;

public class NewRecipeController {
    private NewRecipeWindow newRecipeWindow;
    private ScreenCallback callback;

    public NewRecipeController(ScreenCallback callback) {
        this.newRecipeWindow = new NewRecipeWindow(this);
        this.callback = callback;
    }

    public void open() {
        newRecipeWindow.open(callback);
    }
}
