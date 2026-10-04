package com.survicate.surveys.core.logging;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import com.survicate.surveys.TextRecallingManager;
import java.util.Comparator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetadataFormat.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"formatMetadata", "", TtmlNode.TAG_METADATA, "", "shared_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MetadataFormatKt {
    public static final String formatMetadata(Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return CollectionsKt.joinToString$default(CollectionsKt.sortedWith(metadata.entrySet(), new Comparator() { // from class: com.survicate.surveys.core.logging.MetadataFormatKt$formatMetadata$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((String) ((Map.Entry) t).getKey(), (String) ((Map.Entry) t2).getKey());
            }
        }), TextRecallingManager.ANSWER_SEPARATOR, "{", "}", 0, null, new Function1() { // from class: com.survicate.surveys.core.logging.MetadataFormatKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MetadataFormatKt.formatMetadata$lambda$1((Map.Entry) obj);
            }
        }, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence formatMetadata$lambda$1(Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ((String) it.getKey()) + Literals.PROPERTY_SPLITTER + ((String) it.getValue());
    }
}
