package curriculum.analyser.service.factory

import curriculum.analyser.model.Curriculum
import curriculum.analyser.service.converter.DocxConverterService
import curriculum.analyser.service.converter.HtmlConverterService
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import java.io.File
import javax.inject.Singleton

@Singleton
class CurriculumFactory (private val docxConverterService: DocxConverterService,
                         private val htmlConverterService: HtmlConverterService) {

    suspend fun createCurriculumInstance(file: File): Curriculum = coroutineScope {
        val curriculumDocx =  async(start = CoroutineStart.LAZY) { docxConverterService.convertDocxToObject(file) };
        val curriculumHtml = async { htmlConverterService.convertDocxToHtml(file) };

        Curriculum(curriculumDocx = curriculumDocx.await(), curriculumHtml = curriculumHtml.await());
    }
}