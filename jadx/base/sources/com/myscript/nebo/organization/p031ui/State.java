package com.myscript.nebo.organization.p031ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MandatoryLoginViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/organization/ui/State;", "", "<init>", "()V", "Loading", "Login", "LoggedIn", "Lcom/myscript/nebo/organization/ui/State$Loading;", "Lcom/myscript/nebo/organization/ui/State$LoggedIn;", "Lcom/myscript/nebo/organization/ui/State$Login;", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class State {
    public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: MandatoryLoginViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/organization/ui/State$Loading;", "Lcom/myscript/nebo/organization/ui/State;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Loading extends State {
        public static final Loading INSTANCE = new Loading();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Loading)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1863668960;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
            super(null);
        }
    }

    private State() {
    }

    /* JADX INFO: compiled from: MandatoryLoginViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/organization/ui/State$Login;", "Lcom/myscript/nebo/organization/ui/State;", "hasUserBeenKickedOut", "", "<init>", "(Z)V", "getHasUserBeenKickedOut", "()Z", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Login extends State {
        private final boolean hasUserBeenKickedOut;

        public Login() {
            this(false, 1, null);
        }

        public Login(boolean z) {
            super(null);
            this.hasUserBeenKickedOut = z;
        }

        public /* synthetic */ Login(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean getHasUserBeenKickedOut() {
            return this.hasUserBeenKickedOut;
        }
    }

    /* JADX INFO: compiled from: MandatoryLoginViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/organization/ui/State$LoggedIn;", "Lcom/myscript/nebo/organization/ui/State;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class LoggedIn extends State {
        public static final LoggedIn INSTANCE = new LoggedIn();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoggedIn)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 2113578787;
        }

        public String toString() {
            return "LoggedIn";
        }

        private LoggedIn() {
            super(null);
        }
    }
}
