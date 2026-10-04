package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class ListTeamDevicesErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListTeamDevicesError errorValue;

    public ListTeamDevicesErrorException(String str, String str2, LocalizedText localizedText, ListTeamDevicesError listTeamDevicesError) {
        super(str2, localizedText, buildMessage(str, localizedText, listTeamDevicesError));
        if (listTeamDevicesError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listTeamDevicesError;
    }
}
