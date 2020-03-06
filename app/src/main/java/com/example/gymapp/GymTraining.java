package com.example.gymapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class GymTraining implements Parcelable {

    private int id;
    private String name ,shortdes,longdes,imageUrl;

    public GymTraining(int id, String name, String shortdes, String longdes, String imageUrl) {
        this.id = id;
        this.name = name;
        this.shortdes = shortdes;
        this.longdes = longdes;
        this.imageUrl = imageUrl;
    }
    public GymTraining()
    {}

    protected GymTraining(Parcel in) {
        id = in.readInt();
        name = in.readString();
        shortdes = in.readString();
        longdes = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<GymTraining> CREATOR = new Creator<GymTraining>() {
        @Override
        public GymTraining createFromParcel(Parcel in) {
            return new GymTraining(in);
        }

        @Override
        public GymTraining[] newArray(int size) {
            return new GymTraining[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortdes() {
        return shortdes;
    }

    public void setShortdes(String shortdes) {
        this.shortdes = shortdes;
    }

    public String getLongdes() {
        return longdes;
    }

    public void setLongdes(String longdes) {
        this.longdes = longdes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "GymTraining{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortdes='" + shortdes + '\'' +
                ", longdes='" + longdes + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(shortdes);
        dest.writeString(longdes);
        dest.writeString(imageUrl);
    }
}
