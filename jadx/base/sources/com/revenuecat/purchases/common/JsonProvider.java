package com.revenuecat.purchases.common;

import com.revenuecat.purchases.common.events.BackendEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import kotlinx.serialization.modules.SerializersModuleBuilder;

/* JADX INFO: compiled from: JsonProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b0\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m1599d2 = {"Lcom/revenuecat/purchases/common/JsonProvider;", "", "()V", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class JsonProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Json defaultJson = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.revenuecat.purchases.common.JsonProvider$Companion$defaultJson$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
            PolymorphicModuleBuilder polymorphicModuleBuilder = new PolymorphicModuleBuilder(Reflection.getOrCreateKotlinClass(BackendEvent.class), null);
            polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(BackendEvent.CustomerCenter.class), BackendEvent.CustomerCenter.INSTANCE.serializer());
            polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(BackendEvent.Checkpoint.class), BackendEvent.Checkpoint.INSTANCE.serializer());
            polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(BackendEvent.Paywalls.class), BackendEvent.Paywalls.INSTANCE.serializer());
            polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(BackendEvent.Workflows.class), BackendEvent.Workflows.INSTANCE.serializer());
            polymorphicModuleBuilder.buildTo(serializersModuleBuilder);
            Json.setSerializersModule(serializersModuleBuilder.build());
            Json.setClassDiscriminator("discriminator");
            Json.setEncodeDefaults(false);
            Json.setIgnoreUnknownKeys(true);
        }
    }, 1, null);

    public /* synthetic */ JsonProvider(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: JsonProvider.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/common/JsonProvider$Companion;", "", "()V", "defaultJson", "Lkotlinx/serialization/json/Json;", "getDefaultJson", "()Lkotlinx/serialization/json/Json;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Json getDefaultJson() {
            return JsonProvider.defaultJson;
        }
    }

    private JsonProvider() {
    }
}
