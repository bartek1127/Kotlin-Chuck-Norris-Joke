package com.bartek.chucknorris;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideApiService$app_debugFactory implements Factory<ApiService> {
  private final ApiModule module;

  private final Provider<Retrofit> retrofitProvider;

  public ApiModule_ProvideApiService$app_debugFactory(
      ApiModule module, Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public ApiService get() {
    return provideApiService$app_debug(module, retrofitProvider.get());
  }

  public static ApiModule_ProvideApiService$app_debugFactory create(
      ApiModule module, Provider<Retrofit> retrofitProvider) {
    return new ApiModule_ProvideApiService$app_debugFactory(module, retrofitProvider);
  }

  public static ApiService provideApiService$app_debug(ApiModule instance, Retrofit retrofit) {
    return Preconditions.checkNotNull(
        instance.provideApiService$app_debug(retrofit),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
