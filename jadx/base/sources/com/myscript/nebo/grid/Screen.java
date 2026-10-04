package com.myscript.nebo.grid;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/grid/Screen;", "", "<init>", "()V", "Notebooks", "Trash", "Lcom/myscript/nebo/grid/Screen$Notebooks;", "Lcom/myscript/nebo/grid/Screen$Trash;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class Screen {
    public static final int $stable = 0;

    public /* synthetic */ Screen(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/Screen$Notebooks;", "Lcom/myscript/nebo/grid/Screen;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Notebooks extends Screen {
        public static final int $stable = 0;
        public static final Notebooks INSTANCE = new Notebooks();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Notebooks)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 487974750;
        }

        public String toString() {
            return "Notebooks";
        }

        private Notebooks() {
            super(null);
        }
    }

    private Screen() {
    }

    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/Screen$Trash;", "Lcom/myscript/nebo/grid/Screen;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Trash extends Screen {
        public static final int $stable = 0;
        public static final Trash INSTANCE = new Trash();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Trash)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 230220702;
        }

        public String toString() {
            return "Trash";
        }

        private Trash() {
            super(null);
        }
    }
}
