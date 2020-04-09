package curriculum.analyser.model

import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.jsoup.nodes.Document
import org.languagetool.rules.RuleMatch

data class Curriculum(val curriculumDocx: XWPFDocument, val curriculumHtml: Document, var analyzeResult: List<Analyze> = listOf(Analyze())) {

}


class Analyze {
    var fromPosition: Int = 0
    var toPosition: Int = 0
    lateinit var message: String;
    lateinit var shortMessage: String;
    lateinit var suggestedReplacement: List<String>

    constructor() {}

    constructor(fromPosition: Int, toPosition: Int, message: String,
                shortMessage: String, suggestedReplacement: List<String>) {
        this.fromPosition = fromPosition;
        this.toPosition = toPosition;
        this.message = message;
        this.shortMessage = shortMessage;
        this.suggestedReplacement = suggestedReplacement;
    }

    fun parseRuleMatchToAnaylsis(ruleMatch: List<RuleMatch>): List<Analyze> {
        return ruleMatch.map {
            Analyze(it.fromPos, it.toPos, it.message, it.shortMessage, it.suggestedReplacements)
        }.toList();
    }
}