
package com.midooabdaim.sofra.data.model.Client.RestrentAddReview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.midooabdaim.sofra.data.model.General.RestrentReview.ResterentReviewData;

public class Data {

    @SerializedName("review")
    @Expose
    private ResterentReviewData review;

    public ResterentReviewData getReview() {
        return review;
    }

    public void setReview(ResterentReviewData review) {
        this.review = review;
    }

}
