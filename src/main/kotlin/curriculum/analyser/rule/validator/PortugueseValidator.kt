package curriculum.analyser.rule.validator

import curriculum.analyser.model.Analyze
import curriculum.analyser.model.Curriculum
import org.languagetool.JLanguageTool
import org.languagetool.language.BrazilianPortuguese

class PortugueseValidator(private val curriculum: Curriculum,
                          private val nextValidator: Validator?): Validator {

    override fun callNextValidator() {
        this.nextValidator?.let {
            this.nextValidator.validate();
        }
    }

    override fun validate() {
        val language = JLanguageTool(BrazilianPortuguese());

        val ruleMatch = curriculum.curriculumDocx.paragraphs
                .flatMap {
                    language.check(it.paragraphText)
                }

        curriculum.analyzeResult = Analyze().parseRuleMatchToAnaylsis(ruleMatch);
    }

}