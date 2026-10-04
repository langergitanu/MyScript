package com.survicate.surveys.infrastructure.network;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.infrastructure.environment.UrlProvider;
import com.survicate.surveys.infrastructure.serialization.SuggestionsSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurvicateSuggestionsRequestFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/SurvicateSuggestionsRequestFactory;", "Lcom/survicate/surveys/infrastructure/network/SuggestionsRequestFactory;", "urlProvider", "Lcom/survicate/surveys/infrastructure/environment/UrlProvider;", "suggestionsSerializer", "Lcom/survicate/surveys/infrastructure/serialization/SuggestionsSerializer;", "<init>", "(Lcom/survicate/surveys/infrastructure/environment/UrlProvider;Lcom/survicate/surveys/infrastructure/serialization/SuggestionsSerializer;)V", "createEventSuggestionRequest", "Lcom/survicate/surveys/infrastructure/network/URLRequest;", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/EventSuggestionRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateSuggestionsRequestFactory implements SuggestionsRequestFactory {
    private final SuggestionsSerializer suggestionsSerializer;
    private final UrlProvider urlProvider;

    public SurvicateSuggestionsRequestFactory(UrlProvider urlProvider, SuggestionsSerializer suggestionsSerializer) {
        Intrinsics.checkNotNullParameter(urlProvider, "urlProvider");
        Intrinsics.checkNotNullParameter(suggestionsSerializer, "suggestionsSerializer");
        this.urlProvider = urlProvider;
        this.suggestionsSerializer = suggestionsSerializer;
    }

    @Override // com.survicate.surveys.infrastructure.network.SuggestionsRequestFactory
    public URLRequest createEventSuggestionRequest(EventSuggestionRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return new URLRequest(this.urlProvider.resolveEventSuggestionUrl(), "POST", this.suggestionsSerializer.serializeEventSuggestionRequestBody(body));
    }
}
