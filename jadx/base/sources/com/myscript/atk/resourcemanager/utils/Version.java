package com.myscript.atk.resourcemanager.utils;

/* JADX INFO: loaded from: classes4.dex */
public class Version implements Comparable<Version> {
    private final String mVersion;

    public Version() {
        this(null);
    }

    public static boolean isValidVersion(String str) {
        return str == null || str.matches("[0-9]+(\\.[0-9]+)*");
    }

    public Version(String str) {
        if (!isValidVersion(str)) {
            throw new IllegalArgumentException(String.format("Invalid version format  : '%s'.", str));
        }
        this.mVersion = str;
    }

    public final String toString() {
        return this.mVersion;
    }

    @Override // java.lang.Comparable
    public int compareTo(Version version) {
        if (version == null) {
            return 1;
        }
        String str = this.mVersion;
        if (str == null || version.mVersion == null) {
            return -1;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = version.mVersion.split("\\.");
        int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
        int i = 0;
        while (i < iMax) {
            int i2 = i < strArrSplit.length ? Integer.parseInt(strArrSplit[i]) : 0;
            int i3 = i < strArrSplit2.length ? Integer.parseInt(strArrSplit2[i]) : 0;
            if (i2 < i3) {
                return -1;
            }
            if (i2 > i3) {
                return 1;
            }
            i++;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && compareTo((Version) obj) == 0;
    }

    public int hashCode() {
        return this.mVersion.hashCode();
    }
}
