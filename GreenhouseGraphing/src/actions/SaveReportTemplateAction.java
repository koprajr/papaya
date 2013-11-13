package actions;

import com.opensymphony.xwork2.ActionSupport;
import models.ReportTemplate;

public class SaveReportTemplateAction extends ActionSupport {
    private ReportTemplate template;

    @Override
    public String execute() throws Exception {
        // TODO: Implement logic to save report template to the database.
        return super.execute();
    }

    public ReportTemplate getTemplate() {
        return template;
    }

    public void setTemplate(ReportTemplate template) {
        this.template = template;
    }
}
