package androidx.room.util;

import androidx.sqlite.SQLiteStatement;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"androidx/room/util/SQLiteStatementUtil__StatementUtilKt", "androidx/room/util/SQLiteStatementUtil__StatementUtil_androidKt"}, m1600k = 4, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SQLiteStatementUtil {
    public static final int columnIndexOf(SQLiteStatement sQLiteStatement, String str) {
        return SQLiteStatementUtil__StatementUtil_androidKt.columnIndexOf(sQLiteStatement, str);
    }

    public static final int columnIndexOfCommon(SQLiteStatement sQLiteStatement, String str) {
        return SQLiteStatementUtil__StatementUtilKt.columnIndexOfCommon(sQLiteStatement, str);
    }

    public static final int getColumnIndex(SQLiteStatement sQLiteStatement, String str) {
        return SQLiteStatementUtil__StatementUtilKt.getColumnIndex(sQLiteStatement, str);
    }

    public static final int getColumnIndexOrThrow(SQLiteStatement sQLiteStatement, String str) {
        return SQLiteStatementUtil__StatementUtilKt.getColumnIndexOrThrow(sQLiteStatement, str);
    }

    public static final SQLiteStatement wrapMappedColumns(SQLiteStatement sQLiteStatement, String[] strArr, int[] iArr) {
        return SQLiteStatementUtil__StatementUtilKt.wrapMappedColumns(sQLiteStatement, strArr, iArr);
    }
}
