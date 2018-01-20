package com.research.ui.loading;

import com.research.base.BasePresenter;

/**
 * Created by mienhoang on 1/20/18.
 */

public class LoadingPresenter implements BasePresenter {
    private LoadingView mView;

    public LoadingPresenter(LoadingView view) {
        mView = view;
    }

    @Override
    public void create() {

    }

    @Override
    public void start() {
        checkLogin();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    private void checkLogin() {
        if (false) {//da login roi
            mView.checkLoginWithToken();
        } else {//chua login hoac sign out
            mView.navigateToLoginPage();
        }
    }
}
