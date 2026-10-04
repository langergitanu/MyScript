package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt;
import aws.smithy.kotlin.runtime.hashing.EcdsaKt;
import aws.smithy.kotlin.runtime.hashing.Sha256Kt;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.json.JsonStreamReader;
import aws.smithy.kotlin.runtime.serde.json.JsonStreamReaderKt;
import aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter;
import aws.smithy.kotlin.runtime.serde.json.JsonStreamWriterKt;
import aws.smithy.kotlin.runtime.serde.json.JsonToken;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import aws.smithy.kotlin.runtime.text.encoding.HexKt;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import aws.smithy.kotlin.runtime.util.Uuid;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.p039io.encoding.Base64;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LoginTokenProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\bH\u0002\u001a\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0002\u001a&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0080@¢\u0006\u0002\u0010\u0012\u001a\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\bH\u0000\u001a\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\rH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"DEFAULT_SIGNIN_TOKEN_REFRESH_BUFFER_SECONDS", "", "PROVIDER_NAME", "", "parseECKeyPem", "Laws/sdk/kotlin/runtime/auth/credentials/ECKeyData;", "pem", "padTo32", "", "generateDpopProof", "privateKeyPem", "endpoint", "readLoginTokenFromCache", "Laws/sdk/kotlin/runtime/auth/credentials/LoginToken;", "cacheKey", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "cacheDirectory", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/util/PlatformProvider;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoginCacheFilename", "deserializeLoginToken", "json", "serializeLoginToken", "token", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LoginTokenProviderKt {
    private static final int DEFAULT_SIGNIN_TOKEN_REFRESH_BUFFER_SECONDS = 300;
    private static final String PROVIDER_NAME = "LOGIN";

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProviderKt$readLoginTokenFromCache$1 */
    /* JADX INFO: compiled from: LoginTokenProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProviderKt", m1609f = "LoginTokenProvider.kt", m1610i = {0, 0, 0, 0, 0, 0, 0}, m1611l = {PDFACompliance.e_PDFA3_3_2}, m1612m = "readLoginTokenFromCache", m1613n = {"cacheKey", "platformProvider", "cacheDirectory", SubscriberAttributeKt.JSON_NAME_KEY, "$this$readLoginTokenFromCache_u24lambda_u240", "defaultCacheLocation", "$i$a$-with-LoginTokenProviderKt$readLoginTokenFromCache$bytes$1"}, m1614nl = {330}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, m1616v = 2)
    static final class C30171 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C30171(Continuation<? super C30171> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginTokenProviderKt.readLoginTokenFromCache(null, null, null, this);
        }
    }

    private static final ECKeyData parseECKeyPem(String str) {
        int i;
        byte[] bArrDecodeBase64Bytes = Base64Kt.decodeBase64Bytes(StringsKt.replace$default(StringsKt.replace$default(new Regex("\\s").replace(StringsKt.replace$default(StringsKt.replace$default(str, "-----BEGIN EC PRIVATE KEY-----", "", false, 4, (Object) null), "-----END EC PRIVATE KEY-----", "", false, 4, (Object) null), ""), "\n", "", false, 4, (Object) null), "\r", "", false, 4, (Object) null));
        byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bArrDecodeBase64Bytes, 7, 39);
        int length = bArrDecodeBase64Bytes.length;
        int i2 = 40;
        while (true) {
            if (i2 >= length) {
                i = -1;
                break;
            }
            if (bArrDecodeBase64Bytes[i2] == 4) {
                i = i2 + 1;
                break;
            }
            i2++;
        }
        int length2 = (bArrDecodeBase64Bytes.length - i) / 2;
        int i3 = i + length2;
        return new ECKeyData(bArrCopyOfRange, padTo32(ArraysKt.copyOfRange(bArrDecodeBase64Bytes, i, i3)), padTo32(ArraysKt.copyOfRange(bArrDecodeBase64Bytes, i3, i + (length2 * 2))));
    }

    private static final byte[] padTo32(byte[] bArr) {
        if (bArr.length > 32) {
            throw new IllegalStateException(("Unexpected byte array of size " + bArr.length + "; expected 32 bytes or less").toString());
        }
        return ArraysKt.plus(new byte[32 - bArr.length], bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String generateDpopProof(String str, String str2) {
        ECKeyData eCKeyPem = parseECKeyPem(str);
        Base64 base64WithPadding = Base64.INSTANCE.getUrlSafe().withPadding(Base64.PaddingOption.ABSENT_OPTIONAL);
        JsonStreamWriter jsonStreamWriterJsonStreamWriter$default = JsonStreamWriterKt.jsonStreamWriter$default(false, 1, null);
        jsonStreamWriterJsonStreamWriter$default.beginObject();
        jsonStreamWriterJsonStreamWriter$default.writeName(ClientData.KEY_TYPE);
        jsonStreamWriterJsonStreamWriter$default.writeValue("dpop+jwt");
        jsonStreamWriterJsonStreamWriter$default.writeName("alg");
        jsonStreamWriterJsonStreamWriter$default.writeValue("ES256");
        jsonStreamWriterJsonStreamWriter$default.writeName("jwk");
        jsonStreamWriterJsonStreamWriter$default.beginObject();
        jsonStreamWriterJsonStreamWriter$default.writeName("kty");
        jsonStreamWriterJsonStreamWriter$default.writeValue("EC");
        jsonStreamWriterJsonStreamWriter$default.writeName("x");
        jsonStreamWriterJsonStreamWriter$default.writeValue(Base64.encode$default(base64WithPadding, eCKeyPem.getX(), 0, 0, 6, null));
        jsonStreamWriterJsonStreamWriter$default.writeName("y");
        jsonStreamWriterJsonStreamWriter$default.writeValue(Base64.encode$default(base64WithPadding, eCKeyPem.getY(), 0, 0, 6, null));
        jsonStreamWriterJsonStreamWriter$default.writeName("crv");
        jsonStreamWriterJsonStreamWriter$default.writeValue("P-256");
        jsonStreamWriterJsonStreamWriter$default.endObject();
        jsonStreamWriterJsonStreamWriter$default.endObject();
        byte[] bytes = jsonStreamWriterJsonStreamWriter$default.getBytes();
        JsonStreamWriter jsonStreamWriterJsonStreamWriter$default2 = JsonStreamWriterKt.jsonStreamWriter$default(false, 1, null);
        jsonStreamWriterJsonStreamWriter$default2.beginObject();
        jsonStreamWriterJsonStreamWriter$default2.writeName("jti");
        jsonStreamWriterJsonStreamWriter$default2.writeValue(Uuid.INSTANCE.random().getStringRep());
        jsonStreamWriterJsonStreamWriter$default2.writeName("htm");
        jsonStreamWriterJsonStreamWriter$default2.writeValue("POST");
        jsonStreamWriterJsonStreamWriter$default2.writeName("htu");
        jsonStreamWriterJsonStreamWriter$default2.writeValue(str2);
        jsonStreamWriterJsonStreamWriter$default2.writeName("iat");
        jsonStreamWriterJsonStreamWriter$default2.writeValue(Clock.System.INSTANCE.getNow().getEpochSeconds());
        jsonStreamWriterJsonStreamWriter$default2.endObject();
        byte[] bytes2 = jsonStreamWriterJsonStreamWriter$default2.getBytes();
        Intrinsics.checkNotNull(bytes);
        String strEncode$default = Base64.encode$default(base64WithPadding, bytes, 0, 0, 6, null);
        Intrinsics.checkNotNull(bytes2);
        String str3 = strEncode$default + '.' + Base64.encode$default(base64WithPadding, bytes2, 0, 0, 6, null);
        return str3 + '.' + Base64.encode$default(base64WithPadding, EcdsaKt.ecdsaSecp256r1Rs(eCKeyPem.getD(), StringsKt.encodeToByteArray(str3)), 0, 0, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readLoginTokenFromCache(String str, PlatformProvider platformProvider, String str2, Continuation<? super LoginToken> continuation) {
        C30171 c30171;
        if (continuation instanceof C30171) {
            c30171 = (C30171) continuation;
            if ((c30171.label & Integer.MIN_VALUE) != 0) {
                c30171.label -= Integer.MIN_VALUE;
            } else {
                c30171 = new C30171(continuation);
            }
        }
        Object fileOrNull = c30171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30171.label;
        if (i == 0) {
            ResultKt.throwOnFailure(fileOrNull);
            String loginCacheFilename = getLoginCacheFilename(str);
            String strNormalizePath = AwsConfigLoaderKt.normalizePath(str2, platformProvider);
            String strFilepath = SsoTokenProviderKt.filepath(platformProvider, strNormalizePath, loginCacheFilename);
            c30171.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c30171.L$1 = SpillingKt.nullOutSpilledVariable(platformProvider);
            c30171.L$2 = SpillingKt.nullOutSpilledVariable(str2);
            c30171.L$3 = SpillingKt.nullOutSpilledVariable(loginCacheFilename);
            c30171.L$4 = SpillingKt.nullOutSpilledVariable(platformProvider);
            c30171.L$5 = SpillingKt.nullOutSpilledVariable(strNormalizePath);
            c30171.I$0 = 0;
            c30171.label = 1;
            fileOrNull = platformProvider.readFileOrNull(strFilepath, c30171);
            if (fileOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c30171.I$0;
            ResultKt.throwOnFailure(fileOrNull);
        }
        byte[] bArr = (byte[]) fileOrNull;
        if (bArr == null) {
            throw new ProviderConfigurationException("Invalid or missing login session cache. Run `aws login` to initiate a new session", null, 2, null);
        }
        return deserializeLoginToken(bArr);
    }

    public static final String getLoginCacheFilename(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        return HexKt.encodeToHex(Sha256Kt.sha256(StringsKt.encodeToByteArray(StringsKt.trim((CharSequence) cacheKey).toString()))) + ".json";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final LoginToken deserializeLoginToken(byte[] json) {
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
            boolean z = false;
            String value = null;
            String value2 = null;
            String value3 = null;
            String value4 = null;
            String value5 = null;
            String value6 = null;
            String value7 = null;
            String value8 = null;
            String value9 = null;
            String value10 = null;
            while (true) {
                JsonToken jsonTokenNextToken2 = jsonStreamReader.nextToken();
                if (jsonTokenNextToken2 instanceof JsonToken.EndObject) {
                    if (!z) {
                        throw new InvalidLoginTokenException("missing `accessToken`", null, 2, null);
                    }
                    if (value2 == null) {
                        throw new InvalidLoginTokenException("missing `accessKeyId`", null, 2, null);
                    }
                    if (value3 == null) {
                        throw new InvalidLoginTokenException("missing `secretAccessKey`", null, 2, null);
                    }
                    if (value4 == null) {
                        throw new InvalidLoginTokenException("missing `sessionToken`", null, 2, null);
                    }
                    if (value5 == null) {
                        throw new InvalidLoginTokenException("missing `accountId`", null, 2, null);
                    }
                    if (value == null || (instantFromIso8601 = Instant.INSTANCE.fromIso8601(value)) == null) {
                        throw new InvalidLoginTokenException("missing `expiresAt`", null, 2, null);
                    }
                    if (value9 == null) {
                        throw new InvalidLoginTokenException("missing `clientId`", null, 2, null);
                    }
                    if (value7 == null) {
                        throw new InvalidLoginTokenException("missing `refreshToken`", null, 2, null);
                    }
                    if (value10 != null) {
                        return new LoginToken(value2, value3, value4, value5, value6, instantFromIso8601, value7, value8, value9, value10);
                    }
                    throw new InvalidLoginTokenException("missing `dpopKey`", null, 2, null);
                }
                if (!(jsonTokenNextToken2 instanceof JsonToken.Name)) {
                    throw new IllegalStateException("expected either key or end of object".toString());
                }
                String value11 = ((JsonToken.Name) jsonTokenNextToken2).getValue();
                JsonStreamReader jsonStreamReader2 = jsonStreamReader;
                switch (value11.hashCode()) {
                    case -1042689291:
                        if (value11.equals("accessToken")) {
                            JsonToken jsonTokenNextToken3 = jsonStreamReader2.nextToken();
                            if (jsonTokenNextToken3.getClass() != JsonToken.BeginObject.class) {
                                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.BeginObject.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken3.getClass()));
                            }
                            if (jsonTokenNextToken3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.BeginObject");
                            }
                            while (true) {
                                JsonToken jsonTokenNextToken4 = jsonStreamReader2.nextToken();
                                if (!(jsonTokenNextToken4 instanceof JsonToken.EndObject)) {
                                    if (!(jsonTokenNextToken4 instanceof JsonToken.Name)) {
                                        throw new IllegalStateException("expected key or end of object in accessToken".toString());
                                    }
                                    String value12 = ((JsonToken.Name) jsonTokenNextToken4).getValue();
                                    switch (value12.hashCode()) {
                                        case -1933894261:
                                            if (!value12.equals("secretAccessKey")) {
                                                jsonStreamReader2.skipNext();
                                            } else {
                                                JsonToken jsonTokenNextToken5 = jsonStreamReader2.nextToken();
                                                if (jsonTokenNextToken5.getClass() != JsonToken.String.class) {
                                                    throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken5.getClass()));
                                                }
                                                if (jsonTokenNextToken5 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                                                }
                                                value3 = ((JsonToken.String) jsonTokenNextToken5).getValue();
                                            }
                                            break;
                                        case -1827029976:
                                            if (!value12.equals("accountId")) {
                                                jsonStreamReader2.skipNext();
                                            } else {
                                                JsonToken jsonTokenNextToken6 = jsonStreamReader2.nextToken();
                                                if (jsonTokenNextToken6.getClass() != JsonToken.String.class) {
                                                    throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken6.getClass()));
                                                }
                                                if (jsonTokenNextToken6 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                                                }
                                                value5 = ((JsonToken.String) jsonTokenNextToken6).getValue();
                                            }
                                            break;
                                        case -1051286314:
                                            if (!value12.equals("accessKeyId")) {
                                                jsonStreamReader2.skipNext();
                                            } else {
                                                JsonToken jsonTokenNextToken7 = jsonStreamReader2.nextToken();
                                                if (jsonTokenNextToken7.getClass() != JsonToken.String.class) {
                                                    throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken7.getClass()));
                                                }
                                                if (jsonTokenNextToken7 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                                                }
                                                value2 = ((JsonToken.String) jsonTokenNextToken7).getValue();
                                            }
                                            break;
                                        case -696552189:
                                            if (!value12.equals("sessionToken")) {
                                                jsonStreamReader2.skipNext();
                                            } else {
                                                JsonToken jsonTokenNextToken8 = jsonStreamReader2.nextToken();
                                                if (jsonTokenNextToken8.getClass() != JsonToken.String.class) {
                                                    throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken8.getClass()));
                                                }
                                                if (jsonTokenNextToken8 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                                                }
                                                value4 = ((JsonToken.String) jsonTokenNextToken8).getValue();
                                            }
                                            break;
                                        case 250196615:
                                            if (!value12.equals("expiresAt")) {
                                                jsonStreamReader2.skipNext();
                                            } else {
                                                JsonToken jsonTokenNextToken9 = jsonStreamReader2.nextToken();
                                                if (jsonTokenNextToken9.getClass() != JsonToken.String.class) {
                                                    throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken9.getClass()));
                                                }
                                                if (jsonTokenNextToken9 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                                                }
                                                value = ((JsonToken.String) jsonTokenNextToken9).getValue();
                                            }
                                            break;
                                        default:
                                            jsonStreamReader2.skipNext();
                                            break;
                                    }
                                } else {
                                    z = true;
                                }
                            }
                        } else {
                            jsonStreamReader2.skipNext();
                            jsonStreamReader = jsonStreamReader2;
                            break;
                        }
                        break;
                    case -56506402:
                        if (!value11.equals("refreshToken")) {
                            jsonStreamReader2.skipNext();
                            jsonStreamReader = jsonStreamReader2;
                        } else {
                            JsonToken jsonTokenNextToken10 = jsonStreamReader2.nextToken();
                            if (jsonTokenNextToken10.getClass() != JsonToken.String.class) {
                                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken10.getClass()));
                            }
                            if (jsonTokenNextToken10 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                            }
                            value7 = ((JsonToken.String) jsonTokenNextToken10).getValue();
                            jsonStreamReader = jsonStreamReader2;
                        }
                        break;
                    case 141498579:
                        if (!value11.equals("tokenType")) {
                            jsonStreamReader2.skipNext();
                            jsonStreamReader = jsonStreamReader2;
                        } else {
                            JsonToken jsonTokenNextToken11 = jsonStreamReader2.nextToken();
                            if (jsonTokenNextToken11.getClass() != JsonToken.String.class) {
                                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken11.getClass()));
                            }
                            if (jsonTokenNextToken11 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                            }
                            value6 = ((JsonToken.String) jsonTokenNextToken11).getValue();
                            jsonStreamReader = jsonStreamReader2;
                        }
                        break;
                    case 908408390:
                        if (!value11.equals("clientId")) {
                            jsonStreamReader2.skipNext();
                            jsonStreamReader = jsonStreamReader2;
                        } else {
                            JsonToken jsonTokenNextToken12 = jsonStreamReader2.nextToken();
                            if (jsonTokenNextToken12.getClass() != JsonToken.String.class) {
                                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken12.getClass()));
                            }
                            if (jsonTokenNextToken12 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                            }
                            value9 = ((JsonToken.String) jsonTokenNextToken12).getValue();
                            jsonStreamReader = jsonStreamReader2;
                        }
                        break;
                    case 1642509726:
                        if (!value11.equals("idToken")) {
                            jsonStreamReader2.skipNext();
                            jsonStreamReader = jsonStreamReader2;
                        } else {
                            JsonToken jsonTokenNextToken13 = jsonStreamReader2.nextToken();
                            if (jsonTokenNextToken13.getClass() != JsonToken.String.class) {
                                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken13.getClass()));
                            }
                            if (jsonTokenNextToken13 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                            }
                            value8 = ((JsonToken.String) jsonTokenNextToken13).getValue();
                            jsonStreamReader = jsonStreamReader2;
                        }
                        break;
                    case 1868442546:
                        if (!value11.equals("dpopKey")) {
                            jsonStreamReader2.skipNext();
                            jsonStreamReader = jsonStreamReader2;
                        } else {
                            JsonToken jsonTokenNextToken14 = jsonStreamReader2.nextToken();
                            if (jsonTokenNextToken14.getClass() != JsonToken.String.class) {
                                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.String.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken14.getClass()));
                            }
                            if (jsonTokenNextToken14 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.String");
                            }
                            value10 = ((JsonToken.String) jsonTokenNextToken14).getValue();
                            jsonStreamReader = jsonStreamReader2;
                        }
                        break;
                    default:
                        jsonStreamReader2.skipNext();
                        jsonStreamReader = jsonStreamReader2;
                        break;
                }
            }
        } catch (Exception e) {
            throw new InvalidLoginTokenException("invalid cached login token", e);
        }
    }

    public static final byte[] serializeLoginToken(LoginToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        JsonStreamWriter jsonStreamWriter = JsonStreamWriterKt.jsonStreamWriter(true);
        jsonStreamWriter.beginObject();
        jsonStreamWriter.writeName("accessToken");
        jsonStreamWriter.beginObject();
        SsoTokenProviderKt.writeNotNull(jsonStreamWriter, "accessKeyId", token.getAccessKeyId());
        SsoTokenProviderKt.writeNotNull(jsonStreamWriter, "secretAccessKey", token.getSecretAccessKey());
        SsoTokenProviderKt.writeNotNull(jsonStreamWriter, "sessionToken", token.getSessionToken());
        SsoTokenProviderKt.writeNotNull(jsonStreamWriter, "accountId", token.getAccountId());
        SsoTokenProviderKt.writeNotNull(jsonStreamWriter, "expiresAt", token.getExpiresAt().format(TimestampFormat.ISO_8601));
        jsonStreamWriter.endObject();
        SsoTokenProviderKt.writeNotNull(jsonStreamWriter, "tokenType", token.getTokenType());
        SsoTokenProviderKt.writeNotNull(jsonStreamWriter, "refreshToken", token.getRefreshToken());
        SsoTokenProviderKt.writeNotNull(jsonStreamWriter, "idToken", token.getIdToken());
        SsoTokenProviderKt.writeNotNull(jsonStreamWriter, "clientId", token.getClientId());
        SsoTokenProviderKt.writeNotNull(jsonStreamWriter, "dpopKey", token.getDpopKey());
        jsonStreamWriter.endObject();
        byte[] bytes = jsonStreamWriter.getBytes();
        if (bytes != null) {
            return bytes;
        }
        throw new IllegalStateException("serializing LoginToken failed".toString());
    }
}
