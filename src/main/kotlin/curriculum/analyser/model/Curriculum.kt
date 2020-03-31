package curriculum.analyser.model

import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.jsoup.nodes.Document

data class Curriculum(val curriculumDocx: XWPFDocument, val curriculumHtml: Document) {

}