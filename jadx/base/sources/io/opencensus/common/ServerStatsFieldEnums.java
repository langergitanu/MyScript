package io.opencensus.common;

import java.util.TreeMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes8.dex */
public final class ServerStatsFieldEnums {
    private static final int TOTALSIZE = computeTotalSize();

    /* JADX INFO: renamed from: io.opencensus.common.ServerStatsFieldEnums$Id */
    public enum EnumC8550Id {
        SERVER_STATS_LB_LATENCY_ID(0),
        SERVER_STATS_SERVICE_LATENCY_ID(1),
        SERVER_STATS_TRACE_OPTION_ID(2);

        private static final TreeMap<Integer, EnumC8550Id> map = new TreeMap<>();
        private final int value;

        static {
            for (EnumC8550Id enumC8550Id : values()) {
                map.put(Integer.valueOf(enumC8550Id.value), enumC8550Id);
            }
        }

        EnumC8550Id(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        @Nullable
        public static EnumC8550Id valueOf(int i) {
            return map.get(Integer.valueOf(i));
        }
    }

    public enum Size {
        SERVER_STATS_LB_LATENCY_SIZE(8),
        SERVER_STATS_SERVICE_LATENCY_SIZE(8),
        SERVER_STATS_TRACE_OPTION_SIZE(1);

        private final int value;

        Size(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }
    }

    private ServerStatsFieldEnums() {
    }

    private static int computeTotalSize() {
        int iValue = 0;
        for (Size size : Size.values()) {
            iValue = iValue + size.value() + 1;
        }
        return iValue;
    }

    public static int getTotalSize() {
        return TOTALSIZE;
    }
}
