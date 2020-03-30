package curriculum.analyser.service.converter

import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.slf4j.LoggerFactory
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Singleton
class HtmlConverterService() {

    private val LOG = LoggerFactory.getLogger(HtmlConverterService::class.java)

    fun convertDocxToHtml(docxFile: File): XWPFDocument {
        runShellCommandToConvertDocxToHtml(docxFile.parent, docxFile.name)
        val inputStream: InputStream = FileInputStream(docxFile);
        return XWPFDocument(inputStream);
    }

    private fun runShellCommandToConvertDocxToHtml(filePath: String, fileName: String) {
        try {
            val convertCommand = listOf(
                    "soffic", "--headless", "--convert-to", "html", "${filePath}/${fileName}", "--outdir", filePath);

            val process = ProcessBuilder(convertCommand).start();

            process.inputStream.reader(Charsets.UTF_8).use {
                LOG.info(it.readText());
            }

            process.waitFor(5, TimeUnit.SECONDS);

        }catch (exception: Exception) {
            LOG.error(exception.message);
        }
    }
}
