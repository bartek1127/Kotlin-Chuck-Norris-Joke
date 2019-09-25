package com.bartek.chucknorris;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<ApiService> apiServiceProvider;

  public MainActivity_MembersInjector(Provider<ApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<ApiService> apiServiceProvider) {
    return new MainActivity_MembersInjector(apiServiceProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectApiService(instance, apiServiceProvider.get());
  }

  public static void injectApiService(MainActivity instance, ApiService apiService) {
    instance.apiService = apiService;
  }
}
