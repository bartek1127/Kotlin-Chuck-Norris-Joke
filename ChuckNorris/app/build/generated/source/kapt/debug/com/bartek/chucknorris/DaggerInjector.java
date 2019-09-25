package com.bartek.chucknorris;

import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerInjector implements Injector {
  private Provider<GsonConverterFactory> provideGson$app_debugProvider;

  private Provider<OkHttpClient> provideOkHttpClient$app_debugProvider;

  private Provider<Retrofit> provideRetrofit$app_debugProvider;

  private Provider<ApiService> provideApiService$app_debugProvider;

  private DaggerInjector(ApiModule apiModuleParam) {

    initialize(apiModuleParam);
  }

  public static Injector.Builder builder() {
    return new Builder();
  }

  public static Injector create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final ApiModule apiModuleParam) {
    this.provideGson$app_debugProvider =
        SingleCheck.provider(ApiModule_ProvideGson$app_debugFactory.create(apiModuleParam));
    this.provideOkHttpClient$app_debugProvider =
        SingleCheck.provider(ApiModule_ProvideOkHttpClient$app_debugFactory.create(apiModuleParam));
    this.provideRetrofit$app_debugProvider =
        SingleCheck.provider(
            ApiModule_ProvideRetrofit$app_debugFactory.create(
                apiModuleParam,
                provideGson$app_debugProvider,
                provideOkHttpClient$app_debugProvider));
    this.provideApiService$app_debugProvider =
        SingleCheck.provider(
            ApiModule_ProvideApiService$app_debugFactory.create(
                apiModuleParam, provideRetrofit$app_debugProvider));
  }

  @Override
  public void inject(MainActivity mainActivity) {
    injectMainActivity(mainActivity);
  }

  @Override
  public void inject(DetailActivity mainActivity) {
    injectDetailActivity(mainActivity);
  }

  private MainActivity injectMainActivity(MainActivity instance) {
    MainActivity_MembersInjector.injectApiService(
        instance, provideApiService$app_debugProvider.get());
    return instance;
  }

  private DetailActivity injectDetailActivity(DetailActivity instance) {
    DetailActivity_MembersInjector.injectApi(instance, provideApiService$app_debugProvider.get());
    return instance;
  }

  private static final class Builder implements Injector.Builder {
    private ApiModule apiModule;

    @Override
    public Builder apiModule(ApiModule apiModule) {
      this.apiModule = Preconditions.checkNotNull(apiModule);
      return this;
    }

    @Override
    public Injector build() {
      if (apiModule == null) {
        this.apiModule = new ApiModule();
      }
      return new DaggerInjector(apiModule);
    }
  }
}
