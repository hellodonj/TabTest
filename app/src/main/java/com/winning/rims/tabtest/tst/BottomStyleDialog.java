package com.winning.rims.tabtest.tst;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.winning.rims.tabtest.R;

import java.util.ArrayList;

/**
 * 描述: 自定义底部弹框
 * 作者|时间: djj on 2018/9/10 16:29
 * 博客地址: http://www.jianshu.com/u/dfbde65a03fc
 */

public class BottomStyleDialog extends Dialog implements AdapterView.OnItemClickListener {


    private String[] mNames = new String[]{
            "杨冉", "李林森", "王柳玲", "张三", "李四", "杨冉", "李林森", "王柳玲", "张三", "李四"
    };

    private ListView mLv;

    private ArrayList<StyleItem> mList = new ArrayList<StyleItem>();

    private StyleAdapter mAdapter;

    public BottomStyleDialog(Context context) {
        // 在构造方法里, 传入主题
        super(context, R.style.BottomDialogStyle);
        // 拿到Dialog的Window, 修改Window的属性
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        // 获取Window的LayoutParams
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        // 一定要重新设置, 才能生效
        window.setAttributes(attributes);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_dialog);
        initView();
        initData();
    }

    private void initView() {
        mLv = findViewById(R.id.lv_view_dialog);
        mLv.setOnItemClickListener(this);
    }

    private void initData() {
        // 填充数据集合
        for (int i = 0; i < mNames.length; i++) {
            StyleItem styleItem = new StyleItem();
            styleItem.setName(mNames[i]);
            mList.add(styleItem);
        }
        mAdapter = new StyleAdapter(getContext(), mList);
        mLv.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(),mList.get(position).getName(),Toast.LENGTH_SHORT).show();
        mAdapter.notifyDataSetChanged();
    }
}
