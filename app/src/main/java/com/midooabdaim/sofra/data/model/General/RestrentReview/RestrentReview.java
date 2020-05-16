
package com.midooabdaim.sofra.data.model.General.RestrentReview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestrentReview {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private ResterentReviewPagination data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResterentReviewPagination getData() {
        return data;
    }

    public void setData(ResterentReviewPagination data) {
        this.data = data;
    }

}
