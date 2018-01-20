package com.research.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mienhoang on 1/19/18.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate((getResourceLayout()), container, false);
    }

    protected abstract int getResourceLayout();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView(view);
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        destroyView();
    }

    protected abstract void destroyView();

    protected abstract void initData();

    protected abstract void mapView(View view);

    protected void showFooterMessage(View parentView, String message) {
        Snackbar.make(parentView, message, Snackbar.LENGTH_LONG).show();
    }
}
