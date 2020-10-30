package com.example.hotrovn.utilities.model.country;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Country {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Image")
    @Expose
    private Integer image;

    public Country(Integer id, String name, String code, Integer image) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.image = image;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    @SerializedName("Province")
    @Expose
    private List<Province> province = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Province> getProvince() {
        return province;
    }

    public void setProvince(List<Province> province) {
        this.province = province;
    }
}
