package pl.wlabuda.fortranalpha;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.view.View;

public class ProgressBar {

    private ProgressDialog progressBar;
    private Handler progressBarbHandler = new Handler();
    private int progressBarStatus = 0;
    private long fileSize = 0;

    public ProgressBar(View view){
        progressBar = new ProgressDialog(view.getContext());
        progressBar.setCancelable(true);
        progressBar.setMessage(Global.mContext.getString(R.string.wait));
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();
        progressBarStatus = 0;
        fileSize = 0;
        new Thread(new Runnable() {
            public void run() {
                while (progressBarStatus < 100) {
                    progressBarStatus = downloadFile();
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBarbHandler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressBarStatus);
                        }
                    });
                }
                if (progressBarStatus >= 100) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBar.dismiss();
                }
            }
        }).start();
    }

    public int downloadFile() {
        while (fileSize <= 100000) {
            fileSize++;
            if (fileSize == 10000) {
                return 10;
            } else if (fileSize == 20000) {
                return 20;
            } else if (fileSize == 30000) {
                return 30;
            } else if (fileSize == 40000) {
                return 40;
            } else if (fileSize == 50000) {
                return 50;

            } else if (fileSize == 70000) {
                return 70;
            } else if (fileSize == 80000) {
                return 80;
            }
        }
        return 100;
    }
}
