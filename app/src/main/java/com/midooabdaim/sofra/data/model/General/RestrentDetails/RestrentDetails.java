
package com.midooabdaim.sofra.data.model.General.RestrentDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestrentDetails {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private DetailsData data;

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

    public DetailsData getData() {
        return data;
    }

    public void setData(DetailsData data) {
        this.data = data;
    }

}
