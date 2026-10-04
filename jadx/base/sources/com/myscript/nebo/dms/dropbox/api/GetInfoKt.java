package com.myscript.nebo.dms.dropbox.api;

import com.dropbox.core.p013v2.DbxClientV2;
import com.dropbox.core.p013v2.users.DbxUserUsersRequests;
import com.dropbox.core.p013v2.users.FullAccount;
import com.dropbox.core.p013v2.users.SpaceAllocation;
import com.dropbox.core.p013v2.users.SpaceUsage;
import com.myscript.nebo.dms.cloud.common.api.AccountInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetInfo.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"getAccountInfo", "Lcom/myscript/nebo/dms/cloud/common/api/AccountInfo;", "Lcom/dropbox/core/v2/DbxClientV2;", "dms-dropbox_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetInfoKt {
    public static final AccountInfo getAccountInfo(DbxClientV2 dbxClientV2) {
        long allocated;
        long j;
        Intrinsics.checkNotNullParameter(dbxClientV2, "<this>");
        DbxUserUsersRequests dbxUserUsersRequestsUsers = dbxClientV2.users();
        if (dbxUserUsersRequestsUsers == null) {
            dbxUserUsersRequestsUsers = null;
        }
        FullAccount currentAccount = dbxUserUsersRequestsUsers != null ? dbxUserUsersRequestsUsers.getCurrentAccount() : null;
        SpaceUsage spaceUsage = dbxUserUsersRequestsUsers != null ? dbxUserUsersRequestsUsers.getSpaceUsage() : null;
        SpaceAllocation allocation = spaceUsage != null ? spaceUsage.getAllocation() : null;
        if (allocation != null) {
            if (allocation.isIndividual()) {
                allocated = allocation.getIndividualValue().getAllocated();
            } else {
                if (allocation.isTeam()) {
                    allocated = allocation.getTeamValue().getAllocated();
                }
                j = 0;
            }
            j = allocated;
        } else {
            j = 0;
        }
        return new AccountInfo(currentAccount != null ? currentAccount.getEmail() : null, j, spaceUsage != null ? spaceUsage.getUsed() : 0L);
    }
}
