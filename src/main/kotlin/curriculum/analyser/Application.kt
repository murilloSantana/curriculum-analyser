package curriculum.analyser

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("curriculum.analyser")
                .mainClass(Application.javaClass)
                .start()
    }
}