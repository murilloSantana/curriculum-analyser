package curriculum.analyser.rule.chain

import curriculum.analyser.model.Curriculum
import curriculum.analyser.rule.validator.PortugueseValidator

class DefaultChain: Chain {
    override fun run(curriculum: Curriculum) {
        PortugueseValidator(curriculum, null);
    }
}