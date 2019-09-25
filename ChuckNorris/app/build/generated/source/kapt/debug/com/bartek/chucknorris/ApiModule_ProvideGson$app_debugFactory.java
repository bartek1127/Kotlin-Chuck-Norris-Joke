package com.bartek.chucknorris;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.converter.gson.GsonConverterFactory;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideGson$app_debugFactory implements Factory<GsonConverterFactory> {
  private final ApiModule module;

  public ApiModule_ProvideGson$app_debugFactory(ApiModule module) {
    this.module = module;
  }

  @Override
  public GsonConverterFactory get() {
    return provideGson$app_debug(module);
  }

  public static ApiModule_ProvideGson$app_debugFactory create(ApiModule module) {
    return new ApiModule_ProvideGson$app_debugFactory(module);
  }

  public static GsonConverterFactory provideGson$app_debug(ApiModule instance) {
    return Preconditions.checkNotNull(
        instance.provideGson$app_debug(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
