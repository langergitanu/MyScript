package com.survicate.surveys.entities.survey.audience.attributes;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonClassDiscriminator;

/* JADX INFO: renamed from: com.survicate.surveys.entities.survey.audience.attributes.NetworkAudienceUserFilterAttribute$Companion$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0 */
/* JADX INFO: compiled from: NetworkAudienceUserFilterAttributes.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
public /* synthetic */ class C8384xecb2c058 implements JsonClassDiscriminator {
    private final /* synthetic */ String discriminator;

    public C8384xecb2c058(String discriminator) {
        Intrinsics.checkNotNullParameter(discriminator, "discriminator");
        this.discriminator = discriminator;
    }

    @Override // java.lang.annotation.Annotation
    public final /* synthetic */ Class annotationType() {
        return JsonClassDiscriminator.class;
    }

    @Override // kotlinx.serialization.json.JsonClassDiscriminator
    public final /* synthetic */ String discriminator() {
        return this.discriminator;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        return (obj instanceof JsonClassDiscriminator) && Intrinsics.areEqual(discriminator(), ((JsonClassDiscriminator) obj).discriminator());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return ("discriminator".hashCode() * 127) ^ this.discriminator.hashCode();
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@kotlinx.serialization.json.JsonClassDiscriminator(discriminator=" + this.discriminator + ')';
    }
}
