package com.myscript.nebo.inspector;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NeboFilesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/inspector/State;", "", "<init>", "()V", "files", "", "Lcom/myscript/nebo/inspector/NeboFile;", "getFiles", "()Ljava/util/List;", "stats", "Lcom/myscript/nebo/inspector/Stats;", "getStats", "()Lcom/myscript/nebo/inspector/Stats;", "Loading", "Empty", "Loaded", "Lcom/myscript/nebo/inspector/State$Empty;", "Lcom/myscript/nebo/inspector/State$Loaded;", "Lcom/myscript/nebo/inspector/State$Loading;", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class State {
    private final List<NeboFile> files;
    private final Stats stats;

    public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private State() {
        this.files = CollectionsKt.emptyList();
        this.stats = new Stats(0, 0, 0, 7, null);
    }

    public List<NeboFile> getFiles() {
        return this.files;
    }

    public Stats getStats() {
        return this.stats;
    }

    /* JADX INFO: compiled from: NeboFilesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/inspector/State$Loading;", "Lcom/myscript/nebo/inspector/State;", "stats", "Lcom/myscript/nebo/inspector/Stats;", "<init>", "(Lcom/myscript/nebo/inspector/Stats;)V", "getStats", "()Lcom/myscript/nebo/inspector/Stats;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Loading extends State {
        private final Stats stats;

        public static /* synthetic */ Loading copy$default(Loading loading, Stats stats, int i, Object obj) {
            if ((i & 1) != 0) {
                stats = loading.stats;
            }
            return loading.copy(stats);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Stats getStats() {
            return this.stats;
        }

        public final Loading copy(Stats stats) {
            Intrinsics.checkNotNullParameter(stats, "stats");
            return new Loading(stats);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Loading) && Intrinsics.areEqual(this.stats, ((Loading) other).stats);
        }

        public int hashCode() {
            return this.stats.hashCode();
        }

        public String toString() {
            return "Loading(stats=" + this.stats + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Loading(Stats stats) {
            super(null);
            Intrinsics.checkNotNullParameter(stats, "stats");
            this.stats = stats;
        }

        @Override // com.myscript.nebo.inspector.State
        public Stats getStats() {
            return this.stats;
        }
    }

    /* JADX INFO: compiled from: NeboFilesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/inspector/State$Empty;", "Lcom/myscript/nebo/inspector/State;", "stats", "Lcom/myscript/nebo/inspector/Stats;", "<init>", "(Lcom/myscript/nebo/inspector/Stats;)V", "getStats", "()Lcom/myscript/nebo/inspector/Stats;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Empty extends State {
        private final Stats stats;

        public static /* synthetic */ Empty copy$default(Empty empty, Stats stats, int i, Object obj) {
            if ((i & 1) != 0) {
                stats = empty.stats;
            }
            return empty.copy(stats);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Stats getStats() {
            return this.stats;
        }

        public final Empty copy(Stats stats) {
            Intrinsics.checkNotNullParameter(stats, "stats");
            return new Empty(stats);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Empty) && Intrinsics.areEqual(this.stats, ((Empty) other).stats);
        }

        public int hashCode() {
            return this.stats.hashCode();
        }

        public String toString() {
            return "Empty(stats=" + this.stats + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Empty(Stats stats) {
            super(null);
            Intrinsics.checkNotNullParameter(stats, "stats");
            this.stats = stats;
        }

        @Override // com.myscript.nebo.inspector.State
        public Stats getStats() {
            return this.stats;
        }
    }

    /* JADX INFO: compiled from: NeboFilesViewModel.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, m1599d2 = {"Lcom/myscript/nebo/inspector/State$Loaded;", "Lcom/myscript/nebo/inspector/State;", "files", "", "Lcom/myscript/nebo/inspector/NeboFile;", "stats", "Lcom/myscript/nebo/inspector/Stats;", "<init>", "(Ljava/util/List;Lcom/myscript/nebo/inspector/Stats;)V", "getFiles", "()Ljava/util/List;", "getStats", "()Lcom/myscript/nebo/inspector/Stats;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Loaded extends State {
        private final List<NeboFile> files;
        private final Stats stats;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, Stats stats, int i, Object obj) {
            if ((i & 1) != 0) {
                list = loaded.files;
            }
            if ((i & 2) != 0) {
                stats = loaded.stats;
            }
            return loaded.copy(list, stats);
        }

        public final List<NeboFile> component1() {
            return this.files;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Stats getStats() {
            return this.stats;
        }

        public final Loaded copy(List<NeboFile> files, Stats stats) {
            Intrinsics.checkNotNullParameter(files, "files");
            Intrinsics.checkNotNullParameter(stats, "stats");
            return new Loaded(files, stats);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Loaded)) {
                return false;
            }
            Loaded loaded = (Loaded) other;
            return Intrinsics.areEqual(this.files, loaded.files) && Intrinsics.areEqual(this.stats, loaded.stats);
        }

        public int hashCode() {
            return (this.files.hashCode() * 31) + this.stats.hashCode();
        }

        public String toString() {
            return "Loaded(files=" + this.files + ", stats=" + this.stats + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Loaded(List<NeboFile> files, Stats stats) {
            super(null);
            Intrinsics.checkNotNullParameter(files, "files");
            Intrinsics.checkNotNullParameter(stats, "stats");
            this.files = files;
            this.stats = stats;
        }

        @Override // com.myscript.nebo.inspector.State
        public List<NeboFile> getFiles() {
            return this.files;
        }

        @Override // com.myscript.nebo.inspector.State
        public Stats getStats() {
            return this.stats;
        }
    }
}
