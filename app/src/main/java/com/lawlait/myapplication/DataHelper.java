package com.lawlait.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lawlait on 2017/12/4.
 */

public class DataHelper  extends SQLiteOpenHelper {
    public  DataHelper(Context context){
        this(context, "smartpos.db", null, 1);;

    }

    public DataHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "smartpos.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String   CreateDBSQL = "CREATE TABLE \"POS\" (\n" +
                "\t \"ID\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t \"IP\" TEXT(14,0) NOT NULL,\n" +
                "\t \"PORT\" TEXT(5,0) NOT NULL,\n" +
                "\t \"RESERVE_IP\" TEXT(14,0),\n" +
                "\t \"RESERVE_PORT\" TEXT(5,0),\n" +
                "\t \"SERIAL_NO\" TEXT(6,0)\n" +
                ");\n" +
                "\n" +
                "\n" +
                "CREATE TABLE \"REQUEST_TRADE\" (\n" +
                "\t \"ID\" INTEGER NOT NULL,\n" +
                "\t \"SERIAL_NO\" TEXT(6,0) NOT NULL,\n" +
                "\t \"BATCH_NO\" TEXT(6,0) NOT NULL,\n" +
                "\t \"MSG_ID\" TEXT(4,0),\n" +
                "\t \"BIT_MAP\" TEXT(20,0),\n" +
                "\t \"PAN\" TEXT(19,0),\n" +
                "\t \"PRO_COD\" TEXT(6,0),\n" +
                "\t \"TTXN_AMT\" TEXT(12,0),\n" +
                "\t \"F5\" TEXT(20,0),\n" +
                "\t \"F6\" TEXT(20,0),\n" +
                "\t \"F7\" TEXT(20,0),\n" +
                "\t \"F8\" TEXT(20,0),\n" +
                "\t \"F9\" TEXT(20,0),\n" +
                "\t \"F10\" TEXT(20,0),\n" +
                "\t \"CSEQ_NO\" TEXT(6,0),\n" +
                "\t \"CTXN_TM\" TEXT(6,0),\n" +
                "\t \"CTXN_DT\" TEXT(4,0),\n" +
                "\t \"EXP_DT\" TEXT(4,0),\n" +
                "\t \"STL_DAT\" TEXT(4,0),\n" +
                "\t \"F16\" TEXT(20,0),\n" +
                "\t \"F17\" TEXT(20,0),\n" +
                "\t \"F18\" TEXT(20,0),\n" +
                "\t \"F19\" TEXT(20,0),\n" +
                "\t \"F20\" TEXT(20,0),\n" +
                "\t \"F21\" TEXT(20,0),\n" +
                "\t \"IN_MOD\" TEXT(3,0),\n" +
                "\t \"SEP_NUM\" TEXT(3,0),\n" +
                "\t \"F24\" TEXT(20,0),\n" +
                "\t \"CON_MOD\" TEXT(2,0),\n" +
                "\t \"PIN_CAP_CODE\" TEXT(2,0),\n" +
                "\t \"F27\" TEXT(20,0),\n" +
                "\t \"F28\" TEXT(20,0),\n" +
                "\t \"F29\" TEXT(20,0),\n" +
                "\t \"F30\" TEXT(20,0),\n" +
                "\t \"F31\" TEXT(20,0),\n" +
                "\t \"ACQ_COD\" TEXT(11,0),\n" +
                "\t \"F33\" TEXT(20,0),\n" +
                "\t \"F34\" TEXT(20,0),\n" +
                "\t \"TRACK_2\" TEXT(37,0),\n" +
                "\t \"TRACK_3\" TEXT(104,0),\n" +
                "\t \"RET_RE_NO\" TEXT(12,0),\n" +
                "\t \"AUT_CD\" TEXT(6,0),\n" +
                "\t \"CPSCOD\" TEXT(2,0),\n" +
                "\t \"F40\" TEXT(20,0),\n" +
                "\t \"TRM_NO\" TEXT(8,0),\n" +
                "\t \"MERC_CD\" TEXT(15,0),\n" +
                "\t \"F43\" TEXT(20,0),\n" +
                "\t \"ADD_DATA\" TEXT(25,0),\n" +
                "\t \"F45\" TEXT(20,0),\n" +
                "\t \"F46\" TEXT(20,0),\n" +
                "\t \"F47\" TEXT(20,0),\n" +
                "\t \"PRI_USE\" TEXT(20,0),\n" +
                "\t \"CCY\" TEXT(3,0),\n" +
                "\t \"F50\" TEXT(20,0),\n" +
                "\t \"F51\" TEXT(20,0),\n" +
                "\t \"PIN_DATA\" TEXT(64,0),\n" +
                "\t \"SECUR_INF\" TEXT(16,0),\n" +
                "\t \"BAL_AMT\" TEXT(20,0),\n" +
                "\t \"IC_DAT\" TEXT(255,0),\n" +
                "\t \"F56\" TEXT(20,0),\n" +
                "\t \"F57\" TEXT(999,0),\n" +
                "\t \"PBOC_DATA\" TEXT(999,0),\n" +
                "\t \"F59\" TEXT(20,0),\n" +
                "\t \"RESE_PRI_60\" TEXT(17,0),\n" +
                "\t \"ORI_MES\" TEXT(29,0),\n" +
                "\t \"RESE_PRI_62\" TEXT(50,0),\n" +
                "\t \"RESE_PRI_63\" TEXT(63,0),\n" +
                "\t \"MAC\" TEXT(64,0),\n" +
                "\tPRIMARY KEY(\"ID\")\n" +
                ");\n" +
                "\n" +
                "\n" +
                "CREATE TABLE \"TRADE\" (\n" +
                "\t \"ID\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t \"SERIAL_NO\" TEXT(6,0) NOT NULL,\n" +
                "\t \"BATCH_NO\" TEXT(6,0) NOT NULL,\n" +
                "\t \"AMOUNT\" DOUBLE,\n" +
                "\t \"TRADE_TYPE\" TEXT(10,0),\n" +
                "\t \"TRADE_STATUS\" TEXT(1,0),\n" +
                "\t \"TRADE_TIME\" TIME,\n" +
                "\t \"CONSUME_TYPE\" TEXT(10,0)\n" +
                ");\n" +
                "\n" +
                "\n";

        db.execSQL(CreateDBSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
