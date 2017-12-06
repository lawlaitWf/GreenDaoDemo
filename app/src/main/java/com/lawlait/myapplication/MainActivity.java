package com.lawlait.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lawlait.myapplication.dialog.CenterDialog;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, CenterDialog.OnCenterItemClickListener {

    private android.widget.Button add;
    private android.widget.Button del;
    private android.widget.Button update;
    private android.widget.Button query;
    private android.widget.TextView tv;
    private android.widget.Button alert;
    private TradeDao mTradeDao;
    private CenterDialog mCenterDialog;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initDbHelp();


    }

    private void initview() {
        this.tv = (TextView) findViewById(R.id.tv);
        this.query = (Button) findViewById(R.id.query);
        this.update = (Button) findViewById(R.id.update);
        this.del = (Button) findViewById(R.id.del);
        this.add = (Button) findViewById(R.id.add);
        this.alert = (Button) findViewById(R.id.alert);
        add.setOnClickListener(this);
        del.setOnClickListener(this);
        update.setOnClickListener(this);
        query.setOnClickListener(this);
        alert.setOnClickListener(this);
        tv.setOnClickListener(this);
    }

    private void initDbHelp() {
        DataHelper myHelper = new DataHelper(this);
        SQLiteDatabase writableDatabase = myHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        DaoSession daoSession = daoMaster.newSession();
        mTradeDao = MyApplication.getInstances().getDaoSession().getTradeDao();


    }

    @Override
    public void onClick(View v) {
        if (v == query) {
            List<Trade> users = mTradeDao.loadAll();
            String userName = "";
            for (int i = 0; i < users.size(); i++) {
                userName += users.get(i).getID() + "," + users.get(i).getAmount();
            }
            tv.setText("查询全部数据==>" + userName);

        }
        if (v == add) {
            Trade mUser = new Trade(10001, "s10001", "batcha_10001", 1002.2, "1", "0", "2017-12-4", "2");
            mTradeDao.insert(mUser);//添加一个
        }
        if (v == del) {

        }
        if (v == update) {

        }
        if (v == alert) {

            int[] resid = new int[]{R.id.centerdialog_rg, R.id.centerdialog_rb1, R.id.centerdialog_rb2, R.id.centerdialog_rb3, R.id.centerdialog_cancel, R.id.centerdialog_sure};


            mCenterDialog = new CenterDialog(this, R.layout.dialog_centerdialoglayout, resid);
            mCenterDialog.setOnCenterItemClickListener(this);
            mCenterDialog.show();
            mRadioGroup = (RadioGroup)mCenterDialog.findViewById(R.id.centerdialog_rg);
        }

    }

    @Override
    public void OnCenterItemClick(CenterDialog dialog, View view) {
        int id = view.getId();
        switch (id) {
            case R.id.centerdialog_cancel:
                mCenterDialog.dismiss();
                break;
            case R.id.centerdialog_sure:
                int checkedRadioButtonId = mRadioGroup.getCheckedRadioButtonId();
                Log.d("tag",checkedRadioButtonId + "");
                switch (checkedRadioButtonId) {
                    case R.id.centerdialog_rb1:
                        Toast.makeText(this,"参数1",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.centerdialog_rb2:
                        Toast.makeText(this,"参数2",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.centerdialog_rb3:

                        Toast.makeText(this,"参数3",Toast.LENGTH_SHORT).show();
                        break;
                }
                mCenterDialog.dismiss();
                break;
        }
    }
}
