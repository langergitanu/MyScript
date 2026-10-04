package aws.smithy.kotlin.runtime.http.config;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: HttpClientConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005R1\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b\u0012\u0004\u0012\u00028\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\fÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/config/EngineFactory;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "B", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", ExifInterface.LONGITUDE_EAST, "", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "getEngineConstructor", "()Lkotlin/jvm/functions/Function1;", "engineConstructor", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface EngineFactory<B extends HttpClientEngineConfig.Builder, E extends HttpClientEngine> {
    Function1<Function1<? super B, Unit>, E> getEngineConstructor();
}
