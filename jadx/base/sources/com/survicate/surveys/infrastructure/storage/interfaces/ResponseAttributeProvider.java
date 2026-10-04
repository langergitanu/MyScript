package com.survicate.surveys.infrastructure.storage.interfaces;

import com.survicate.surveys.ResponseAttribute;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ResponseAttributeProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/interfaces/ResponseAttributeProvider;", "", "provideResponseAttributes", "", "Lcom/survicate/surveys/ResponseAttribute;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ResponseAttributeProvider {
    List<ResponseAttribute> provideResponseAttributes();
}
