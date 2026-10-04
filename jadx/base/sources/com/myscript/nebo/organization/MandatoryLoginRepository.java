package com.myscript.nebo.organization;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: MandatoryLoginRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u000e\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH&J\u000e\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0013À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/organization/MandatoryLoginRepository;", "", "hasUser", "", "canOpenApp", "getAuthorizeUrl", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "authorizationCode", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "", "loadOrganizationState", "Lcom/myscript/nebo/organization/MandatoryLoginRepository$OrganizationState;", "saveOrganizationState", "lastFetch", "", "OrganizationState", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface MandatoryLoginRepository {
    boolean canOpenApp();

    Object getAuthorizeUrl(Continuation<? super String> continuation);

    boolean hasUser();

    Object loadOrganizationState(Continuation<? super OrganizationState> continuation);

    Object login(String str, Continuation<? super Boolean> continuation);

    void logout();

    void saveOrganizationState(boolean canOpenApp, long lastFetch);

    /* JADX INFO: compiled from: MandatoryLoginRepository.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/organization/MandatoryLoginRepository$OrganizationState;", "", "canOpenApp", "", "lastFetch", "", "<init>", "(ZJ)V", "getCanOpenApp", "()Z", "getLastFetch", "()J", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class OrganizationState {
        private final boolean canOpenApp;
        private final long lastFetch;

        public static /* synthetic */ OrganizationState copy$default(OrganizationState organizationState, boolean z, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                z = organizationState.canOpenApp;
            }
            if ((i & 2) != 0) {
                j = organizationState.lastFetch;
            }
            return organizationState.copy(z, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getCanOpenApp() {
            return this.canOpenApp;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getLastFetch() {
            return this.lastFetch;
        }

        public final OrganizationState copy(boolean canOpenApp, long lastFetch) {
            return new OrganizationState(canOpenApp, lastFetch);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OrganizationState)) {
                return false;
            }
            OrganizationState organizationState = (OrganizationState) other;
            return this.canOpenApp == organizationState.canOpenApp && this.lastFetch == organizationState.lastFetch;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.canOpenApp) * 31) + Long.hashCode(this.lastFetch);
        }

        public String toString() {
            return "OrganizationState(canOpenApp=" + this.canOpenApp + ", lastFetch=" + this.lastFetch + ")";
        }

        public OrganizationState(boolean z, long j) {
            this.canOpenApp = z;
            this.lastFetch = j;
        }

        public final boolean getCanOpenApp() {
            return this.canOpenApp;
        }

        public final long getLastFetch() {
            return this.lastFetch;
        }
    }
}
