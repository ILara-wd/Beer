package mx.fintonic.test.domain.remote

internal interface ServiceFactory {

    fun <T> createApiService(serviceClass: Class<T>): T
}
