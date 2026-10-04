package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.model.CreateTokenResponse;
import aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt;
import aws.smithy.kotlin.runtime.hashing.Sha1Kt;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.json.JsonStreamReader;
import aws.smithy.kotlin.runtime.serde.json.JsonStreamReaderKt;
import aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter;
import aws.smithy.kotlin.runtime.serde.json.JsonStreamWriterKt;
import aws.smithy.kotlin.runtime.serde.json.JsonToken;
import aws.smithy.kotlin.runtime.text.encoding.HexKt;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: SsoTokenProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0004\u001a\u00020\u0003*\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\"\u00020\u0003H\u0000¢\u0006\u0002\u0010\b\u001a\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\r\u001a\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u000f\u001a\u00020\n*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\nH\u0000\u001a\u001e\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0014\u001a\u00020\u0015*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, m1599d2 = {"DEFAULT_SSO_TOKEN_REFRESH_BUFFER_SECONDS", "", "OIDC_GRANT_TYPE_REFRESH", "", "filepath", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "parts", "", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;[Ljava/lang/String;)Ljava/lang/String;", "readTokenFromCache", "Laws/sdk/kotlin/runtime/auth/credentials/SsoToken;", "cacheKey", "platformProvider", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/util/PlatformProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCacheFilename", "toSsoToken", "Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenResponse;", "oldToken", "clock", "Laws/smithy/kotlin/runtime/time/Clock;", "canRefresh", "", "getCanRefresh", "(Laws/sdk/kotlin/runtime/auth/credentials/SsoToken;)Z", "deserializeSsoToken", "json", "", "serializeSsoToken", "token", "writeNotNull", "", "Laws/smithy/kotlin/runtime/serde/json/JsonStreamWriter;", "name", "value", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SsoTokenProviderKt {
    private static final int DEFAULT_SSO_TOKEN_REFRESH_BUFFER_SECONDS = 300;
    private static final String OIDC_GRANT_TYPE_REFRESH = "refresh_token";

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProviderKt$readTokenFromCache$1 */
    /* JADX INFO: compiled from: SsoTokenProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProviderKt", m1609f = "SsoTokenProvider.kt", m1610i = {0, 0, 0, 0, 0, 0}, m1611l = {147}, m1612m = "readTokenFromCache", m1613n = {"cacheKey", "platformProvider", SubscriberAttributeKt.JSON_NAME_KEY, "$this$readTokenFromCache_u24lambda_u240", "defaultCacheLocation", "$i$a$-with-SsoTokenProviderKt$readTokenFromCache$bytes$1"}, m1614nl = {145}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, m1616v = 2)
    static final class C30301 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C30301(Continuation<? super C30301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SsoTokenProviderKt.readTokenFromCache(null, null, this);
        }
    }

    public static final String filepath(PlatformProvider platformProvider, String... parts) {
        Intrinsics.checkNotNullParameter(platformProvider, "<this>");
        Intrinsics.checkNotNullParameter(parts, "parts");
        return ArraysKt.joinToString$default(parts, platformProvider.getFilePathSeparator(), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readTokenFromCache(String str, PlatformProvider platformProvider, Continuation<? super SsoToken> continuation) {
        C30301 c30301;
        if (continuation instanceof C30301) {
            c30301 = (C30301) continuation;
            if ((c30301.label & Integer.MIN_VALUE) != 0) {
                c30301.label -= Integer.MIN_VALUE;
            } else {
                c30301 = new C30301(continuation);
            }
        }
        Object fileOrNull = c30301.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30301.label;
        if (i == 0) {
            ResultKt.throwOnFailure(fileOrNull);
            String cacheFilename = getCacheFilename(str);
            String strNormalizePath = AwsConfigLoaderKt.normalizePath(filepath(platformProvider, "~", ".aws", "sso", "cache"), platformProvider);
            String strFilepath = filepath(platformProvider, strNormalizePath, cacheFilename);
            c30301.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c30301.L$1 = SpillingKt.nullOutSpilledVariable(platformProvider);
            c30301.L$2 = SpillingKt.nullOutSpilledVariable(cacheFilename);
            c30301.L$3 = SpillingKt.nullOutSpilledVariable(platformProvider);
            c30301.L$4 = SpillingKt.nullOutSpilledVariable(strNormalizePath);
            c30301.I$0 = 0;
            c30301.label = 1;
            fileOrNull = platformProvider.readFileOrNull(strFilepath, c30301);
            if (fileOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c30301.I$0;
            ResultKt.throwOnFailure(fileOrNull);
        }
        byte[] bArr = (byte[]) fileOrNull;
        if (bArr == null) {
            throw new ProviderConfigurationException("Invalid or missing SSO session cache. Run `aws sso login` to initiate a new SSO session", null, 2, null);
        }
        return deserializeSsoToken(bArr);
    }

    public static final String getCacheFilename(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        return HexKt.encodeToHex(Sha1Kt.sha1(StringsKt.encodeToByteArray(cacheKey))) + ".json";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SsoToken toSsoToken(CreateTokenResponse createTokenResponse, SsoToken ssoToken, Clock clock) {
        String accessToken = createTokenResponse.getAccessToken();
        if (accessToken == null) {
            throw new IllegalStateException("missing accessToken from CreateTokenResponse".toString());
        }
        Instant now = clock.getNow();
        Duration.Companion companion = Duration.INSTANCE;
        return SsoToken.copy$default(ssoToken, accessToken, now.m12289plusLRDsOJo(DurationKt.toDuration(createTokenResponse.getExpiresIn(), DurationUnit.SECONDS)), createTokenResponse.getRefreshToken(), null, null, null, null, null, 248, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getCanRefresh(SsoToken ssoToken) {
        return (ssoToken.getClientId() == null || ssoToken.getClientSecret() == null || ssoToken.getRefreshToken() == null) ? false : true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final SsoToken deserializeSsoToken(byte[] json) {
        Instant instantFromIso8601;
        Intrinsics.checkNotNullParameter(json, "json");
        JsonStreamReader jsonStreamReader = JsonStreamReaderKt.jsonStreamReader(json);
        try {
            JsonToken jsonTokenNextToken = jsonStreamReader.nextToken();
            if (jsonTokenNextToken.getClass() != JsonToken.BeginObject.class) {
                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.BeginObject.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken.getClass()));
            }
            if (jsonTokenNextToken == null) {
                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.BeginObject");
            }
            String value = null;
            String value2 = null;
            String value3 = null;
            String value4 = null;
            String value5 = null;
            Instant instantFromIso86012 = null;
            String value6 = null;
            String value7 = null;
            while (true) {
                JsonToken jsonTokenNextToken2 = jsonStreamReader.nextToken();
                if (jsonTokenNextToken2 instanceof JsonToken.EndObject) {
                    if (value2 == null) {
                        throw new InvalidSsoTokenException("missing `accessToken`", null, 2, null);
                    }
                    if (value == null || (instantFromIso8601 = Instant.INSTANCE.fromIso8601(value)) == null) {
                        throw new InvalidSsoTokenException("missing `expiresAt`", null, 2, null);
                    }
                    return new SsoToken(value2, instantFromIso8601, value3, value4, value5, instantFromIso86012, value6, value7);
                }
                if (!(jsonTokenNextToken2 instanceof JsonToken.Name)) {
                    throw new IllegalStateException("expected either key or end of object".toString());
                }
                String value8 = ((JsonToken.Name) jsonTokenNextToken2).getValue();
                switch (value8.hashCode()) {
                    case -1446909349:
                        if (!value8.equals("clientSecret")) {
                            jsonStreamReader.skipNext();
                        } else {
                            JsonToken jsonTokenNextToken3 = jsonStreamReader.nextToken();
                            if (jsonTokenNextToken3.getClass() != JsonToken.String.class) {
                                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken3.getClass()));
                            }
                            if (jsonTokenNextToken3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                            }
                            value5 = ((JsonToken.String) jsonTokenNextToken3).getValue();
                        }
                        break;
                    case -1311790642:
                        if (!value8.equals("registrationExpiresAt")) {
                            jsonStreamReader.skipNext();
                        } else {
                            JsonToken jsonTokenNextToken4 = jsonStreamReader.nextToken();
                            if (jsonTokenNextToken4.getClass() != JsonToken.String.class) {
                                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken4.getClass()));
                            }
                            if (jsonTokenNextToken4 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                            }
                            instantFromIso86012 = Instant.INSTANCE.fromIso8601(((JsonToken.String) jsonTokenNextToken4).getValue());
                        }
                        break;
                    case -1042689291:
                        if (!value8.equals("accessToken")) {
                            jsonStreamReader.skipNext();
                        } else {
                            JsonToken jsonTokenNextToken5 = jsonStreamReader.nextToken();
                            if (jsonTokenNextToken5.getClass() != JsonToken.String.class) {
                                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken5.getClass()));
                            }
                            if (jsonTokenNextToken5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                            }
                            value2 = ((JsonToken.String) jsonTokenNextToken5).getValue();
                        }
                        break;
                    case -934795532:
                        if (!value8.equals(TtmlNode.TAG_REGION)) {
                            jsonStreamReader.skipNext();
                        } else {
                            JsonToken jsonTokenNextToken6 = jsonStreamReader.nextToken();
                            if (jsonTokenNextToken6.getClass() != JsonToken.String.class) {
                                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken6.getClass()));
                            }
                            if (jsonTokenNextToken6 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                            }
                            value6 = ((JsonToken.String) jsonTokenNextToken6).getValue();
                        }
                        break;
                    case -56506402:
                        if (!value8.equals("refreshToken")) {
                            jsonStreamReader.skipNext();
                        } else {
                            JsonToken jsonTokenNextToken7 = jsonStreamReader.nextToken();
                            if (jsonTokenNextToken7.getClass() != JsonToken.String.class) {
                                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken7.getClass()));
                            }
                            if (jsonTokenNextToken7 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                            }
                            value3 = ((JsonToken.String) jsonTokenNextToken7).getValue();
                        }
                        break;
                    case 250196615:
                        if (!value8.equals("expiresAt")) {
                            jsonStreamReader.skipNext();
                        } else {
                            JsonToken jsonTokenNextToken8 = jsonStreamReader.nextToken();
                            if (jsonTokenNextToken8.getClass() != JsonToken.String.class) {
                                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken8.getClass()));
                            }
                            if (jsonTokenNextToken8 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                            }
                            value = ((JsonToken.String) jsonTokenNextToken8).getValue();
                        }
                        break;
                    case 908408390:
                        if (!value8.equals("clientId")) {
                            jsonStreamReader.skipNext();
                        } else {
                            JsonToken jsonTokenNextToken9 = jsonStreamReader.nextToken();
                            if (jsonTokenNextToken9.getClass() != JsonToken.String.class) {
                                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken9.getClass()));
                            }
                            if (jsonTokenNextToken9 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                            }
                            value4 = ((JsonToken.String) jsonTokenNextToken9).getValue();
                        }
                        break;
                    case 1316787629:
                        if (!value8.equals("startUrl")) {
                            jsonStreamReader.skipNext();
                        } else {
                            JsonToken jsonTokenNextToken10 = jsonStreamReader.nextToken();
                            if (jsonTokenNextToken10.getClass() != JsonToken.String.class) {
                                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken10.getClass()));
                            }
                            if (jsonTokenNextToken10 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                            }
                            value7 = ((JsonToken.String) jsonTokenNextToken10).getValue();
                        }
                        break;
                    default:
                        jsonStreamReader.skipNext();
                        break;
                }
            }
        } catch (Exception e) {
            throw new InvalidSsoTokenException("invalid cached SSO token", e);
        }
    }

    public static final byte[] serializeSsoToken(SsoToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        JsonStreamWriter jsonStreamWriter = JsonStreamWriterKt.jsonStreamWriter(true);
        jsonStreamWriter.beginObject();
        jsonStreamWriter.writeName("accessToken");
        jsonStreamWriter.writeValue(token.getToken());
        jsonStreamWriter.writeName("expiresAt");
        jsonStreamWriter.writeValue(token.getExpiration().format(TimestampFormat.ISO_8601));
        writeNotNull(jsonStreamWriter, "refreshToken", token.getRefreshToken());
        writeNotNull(jsonStreamWriter, "clientId", token.getClientId());
        writeNotNull(jsonStreamWriter, "clientSecret", token.getClientSecret());
        Instant registrationExpiresAt = token.getRegistrationExpiresAt();
        writeNotNull(jsonStreamWriter, "registrationExpiresAt", registrationExpiresAt != null ? registrationExpiresAt.format(TimestampFormat.ISO_8601) : null);
        writeNotNull(jsonStreamWriter, TtmlNode.TAG_REGION, token.getRegion());
        writeNotNull(jsonStreamWriter, "startUrl", token.getStartUrl());
        jsonStreamWriter.endObject();
        byte[] bytes = jsonStreamWriter.getBytes();
        if (bytes != null) {
            return bytes;
        }
        throw new IllegalStateException("serializing SsoToken failed".toString());
    }

    public static final void writeNotNull(JsonStreamWriter jsonStreamWriter, String name, String str) {
        Intrinsics.checkNotNullParameter(jsonStreamWriter, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (str == null) {
            return;
        }
        jsonStreamWriter.writeName(name);
        jsonStreamWriter.writeValue(str);
    }
}
