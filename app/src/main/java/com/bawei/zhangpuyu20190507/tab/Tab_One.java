package com.bawei.zhangpuyu20190507.tab;

import android.view.View;
import android.widget.ListView;

import com.bawei.zhangpuyu20190507.R;
import com.bawei.zhangpuyu20190507.adapter.ListAdapter;
import com.bawei.zhangpuyu20190507.base.BaseFragment;
import com.bawei.zhangpuyu20190507.bean.Bean;
import com.bawei.zhangpuyu20190507.util.NetUtil;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * PullToRefreshListView 上下拉刷新
 * 拼接口
 */
public class Tab_One extends BaseFragment {
    private String server_url = "http://172.17.8.100/movieApi/movie/v1/findHotMovieList?count=3";
    private PullToRefreshListView pullToRefreshListView;
    private int page = 1;
    private List<Bean.ResultBean> list = new ArrayList<>();
    private ListAdapter listAdapter;
    @Override
    protected int layoutID() {
        return R.layout.tab_one;
    }

    @Override
    protected void initView(View view) {
        pullToRefreshListView = view.findViewById(R.id.pull_to_list);
        initPull();
    }
    //上下拉刷新
    private void initPull() {
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);

        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                page = 1;
                initData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                page++;
                initData();
            }
        });
        listAdapter = new ListAdapter(getActivity(),list);
        pullToRefreshListView.setAdapter(listAdapter);
    }
    //加载数据
    @Override
    protected void initData() {
        String bean = server_url+"&page="+page;
        NetUtil.getInstance().getAsyncTask(bean, new NetUtil.CallBaskTask() {
            @Override
            public void onError(int code, String msg) {

            }

            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                Bean bean = gson.fromJson(s, Bean.class);
                List<Bean.ResultBean> result = bean.getResult();
                if(page == 1){
                    list.clear();
                }
                list.addAll(result);
                listAdapter.notifyDataSetChanged();
                pullToRefreshListView.onRefreshComplete();
            }
        });
    }

    @Override
    protected void initListener() {

    }
}
