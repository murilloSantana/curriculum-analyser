package curriculum.analyser.controller

import curriculum.analyser.rule.chain.Chain
import curriculum.analyser.service.factory.CurriculumFactory
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Post
import io.micronaut.http.multipart.CompletedFileUpload
import org.apache.commons.io.FileUtils
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths


@Controller("/curriculum")
class CurriculumController(private val curriculumFactory: CurriculumFactory,
                           private val defaultChain: Chain) {


    @Post("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    fun updateCurrilum(curriculum: CompletedFileUpload): MutableHttpResponse<String> {
        try {
            if(!curriculum.filename.endsWith(".docx")) return HttpResponse.badRequest("Invalid format");

            val docxFile = File.createTempFile("temp", ".docx");
            Files.write(Paths.get(docxFile.absolutePath), curriculum.bytes);

            return HttpResponse.ok(docxFile.absolutePath);
        }catch (exception: Exception) {
            return HttpResponse.serverError("Upload failed");
        }
    }

    @Post("/converter")
    @Consumes(MediaType.APPLICATION_JSON)
    fun converter(@Header docxAbsolutePath: String): MutableHttpResponse<Any> {
        val docxFile = FileUtils.getFile(docxAbsolutePath);
        val curriculum = curriculumFactory.createCurriculumInstance(docxFile);

        defaultChain.run(curriculum);

        return HttpResponse.ok(curriculum.analyzeResult);
    }
}