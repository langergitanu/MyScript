package com.survicate.surveys;

/* JADX INFO: loaded from: classes8.dex */
public class SurvicateVersionProvider {
    public String getSdkVersion() {
        return "8.3.0";
    }

    public boolean isSavedVersionUpToDate(String str) {
        return getSdkVersion().equals(str);
    }
}
