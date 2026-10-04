package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class ListMemberDevicesErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListMemberDevicesError errorValue;

    public ListMemberDevicesErrorException(String str, String str2, LocalizedText localizedText, ListMemberDevicesError listMemberDevicesError) {
        super(str2, localizedText, buildMessage(str, localizedText, listMemberDevicesError));
        if (listMemberDevicesError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listMemberDevicesError;
    }
}
