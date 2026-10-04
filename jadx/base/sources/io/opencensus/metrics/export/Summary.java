package io.opencensus.metrics.export;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.opencensus.internal.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes8.dex */
public abstract class Summary {
    @Nullable
    public abstract Long getCount();

    public abstract Snapshot getSnapshot();

    @Nullable
    public abstract Double getSum();

    Summary() {
    }

    public static Summary create(@Nullable Long l, @Nullable Double d, Snapshot snapshot) {
        checkCountAndSum(l, d);
        Utils.checkNotNull(snapshot, "snapshot");
        return new AutoValue_Summary(l, d, snapshot);
    }

    public static abstract class Snapshot {
        @Nullable
        public abstract Long getCount();

        @Nullable
        public abstract Double getSum();

        public abstract List<ValueAtPercentile> getValueAtPercentiles();

        public static Snapshot create(@Nullable Long l, @Nullable Double d, List<ValueAtPercentile> list) {
            Summary.checkCountAndSum(l, d);
            Utils.checkListElementNotNull((List) Utils.checkNotNull(list, "valueAtPercentiles"), "valueAtPercentile");
            return new AutoValue_Summary_Snapshot(l, d, Collections.unmodifiableList(new ArrayList(list)));
        }

        public static abstract class ValueAtPercentile {
            public abstract double getPercentile();

            public abstract double getValue();

            public static ValueAtPercentile create(double d, double d2) {
                Utils.checkArgument(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE < d && d <= 100.0d, "percentile must be in the interval (0.0, 100.0]");
                Utils.checkArgument(d2 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, "value must be non-negative");
                return new AutoValue_Summary_Snapshot_ValueAtPercentile(d, d2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkCountAndSum(@Nullable Long l, @Nullable Double d) {
        Utils.checkArgument(l == null || l.longValue() >= 0, "count must be non-negative.");
        Utils.checkArgument(d == null || d.doubleValue() >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, "sum must be non-negative.");
        if (l == null || l.longValue() != 0) {
            return;
        }
        Utils.checkArgument(d == null || d.doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, "sum must be 0 if count is 0.");
    }
}
