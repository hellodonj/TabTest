package com.winning.rims.tabtest.tst;

import android.util.Log;

import com.winning.rims.tabtest.R;

/**
 * 描述: Fragment1
 * 作者|时间: djj on 2018/9/11 16:14
 * 博客地址: http://www.jianshu.com/u/dfbde65a03fc
 *
 */

public class Fragment1 extends BaseFragment {
    @Override
    public int setContentView() {
        return R.layout.fm_layout1;
    }

    @Override
    protected void lazyLoad() {
        String message = "Fragment1" + (isInit ? "已经初始并已经显示给用户可以加载数据" : "没有初始化不能加载数据")+">>>>>>>>>>>>>>>>>>>";
        showToast(message);
        Log.d(TAG, message);
    }

    @Override
    protected void stopLoad() {
        Log.d(TAG, "Fragment1" + "已经对用户不可见，可以停止加载数据");
    }
}
