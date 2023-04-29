package test.model.dao;

import main.model.dao.ReportDAOImp;
import main.model.entities.Os;
import main.model.entities.Report;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Date;

public class ReportDAOImpTest {

    private ReportDAOImp reportDAO;

    @BeforeEach
    public void setUp() {
        reportDAO = new ReportDAOImp();
    }

    @Test
    public void saveReportTest() throws Exception {
        Os osSubject = new Os("generic_id");
        osSubject.setEndTime(new Date());
        Report report = new Report(osSubject);
        reportDAO.saveReport(report);

        File file = new File(reportDAO.getFilename(report));
        Assertions.assertTrue(file.exists());

        final String expected = report.generateAsString();
        final String received = java.nio.file.Files.readString(file.toPath());
        Assertions.assertEquals(expected.strip() , received.strip());
    }
}
