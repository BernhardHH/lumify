package io.lumify.analystsNotebook;

import io.lumify.analystsNotebook.routes.AnalystsNotebookExport;
import io.lumify.miniweb.Handler;
import io.lumify.web.LumifyCsrfHandler;
import io.lumify.web.WebApp;
import io.lumify.web.WebAppPlugin;
import io.lumify.web.privilegeFilters.ReadPrivilegeFilter;

import javax.servlet.ServletContext;

public class AnalystsNotebookExportWebPlugin implements WebAppPlugin {
    @Override
    public void init(WebApp app, ServletContext servletContext, Handler authenticationHandler) {
        Class<? extends Handler> authenticationHandlerClass = authenticationHandler.getClass();
        Class<? extends Handler> csrfHandlerClass = LumifyCsrfHandler.class;

        app.get("/export/analysts-notebook", authenticationHandlerClass, csrfHandlerClass, ReadPrivilegeFilter.class, AnalystsNotebookExport.class);
    }
}
