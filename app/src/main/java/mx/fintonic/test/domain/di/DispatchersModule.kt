package mx.fintonic.test.domain.di

import mx.fintonic.test.domain.dispatchers.DefaultDispatcherProvider
import mx.fintonic.test.domain.dispatchers.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DispatchersModule {

    @Singleton
    @Binds
    abstract fun bindDispatcherProvider(
        defaultDispatcherProvider: DefaultDispatcherProvider,
    ): DispatcherProvider
}
