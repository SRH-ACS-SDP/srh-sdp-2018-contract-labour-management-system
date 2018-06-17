package com.srh.DynamicJasper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Report {

	public static void main(String[] args) throws Exception {

		try {
			ResultSet rs = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/clms_db",
					"root", "password");
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery("Select work.WORK_DECSP, project.PROJECT_NAME, project.PROJECT_DESCP,\r\n" + 
					"  project.PROJECT_STATUS, work.WORK_STATUS\r\n" + 
					"From work Left Outer Join\r\n" + 
					"  project On work.PROJECT_PROJECT_ID = project.PROJECT_ID");

			FastReportBuilder drb = new FastReportBuilder();

			DynamicReport dr = drb.addColumn("Work Status", "WORK_STATUS", String.class.getName(), 50)
					.addColumn("Work Description", "WORK_DECSP", String.class.getName(), 50)
					.addColumn("Project Name", "PROJECT_NAME", String.class.getName(), 50)
					.addColumn("Project Description", "PROJECT_DESCP", String.class.getName(), 50)
					.addColumn("Status", "PROJECT_STATUS", String.class.getName(), 50)
					.setTitle("CLMS REPORT").setSubtitle("This report was generated at " + new Date())
					.setPrintBackgroundOnOddRows(true).setUseFullPageWidth(true).build();

			JRResultSetDataSource resultsetdatasource = new JRResultSetDataSource(rs);

			JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(),
					resultsetdatasource);

			JasperViewer.viewReport(jp);
		}

		catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
