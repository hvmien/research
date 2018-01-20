package com.research.ui.loading;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;

import com.research.R;
import com.research.base.BaseActivity;
import com.research.ui.login.LoginWithTokenPresenter;

import butterknife.BindView;

/**
 * Created by mienhoang on 1/19/18.
 */

public class LoadingActivity extends BaseActivity implements LoadingView {

    @BindView(R.id.pb_loading)
    ProgressBar _pbLoading;
    private ProgressAsynTask mProgessAsyn;
    private LoadingPresenter mLoadingPresenter;
    private LoginWithTokenPresenter mLoginTokenPresenter;


    @Override
    protected void setScreenOrientation(boolean aBoolean) {

    }

    @Override
    protected void initData() {
        mLoadingPresenter = new LoadingPresenter(this);
        mLoginTokenPresenter = new LoginWithTokenPresenter();
        mProgessAsyn = new ProgressAsynTask();
        mProgessAsyn.execute(100);
    }

    @Override
    protected void mapView() {

    }

    @Override
    protected int getResourceLayout() {
        return R.layout.activity_loading;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void navigateToMainPage() {

    }

    @Override
    public void navigateToLoginPage() {
        openLoginPage();
        finish();
    }

    @Override
    public void checkLoginWithToken() {
        mLoginTokenPresenter.signInToken();
    }

    class ProgressAsynTask extends AsyncTask<Integer, Integer, Void> {
        private String WATCH_DOG = "PAUSE";
        private boolean resume = true;
        private boolean isPause = false;
        private int progress_status;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress_status = 0;
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            while (progress_status < 100 && resume) {
                progress_status += 1;

                publishProgress(progress_status);
                SystemClock.sleep(100);
                resume = (progress_status++ == integers[0]) ? false : true;
                if (isPause) {
                    synchronized (WATCH_DOG) {
                        try {
                            // --- set text field status to 'paused' --
                            publishProgress(-1);
                            // --- sleep tile wake-up method will be called --
                            WATCH_DOG.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            _pbLoading.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mLoadingPresenter.start();
        }

        public void pauseMyTask() {
            isPause = true;
        }

        public void wakeUp() {
            synchronized (WATCH_DOG) {
                WATCH_DOG.notify();
            }
        }

        public boolean getPause() {
            return isPause;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mProgessAsyn.pauseMyTask();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mProgessAsyn.getPause()==false)
            mProgessAsyn.wakeUp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
