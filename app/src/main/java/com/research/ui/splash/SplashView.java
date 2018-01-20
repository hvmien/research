package com.research.ui.splash;


import com.research.base.BaseView;

/**
 * Created by MienHV1 on 4/11/2017.
 */

public interface SplashView extends BaseView {

    void navigateToLoginNoPassPage(String Username);

    void navigateToHomePage();

    void navigateToLoginPage();

    void navigateToStoreListPage();

    void callbackFinishActivity();

}
