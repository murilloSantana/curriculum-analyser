package curriculum.analyser.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcurriculum/analyser/controller/ConverterController;", "", "docxConverter", "Lcurriculum/analyser/service/converter/DocxConverterService;", "curriculumFactory", "Lcurriculum/analyser/service/factory/CurriculumFactory;", "(Lcurriculum/analyser/service/converter/DocxConverterService;Lcurriculum/analyser/service/factory/CurriculumFactory;)V", "getDocxConverter", "()Lcurriculum/analyser/service/converter/DocxConverterService;", "converter", "", "curriculum-analyser"})
@io.micronaut.http.annotation.Controller(value = "/converter")
public final class ConverterController {
    @org.jetbrains.annotations.NotNull()
    private final curriculum.analyser.service.converter.DocxConverterService docxConverter = null;
    private final curriculum.analyser.service.factory.CurriculumFactory curriculumFactory = null;
    
    @io.micronaut.http.annotation.Post()
    public final int converter() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final curriculum.analyser.service.converter.DocxConverterService getDocxConverter() {
        return null;
    }
    
    public ConverterController(@org.jetbrains.annotations.NotNull()
    curriculum.analyser.service.converter.DocxConverterService docxConverter, @org.jetbrains.annotations.NotNull()
    curriculum.analyser.service.factory.CurriculumFactory curriculumFactory) {
        super();
    }
}