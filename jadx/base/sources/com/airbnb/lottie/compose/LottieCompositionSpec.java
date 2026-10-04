package com.airbnb.lottie.compose;

import android.net.Uri;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LottieCompositionSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000b\f\r¨\u0006\u000e"}, m1599d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "", "Asset", "ContentProvider", "File", "JsonString", "RawRes", "Url", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$Asset;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$ContentProvider;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$File;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$JsonString;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$RawRes;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$Url;", "lottie-compose_release"}, m1600k = 1, m1601mv = {1, 9, 0}, m1603xi = 48)
public interface LottieCompositionSpec {

    /* JADX INFO: compiled from: LottieCompositionSpec.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, m1599d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$RawRes;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "resId", "", "constructor-impl", "(I)I", "getResId", "()I", "equals", "", "other", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "lottie-compose_release"}, m1600k = 1, m1601mv = {1, 9, 0}, m1603xi = 48)
    @JvmInline
    public static final class RawRes implements LottieCompositionSpec {
        private final int resId;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ RawRes m12421boximpl(int i) {
            return new RawRes(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m12422constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m12423equalsimpl(int i, Object obj) {
            return (obj instanceof RawRes) && i == ((RawRes) obj).m12427unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m12424equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m12425hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m12426toStringimpl(int i) {
            return "RawRes(resId=" + i + ")";
        }

        public boolean equals(Object obj) {
            return m12423equalsimpl(this.resId, obj);
        }

        public int hashCode() {
            return m12425hashCodeimpl(this.resId);
        }

        public String toString() {
            return m12426toStringimpl(this.resId);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m12427unboximpl() {
            return this.resId;
        }

        private /* synthetic */ RawRes(int i) {
            this.resId = i;
        }

        public final int getResId() {
            return this.resId;
        }
    }

    /* JADX INFO: compiled from: LottieCompositionSpec.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, m1599d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$Url;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", ImagesContract.URL, "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "lottie-compose_release"}, m1600k = 1, m1601mv = {1, 9, 0}, m1603xi = 48)
    @JvmInline
    public static final class Url implements LottieCompositionSpec {
        private final String url;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Url m12428boximpl(String str) {
            return new Url(str);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static String m12429constructorimpl(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return url;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m12430equalsimpl(String str, Object obj) {
            return (obj instanceof Url) && Intrinsics.areEqual(str, ((Url) obj).m12434unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m12431equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m12432hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m12433toStringimpl(String str) {
            return "Url(url=" + str + ")";
        }

        public boolean equals(Object obj) {
            return m12430equalsimpl(this.url, obj);
        }

        public int hashCode() {
            return m12432hashCodeimpl(this.url);
        }

        public String toString() {
            return m12433toStringimpl(this.url);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ String m12434unboximpl() {
            return this.url;
        }

        private /* synthetic */ Url(String str) {
            this.url = str;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* JADX INFO: compiled from: LottieCompositionSpec.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, m1599d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$File;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "fileName", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getFileName", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "lottie-compose_release"}, m1600k = 1, m1601mv = {1, 9, 0}, m1603xi = 48)
    @JvmInline
    public static final class File implements LottieCompositionSpec {
        private final String fileName;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ File m12407boximpl(String str) {
            return new File(str);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static String m12408constructorimpl(String fileName) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return fileName;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m12409equalsimpl(String str, Object obj) {
            return (obj instanceof File) && Intrinsics.areEqual(str, ((File) obj).m12413unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m12410equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m12411hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m12412toStringimpl(String str) {
            return "File(fileName=" + str + ")";
        }

        public boolean equals(Object obj) {
            return m12409equalsimpl(this.fileName, obj);
        }

        public int hashCode() {
            return m12411hashCodeimpl(this.fileName);
        }

        public String toString() {
            return m12412toStringimpl(this.fileName);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ String m12413unboximpl() {
            return this.fileName;
        }

        private /* synthetic */ File(String str) {
            this.fileName = str;
        }

        public final String getFileName() {
            return this.fileName;
        }
    }

    /* JADX INFO: compiled from: LottieCompositionSpec.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, m1599d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$Asset;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "assetName", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getAssetName", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "lottie-compose_release"}, m1600k = 1, m1601mv = {1, 9, 0}, m1603xi = 48)
    @JvmInline
    public static final class Asset implements LottieCompositionSpec {
        private final String assetName;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Asset m12393boximpl(String str) {
            return new Asset(str);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static String m12394constructorimpl(String assetName) {
            Intrinsics.checkNotNullParameter(assetName, "assetName");
            return assetName;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m12395equalsimpl(String str, Object obj) {
            return (obj instanceof Asset) && Intrinsics.areEqual(str, ((Asset) obj).m12399unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m12396equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m12397hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m12398toStringimpl(String str) {
            return "Asset(assetName=" + str + ")";
        }

        public boolean equals(Object obj) {
            return m12395equalsimpl(this.assetName, obj);
        }

        public int hashCode() {
            return m12397hashCodeimpl(this.assetName);
        }

        public String toString() {
            return m12398toStringimpl(this.assetName);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ String m12399unboximpl() {
            return this.assetName;
        }

        private /* synthetic */ Asset(String str) {
            this.assetName = str;
        }

        public final String getAssetName() {
            return this.assetName;
        }
    }

    /* JADX INFO: compiled from: LottieCompositionSpec.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, m1599d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$JsonString;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "jsonString", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getJsonString", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "lottie-compose_release"}, m1600k = 1, m1601mv = {1, 9, 0}, m1603xi = 48)
    @JvmInline
    public static final class JsonString implements LottieCompositionSpec {
        private final String jsonString;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ JsonString m12414boximpl(String str) {
            return new JsonString(str);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static String m12415constructorimpl(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            return jsonString;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m12416equalsimpl(String str, Object obj) {
            return (obj instanceof JsonString) && Intrinsics.areEqual(str, ((JsonString) obj).m12420unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m12417equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m12418hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m12419toStringimpl(String str) {
            return "JsonString(jsonString=" + str + ")";
        }

        public boolean equals(Object obj) {
            return m12416equalsimpl(this.jsonString, obj);
        }

        public int hashCode() {
            return m12418hashCodeimpl(this.jsonString);
        }

        public String toString() {
            return m12419toStringimpl(this.jsonString);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ String m12420unboximpl() {
            return this.jsonString;
        }

        private /* synthetic */ JsonString(String str) {
            this.jsonString = str;
        }

        public final String getJsonString() {
            return this.jsonString;
        }
    }

    /* JADX INFO: compiled from: LottieCompositionSpec.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0016"}, m1599d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$ContentProvider;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "uri", "Landroid/net/Uri;", "constructor-impl", "(Landroid/net/Uri;)Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "equals", "", "other", "", "equals-impl", "(Landroid/net/Uri;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroid/net/Uri;)I", "toString", "", "toString-impl", "(Landroid/net/Uri;)Ljava/lang/String;", "lottie-compose_release"}, m1600k = 1, m1601mv = {1, 9, 0}, m1603xi = 48)
    @JvmInline
    public static final class ContentProvider implements LottieCompositionSpec {
        private final Uri uri;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ ContentProvider m12400boximpl(Uri uri) {
            return new ContentProvider(uri);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static Uri m12401constructorimpl(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return uri;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m12402equalsimpl(Uri uri, Object obj) {
            return (obj instanceof ContentProvider) && Intrinsics.areEqual(uri, ((ContentProvider) obj).m12406unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m12403equalsimpl0(Uri uri, Uri uri2) {
            return Intrinsics.areEqual(uri, uri2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m12404hashCodeimpl(Uri uri) {
            return uri.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m12405toStringimpl(Uri uri) {
            return "ContentProvider(uri=" + uri + ")";
        }

        public boolean equals(Object obj) {
            return m12402equalsimpl(this.uri, obj);
        }

        public int hashCode() {
            return m12404hashCodeimpl(this.uri);
        }

        public String toString() {
            return m12405toStringimpl(this.uri);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ Uri m12406unboximpl() {
            return this.uri;
        }

        private /* synthetic */ ContentProvider(Uri uri) {
            this.uri = uri;
        }

        public final Uri getUri() {
            return this.uri;
        }
    }
}
