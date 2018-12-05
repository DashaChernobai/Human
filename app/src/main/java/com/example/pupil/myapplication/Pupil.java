package com.example.pupil.myapplication;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;

import timber.log.Timber;

public class Pupil extends Human implements PupilInterface, Parcelable {


    protected Pupil(Parcel in) {
        setName(in.readString());
        setSurname(in.readString());
    }

    public static final Creator<Pupil> CREATOR = new Creator<Pupil>() {
        @Override
        public Pupil createFromParcel(Parcel in) {
            return new Pupil(in);
        }

        @Override
        public Pupil[] newArray(int size) {
            return new Pupil[size];
        }
    };

    @Override
    public void run() {
        super.run();
        Timber.i("И мне это нравится.");
        Log.d("", "И мне это нравится.");
    }

    @Override
    public void eat() {
        super.eat();
        Timber.i("И мне это нравится.");
        Log.d("", "И мне это нравится.");
    }

    @Override
    public void write() {
        Timber.i("Я могу писать.");
        Log.d("", "Я могу писать.");
    }

    @Override
    public void read() {
        Timber.i("Я могу читать.");
        Log.d("", "Я могу читать.");
    }

    public Pupil() {

    }

    public Pupil(String name, String surname) {
        this.setName(name);
        this.setSurname(surname);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeString(getSurname());
    }
}
