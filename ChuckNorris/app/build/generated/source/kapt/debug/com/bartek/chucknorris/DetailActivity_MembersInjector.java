package com.bartek.chucknorris;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DetailActivity_MembersInjector implements MembersInjector<DetailActivity> {
  private final Provider<ApiService> apiProvider;

  public DetailActivity_MembersInjector(Provider<ApiService> apiProvider) {
    this.apiProvider = apiProvider;
  }

  public static MembersInjector<DetailActivity> create(Provider<ApiService> apiProvider) {
    return new DetailActivity_MembersInjector(apiProvider);
  }

  @Override
  public void injectMembers(DetailActivity instance) {
    injectApi(instance, apiProvider.get());
  }

  public static void injectApi(DetailActivity instance, ApiService api) {
    instance.api = api;
  }
}
