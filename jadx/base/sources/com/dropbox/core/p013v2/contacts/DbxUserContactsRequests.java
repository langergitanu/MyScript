package com.dropbox.core.p013v2.contacts;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.contacts.DeleteManualContactsArg;
import com.dropbox.core.p013v2.contacts.DeleteManualContactsError;
import com.dropbox.core.stone.StoneSerializers;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DbxUserContactsRequests {
    private final DbxRawClientV2 client;

    public DbxUserContactsRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    public void deleteManualContacts() throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/contacts/delete_manual_contacts", null, false, StoneSerializers.void_(), StoneSerializers.void_(), StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"delete_manual_contacts\":" + e.getErrorValue());
        }
    }

    void deleteManualContactsBatch(DeleteManualContactsArg deleteManualContactsArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/contacts/delete_manual_contacts_batch", deleteManualContactsArg, false, DeleteManualContactsArg.Serializer.INSTANCE, StoneSerializers.void_(), DeleteManualContactsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DeleteManualContactsErrorException("2/contacts/delete_manual_contacts_batch", e.getRequestId(), e.getUserMessage(), (DeleteManualContactsError) e.getErrorValue());
        }
    }

    public void deleteManualContactsBatch(List<String> list) throws DbxException {
        deleteManualContactsBatch(new DeleteManualContactsArg(list));
    }
}
