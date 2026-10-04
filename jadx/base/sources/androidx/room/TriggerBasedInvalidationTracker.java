package androidx.room;

import androidx.room.concurrent.CloseBarrier;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: InvalidationTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u0000 O2\u00020\u0001:\u0001OBo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&J9\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\fH\u0000¢\u0006\u0004\b-\u0010.J1\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0004\u0012\u00020+002\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\nH\u0000¢\u0006\u0004\b2\u00103J#\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\nH\u0002¢\u0006\u0002\u00105J\u0015\u00106\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b7J\u0015\u00108\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b9J\u0010\u0010:\u001a\u00020\u0010H\u0080@¢\u0006\u0004\b;\u0010<J\u001e\u0010=\u001a\u00020\u00102\u0006\u0010%\u001a\u00020>2\u0006\u0010?\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010@J\u001e\u0010A\u001a\u00020\u00102\u0006\u0010%\u001a\u00020>2\u0006\u0010?\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010@J@\u0010B\u001a\u00020\f2\u000e\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\n2\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00100\u001f2\u000e\b\u0002\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00100\u001fH\u0080@¢\u0006\u0004\bF\u0010GJ-\u0010H\u001a\u00020\u00102\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00100\u001f2\u000e\b\u0002\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00100\u001fH\u0000¢\u0006\u0002\bIJ\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0082@¢\u0006\u0002\u0010<J\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010%\u001a\u00020>H\u0082@¢\u0006\u0002\u0010LJ\r\u0010M\u001a\u00020\u0010H\u0000¢\u0006\u0002\bNR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00060\u001bj\u0002`\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006P"}, m1599d2 = {"Landroidx/room/TriggerBasedInvalidationTracker;", "", "database", "Landroidx/room/RoomDatabase;", "shadowTablesMap", "", "", "viewTables", "", "tableNames", "", "useTempTable", "", "onInvalidatedTablesIds", "Lkotlin/Function1;", "", "", "<init>", "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "tableIdLookup", "tablesNames", "[Ljava/lang/String;", "observedTableStates", "Landroidx/room/ObservedTableStates;", "observedTableVersions", "Landroidx/room/ObservedTableVersions;", "pendingRefresh", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onAllowRefresh", "Lkotlin/Function0;", "getOnAllowRefresh$room_runtime_release", "()Lkotlin/jvm/functions/Function0;", "setOnAllowRefresh$room_runtime_release", "(Lkotlin/jvm/functions/Function0;)V", "configureConnection", "connection", "Landroidx/sqlite/SQLiteConnection;", "createFlow", "Lkotlinx/coroutines/flow/Flow;", "resolvedTableNames", "tableIds", "", "emitInitialState", "createFlow$room_runtime_release", "([Ljava/lang/String;[IZ)Lkotlinx/coroutines/flow/Flow;", "validateTableNames", "Lkotlin/Pair;", "names", "validateTableNames$room_runtime_release", "([Ljava/lang/String;)Lkotlin/Pair;", "resolveViews", "([Ljava/lang/String;)[Ljava/lang/String;", "onObserverAdded", "onObserverAdded$room_runtime_release", "onObserverRemoved", "onObserverRemoved$room_runtime_release", "syncTriggers", "syncTriggers$room_runtime_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startTrackingTable", "Landroidx/room/PooledConnection;", "tableId", "(Landroidx/room/PooledConnection;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTrackingTable", "refreshInvalidation", "tables", "onRefreshScheduled", "onRefreshCompleted", "refreshInvalidation$room_runtime_release", "([Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshInvalidationAsync", "refreshInvalidationAsync$room_runtime_release", "notifyInvalidation", "checkInvalidatedTables", "(Landroidx/room/PooledConnection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetSync", "resetSync$room_runtime_release", "Companion", "room-runtime_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class TriggerBasedInvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String DROP_TRACKING_TABLE_SQL = "DROP TABLE IF EXISTS room_table_modification_log";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    private static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";
    private static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    private final RoomDatabase database;
    private final ObservedTableStates observedTableStates;
    private final ObservedTableVersions observedTableVersions;
    private Function0<Boolean> onAllowRefresh;
    private final Function1<Set<Integer>, Unit> onInvalidatedTablesIds;
    private final AtomicBoolean pendingRefresh;
    private final Map<String, String> shadowTablesMap;
    private final Map<String, Integer> tableIdLookup;
    private final String[] tablesNames;
    private final boolean useTempTable;
    private final Map<String, Set<String>> viewTables;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] TRIGGERS = {"INSERT", "UPDATE", "DELETE"};

    /* JADX INFO: renamed from: androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1 */
    /* JADX INFO: compiled from: InvalidationTracker.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.room.TriggerBasedInvalidationTracker", m1609f = "InvalidationTracker.kt", m1610i = {0, 1}, m1611l = {440, 448}, m1612m = "checkInvalidatedTables", m1613n = {"connection", "invalidatedTableIds"}, m1615s = {"L$0", "L$0"})
    static final class C26671 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C26671(Continuation<? super C26671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.checkInvalidatedTables(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1 */
    /* JADX INFO: compiled from: InvalidationTracker.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.room.TriggerBasedInvalidationTracker", m1609f = "InvalidationTracker.kt", m1610i = {0, 0}, m1611l = {412}, m1612m = "notifyInvalidation", m1613n = {"this", "$this$ifNotClosed$iv"}, m1615s = {"L$0", "L$1"})
    static final class C26701 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C26701(Continuation<? super C26701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.notifyInvalidation(this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.TriggerBasedInvalidationTracker$startTrackingTable$1 */
    /* JADX INFO: compiled from: InvalidationTracker.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.room.TriggerBasedInvalidationTracker", m1609f = "InvalidationTracker.kt", m1610i = {0, 0, 0, 1, 1, 1, 1}, m1611l = {PDFACompliance.e_PDFA3_2_3, 328}, m1612m = "startTrackingTable", m1613n = {"this", "connection", "tableId", "this", "connection", "tableName", "tableId"}, m1615s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0"})
    static final class C26721 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C26721(Continuation<? super C26721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.startTrackingTable(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 */
    /* JADX INFO: compiled from: InvalidationTracker.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.room.TriggerBasedInvalidationTracker", m1609f = "InvalidationTracker.kt", m1610i = {0, 0}, m1611l = {342}, m1612m = "stopTrackingTable", m1613n = {"connection", "tableName"}, m1615s = {"L$0", "L$1"})
    static final class C26731 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C26731(Continuation<? super C26731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.stopTrackingTable(null, 0, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onAllowRefresh$lambda$0() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TriggerBasedInvalidationTracker(RoomDatabase database, Map<String, String> shadowTablesMap, Map<String, ? extends Set<String>> viewTables, String[] tableNames, boolean z, Function1<? super Set<Integer>, Unit> onInvalidatedTablesIds) {
        String lowerCase;
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(shadowTablesMap, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(viewTables, "viewTables");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        Intrinsics.checkNotNullParameter(onInvalidatedTablesIds, "onInvalidatedTablesIds");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.useTempTable = z;
        this.onInvalidatedTablesIds = onInvalidatedTablesIds;
        this.pendingRefresh = new AtomicBoolean(false);
        this.onAllowRefresh = new Function0() { // from class: androidx.room.TriggerBasedInvalidationTracker$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(TriggerBasedInvalidationTracker.onAllowRefresh$lambda$0());
            }
        };
        this.tableIdLookup = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            String lowerCase2 = tableNames[i].toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            this.tableIdLookup.put(lowerCase2, Integer.valueOf(i));
            String str = this.shadowTablesMap.get(tableNames[i]);
            if (str != null) {
                lowerCase = str.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr[i] = lowerCase2;
        }
        this.tablesNames = strArr;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            String lowerCase3 = entry.getValue().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            if (this.tableIdLookup.containsKey(lowerCase3)) {
                String lowerCase4 = entry.getKey().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                Map<String, Integer> map = this.tableIdLookup;
                map.put(lowerCase4, (Integer) MapsKt.getValue(map, lowerCase3));
            }
        }
        this.observedTableStates = new ObservedTableStates(this.tablesNames.length);
        this.observedTableVersions = new ObservedTableVersions(this.tablesNames.length);
    }

    public final Function0<Boolean> getOnAllowRefresh$room_runtime_release() {
        return this.onAllowRefresh;
    }

    public final void setOnAllowRefresh$room_runtime_release(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onAllowRefresh = function0;
    }

    public final void configureConnection(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("PRAGMA query_only");
        try {
            SQLiteStatement sQLiteStatement = sQLiteStatementPrepare;
            sQLiteStatement.step();
            boolean z = sQLiteStatement.getBoolean(0);
            AutoCloseableKt.closeFinally(sQLiteStatementPrepare, null);
            if (z) {
                return;
            }
            SQLite.execSQL(connection, "PRAGMA temp_store = MEMORY");
            SQLite.execSQL(connection, "PRAGMA recursive_triggers = 1");
            SQLite.execSQL(connection, DROP_TRACKING_TABLE_SQL);
            if (this.useTempTable) {
                SQLite.execSQL(connection, CREATE_TRACKING_TABLE_SQL);
            } else {
                SQLite.execSQL(connection, StringsKt.replace$default(CREATE_TRACKING_TABLE_SQL, "TEMP", "", false, 4, (Object) null));
            }
            this.observedTableStates.forceNeedSync$room_runtime_release();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    public final Flow<Set<String>> createFlow$room_runtime_release(String[] resolvedTableNames, int[] tableIds, boolean emitInitialState) {
        Intrinsics.checkNotNullParameter(resolvedTableNames, "resolvedTableNames");
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        return FlowKt.flow(new TriggerBasedInvalidationTracker$createFlow$1(this, tableIds, emitInitialState, resolvedTableNames, null));
    }

    public final Pair<String[], int[]> validateTableNames$room_runtime_release(String[] names) {
        Intrinsics.checkNotNullParameter(names, "names");
        String[] strArrResolveViews = resolveViews(names);
        int length = strArrResolveViews.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            String str = strArrResolveViews[i];
            Map<String, Integer> map = this.tableIdLookup;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Integer num = map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
            iArr[i] = num.intValue();
        }
        return TuplesKt.m1606to(strArrResolveViews, iArr);
    }

    private final String[] resolveViews(String[] names) {
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        for (String str : names) {
            Map<String, Set<String>> map = this.viewTables;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Set<String> set = map.get(lowerCase);
            if (set != null) {
                setCreateSetBuilder.addAll(set);
            } else {
                setCreateSetBuilder.add(str);
            }
        }
        return (String[]) SetsKt.build(setCreateSetBuilder).toArray(new String[0]);
    }

    public final boolean onObserverAdded$room_runtime_release(int[] tableIds) {
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        return this.observedTableStates.onObserverAdded$room_runtime_release(tableIds);
    }

    public final boolean onObserverRemoved$room_runtime_release(int[] tableIds) {
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        return this.observedTableStates.onObserverRemoved$room_runtime_release(tableIds);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object syncTriggers$room_runtime_release(Continuation<? super Unit> continuation) throws Throwable {
        TriggerBasedInvalidationTracker$syncTriggers$1 triggerBasedInvalidationTracker$syncTriggers$1;
        CloseBarrier closeBarrier;
        Throwable th;
        if (continuation instanceof TriggerBasedInvalidationTracker$syncTriggers$1) {
            triggerBasedInvalidationTracker$syncTriggers$1 = (TriggerBasedInvalidationTracker$syncTriggers$1) continuation;
            if ((triggerBasedInvalidationTracker$syncTriggers$1.label & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$syncTriggers$1.label -= Integer.MIN_VALUE;
            } else {
                triggerBasedInvalidationTracker$syncTriggers$1 = new TriggerBasedInvalidationTracker$syncTriggers$1(this, continuation);
            }
        }
        Object obj = triggerBasedInvalidationTracker$syncTriggers$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = triggerBasedInvalidationTracker$syncTriggers$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CloseBarrier closeBarrier2 = this.database.getCloseBarrier();
            if (closeBarrier2.block$room_runtime_release()) {
                try {
                    RoomDatabase roomDatabase = this.database;
                    TriggerBasedInvalidationTracker$syncTriggers$2$1 triggerBasedInvalidationTracker$syncTriggers$2$1 = new TriggerBasedInvalidationTracker$syncTriggers$2$1(this, null);
                    triggerBasedInvalidationTracker$syncTriggers$1.L$0 = closeBarrier2;
                    triggerBasedInvalidationTracker$syncTriggers$1.label = 1;
                    if (roomDatabase.useConnection$room_runtime_release(false, triggerBasedInvalidationTracker$syncTriggers$2$1, triggerBasedInvalidationTracker$syncTriggers$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    closeBarrier = closeBarrier2;
                    closeBarrier.unblock$room_runtime_release();
                } catch (Throwable th2) {
                    closeBarrier = closeBarrier2;
                    th = th2;
                    closeBarrier.unblock$room_runtime_release();
                    throw th;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            closeBarrier = (CloseBarrier) triggerBasedInvalidationTracker$syncTriggers$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                closeBarrier.unblock$room_runtime_release();
            } catch (Throwable th3) {
                th = th3;
                closeBarrier.unblock$room_runtime_release();
                throw th;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0106, code lost:
    
        if (androidx.room.TransactorKt.execSQL(r11, r3, r4) == r5) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0106 -> B:29:0x0109). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startTrackingTable(PooledConnection pooledConnection, int i, Continuation<? super Unit> continuation) {
        C26721 c26721;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker;
        String[] strArr;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker2;
        int i2;
        int i3;
        PooledConnection pooledConnection2;
        int length;
        String str;
        PooledConnection pooledConnection3 = pooledConnection;
        int i4 = i;
        if (continuation instanceof C26721) {
            c26721 = (C26721) continuation;
            if ((c26721.label & Integer.MIN_VALUE) != 0) {
                c26721.label -= Integer.MIN_VALUE;
            } else {
                c26721 = new C26721(continuation);
            }
        }
        Object obj = c26721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c26721.label;
        boolean z = true;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            String str2 = "INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i4 + ", 0)";
            c26721.L$0 = this;
            c26721.L$1 = pooledConnection3;
            c26721.I$0 = i4;
            c26721.label = 1;
            if (TransactorKt.execSQL(pooledConnection3, str2, c26721) != coroutine_suspended) {
                triggerBasedInvalidationTracker = this;
            }
            return coroutine_suspended;
        }
        if (i5 == 1) {
            int i6 = c26721.I$0;
            PooledConnection pooledConnection4 = (PooledConnection) c26721.L$1;
            triggerBasedInvalidationTracker = (TriggerBasedInvalidationTracker) c26721.L$0;
            ResultKt.throwOnFailure(obj);
            i4 = i6;
            pooledConnection3 = pooledConnection4;
        } else {
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            length = c26721.I$2;
            i3 = c26721.I$1;
            i2 = c26721.I$0;
            strArr = (String[]) c26721.L$3;
            str = (String) c26721.L$2;
            pooledConnection2 = (PooledConnection) c26721.L$1;
            triggerBasedInvalidationTracker2 = (TriggerBasedInvalidationTracker) c26721.L$0;
            ResultKt.throwOnFailure(obj);
            boolean z2 = true;
            i3++;
            z = z2;
            if (i3 < length) {
                return Unit.INSTANCE;
            }
            String str3 = strArr[i3];
            z2 = z;
            String str4 = "CREATE " + (triggerBasedInvalidationTracker2.useTempTable ? "TEMP" : "") + " TRIGGER IF NOT EXISTS `" + INSTANCE.getTriggerName(str, str3) + "` AFTER " + str3 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i2 + " AND invalidated = 0; END";
            c26721.L$0 = triggerBasedInvalidationTracker2;
            c26721.L$1 = pooledConnection2;
            c26721.L$2 = str;
            c26721.L$3 = strArr;
            c26721.I$0 = i2;
            c26721.I$1 = i3;
            c26721.I$2 = length;
            c26721.label = 2;
        }
        String str5 = triggerBasedInvalidationTracker.tablesNames[i4];
        strArr = TRIGGERS;
        triggerBasedInvalidationTracker2 = triggerBasedInvalidationTracker;
        i2 = i4;
        i3 = 0;
        pooledConnection2 = pooledConnection3;
        length = strArr.length;
        str = str5;
        if (i3 < length) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0085 -> B:20:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object stopTrackingTable(PooledConnection pooledConnection, int i, Continuation<? super Unit> continuation) {
        C26731 c26731;
        int i2;
        PooledConnection pooledConnection2;
        int length;
        String[] strArr;
        String str;
        if (continuation instanceof C26731) {
            c26731 = (C26731) continuation;
            if ((c26731.label & Integer.MIN_VALUE) != 0) {
                c26731.label -= Integer.MIN_VALUE;
            } else {
                c26731 = new C26731(continuation);
            }
        }
        Object obj = c26731.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c26731.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            String str2 = this.tablesNames[i];
            String[] strArr2 = TRIGGERS;
            i2 = 0;
            pooledConnection2 = pooledConnection;
            length = strArr2.length;
            strArr = strArr2;
            str = str2;
            if (i2 < length) {
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            length = c26731.I$1;
            int i4 = c26731.I$0;
            strArr = (String[]) c26731.L$2;
            String str3 = (String) c26731.L$1;
            PooledConnection pooledConnection3 = (PooledConnection) c26731.L$0;
            ResultKt.throwOnFailure(obj);
            str = str3;
            i2 = i4 + 1;
            pooledConnection2 = pooledConnection3;
            if (i2 < length) {
                String str4 = "DROP TRIGGER IF EXISTS `" + INSTANCE.getTriggerName(str, strArr[i2]) + '`';
                c26731.L$0 = pooledConnection2;
                c26731.L$1 = str;
                c26731.L$2 = strArr;
                c26731.I$0 = i2;
                c26731.I$1 = length;
                c26731.label = 1;
                if (TransactorKt.execSQL(pooledConnection2, str4, c26731) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pooledConnection3 = pooledConnection2;
                i4 = i2;
                i2 = i4 + 1;
                pooledConnection2 = pooledConnection3;
                if (i2 < length) {
                    return Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshInvalidation$room_runtime_release(String[] strArr, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super Boolean> continuation) {
        TriggerBasedInvalidationTracker$refreshInvalidation$1 triggerBasedInvalidationTracker$refreshInvalidation$1;
        int[] iArrComponent2;
        if (continuation instanceof TriggerBasedInvalidationTracker$refreshInvalidation$1) {
            triggerBasedInvalidationTracker$refreshInvalidation$1 = (TriggerBasedInvalidationTracker$refreshInvalidation$1) continuation;
            if ((triggerBasedInvalidationTracker$refreshInvalidation$1.label & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$refreshInvalidation$1.label -= Integer.MIN_VALUE;
            } else {
                triggerBasedInvalidationTracker$refreshInvalidation$1 = new TriggerBasedInvalidationTracker$refreshInvalidation$1(this, continuation);
            }
        }
        Object objNotifyInvalidation = triggerBasedInvalidationTracker$refreshInvalidation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = triggerBasedInvalidationTracker$refreshInvalidation$1.label;
        boolean z = true;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objNotifyInvalidation);
                iArrComponent2 = validateTableNames$room_runtime_release(strArr).component2();
                function0.invoke();
                triggerBasedInvalidationTracker$refreshInvalidation$1.L$0 = function02;
                triggerBasedInvalidationTracker$refreshInvalidation$1.L$1 = iArrComponent2;
                triggerBasedInvalidationTracker$refreshInvalidation$1.label = 1;
                objNotifyInvalidation = notifyInvalidation(triggerBasedInvalidationTracker$refreshInvalidation$1);
                if (objNotifyInvalidation == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                iArrComponent2 = (int[]) triggerBasedInvalidationTracker$refreshInvalidation$1.L$1;
                function02 = (Function0) triggerBasedInvalidationTracker$refreshInvalidation$1.L$0;
                ResultKt.throwOnFailure(objNotifyInvalidation);
            }
            Set set = (Set) objNotifyInvalidation;
            if (!(iArrComponent2.length == 0)) {
                for (int i2 : iArrComponent2) {
                    if (set.contains(Boxing.boxInt(i2))) {
                        break;
                    }
                }
                z = false;
            } else if (set.isEmpty()) {
                z = false;
            }
            return Boxing.boxBoolean(z);
        } finally {
            function02.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object refreshInvalidation$room_runtime_release$default(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, String[] strArr, Function0 function0, Function0 function02, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.room.TriggerBasedInvalidationTracker$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: androidx.room.TriggerBasedInvalidationTracker$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        return triggerBasedInvalidationTracker.refreshInvalidation$room_runtime_release(strArr, function0, function02, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refreshInvalidationAsync$room_runtime_release$default(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new Function0() { // from class: androidx.room.TriggerBasedInvalidationTracker$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function02 = new Function0() { // from class: androidx.room.TriggerBasedInvalidationTracker$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        triggerBasedInvalidationTracker.refreshInvalidationAsync$room_runtime_release(function0, function02);
    }

    public final void refreshInvalidationAsync$room_runtime_release(Function0<Unit> onRefreshScheduled, Function0<Unit> onRefreshCompleted) {
        Intrinsics.checkNotNullParameter(onRefreshScheduled, "onRefreshScheduled");
        Intrinsics.checkNotNullParameter(onRefreshCompleted, "onRefreshCompleted");
        if (this.pendingRefresh.compareAndSet(false, true)) {
            onRefreshScheduled.invoke();
            BuildersKt__Builders_commonKt.launch$default(this.database.getCoroutineScope(), new CoroutineName("Room Invalidation Tracker Refresh"), null, new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this, onRefreshCompleted, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object notifyInvalidation(Continuation<? super Set<Integer>> continuation) throws Throwable {
        C26701 c26701;
        CloseBarrier closeBarrier;
        Throwable th;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker;
        if (continuation instanceof C26701) {
            c26701 = (C26701) continuation;
            if ((c26701.label & Integer.MIN_VALUE) != 0) {
                c26701.label -= Integer.MIN_VALUE;
            } else {
                c26701 = new C26701(continuation);
            }
        }
        Object obj = c26701.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c26701.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CloseBarrier closeBarrier2 = this.database.getCloseBarrier();
            if (closeBarrier2.block$room_runtime_release()) {
                try {
                    if (!this.pendingRefresh.compareAndSet(true, false)) {
                        Set setEmptySet = SetsKt.emptySet();
                        closeBarrier2.unblock$room_runtime_release();
                        return setEmptySet;
                    }
                    if (!this.onAllowRefresh.invoke().booleanValue()) {
                        Set setEmptySet2 = SetsKt.emptySet();
                        closeBarrier2.unblock$room_runtime_release();
                        return setEmptySet2;
                    }
                    RoomDatabase roomDatabase = this.database;
                    C2671xcf25c6f6 c2671xcf25c6f6 = new C2671xcf25c6f6(this, null);
                    c26701.L$0 = this;
                    c26701.L$1 = closeBarrier2;
                    c26701.label = 1;
                    Object objUseConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(false, c2671xcf25c6f6, c26701);
                    if (objUseConnection$room_runtime_release == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    closeBarrier = closeBarrier2;
                    obj = objUseConnection$room_runtime_release;
                    triggerBasedInvalidationTracker = this;
                } catch (Throwable th2) {
                    closeBarrier = closeBarrier2;
                    th = th2;
                    closeBarrier.unblock$room_runtime_release();
                    throw th;
                }
            } else {
                return SetsKt.emptySet();
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            closeBarrier = (CloseBarrier) c26701.L$1;
            triggerBasedInvalidationTracker = (TriggerBasedInvalidationTracker) c26701.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                closeBarrier.unblock$room_runtime_release();
                throw th;
            }
        }
        Set<Integer> set = (Set) obj;
        if (!set.isEmpty()) {
            triggerBasedInvalidationTracker.observedTableVersions.increment(set);
            triggerBasedInvalidationTracker.onInvalidatedTablesIds.invoke(set);
        }
        closeBarrier.unblock$room_runtime_release();
        return set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkInvalidatedTables(PooledConnection pooledConnection, Continuation<? super Set<Integer>> continuation) {
        C26671 c26671;
        if (continuation instanceof C26671) {
            c26671 = (C26671) continuation;
            if ((c26671.label & Integer.MIN_VALUE) != 0) {
                c26671.label -= Integer.MIN_VALUE;
            } else {
                c26671 = new C26671(continuation);
            }
        }
        Object objUsePrepared = c26671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c26671.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUsePrepared);
            Function1 function1 = new Function1() { // from class: androidx.room.TriggerBasedInvalidationTracker$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TriggerBasedInvalidationTracker.checkInvalidatedTables$lambda$14((SQLiteStatement) obj);
                }
            };
            c26671.L$0 = pooledConnection;
            c26671.label = 1;
            objUsePrepared = pooledConnection.usePrepared(SELECT_UPDATED_TABLES_SQL, function1, c26671);
            if (objUsePrepared != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Set set = (Set) c26671.L$0;
            ResultKt.throwOnFailure(objUsePrepared);
            return set;
        }
        pooledConnection = (PooledConnection) c26671.L$0;
        ResultKt.throwOnFailure(objUsePrepared);
        Set set2 = (Set) objUsePrepared;
        if (!set2.isEmpty()) {
            c26671.L$0 = set2;
            c26671.label = 2;
            if (TransactorKt.execSQL(pooledConnection, RESET_UPDATED_TABLES_SQL, c26671) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return set2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set checkInvalidatedTables$lambda$14(SQLiteStatement statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        while (statement.step()) {
            setCreateSetBuilder.add(Integer.valueOf((int) statement.getLong(0)));
        }
        return SetsKt.build(setCreateSetBuilder);
    }

    public final void resetSync$room_runtime_release() {
        this.observedTableStates.resetTriggerState$room_runtime_release();
    }

    /* JADX INFO: compiled from: InvalidationTracker.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Landroidx/room/TriggerBasedInvalidationTracker$Companion;", "", "<init>", "()V", "TRIGGERS", "", "", "[Ljava/lang/String;", "UPDATE_TABLE_NAME", "TABLE_ID_COLUMN_NAME", "INVALIDATED_COLUMN_NAME", "CREATE_TRACKING_TABLE_SQL", "DROP_TRACKING_TABLE_SQL", "SELECT_UPDATED_TABLES_SQL", "RESET_UPDATED_TABLES_SQL", "getTriggerName", "tableName", "triggerType", "room-runtime_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getTriggerName(String tableName, String triggerType) {
            return "room_table_modification_trigger_" + tableName + '_' + triggerType;
        }
    }
}
