package com.huafeng.client.ui.home.activity.origin;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huafeng.client.MyApp;
import com.huafeng.client.R;
import com.huafeng.client.net.Api;
import com.huafeng.client.net.NetUtils;
import com.huafeng.client.net.OnMessageReceived;
import com.huafeng.client.tools.CheckDoubleClick;
import com.huafeng.client.tools.PhotoUtil;
import com.huafeng.client.ui.home.activity.BaseActivity;
import com.huafeng.client.view.CursorEditText;
import com.huafeng.client.view.selectimage.EvaluationChoiceImageView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.weigan.loopview.LoopView;
import com.weigan.loopview.OnItemSelectedListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateOriginDataActivity extends BaseActivity {


    @BindView(R.id.tv_style)
    TextView tv_style;
    @BindView(R.id.tv_type)
    TextView tv_type;
    @BindView(R.id.et_des)
    EditText et_des;
    @BindView(R.id.et_name)
    CursorEditText et_name;
    @BindView(R.id.addimgs)
    EvaluationChoiceImageView addimgs;

    ArrayList<String> images;
    List<String> typeList;
    int type = 1;

    String head;
    String path;

    OriginDataSubmit originDataSubmit;
    OriginStorageDetail.RawMaterialBean rawMaterialBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_origin_data);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        originDataSubmit=new OriginDataSubmit();
        rawMaterialBean= (OriginStorageDetail.RawMaterialBean) getIntent().getSerializableExtra("data");
        initView();
    }
    private String getJson(){
        String json="";
        Map<String, Object> params = new HashMap<>();
        params.put("id", rawMaterialBean.getId());
        params.put("image", head);
        params.put("name", et_name.getEditableText().toString());
        params.put("purchaseType", type);
        params.put("description", et_des.getEditableText().toString());
        json = new Gson().toJson(params);
        return json;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if (data != null && requestCode == 5) {
            List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
            path = selectList.get(0).getPath();
            File file = new File(path);
            upLoadImg(file, path);
        }
    }

    private void submit() {

        LogUtils.e(getJson());
        NetUtils.getInstance().post(Api.Raw.edit, getJson(), MyApp.token, new OnMessageReceived() {
            @Override
            public void onSuccess(String response) {
                LogUtils.e(response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int code = jsonObject.getInt("resultCode");
                    if (code == 0) {
                        ToastUtils.showShort("提交成功");
                        finish();
                    } else {
                        String msg = jsonObject.getString("message");
                        ToastUtils.showShort(msg);
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

    private void initPhoto() {
        images = new ArrayList<>();
        addimgs.setOnClickAddImageListener(new EvaluationChoiceImageView.OnClickAddImageListener() {
            @Override
            public void onClickAddImage() {
                if (images.size() == 1) {
                    ToastUtils.showLong("只能选择一张图片！");
                    return;
                }
                openPhoto(5);
            }
        });
        addimgs.setOnClickDeleteImageListener(new EvaluationChoiceImageView.OnClickDeleteImageListener() {
            @Override
            public void onClickDeleteImage(int position) {
                images.remove(position);
            }
        });
        addimgs.setOnClickImageListener(new EvaluationChoiceImageView.OnClickImageListener() {
            @Override
            public void onClickImage(int position) {

               PhotoUtil.seeSinglePhoto(UpdateOriginDataActivity.this, rawMaterialBean.getImageUrl(), addimgs.getmFlowlayoutChilds().get(position));
            }
        });
        initData();
    }
    private void initData(){
        images.add(rawMaterialBean.getImage());
        head=rawMaterialBean.getImage();
        addimgs.addImage(rawMaterialBean.getImageUrl());
        switch (rawMaterialBean.getPurchaseType()){
            case 1:
                tv_type.setText("产前采购");
                type=1;
                break;
            case 2:
                tv_type.setText("车间采购");
                type=2;
                break;
            case 3:
                tv_type.setText("后整采购");
                type=3;
                break;
        }
        et_name.setText(rawMaterialBean.getName());
        et_des.setText(rawMaterialBean.getDescription());
        tv_style.setText(rawMaterialBean.getCategory1Name()+rawMaterialBean.getCategory2Name());
    }
    private void openPhoto(int code) {
        PictureSelector.create(UpdateOriginDataActivity.this)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .enablePreviewAudio(false) // 是否可播放音频 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                .enableCrop(false)// 是否裁剪 true or false
                .compress(true)// 是否压缩 true or false
                .withAspectRatio(16, 9)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .cropCompressQuality(90)// 裁剪压缩质量 默认90 int
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .forResult(code);//结果回调onActivityResult code
    }

    @OnClick({R.id.iv_back, R.id.tv_add, R.id.rl_type})
    void onClick(View view) {
        if(CheckDoubleClick.isFastDoubleClick()){
            return;
        }
        switch (view.getId()) {

            case R.id.rl_type:
                showTypeDialog();
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_add:
                if (checkInput()) {
                    submit();
                }
                break;

        }
    }

    private void upLoadImg(File file, String path) {
        NetUtils.getInstance().upLoadImage(Api.Image.uploadImage, file, new OnMessageReceived() {
            @Override
            public void onSuccess(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    head = jsonObject.getString("data");
                    images.add(head);
                    addimgs.addImage(path);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onError(String error) {

            }
        });
    }

    private boolean checkInput() {
        boolean isOk = true;
        if (TextUtils.isEmpty(et_name.getEditableText().toString().trim())) {
            isOk = false;
            ToastUtils.showShort("请输入名称");
            return isOk;
        }
        if (TextUtils.isEmpty(et_des.getEditableText().toString().trim())) {
            isOk = false;
            ToastUtils.showShort("请输入描述");
            return isOk;
        }

        return isOk;
    }

    private void initView() {
        typeList = new ArrayList<>();
        typeList.add("产前采购");
        typeList.add("车间采购");
        typeList.add("后整采购");
        initPhoto();
    }

    private void showTypeDialog() {
        final Dialog dialog = new Dialog(this, R.style.CustomDialog);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_pay_type, null);
        TextView tv_cancel = view.findViewById(R.id.tv_cancel);
        TextView tv_title = view.findViewById(R.id.tv_title);
        TextView tv_confirm = view.findViewById(R.id.tv_confirm);
        LoopView loopView = (LoopView) view.findViewById(R.id.loopView);
        tv_title.setText("选择采购类型");
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                tv_type.setText(typeList.get(loopView.getSelectedItem()));

            }
        });

        // 滚动监听
        loopView.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                type = ++index;
            }
        });
        // 设置原始数据
        loopView.setItems(typeList);
        loopView.setNotLoop();
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        window.setAttributes(layoutParams);
    }
}
