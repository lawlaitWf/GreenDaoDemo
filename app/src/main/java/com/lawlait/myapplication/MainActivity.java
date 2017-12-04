package com.lawlait.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.Button add;
    private android.widget.Button del;
    private android.widget.Button update;
    private android.widget.Button query;
    private android.widget.TextView tv;
    private TradeDao mTradeDao;

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

        add.setOnClickListener(this);
        del.setOnClickListener(this);
        update.setOnClickListener(this);
        query.setOnClickListener(this);
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
                userName += users.get(i).getID()+"," +users.get(i).getAmount();
            }
            tv.setText("查询全部数据==>"+userName);

        }
        if (v == add) {
            Trade mUser = new Trade(10001,"s10001","batcha_10001",1002.2,"1","0","2017-12-4","2");
            mTradeDao.insert(mUser);//添加一个
        }
        if (v == del) {

        }
        if (v == update) {

        }
    }
}
