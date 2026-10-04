package kotlinx.serialization.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: compiled from: JsonAnnotations.kt */
/* JADX INFO: loaded from: classes8.dex */
@Target({ElementType.TYPE})
@Metadata(m1598d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m1599d2 = {"Lkotlinx/serialization/json/JsonIgnoreUnknownKeys;", "", "kotlinx-serialization-json"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@ExperimentalSerializationApi
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonIgnoreUnknownKeys {

    /* JADX INFO: compiled from: JsonAnnotations.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class Impl implements JsonIgnoreUnknownKeys {
    }
}
