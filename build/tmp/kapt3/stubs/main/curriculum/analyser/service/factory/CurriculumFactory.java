package curriculum.analyser.service.factory;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcurriculum/analyser/service/factory/CurriculumFactory;", "", "docxConverterService", "Lcurriculum/analyser/service/converter/DocxConverterService;", "htmlConverterService", "Lcurriculum/analyser/service/converter/HtmlConverterService;", "(Lcurriculum/analyser/service/converter/DocxConverterService;Lcurriculum/analyser/service/converter/HtmlConverterService;)V", "createCurriculumInstance", "Lcurriculum/analyser/model/Curriculum;", "file", "Ljava/io/File;", "curriculum-analyser"})
@javax.inject.Singleton()
public final class CurriculumFactory {
    private final curriculum.analyser.service.converter.DocxConverterService docxConverterService = null;
    private final curriculum.analyser.service.converter.HtmlConverterService htmlConverterService = null;
    
    @org.jetbrains.annotations.NotNull()
    public final curriculum.analyser.model.Curriculum createCurriculumInstance(@org.jetbrains.annotations.NotNull()
    java.io.File file) {
        return null;
    }
    
    public CurriculumFactory(@org.jetbrains.annotations.NotNull()
    curriculum.analyser.service.converter.DocxConverterService docxConverterService, @org.jetbrains.annotations.NotNull()
    curriculum.analyser.service.converter.HtmlConverterService htmlConverterService) {
        super();
    }
}