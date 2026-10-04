package com.myscript.nebo.discoverability.p024ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TooltipUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/ui/TooltipIllustration;", "", "<init>", "()V", "LottieJson", "DrawableIllustration", "Video", "Lcom/myscript/nebo/discoverability/ui/TooltipIllustration$DrawableIllustration;", "Lcom/myscript/nebo/discoverability/ui/TooltipIllustration$LottieJson;", "Lcom/myscript/nebo/discoverability/ui/TooltipIllustration$Video;", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class TooltipIllustration {
    public static final int $stable = 0;

    public /* synthetic */ TooltipIllustration(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: TooltipUIState.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/ui/TooltipIllustration$LottieJson;", "Lcom/myscript/nebo/discoverability/ui/TooltipIllustration;", "jsonString", "", "<init>", "(Ljava/lang/String;)V", "getJsonString", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class LottieJson extends TooltipIllustration {
        public static final int $stable = 0;
        private final String jsonString;

        public static /* synthetic */ LottieJson copy$default(LottieJson lottieJson, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = lottieJson.jsonString;
            }
            return lottieJson.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getJsonString() {
            return this.jsonString;
        }

        public final LottieJson copy(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            return new LottieJson(jsonString);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LottieJson) && Intrinsics.areEqual(this.jsonString, ((LottieJson) other).jsonString);
        }

        public int hashCode() {
            return this.jsonString.hashCode();
        }

        public String toString() {
            return "LottieJson(jsonString=" + this.jsonString + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LottieJson(String jsonString) {
            super(null);
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            this.jsonString = jsonString;
        }

        public final String getJsonString() {
            return this.jsonString;
        }
    }

    private TooltipIllustration() {
    }

    /* JADX INFO: compiled from: TooltipUIState.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/ui/TooltipIllustration$DrawableIllustration;", "Lcom/myscript/nebo/discoverability/ui/TooltipIllustration;", "drawableId", "", "<init>", "(I)V", "getDrawableId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class DrawableIllustration extends TooltipIllustration {
        public static final int $stable = 0;
        private final int drawableId;

        public static /* synthetic */ DrawableIllustration copy$default(DrawableIllustration drawableIllustration, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = drawableIllustration.drawableId;
            }
            return drawableIllustration.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDrawableId() {
            return this.drawableId;
        }

        public final DrawableIllustration copy(int drawableId) {
            return new DrawableIllustration(drawableId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DrawableIllustration) && this.drawableId == ((DrawableIllustration) other).drawableId;
        }

        public int hashCode() {
            return Integer.hashCode(this.drawableId);
        }

        public String toString() {
            return "DrawableIllustration(drawableId=" + this.drawableId + ")";
        }

        public DrawableIllustration(int i) {
            super(null);
            this.drawableId = i;
        }

        public final int getDrawableId() {
            return this.drawableId;
        }
    }

    /* JADX INFO: compiled from: TooltipUIState.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/ui/TooltipIllustration$Video;", "Lcom/myscript/nebo/discoverability/ui/TooltipIllustration;", "rawResId", "", "<init>", "(I)V", "getRawResId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Video extends TooltipIllustration {
        public static final int $stable = 0;
        private final int rawResId;

        public static /* synthetic */ Video copy$default(Video video, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = video.rawResId;
            }
            return video.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getRawResId() {
            return this.rawResId;
        }

        public final Video copy(int rawResId) {
            return new Video(rawResId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Video) && this.rawResId == ((Video) other).rawResId;
        }

        public int hashCode() {
            return Integer.hashCode(this.rawResId);
        }

        public String toString() {
            return "Video(rawResId=" + this.rawResId + ")";
        }

        public Video(int i) {
            super(null);
            this.rawResId = i;
        }

        public final int getRawResId() {
            return this.rawResId;
        }
    }
}
