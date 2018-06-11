package com.gabcode.randomgallery_mvvm.data.source.remote;


import com.gabcode.randomgallery_mvvm.data.UserProfile;

import java.util.List;

public class ResponseApiArray {

    private List<UserProfile> results;
    private Info info;

    public List<UserProfile> getResults() {
        return results;
    }

    public void setResults(List<UserProfile> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
