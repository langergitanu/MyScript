package com.myscript.nebo.dms.sharepage.dialog;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SinglePageUIController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/Result;", "", "<init>", "()V", "UpdateUI", "Error", "Lcom/myscript/nebo/dms/sharepage/dialog/Result$Error;", "Lcom/myscript/nebo/dms/sharepage/dialog/Result$UpdateUI;", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class Result {
    public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: SinglePageUIController.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/Result$UpdateUI;", "Lcom/myscript/nebo/dms/sharepage/dialog/Result;", "<init>", "()V", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class UpdateUI extends Result {
        public static final UpdateUI INSTANCE = new UpdateUI();

        private UpdateUI() {
            super(null);
        }
    }

    private Result() {
    }

    /* JADX INFO: compiled from: SinglePageUIController.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/Result$Error;", "Lcom/myscript/nebo/dms/sharepage/dialog/Result;", "<init>", "()V", "Generic", "NotOwner", "Lcom/myscript/nebo/dms/sharepage/dialog/Result$Error$Generic;", "Lcom/myscript/nebo/dms/sharepage/dialog/Result$Error$NotOwner;", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class Error extends Result {
        public /* synthetic */ Error(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: SinglePageUIController.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/Result$Error$Generic;", "Lcom/myscript/nebo/dms/sharepage/dialog/Result$Error;", "<init>", "()V", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Generic extends Error {
            public static final Generic INSTANCE = new Generic();

            private Generic() {
                super(null);
            }
        }

        private Error() {
            super(null);
        }

        /* JADX INFO: compiled from: SinglePageUIController.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/Result$Error$NotOwner;", "Lcom/myscript/nebo/dms/sharepage/dialog/Result$Error;", "<init>", "()V", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class NotOwner extends Error {
            public static final NotOwner INSTANCE = new NotOwner();

            private NotOwner() {
                super(null);
            }
        }
    }
}
