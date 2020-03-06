package com.example.gymapp;

import android.os.Parcel;
import android.os.Parcelable;

public class plan implements Parcelable {
    private  GymTraining training;
    private int minutes;
    private  String date;
    private boolean isAccomplished;

    public plan() {
    }

    public plan(GymTraining training, int minutes, String date, boolean isAccomplished) {
        this.training = training;
        this.minutes = minutes;
        this.date = date;
        this.isAccomplished = isAccomplished;
    }


    protected plan(Parcel in) {
        training = in.readParcelable(GymTraining.class.getClassLoader());
        minutes = in.readInt();
        date = in.readString();
        isAccomplished = in.readByte() != 0;
    }

    public static final Creator<plan> CREATOR = new Creator<plan>() {
        @Override
        public plan createFromParcel(Parcel in) {
            return new plan(in);
        }

        @Override
        public plan[] newArray(int size) {
            return new plan[size];
        }
    };

    public GymTraining getTraining() {
        return training;
    }

    public void setTraining(GymTraining training) {
        this.training = training;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isAccomplished() {
        return isAccomplished;
    }

    public void setAccomplished(boolean accomplished) {
        isAccomplished = accomplished;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(training, flags);
        dest.writeInt(minutes);
        dest.writeString(date);
    }
}
