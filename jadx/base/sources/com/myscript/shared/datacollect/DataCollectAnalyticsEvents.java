package com.myscript.shared.datacollect;

import kotlin.Metadata;

/* JADX INFO: compiled from: DataCollectAnalyticsEvents.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006("}, m1599d2 = {"Lcom/myscript/shared/datacollect/DataCollectAnalyticsEvents;", "", "<init>", "()V", "COLLECT_SUCCEED", "", "COLLECT_FAILED", "COLLECT_DURATION", "COLLECT_FILE_NOT_FOUND", "COLLECT_NOT_A_FILE", "COLLECT_SEND_FAILED", "COLLECT_METADATA_JSON_ERROR", "COLLECT_ZIP_CREATION_ERROR", "COLLECT_CRASH", "COLLECT_FILE_COUNT_1", "COLLECT_FILE_COUNT_2", "COLLECT_FILE_COUNT_3", "COLLECT_FILE_COUNT_4", "COLLECT_FILE_COUNT_5", "COLLECT_FILE_COUNT_6_10", "COLLECT_FILE_COUNT_11_15", "COLLECT_FILE_COUNT_16_20", "COLLECT_FILE_COUNT_21_25", "COLLECT_FILE_COUNT_26_INF", "COLLECT_TIME_0_5", "COLLECT_TIME_5_10", "COLLECT_TIME_10_15", "COLLECT_TIME_15_20", "COLLECT_TIME_20_30", "COLLECT_TIME_30_60", "COLLECT_TIME_60_120", "COLLECT_TIME_120_180", "COLLECT_TIME_180_240", "COLLECT_TIME_240_INF", "computeFileCountBucket", "filesProcessed", "", "computeDurationBucket", "durationMs", "", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DataCollectAnalyticsEvents {
    public static final String COLLECT_CRASH = "crash";
    public static final String COLLECT_DURATION = "collect_duration";
    public static final String COLLECT_FAILED = "collect_failed";
    public static final String COLLECT_FILE_COUNT_1 = "1";
    public static final String COLLECT_FILE_COUNT_11_15 = "11-15";
    public static final String COLLECT_FILE_COUNT_16_20 = "16-20";
    public static final String COLLECT_FILE_COUNT_2 = "2";
    public static final String COLLECT_FILE_COUNT_21_25 = "21-25";
    public static final String COLLECT_FILE_COUNT_26_INF = "25+";
    public static final String COLLECT_FILE_COUNT_3 = "3";
    public static final String COLLECT_FILE_COUNT_4 = "4";
    public static final String COLLECT_FILE_COUNT_5 = "5";
    public static final String COLLECT_FILE_COUNT_6_10 = "6-10";
    public static final String COLLECT_FILE_NOT_FOUND = "file_not_found";
    public static final String COLLECT_METADATA_JSON_ERROR = "metadata_json_error";
    public static final String COLLECT_NOT_A_FILE = "not_a_file";
    public static final String COLLECT_SEND_FAILED = "send_failed";
    public static final String COLLECT_SUCCEED = "collect_succeed";
    public static final String COLLECT_TIME_0_5 = "-5";
    public static final String COLLECT_TIME_10_15 = "10-15";
    public static final String COLLECT_TIME_120_180 = "120-180";
    public static final String COLLECT_TIME_15_20 = "15-20";
    public static final String COLLECT_TIME_180_240 = "180-240";
    public static final String COLLECT_TIME_20_30 = "20-30";
    public static final String COLLECT_TIME_240_INF = "240+";
    public static final String COLLECT_TIME_30_60 = "30-60";
    public static final String COLLECT_TIME_5_10 = "5-10";
    public static final String COLLECT_TIME_60_120 = "60-120";
    public static final String COLLECT_ZIP_CREATION_ERROR = "zip_creation_error";
    public static final DataCollectAnalyticsEvents INSTANCE = new DataCollectAnalyticsEvents();

    private DataCollectAnalyticsEvents() {
    }

    public final String computeFileCountBucket(int filesProcessed) {
        if (filesProcessed == 1) {
            return "1";
        }
        if (filesProcessed == 2) {
            return "2";
        }
        if (filesProcessed == 3) {
            return "3";
        }
        if (filesProcessed == 4) {
            return COLLECT_FILE_COUNT_4;
        }
        if (filesProcessed == 5) {
            return COLLECT_FILE_COUNT_5;
        }
        if (6 <= filesProcessed && filesProcessed < 11) {
            return COLLECT_FILE_COUNT_6_10;
        }
        if (11 <= filesProcessed && filesProcessed < 16) {
            return COLLECT_FILE_COUNT_11_15;
        }
        if (16 <= filesProcessed && filesProcessed < 21) {
            return COLLECT_FILE_COUNT_16_20;
        }
        if (21 <= filesProcessed && filesProcessed < 26) {
            return COLLECT_FILE_COUNT_21_25;
        }
        return COLLECT_FILE_COUNT_26_INF;
    }

    public final String computeDurationBucket(long durationMs) {
        if (0 <= durationMs && durationMs < 5001) {
            return COLLECT_TIME_0_5;
        }
        if (5001 <= durationMs && durationMs < 10001) {
            return COLLECT_TIME_5_10;
        }
        if (10001 <= durationMs && durationMs < 15001) {
            return COLLECT_TIME_10_15;
        }
        if (15001 <= durationMs && durationMs < 20001) {
            return COLLECT_TIME_15_20;
        }
        if (20001 <= durationMs && durationMs < 30001) {
            return COLLECT_TIME_20_30;
        }
        if (30001 <= durationMs && durationMs < 60001) {
            return COLLECT_TIME_30_60;
        }
        if (60001 <= durationMs && durationMs < 120001) {
            return COLLECT_TIME_60_120;
        }
        if (120001 <= durationMs && durationMs < 180001) {
            return COLLECT_TIME_120_180;
        }
        if (180001 <= durationMs && durationMs < 240001) {
            return COLLECT_TIME_180_240;
        }
        return COLLECT_TIME_240_INF;
    }
}
