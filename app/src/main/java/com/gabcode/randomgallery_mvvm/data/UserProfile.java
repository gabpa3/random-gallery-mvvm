package com.gabcode.randomgallery_mvvm.data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

public class UserProfile extends BaseObservable implements Parcelable {

    private String gender;
    private Name name;
    private String email;
    private Login login;
    private Picture picture;

    protected UserProfile(Parcel in) {
        gender = in.readString();
        name = in.readParcelable(Name.class.getClassLoader());
        email = in.readString();
        login = in.readParcelable(Login.class.getClassLoader());
        picture = in.readParcelable(Picture.class.getClassLoader());
    }

    public static final Creator<UserProfile> CREATOR = new Creator<UserProfile>() {
        @Override
        public UserProfile createFromParcel(Parcel in) {
            return new UserProfile(in);
        }

        @Override
        public UserProfile[] newArray(int size) {
            return new UserProfile[size];
        }
    };

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Bindable
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Bindable
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Bindable
    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(gender);
        dest.writeParcelable(name, flags);
        dest.writeString(email);
        dest.writeParcelable(login, flags);
        dest.writeParcelable(picture, flags);
    }
}
