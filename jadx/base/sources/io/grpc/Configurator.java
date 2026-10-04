package io.grpc;

/* JADX INFO: loaded from: classes8.dex */
interface Configurator {
    default void configureChannelBuilder(ManagedChannelBuilder<?> managedChannelBuilder) {
    }

    default void configureServerBuilder(ServerBuilder<?> serverBuilder) {
    }
}
