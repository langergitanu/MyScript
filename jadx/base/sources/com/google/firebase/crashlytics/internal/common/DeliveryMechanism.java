package com.google.firebase.crashlytics.internal.common;

/* JADX INFO: loaded from: classes3.dex */
public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* JADX INFO: renamed from: id */
    private final int f1237id;

    DeliveryMechanism(int i) {
        this.f1237id = i;
    }

    public int getId() {
        return this.f1237id;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f1237id);
    }

    public static DeliveryMechanism determineFrom(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }
}
