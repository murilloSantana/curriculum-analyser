package curriculum.analyser.service.factory

import curriculum.analyser.model.Curriculum
import curriculum.analyser.service.converter.DocxConverterService
import curriculum.analyser.service.converter.HtmlConverterService
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.io.File
import javax.inject.Singleton

@Singleton
class CurriculumFactory (private val docxConverterService: DocxConverterService,
                         private val htmlConverterService: HtmlConverterService) {

    fun createCurriculumInstance(file: File): Curriculum = runBlocking {
        val curriculumDocx =  async(start = CoroutineStart.LAZY) { docxConverterService.convertDocxToObject(file) };
        val curriculumHtml = async { htmlConverterService.convertDocxToHtml(file) };

        Curriculum(curriculumDocx = curriculumDocx.await(),
                curriculumHtml = curriculumHtml.await());
    }
}