package com.mobile.fuhome.app.application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Ahead on 2016/7/28.
 */
public class BaseActivity extends Activity {

    public Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void jumpToActivity(Class<?> activity, Bundle bundle, boolean hasResult,int requestCode) {
        try {
            Intent intent = new Intent(mContext,activity);
            if (bundle!=null){
                intent.putExtras(bundle);
            }
            if (hasResult){
                startActivityForResult(intent,requestCode);
            }else {
                startActivity(intent);
            }

        }catch (Exception e){
            Toast.makeText(mContext, "跳转失败~", Toast.LENGTH_SHORT).show();
        }

    }
}
