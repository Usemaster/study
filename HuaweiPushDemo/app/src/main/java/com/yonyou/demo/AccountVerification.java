package com.yonyou.demo;

import android.util.Log;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;

/**
 * @author gongwj
 * @Date 2022/7/20
 */
public class AccountVerification {


    private static void accountVerification(){
        // 添加当前设备上该用户与应用的关系
        HmsProfile.getInstance(this).addProfile(type,profileId)
        .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                // 获取结果
                if (task.isSuccessful()){
                    Log.i(TAG, "add profile success.");
                } else{
                    Log.e(TAG, "add profile failed: " + task.getException().getMessage());
                }
            }
        });
    }


}
