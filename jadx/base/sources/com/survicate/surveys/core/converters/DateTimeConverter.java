package com.survicate.surveys.core.converters;

import kotlin.Metadata;

/* JADX INFO: compiled from: DateTimeConverter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/core/converters/DateTimeConverter;", "", "fromIsoStringToMillis", "", "dateTimeIso", "", "(Ljava/lang/String;)Ljava/lang/Long;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface DateTimeConverter {
    Long fromIsoStringToMillis(String dateTimeIso);
}
