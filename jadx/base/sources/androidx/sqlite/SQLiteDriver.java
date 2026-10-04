package androidx.sqlite;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;

/* JADX INFO: compiled from: SQLiteDriver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, m1599d2 = {"Landroidx/sqlite/SQLiteDriver;", "", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "Landroidx/sqlite/SQLiteConnection;", "fileName", "", "sqlite_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public interface SQLiteDriver {
    SQLiteConnection open(String fileName);
}
