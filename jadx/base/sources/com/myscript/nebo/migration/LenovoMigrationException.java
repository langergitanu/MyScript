package com.myscript.nebo.migration;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MigrationProgress.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/migration/LenovoMigrationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/myscript/nebo/migration/MigrationError;", "detail", "", "cause", "", "<init>", "(Lcom/myscript/nebo/migration/MigrationError;Ljava/lang/String;Ljava/lang/Throwable;)V", "getError", "()Lcom/myscript/nebo/migration/MigrationError;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LenovoMigrationException extends Exception {
    public static final int $stable = 8;
    private final MigrationError error;

    public /* synthetic */ LenovoMigrationException(MigrationError migrationError, String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(migrationError, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : th);
    }

    public final MigrationError getError() {
        return this.error;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LenovoMigrationException(MigrationError error, String str, Throwable th) {
        String string;
        Intrinsics.checkNotNullParameter(error, "error");
        super("Lenovo migration failed [" + error.getCode() + "]" + ((str == null || (string = new StringBuilder(": ").append(str).toString()) == null) ? "" : string), th);
        this.error = error;
    }
}
