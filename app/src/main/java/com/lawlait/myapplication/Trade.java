package com.lawlait.myapplication;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by lawlait on 2017/12/4.
 */
@Entity
public class Trade {

    @Generated(hash = 1544510903)
    public Trade(long ID, String serial_no, String batch_no, Double amount,
            String trade_type, String trade_status, String trade_time,
            String consume_type) {
        this.ID = ID;
        this.serial_no = serial_no;
        this.batch_no = batch_no;
        this.amount = amount;
        this.trade_type = trade_type;
        this.trade_status = trade_status;
        this.trade_time = trade_time;
        this.consume_type = consume_type;
    }

    @Generated(hash = 1773414334)
    public Trade() {
    }

    public long getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSerial_no() {
        return this.serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    public String getBatch_no() {
        return this.batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTrade_type() {
        return this.trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getTrade_status() {
        return this.trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getTrade_time() {
        return this.trade_time;
    }

    public void setTrade_time(String trade_time) {
        this.trade_time = trade_time;
    }

    public String getConsume_type() {
        return this.consume_type;
    }

    public void setConsume_type(String consume_type) {
        this.consume_type = consume_type;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    @Id
    long ID;
    String serial_no;
    String batch_no;
    Double amount;// DOUBLE,
    String trade_type;// TEXT(10,0),
    String trade_status; //TEXT(1,0),
    String trade_time;//TIME,
    String consume_type; //TEXT(10,0)

}
