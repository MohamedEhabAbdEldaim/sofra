package com.midooabdaim.sofra.data.api;

import com.midooabdaim.sofra.data.model.Client.RestrentAddReview.RestrentAddReview;
import com.midooabdaim.sofra.data.model.General.ResterentItem.ResterentItem;
import com.midooabdaim.sofra.data.model.General.RestrentDetails.RestrentDetails;
import com.midooabdaim.sofra.data.model.General.RestrentReview.RestrentReview;
import com.midooabdaim.sofra.data.model.General.Resturant.ResturantList;
import com.midooabdaim.sofra.data.model.General.categories.Categories;
import com.midooabdaim.sofra.data.model.General.cityAndRegion.CitiesAndRegion;
import com.midooabdaim.sofra.data.model.Resterent.loginResterent.LoginResterent;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiService {
    @GET("restaurants")
    Call<ResturantList> getRestaurants(@Query("page") int page);

    @GET("restaurants")
    Call<ResturantList> getResterentWithFilter(@Query("page") int page,
                                               @Query("keyword") String keyword,
                                               @Query("region_id") int region_id);

    @GET("cities-not-paginated")
    Call<CitiesAndRegion> getCity();

    @GET("regions-not-paginated")
    Call<CitiesAndRegion> getRegion(@Query("city_id") int city_id);

    @GET("categories")
    Call<Categories> getCategories(@Query("restaurant_id") int restaurant_id);

    @GET("items")
    Call<ResterentItem> getRestentitem(@Query("restaurant_id") int restaurant_id,
                                       @Query("category_id") int category_id,
                                       @Query("page") int page);

    @GET("restaurant")
    Call<RestrentDetails> getDetails(@Query("restaurant_id") int restaurant_id);

    @GET("restaurant/reviews")
    Call<RestrentReview> getRestaurantReviews(@Query("api_token") String apiToken,
                                              @Query("restaurant_id") int restaurantId,
                                              @Query("page") int page);

    @POST("client/restaurant/review")
    @FormUrlEncoded
    Call<RestrentAddReview> addReview(@Field("rate") float rate,
                                      @Field("comment") String comment,
                                      @Field("restaurant_id") int resId,
                                      @Field("api_token") String apiToken);

    @POST("restaurant/login")
    @FormUrlEncoded
    Call<LoginResterent> getLoginResterent(@Field("email") String email,
                                  @Field("password") String password);


}
