package com.huafeng.client.ui.home.activity.client;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.huafeng.client.R;
import com.huafeng.client.tools.StringUtils;
import com.huafeng.client.ui.home.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClientManaPhoneActivity extends BaseActivity {
    SelectPhoneAdapter selectPhoneAdapter;
    @BindView(R.id.lv_select)
    ListView lv_select;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.tv_add)
    TextView tv_add;
    List<String> photoList;
    String phone;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_mana_phone);
        ButterKnife.bind(this);
        phone = getIntent().getStringExtra("phone");
        id = getIntent().getIntExtra("id", 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        initView();
    }

    private void initView() {
        photoList = new ArrayList<>();
        if (!TextUtils.isEmpty(phone)) {
            photoList.addAll(StringUtils.StringToArrayList(phone, ","));
        }
        selectPhoneAdapter = new SelectPhoneAdapter(this, photoList);
        selectPhoneAdapter.setOnTouchListener(new SelectPhoneAdapter.OnTouchListener() {
            @Override
            public void onDel(int pos) {
                if (id == 0) {
                    return;
                }
                photoList.remove(pos);
                selectPhoneAdapter.notifyDataSetChanged();
            }

            @Override
            public void onItem(int pos) {
                if (id == 0) {
                    return;
                }
                showPhone(2, pos, photoList.get(pos));
            }
        });
        lv_select.setAdapter(selectPhoneAdapter);
        if (id == 0) {
            tvSave.setVisibility(View.GONE);
            tv_add.setVisibility(View.GONE);
        }
    }

    private void showPhone(int type, int pos, String phone) {
        final Dialog dialog = new Dialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_phone, null);
        final EditText et_value = (EditText) view.findViewById(R.id.et_value);
        TextView tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
        TextView tv_submit = (TextView) view.findViewById(R.id.tv_submit);
        et_value.setText(phone);
        tv_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                String value = et_value.getEditableText().toString();
                if (TextUtils.isEmpty(value)) {
                    ToastUtils.showShort("手机号不能为空！");
                    return;
                }
                if (value.length() != 11) {
                    ToastUtils.showShort("手机号格式不合适！");
                    return;
                }
                if (type == 1) {
                    photoList.add(value);
                    selectPhoneAdapter.notifyDataSetChanged();
                } else {
                    photoList.remove(pos);
                    photoList.add(pos, value);
                    selectPhoneAdapter.notifyDataSetChanged();
                }

            }
        });
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        dialog.show();
        Window window = dialog.getWindow();
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();

        window.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.width = (int) (display.getWidth() * 0.9);
        window.setAttributes(layoutParams);

    }

    @OnClick({R.id.iv_back, R.id.tv_save, R.id.tv_add})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.tv_add:
                showPhone(1, 0, "");
                break;
            case R.id.tv_save:
                phone = StringUtils.listToString2(photoList, ',');
                ToastUtils.showShort("保存成功");
                Intent intent = new Intent();
                intent.putExtra("phone", phone);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.iv_back:
                finish();
                break;

        }
    }
}
