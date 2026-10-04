package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class DateRangeErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final DateRangeError errorValue;

    public DateRangeErrorException(String str, String str2, LocalizedText localizedText, DateRangeError dateRangeError) {
        super(str2, localizedText, buildMessage(str, localizedText, dateRangeError));
        if (dateRangeError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = dateRangeError;
    }
}
