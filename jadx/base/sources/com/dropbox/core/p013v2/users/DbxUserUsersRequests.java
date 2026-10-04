package com.dropbox.core.p013v2.users;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.users.BasicAccount;
import com.dropbox.core.p013v2.users.FullAccount;
import com.dropbox.core.p013v2.users.GetAccountArg;
import com.dropbox.core.p013v2.users.GetAccountBatchArg;
import com.dropbox.core.p013v2.users.GetAccountBatchError;
import com.dropbox.core.p013v2.users.GetAccountError;
import com.dropbox.core.p013v2.users.SpaceUsage;
import com.dropbox.core.p013v2.users.UserFeaturesGetValuesBatchArg;
import com.dropbox.core.p013v2.users.UserFeaturesGetValuesBatchError;
import com.dropbox.core.p013v2.users.UserFeaturesGetValuesBatchResult;
import com.dropbox.core.stone.StoneSerializers;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class DbxUserUsersRequests {
    private final DbxRawClientV2 client;

    public DbxUserUsersRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    UserFeaturesGetValuesBatchResult featuresGetValues(UserFeaturesGetValuesBatchArg userFeaturesGetValuesBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (UserFeaturesGetValuesBatchResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/users/features/get_values", userFeaturesGetValuesBatchArg, false, UserFeaturesGetValuesBatchArg.Serializer.INSTANCE, UserFeaturesGetValuesBatchResult.Serializer.INSTANCE, UserFeaturesGetValuesBatchError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new UserFeaturesGetValuesBatchErrorException("2/users/features/get_values", e.getRequestId(), e.getUserMessage(), (UserFeaturesGetValuesBatchError) e.getErrorValue());
        }
    }

    public UserFeaturesGetValuesBatchResult featuresGetValues(List<UserFeature> list) throws DbxException {
        return featuresGetValues(new UserFeaturesGetValuesBatchArg(list));
    }

    BasicAccount getAccount(GetAccountArg getAccountArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (BasicAccount) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/users/get_account", getAccountArg, false, GetAccountArg.Serializer.INSTANCE, BasicAccount.Serializer.INSTANCE, GetAccountError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GetAccountErrorException("2/users/get_account", e.getRequestId(), e.getUserMessage(), (GetAccountError) e.getErrorValue());
        }
    }

    public BasicAccount getAccount(String str) throws DbxException {
        return getAccount(new GetAccountArg(str));
    }

    List<BasicAccount> getAccountBatch(GetAccountBatchArg getAccountBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (List) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/users/get_account_batch", getAccountBatchArg, false, GetAccountBatchArg.Serializer.INSTANCE, StoneSerializers.list(BasicAccount.Serializer.INSTANCE), GetAccountBatchError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GetAccountBatchErrorException("2/users/get_account_batch", e.getRequestId(), e.getUserMessage(), (GetAccountBatchError) e.getErrorValue());
        }
    }

    public List<BasicAccount> getAccountBatch(List<String> list) throws DbxException {
        return getAccountBatch(new GetAccountBatchArg(list));
    }

    public FullAccount getCurrentAccount() throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (FullAccount) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/users/get_current_account", null, false, StoneSerializers.void_(), FullAccount.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"get_current_account\":" + e.getErrorValue());
        }
    }

    public SpaceUsage getSpaceUsage() throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SpaceUsage) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/users/get_space_usage", null, false, StoneSerializers.void_(), SpaceUsage.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"get_space_usage\":" + e.getErrorValue());
        }
    }
}
