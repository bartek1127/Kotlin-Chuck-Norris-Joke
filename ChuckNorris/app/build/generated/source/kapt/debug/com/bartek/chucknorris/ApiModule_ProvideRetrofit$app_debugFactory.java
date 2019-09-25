package com.bartek.chucknorris;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideRetrofit$app_debugFactory implements Factory<Retrofit> {
  private final ApiModule module;

  private final Provider<GsonConverterFactory> gsonProvider;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public ApiModule_ProvideRetrofit$app_debugFactory(
      ApiModule module,
      Provider<GsonConverterFactory> gsonProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    this.module = module;
    this.gsonProvider = gsonProvider;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit$app_debug(module, gsonProvider.get(), okHttpClientProvider.get());
  }

  public static ApiModule_ProvideRetrofit$app_debugFactory create(
      ApiModule module,
      Provider<GsonConverterFactory> gsonProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    return new ApiModule_ProvideRetrofit$app_debugFactory(
        module, gsonProvider, okHttpClientProvider);
  }

  public static Retrofit provideRetrofit$app_debug(
      ApiModule instance, GsonConverterFactory gson, OkHttpClient okHttpClient) {
    return Preconditions.checkNotNull(
        instance.provideRetrofit$app_debug(gson, okHttpClient),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
