package curriculum.analyser.rule.validator

import curriculum.analyser.model.Curriculum

class PortugueseValidator(private val curriculum: Curriculum,
                          private val nextValidator: Validator?): Validator {

    override fun callNextValidator() {
        this.nextValidator?.let {
            this.nextValidator.validate();
        }
    }

    override fun validate() {
        this.callNextValidator();
    }

}