package Model.Dao;

import Model.entities.Os;
import Model.entities.Report;

public interface ReportDAO {
    public void createReport(Report report);
    public void deleteReport(Report report);
    public void updateReport(Report report, Os os);
    public Report genReport();
}
