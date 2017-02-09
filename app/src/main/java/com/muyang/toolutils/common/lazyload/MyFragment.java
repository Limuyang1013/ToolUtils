package com.muyang.toolutils.common.lazyload;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muyang.toolutils.R;

/**
 * Created by Limuyang on 2017/2/8.
 * 使用博客地址 http://www.jianshu.com/p/311c7ffdb85b
 */

public class MyFragment extends ViewPagerFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView==null) {
            rootView = inflater.inflate(R.layout.activity_main, container, false);
        }
        return rootView;
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        if (isVisible){
            //   do things when fragment is visible
            //   if (ListUtils.isEmpty(mDataList) && !isRefreshing()) {
            //   setRefresh(true);
            //   loadServiceData(false);
        }else{
            //        setRefresh(false);
        }
    }
}
