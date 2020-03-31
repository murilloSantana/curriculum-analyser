package curriculum.analyser.rule.chain

import curriculum.analyser.model.Curriculum

interface Chain {
    fun run(curriculum: Curriculum)
}