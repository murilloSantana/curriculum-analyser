package curriculum.analyser.service.converter

import org.apache.commons.io.FileUtils
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.slf4j.LoggerFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Singleton
class HtmlConverterService() {

    private val LOG = LoggerFactory.getLogger(HtmlConverterService::class.java)

    fun convertDocxToHtml(docxFile: File): Document {
        val convertedFile = runShellCommandToConvertDocxToHtml(docxFile);
        val document = Jsoup.parse(FileUtils.readFileToString(convertedFile, Charsets.UTF_8));

        return document;
    }

    private fun runShellCommandToConvertDocxToHtml(file: File): File {
        val convertCommand = listOf(
                "soffice", "--headless", "--convert-to", "html", file.absolutePath, "--outdir", file.parent);

        val process = ProcessBuilder(convertCommand).start();

        process.inputStream.reader(Charsets.UTF_8).use {
            LOG.info(it.readText());
        }

        process.waitFor(5, TimeUnit.SECONDS);

        val convertedFileName = file.absolutePath.replace(file.extension, "html");

        return FileUtils.getFile(convertedFileName);
    }
}
