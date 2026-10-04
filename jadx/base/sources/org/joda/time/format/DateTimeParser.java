package org.joda.time.format;

/* JADX INFO: loaded from: classes9.dex */
public interface DateTimeParser {
    int estimateParsedLength();

    int parseInto(DateTimeParserBucket dateTimeParserBucket, String str, int i);
}
