package com.survicate.surveys.helpers;

import com.survicate.surveys.infrastructure.network.image.SurvicateImageLoader;
import com.survicate.surveys.presentation.theming.FontProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewDependencies.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/helpers/ViewDependenciesImpl;", "Lcom/survicate/surveys/helpers/ViewDependencies;", "imageLoader", "Lcom/survicate/surveys/infrastructure/network/image/SurvicateImageLoader;", "fontProvider", "Lcom/survicate/surveys/presentation/theming/FontProvider;", "<init>", "(Lcom/survicate/surveys/infrastructure/network/image/SurvicateImageLoader;Lcom/survicate/surveys/presentation/theming/FontProvider;)V", "getImageLoader", "()Lcom/survicate/surveys/infrastructure/network/image/SurvicateImageLoader;", "getFontProvider", "()Lcom/survicate/surveys/presentation/theming/FontProvider;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ViewDependenciesImpl implements ViewDependencies {
    private final FontProvider fontProvider;
    private final SurvicateImageLoader imageLoader;

    public ViewDependenciesImpl(SurvicateImageLoader imageLoader, FontProvider fontProvider) {
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(fontProvider, "fontProvider");
        this.imageLoader = imageLoader;
        this.fontProvider = fontProvider;
    }

    @Override // com.survicate.surveys.helpers.ViewDependencies
    public SurvicateImageLoader getImageLoader() {
        return this.imageLoader;
    }

    @Override // com.survicate.surveys.helpers.ViewDependencies
    public FontProvider getFontProvider() {
        return this.fontProvider;
    }
}
