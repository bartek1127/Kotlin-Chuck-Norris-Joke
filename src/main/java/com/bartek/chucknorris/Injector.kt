package com.bartek.chucknorris

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component( modules = [ApiModule::class] )
interface Injector {

    fun inject(mainActivity: MainActivity)
    fun inject(mainActivity: DetailActivity)

    @Component.Builder
    interface Builder {
        fun apiModule(apiModule: ApiModule): Builder
        fun build(): Injector
    }

}