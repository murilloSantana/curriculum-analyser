package curriculum.analyser.controller

import curriculum.analyser.model.Analyze
import curriculum.analyser.rule.chain.Chain
import curriculum.analyser.service.factory.CurriculumFactory
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import org.apache.commons.io.FileUtils
import org.languagetool.rules.RuleMatch


@Controller("/converter")
class ConverterController(private val curriculumFactory: CurriculumFactory,
                          private val defaultChain: Chain) {

    @Post
    fun converter(): List<Analyze> {
        val docxFile = FileUtils.getFile("${FileUtils.getTempDirectory()}/doc/murillo_ferreira.docx");
        val curriculum = curriculumFactory.createCurriculumInstance(docxFile);

        defaultChain.run(curriculum);

        return curriculum.analyzeResult;
    }
}