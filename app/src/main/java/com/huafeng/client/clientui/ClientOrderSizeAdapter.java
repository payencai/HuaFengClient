package com.huafeng.client.clientui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.huafeng.client.R;
import com.huafeng.client.view.MathUtils;

import java.util.List;

public class ClientOrderSizeAdapter extends BaseAdapter {
    private int mTouchItemPosition = -1;
    Context mContext;
    List<ClientOrderSubmit.SizeQuantityListBean> mSizeTypes;
    private ViewHolder mViewHolder;

    public ClientOrderSizeAdapter(Context context, List<ClientOrderSubmit.SizeQuantityListBean> sizeTypes) {
        mContext = context;
        mSizeTypes = sizeTypes;
    }

    @Override
    public int getCount() {
        return mSizeTypes.size();
    }

    @Override
    public Object getItem(int position) {
        return mSizeTypes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ClientOrderSubmit.SizeQuantityListBean sizeType = mSizeTypes.get(position);
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_size_input, null);
            mViewHolder.mTextView = (TextView) convertView.findViewById(R.id.tv_name);
            mViewHolder.mEditText = (EditText) convertView.findViewById(R.id.et_number);

            mViewHolder.mEditText.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    //注意，此处必须使用getTag的方式，不能将position定义为final，写成mTouchItemPosition = position
                    mTouchItemPosition = (Integer) view.getTag();
                    return false;
                }
            });

            // 让ViewHolder持有一个TextWathcer，动态更新position来防治数据错乱；不能将position定义成final直接使用，必须动态更新
            mViewHolder.mTextWatcher = new MyTextWatcher();
            mViewHolder.mEditText.addTextChangedListener(mViewHolder.mTextWatcher);
            mViewHolder.updatePosition(position);
            convertView.setTag(mViewHolder);

        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
            mViewHolder.updatePosition(position);
        }
        mViewHolder.mTextView.setText(sizeType.getSizeName());
        if(sizeType.getQuantity()>0)
           mViewHolder.mEditText.setText(sizeType.getQuantity()+"");
        else{

        }
        mViewHolder.mEditText.setTag(position);
        if (mTouchItemPosition == position) {
            mViewHolder.mEditText.requestFocus();
            mViewHolder.mEditText.setSelection(mViewHolder.mEditText.getText().length());
        } else {
            mViewHolder.mEditText.clearFocus();
        }

        return convertView;
    }

    static final class ViewHolder {
        TextView mTextView;
        EditText mEditText;

        MyTextWatcher mTextWatcher;

        //动态更新TextWathcer的position
        public void updatePosition(int position) {
            mTextWatcher.updatePosition(position);
        }
    }

    class MyTextWatcher implements TextWatcher {
        //由于TextWatcher的afterTextChanged中拿不到对应的position值，所以自己创建一个子类
        private int mPosition;

        public void updatePosition(int position) {
            mPosition = position;
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            ClientOrderSubmit.SizeQuantityListBean sizeType = mSizeTypes.get(mPosition);
            if(MathUtils.isNumber(s.toString())){
                sizeType.setQuantity(Integer.parseInt(s.toString()));
                mSizeTypes.set(mPosition, sizeType);
            }

        }
    }

}
