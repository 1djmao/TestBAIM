package com.example.testbaim;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.qim.basdk.BAIM;
import com.qim.basdk.data.BALoginInfo;
import com.qim.basdk.data.BALoginParams;
import com.qim.basdk.databases.BAProvider;
import com.qim.basdk.utilites.BAConst;
import com.qim.basdk.utilites.BAUtil;

import static com.qim.basdk.databases.BADataHelper.dbName;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    public void login() {
        BALoginParams params=new BALoginParams();
        params.setDomainName("aipu");
        params.setServerIP("192.168.0.91");
        params.setServerPort(6661);
        params.setAccount("user10005");
        params.setPassword("123", BAConst.PWD_TYPE_ATEN);
// 设备类型（Android）
        params.setPlatform(BAConst.PLATFORM_ANDROID);
        params.setUpdatePlatform(BAConst.UPDATE_PLATFORM_ANDROID);
        params.setLoginFlag(0);//普通登录

        try {
 //客户端版本
            params.setClientVer(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            Log.i("hhhhh", "login: "+getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            String deviceID = Build.SERIAL;
// 设备号
            params.setDeviceID(deviceID);
            params.setOpType(1);//普通登录
            params.setOpData(deviceID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int i=BAIM.getInstance().login(params);

        Log.i("hhhhh", "login: "+i);

    }
}
