package com.myscript.atk.resourcemanager.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class Latest {
    private Integer mDelay;
    private final Map<String, String> mLanguagesHashes = new HashMap();
    private Version mVersion;

    public Version getVersion() {
        return this.mVersion;
    }

    public void setVersion(Version version) {
        this.mVersion = version;
    }

    public void addLanguageHash(String str, String str2) {
        this.mLanguagesHashes.put(str, str2);
    }

    public Map<String, String> getLanguagesHashes() {
        return this.mLanguagesHashes;
    }

    public String getLanguageHash(String str) {
        return this.mLanguagesHashes.get(str);
    }

    public Set<String> getLanguages() {
        return this.mLanguagesHashes.keySet();
    }
}
