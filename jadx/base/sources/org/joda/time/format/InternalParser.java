package org.joda.time.format;

/* JADX INFO: loaded from: classes9.dex */
interface InternalParser {
    int estimateParsedLength();

    int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i);
}
