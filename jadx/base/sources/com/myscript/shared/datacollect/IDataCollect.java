package com.myscript.shared.datacollect;

import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: DataCollect.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JN\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/shared/datacollect/IDataCollect;", "", "sendFileForDataCollect", "", "file", "Ljava/io/File;", "ssoId", "", "appVersion", "uuid", "lastModificationDate", "", "title", "userStatus", "creationDate", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IDataCollect {
    Object sendFileForDataCollect(File file, String str, String str2, String str3, long j, String str4, String str5, long j2, Continuation<? super Boolean> continuation);
}
