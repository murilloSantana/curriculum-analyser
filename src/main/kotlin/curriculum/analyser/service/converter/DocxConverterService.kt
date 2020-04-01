package curriculum.analyser.service.converter

import org.apache.poi.xwpf.usermodel.XWPFDocument
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import javax.inject.Singleton

@Singleton
class DocxConverterService {

    suspend fun convertDocxToObject(docxFile: File): XWPFDocument {
        val inputStream: InputStream = FileInputStream(docxFile);
        return XWPFDocument(inputStream);
    }
}