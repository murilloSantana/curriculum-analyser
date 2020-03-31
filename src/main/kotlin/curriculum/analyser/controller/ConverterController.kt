package curriculum.analyser.controller

import curriculum.analyser.service.converter.DocxConverterService
import curriculum.analyser.service.factory.CurriculumFactory
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import org.apache.commons.io.FileUtils

@Controller("/converter")
class ConverterController(val docxConverter: DocxConverterService, private val curriculumFactory: CurriculumFactory) {

    @Post
    fun converter(): Int {
        val docxFile = FileUtils.getFile("./doc/murillo_ferreira.docx");
        val curriculum = curriculumFactory.createCurriculumInstance(docxFile);

        return curriculum.curriculumDocx.paragraphs.size;
    }
}