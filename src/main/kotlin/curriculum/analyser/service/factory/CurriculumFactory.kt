package curriculum.analyser.service.factory

import curriculum.analyser.model.Curriculum
import curriculum.analyser.service.converter.DocxConverterService
import curriculum.analyser.service.converter.HtmlConverterService
import java.io.File
import javax.inject.Singleton

@Singleton
class CurriculumFactory (private val docxConverterService: DocxConverterService,
                         private val htmlConverterService: HtmlConverterService) {

    fun createCurriculumInstance(file: File): Curriculum {
        val curriculumDocx = docxConverterService.convertDocxToObject(file);
        val curriculumHtml = htmlConverterService.convertDocxToHtml(file);

        return Curriculum(curriculumDocx = curriculumDocx, curriculumHtml = curriculumHtml);
    }
}