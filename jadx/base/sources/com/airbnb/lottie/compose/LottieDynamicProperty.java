package com.airbnb.lottie.compose;

import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LottieDynamicProperties.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007B@\b\u0000\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012'\u0010\b\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\u000eR5\u0010\b\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00028\u00000\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00028\u0000X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, m1599d2 = {"Lcom/airbnb/lottie/compose/LottieDynamicProperty;", ExifInterface.GPS_DIRECTION_TRUE, "", "property", "keyPath", "Lcom/airbnb/lottie/model/KeyPath;", "value", "(Ljava/lang/Object;Lcom/airbnb/lottie/model/KeyPath;Ljava/lang/Object;)V", "callback", "Lkotlin/Function1;", "Lcom/airbnb/lottie/value/LottieFrameInfo;", "Lkotlin/ParameterName;", "name", "frameInfo", "(Ljava/lang/Object;Lcom/airbnb/lottie/model/KeyPath;Lkotlin/jvm/functions/Function1;)V", "getCallback$lottie_compose_release", "()Lkotlin/jvm/functions/Function1;", "getKeyPath$lottie_compose_release", "()Lcom/airbnb/lottie/model/KeyPath;", "getProperty$lottie_compose_release", "()Ljava/lang/Object;", "Ljava/lang/Object;", "lottie-compose_release"}, m1600k = 1, m1601mv = {1, 9, 0}, m1603xi = 48)
public final class LottieDynamicProperty<T> {
    public static final int $stable = 8;
    private final Function1<LottieFrameInfo<T>, T> callback;
    private final KeyPath keyPath;
    private final T property;

    /* JADX WARN: Multi-variable type inference failed */
    public LottieDynamicProperty(T t, KeyPath keyPath, Function1<? super LottieFrameInfo<T>, ? extends T> callback) {
        Intrinsics.checkNotNullParameter(keyPath, "keyPath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.property = t;
        this.keyPath = keyPath;
        this.callback = callback;
    }

    public final T getProperty$lottie_compose_release() {
        return this.property;
    }

    /* JADX INFO: renamed from: getKeyPath$lottie_compose_release, reason: from getter */
    public final KeyPath getKeyPath() {
        return this.keyPath;
    }

    public final Function1<LottieFrameInfo<T>, T> getCallback$lottie_compose_release() {
        return this.callback;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LottieDynamicProperty(T t, KeyPath keyPath, final T t2) {
        this((Object) t, keyPath, (Function1) new Function1<LottieFrameInfo<T>, T>() { // from class: com.airbnb.lottie.compose.LottieDynamicProperty.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(LottieFrameInfo<T> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return t2;
            }
        });
        Intrinsics.checkNotNullParameter(keyPath, "keyPath");
    }
}
