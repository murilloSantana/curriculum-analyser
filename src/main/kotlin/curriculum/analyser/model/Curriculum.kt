package curriculum.analyser.model

import org.apache.poi.xwpf.usermodel.XWPFDocument

data class Curriculum(val curriculumDocx: XWPFDocument, val curriculumHtml: String) {

}