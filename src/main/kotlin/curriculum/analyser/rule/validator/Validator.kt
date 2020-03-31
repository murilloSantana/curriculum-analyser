package curriculum.analyser.rule.validator

interface Validator {
    fun callNextValidator();
    fun validate();
}