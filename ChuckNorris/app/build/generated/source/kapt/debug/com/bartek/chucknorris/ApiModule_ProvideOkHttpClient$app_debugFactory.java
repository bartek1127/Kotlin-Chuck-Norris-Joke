package com.bartek.chucknorris;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideOkHttpClient$app_debugFactory implements Factory<OkHttpClient> {
  private final ApiModule module;

  public ApiModule_ProvideOkHttpClient$app_debugFactory(ApiModule module) {
    this.module = module;
  }

  @Override
  public OkHttpClient get() {
    return provideOkHttpClient$app_debug(module);
  }

  public static ApiModule_ProvideOkHttpClient$app_debugFactory create(ApiModule module) {
    return new ApiModule_ProvideOkHttpClient$app_debugFactory(module);
  }

  public static OkHttpClient provideOkHttpClient$app_debug(ApiModule instance) {
    return Preconditions.checkNotNull(
        instance.provideOkHttpClient$app_debug(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
