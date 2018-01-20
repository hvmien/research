package com.research.base;

/**
 * Created by mienhoang on 1/19/18.
 */

public interface BaseView {
    void showProgress();

    void hideProgress();

    void showError(String error);

    void navigateToMainPage();
}
