package com.huafeng.client.ui.home.activity.origin;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huafeng.client.MyApp;
import com.huafeng.client.R;
import com.huafeng.client.net.Api;
import com.huafeng.client.net.NetUtils;
import com.huafeng.client.net.OnMessageReceived;
import com.huafeng.client.tools.CheckDoubleClick;
import com.huafeng.client.ui.home.activity.BaseActivity;
import com.huafeng.client.ui.home.activity.search.SearchOriginActivity;
import com.huafeng.client.ui.home.adapter.OriginalStorageAdapter;
import com.huafeng.client.ui.home.adapter.RawCategoryAdapter;
import com.huafeng.client.ui.home.model.OriginalStorage;
import com.huafeng.client.ui.home.model.RawCategory;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.lzy.okgo.model.HttpParams;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fj.dropdownmenu.lib.concat.DropdownI;
import fj.dropdownmenu.lib.ion.ViewInject;
import fj.dropdownmenu.lib.ion.ViewUtils;
import fj.dropdownmenu.lib.utils.DropdownUtils;
import fj.dropdownmenu.lib.view.DropdownButton;
import fj.dropdownmenu.lib.view.DropdownColumnView;

public class OriginalStorageActivity extends BaseActivity implements  DropdownI.RandomView{

    @BindView(R.id.mask)
    View mask;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @ViewInject(R.id.btn_type)
    @BindView(R.id.btn_type)
    DropdownButton btn_type;
    @ViewInject(R.id.lvType)
    @BindView(R.id.lvType)
    DropdownColumnView lvType;
    List<RawCategory> mFirstCategory;
    List<RawCategory> mSecCategory;
    RawCategoryAdapter mFristAdapter;
    RawCategoryAdapter mSecAdapter;
    int page = 1;
    int category1Id = -2;
    int category2Id = -2;
    String firstName;
    String secName;
//    List<FirstType> firstTypes;
//    List<FirstType> secTypes;
    boolean isLoadMore = false;
    @BindView(R.id.rv_design)
    RecyclerView rv_finish;
    OriginalStorageAdapter mOriginalStorageAdapter;
    List<OriginalStorage> mOriginalStorages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_original_storage);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        showLoading();
        initView();
    }
    KProgressHUD kProgressHUD;
    private void showLoading(){
        kProgressHUD= KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setDimAmount(1000)
                .setCancellable(true)
                .setDimAmount(0.5f)
                .show();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                kProgressHUD.dismiss();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 500);//3秒后执行TimeTask的run方法
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        refresh();
    }

    private void getFirstCategory() {

        NetUtils.getInstance().get(MyApp.token, Api.Matrerial.getFirstCategorys, new OnMessageReceived() {
            @Override
            public void onSuccess(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int code = jsonObject.getInt("resultCode");
                    if (code == 0) {
                        JSONArray data = jsonObject.getJSONArray("data");
                        for (int i = 0; i < data.length(); i++) {
                            JSONObject item = data.getJSONObject(i);
                            RawCategory firstType=new Gson().fromJson(item.toString(),RawCategory.class);
                            mFirstCategory.add(firstType);
                        }
                        mFristAdapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }
    private void getSecCategory(int id) {
        mSecCategory.clear();
        final RawCategory rawCategory=new RawCategory();
        rawCategory.setName("全部");
        mSecCategory.add(rawCategory);
        final HttpParams params=new HttpParams();
        params.put("firstCategoryId",id);
        NetUtils.getInstance().get(MyApp.token, Api.Matrerial.getSecondCategorysByFirst, params,new OnMessageReceived() {
            @Override
            public void onSuccess(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int code = jsonObject.getInt("resultCode");
                    if (code == 0) {
                        JSONArray data = jsonObject.getJSONArray("data");
                        for (int i = 0; i < data.length(); i++) {
                            JSONObject item = data.getJSONObject(i);
                            RawCategory firstType=new Gson().fromJson(item.toString(),RawCategory.class);
                            mSecCategory.add(firstType);
                        }
                        mSecAdapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    @OnClick({R.id.iv_back,R.id.iv_search,R.id.iv_add})
    void onClick(View view){
        if(CheckDoubleClick.isFastDoubleClick()){
            return;
        }
        switch (view.getId()){
            case R.id.iv_add:
                startActivityForResult(new Intent(OriginalStorageActivity.this, AddOriginDataActivity.class),1);
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_search:
                startActivity(new Intent(OriginalStorageActivity.this, SearchOriginActivity.class));
                break;

        }
    }
    private void initView() {
        DropdownUtils.init(this, mask);
        ViewUtils.injectViews(this, mask);
        btn_type.setText("全部");
        lvType.setRandom(this)
                .setRandomView(R.layout.menu_style)
                .setButton(btn_type) //按钮
                .show();
        mOriginalStorages=new ArrayList<>();
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refresh();
            }
        });
        mOriginalStorageAdapter=new OriginalStorageAdapter(R.layout.item_finished_product,mOriginalStorages);
        mOriginalStorageAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(CheckDoubleClick.isFastDoubleClick()){
                    return;
                }
                OriginalStorage originalStorage= (OriginalStorage) adapter.getItem(position);
                Intent intent=new Intent(OriginalStorageActivity.this, OriginStorageDetailActivity.class);
                intent.putExtra("id",originalStorage.getMaterialId());
                startActivityForResult(intent,1);
            }
        });
        rv_finish.setLayoutManager(new GridLayoutManager(this,2, LinearLayoutManager.VERTICAL,false));
        rv_finish.setAdapter(mOriginalStorageAdapter);
        getData();
    }

    private void refresh() {
        page=1;
        mOriginalStorages.clear();
        mOriginalStorageAdapter.setNewData(mOriginalStorages);
        getData();
    }



    private void getData() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("page", page);
        httpParams.put("imageNecessary",1);
        if (category1Id > 0) {
            httpParams.put("categoryId1", category1Id);
        }
        if (category2Id > 0) {
            httpParams.put("categoryId2", category2Id);
        }
        Log.e("cate1",category1Id+"-"+category2Id);
        NetUtils.getInstance().get(MyApp.token, Api.Inventory.getMaterialList, httpParams, new OnMessageReceived() {
            @Override
            public void onSuccess(String response) {
                refresh.finishRefresh();
                LogUtils.e(response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    int code=jsonObject.getInt("resultCode");
                    if(code==0){
                        jsonObject=jsonObject.getJSONObject("data");
                        List<OriginalStorage> modelDesigns=new ArrayList<>();
                        JSONArray data=jsonObject.getJSONArray("beanList");
                        for (int i = 0; i <data.length() ; i++) {
                            JSONObject item=data.getJSONObject(i);
                            OriginalStorage modelDesign=new Gson().fromJson(item.toString(),OriginalStorage.class);
                            mOriginalStorages.add(modelDesign);
                            modelDesigns.add(modelDesign);
                        }
                        if(isLoadMore){
                            isLoadMore=false;
                            if(data.length()>0){
                                mOriginalStorageAdapter.addData(modelDesigns);
                                mOriginalStorageAdapter.loadMoreComplete();
                            }else{
                                mOriginalStorageAdapter.loadMoreEnd(true);
                            }
                        }else{
                            mOriginalStorageAdapter.setNewData(mOriginalStorages);
                        }

                    }else{
                        ToastUtils.showShort("你没有该权限");
                        finish();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String error) {

            }
        });

    }
    @Override
    public void onRandom(View view) {
        mFirstCategory=new ArrayList<>();
        mSecCategory=new ArrayList<>();
        final RawCategory rawCategory=new RawCategory();
        rawCategory.setName("全部");
        mFirstCategory.add(rawCategory);
        mSecCategory.add(rawCategory);
        ListView lv_left=view.findViewById(R.id.lv_left);
        ListView lv_right=view.findViewById(R.id.lv_right);
        mFristAdapter=new RawCategoryAdapter(this,mFirstCategory);
        mSecAdapter=new RawCategoryAdapter(this,mSecCategory);
        lv_left.setAdapter(mFristAdapter);
        lv_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mFristAdapter.setPos(position);
                mFristAdapter.notifyDataSetChanged();
                mSecAdapter.setPos(0);
                mSecAdapter.notifyDataSetChanged();

                if(position>0){
                    firstName=mFirstCategory.get(position).getName();
                    category1Id=mFirstCategory.get(position).getId();
                    category2Id=-1;
                    btn_type.setText(firstName);
                    getSecCategory(mFirstCategory.get(position).getId());
                }else{
                    category1Id=-1;
                    category2Id=-1;
                    mSecCategory.clear();
                    final RawCategory rawCategory1=new RawCategory();
                    rawCategory1.setName("全部");
                    btn_type.setText("全部");
                    mSecCategory.add(rawCategory1);
                    mSecAdapter.notifyDataSetChanged();

                }
                refresh();

            }
        });
        lv_right.setAdapter(mSecAdapter);
        lv_right.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSecAdapter.setPos(position);
                mSecAdapter.notifyDataSetChanged();

                if(position==0){
                    category2Id=-1;
                    if(category1Id>0)
                        btn_type.setText(firstName);
                    else{
                        btn_type.setText("全部");
                    }
                }else{
                    category2Id=mSecCategory.get(position).getId();
                    secName=mSecCategory.get(position).getName();
                    btn_type.setText(firstName+secName);
                }
                refresh();

            }
        });
        getFirstCategory();
    }

}
