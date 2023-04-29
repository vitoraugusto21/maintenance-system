package model.dao;

import model.entities.Report;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public interface ReportDAO {
    void saveReport(Report report) throws Exception, UnsupportedEncodingException;
}
