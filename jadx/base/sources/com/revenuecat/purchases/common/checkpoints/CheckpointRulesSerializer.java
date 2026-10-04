package com.revenuecat.purchases.common.checkpoints;

import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;

/* JADX INFO: compiled from: CheckpointResponse.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u000fH\u0016J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001a"}, m1599d2 = {"Lcom/revenuecat/purchases/common/checkpoints/CheckpointRulesSerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointRule;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeRule", "decoder", "Lkotlinx/serialization/json/JsonDecoder;", "element", "Lkotlinx/serialization/json/JsonElement;", "deserialize", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "skipRule", "reason", "", "validateRule", "rule", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CheckpointRulesSerializer implements KSerializer<List<? extends CheckpointRule>> {
    public static final CheckpointRulesSerializer INSTANCE = new CheckpointRulesSerializer();
    private static final SerialDescriptor descriptor = CheckpointResponseKt.checkpointRuleListSerializer.getDescriptor();

    private CheckpointRulesSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public List<CheckpointRule> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new SerializationException("Checkpoint rules can only be deserialized from JSON.");
        }
        Object objDecodeJsonElement = jsonDecoder.decodeJsonElement();
        if (Intrinsics.areEqual(objDecodeJsonElement, JsonNull.INSTANCE)) {
            return CollectionsKt.emptyList();
        }
        if (objDecodeJsonElement instanceof JsonArray) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Iterable) objDecodeJsonElement).iterator();
            while (it.hasNext()) {
                CheckpointRule checkpointRuleDecodeRule = INSTANCE.decodeRule(jsonDecoder, (JsonElement) it.next());
                if (checkpointRuleDecodeRule != null) {
                    arrayList.add(checkpointRuleDecodeRule);
                }
            }
            return arrayList;
        }
        LogLevel logLevel = LogLevel.WARN;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Skipping malformed checkpoint rules: expected an array.");
        }
        return CollectionsKt.emptyList();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, List<CheckpointRule> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        CheckpointResponseKt.checkpointRuleListSerializer.serialize(encoder, value);
    }

    private final CheckpointRule decodeRule(JsonDecoder decoder, JsonElement element) {
        try {
            Json json = decoder.getJson();
            json.getSerializersModule();
            return validateRule((CheckpointRule) json.decodeFromJsonElement(CheckpointRule.INSTANCE.serializer(), element));
        } catch (SerializationException unused) {
            return skipRule("invalid structure");
        }
    }

    private final CheckpointRule validateRule(CheckpointRule rule) {
        String str;
        if (rule.getAudienceId().length() == 0) {
            str = "missing 'audience_id'";
        } else {
            str = rule.getWorkflowId().length() == 0 ? "missing 'workflow_id'" : null;
        }
        return str == null ? rule : skipRule(str);
    }

    private final CheckpointRule skipRule(String reason) {
        LogLevel logLevel = LogLevel.WARN;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) > 0) {
            return null;
        }
        currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Skipping malformed checkpoint rule: " + reason + '.');
        return null;
    }
}
