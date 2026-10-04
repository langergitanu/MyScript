package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.auth.credentials.JsonCredentialsResponse;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.Deserializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.json.JsonFieldTraitsKt;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import aws.smithy.kotlin.runtime.time.Instant;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonCredentialsDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0005"}, m1599d2 = {"deserializeJsonCredentials", "Laws/sdk/kotlin/runtime/auth/credentials/JsonCredentialsResponse;", "deserializer", "Laws/smithy/kotlin/runtime/serde/Deserializer;", "deserializeJsonProcessCredentials", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JsonCredentialsDeserializerKt {
    public static final JsonCredentialsResponse deserializeJsonCredentials(Deserializer deserializer) {
        Deserializer.FieldIterator fieldIterator;
        String lowerCase;
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("Code"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("AccessKeyId"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("SecretAccessKey"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("Token"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.Timestamp.INSTANCE, new JsonSerialName("Expiration"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("AccountId"));
        SdkFieldDescriptor sdkFieldDescriptor7 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("Message"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        builder.field(sdkFieldDescriptor7);
        try {
            Deserializer.FieldIterator fieldIteratorDeserializeStruct = deserializer.deserializeStruct(builder.build());
            String strDeserializeString = null;
            String strDeserializeString2 = null;
            String strDeserializeString3 = null;
            String strDeserializeString4 = null;
            String strDeserializeString5 = null;
            Instant instantFromIso8601 = null;
            String strDeserializeString6 = null;
            while (true) {
                Integer numFindNextFieldIndex = fieldIteratorDeserializeStruct.findNextFieldIndex();
                int index = sdkFieldDescriptor.getIndex();
                if (numFindNextFieldIndex == null) {
                    fieldIterator = fieldIteratorDeserializeStruct;
                } else {
                    fieldIterator = fieldIteratorDeserializeStruct;
                    if (numFindNextFieldIndex.intValue() == index) {
                        strDeserializeString = fieldIterator.deserializeString();
                    }
                    fieldIteratorDeserializeStruct = fieldIterator;
                }
                int index2 = sdkFieldDescriptor2.getIndex();
                if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index2) {
                    int index3 = sdkFieldDescriptor3.getIndex();
                    if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index3) {
                        int index4 = sdkFieldDescriptor4.getIndex();
                        if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index4) {
                            int index5 = sdkFieldDescriptor5.getIndex();
                            if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index5) {
                                int index6 = sdkFieldDescriptor6.getIndex();
                                if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index6) {
                                    int index7 = sdkFieldDescriptor7.getIndex();
                                    if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index7) {
                                        if (numFindNextFieldIndex == null) {
                                            break;
                                        }
                                        fieldIterator.skipValue();
                                    } else {
                                        strDeserializeString2 = fieldIterator.deserializeString();
                                    }
                                } else {
                                    strDeserializeString6 = fieldIterator.deserializeString();
                                }
                            } else {
                                instantFromIso8601 = Instant.INSTANCE.fromIso8601(fieldIterator.deserializeString());
                            }
                        } else {
                            strDeserializeString5 = fieldIterator.deserializeString();
                        }
                    } else {
                        strDeserializeString4 = fieldIterator.deserializeString();
                    }
                } else {
                    strDeserializeString3 = fieldIterator.deserializeString();
                }
                fieldIteratorDeserializeStruct = fieldIterator;
            }
            if (strDeserializeString != null) {
                lowerCase = strDeserializeString.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (!Intrinsics.areEqual(lowerCase, FirebaseAnalytics.Param.SUCCESS) && lowerCase != null) {
                return new JsonCredentialsResponse.Error(strDeserializeString, strDeserializeString2);
            }
            if (strDeserializeString3 == null) {
                throw new InvalidJsonCredentialsException("missing field `AccessKeyId`", null, 2, null);
            }
            if (strDeserializeString4 == null) {
                throw new InvalidJsonCredentialsException("missing field `SecretAccessKey`", null, 2, null);
            }
            if (strDeserializeString5 == null) {
                throw new InvalidJsonCredentialsException("missing field `Token`", null, 2, null);
            }
            if (instantFromIso8601 == null) {
                throw new InvalidJsonCredentialsException("missing field `Expiration`", null, 2, null);
            }
            return new JsonCredentialsResponse.SessionCredentials(strDeserializeString3, strDeserializeString4, strDeserializeString5, instantFromIso8601, strDeserializeString6);
        } catch (DeserializationException e) {
            throw new InvalidJsonCredentialsException("invalid JSON credentials response", e);
        }
    }

    public static final JsonCredentialsResponse deserializeJsonProcessCredentials(Deserializer deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("AccessKeyId"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("SecretAccessKey"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("SessionToken"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.Timestamp.INSTANCE, new JsonSerialName("Expiration"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("Version"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("AccountId"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        try {
            Deserializer.FieldIterator fieldIteratorDeserializeStruct = deserializer.deserializeStruct(builder.build());
            Integer numValueOf = null;
            String strDeserializeString = null;
            String strDeserializeString2 = null;
            String strDeserializeString3 = null;
            Instant instantFromIso8601 = null;
            String strDeserializeString4 = null;
            while (true) {
                Integer numFindNextFieldIndex = fieldIteratorDeserializeStruct.findNextFieldIndex();
                int index = sdkFieldDescriptor.getIndex();
                if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index) {
                    int index2 = sdkFieldDescriptor2.getIndex();
                    if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index2) {
                        int index3 = sdkFieldDescriptor3.getIndex();
                        if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index3) {
                            int index4 = sdkFieldDescriptor4.getIndex();
                            if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index4) {
                                int index5 = sdkFieldDescriptor5.getIndex();
                                if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index5) {
                                    int index6 = sdkFieldDescriptor6.getIndex();
                                    if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index6) {
                                        if (numFindNextFieldIndex == null) {
                                            break;
                                        }
                                        fieldIteratorDeserializeStruct.skipValue();
                                    } else {
                                        strDeserializeString4 = fieldIteratorDeserializeStruct.deserializeString();
                                    }
                                } else {
                                    numValueOf = Integer.valueOf(fieldIteratorDeserializeStruct.deserializeInt());
                                }
                            } else {
                                instantFromIso8601 = Instant.INSTANCE.fromIso8601(fieldIteratorDeserializeStruct.deserializeString());
                            }
                        } else {
                            strDeserializeString3 = fieldIteratorDeserializeStruct.deserializeString();
                        }
                    } else {
                        strDeserializeString2 = fieldIteratorDeserializeStruct.deserializeString();
                    }
                } else {
                    strDeserializeString = fieldIteratorDeserializeStruct.deserializeString();
                }
            }
            if (strDeserializeString == null) {
                throw new InvalidJsonCredentialsException("missing field `" + JsonFieldTraitsKt.getSerialName(sdkFieldDescriptor) + '`', null, 2, null);
            }
            if (strDeserializeString2 == null) {
                throw new InvalidJsonCredentialsException("missing field `" + JsonFieldTraitsKt.getSerialName(sdkFieldDescriptor2) + '`', null, 2, null);
            }
            if (strDeserializeString3 == null) {
                throw new InvalidJsonCredentialsException("missing field `" + JsonFieldTraitsKt.getSerialName(sdkFieldDescriptor3) + '`', null, 2, null);
            }
            if (numValueOf == null) {
                throw new InvalidJsonCredentialsException("missing field `" + JsonFieldTraitsKt.getSerialName(sdkFieldDescriptor5) + '`', null, 2, null);
            }
            if (numValueOf.intValue() != 1) {
                throw new InvalidJsonCredentialsException("version " + numValueOf.intValue() + " is not supported", null, 2, null);
            }
            return new JsonCredentialsResponse.SessionCredentials(strDeserializeString, strDeserializeString2, strDeserializeString3, instantFromIso8601, strDeserializeString4);
        } catch (DeserializationException e) {
            throw new InvalidJsonCredentialsException("invalid JSON credentials response", e);
        }
    }
}
