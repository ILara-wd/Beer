package mx.fintonic.test.data.remote.api

import mx.fintonic.test.domain.remote.ServiceFactory
import mx.fintonic.test.data.di.FintonicRetrofit
import retrofit2.Retrofit
import javax.inject.Inject

internal class ApiServiceFactory @Inject constructor(
    @FintonicRetrofit private val retrofit: Retrofit,
) : ServiceFactory {

    override fun <T> createApiService(serviceClass: Class<T>): T = retrofit.create(serviceClass)
}
