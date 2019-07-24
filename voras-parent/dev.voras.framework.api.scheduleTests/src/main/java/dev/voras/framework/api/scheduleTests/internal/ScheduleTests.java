package dev.voras.framework.api.scheduleTests.internal;

import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import com.google.gson.Gson;

import dev.voras.framework.api.scheduleTests.bind.RunStatus;
import dev.voras.framework.api.scheduleTests.bind.ScheduleRequest;
import dev.voras.framework.api.scheduleTests.bind.ScheduleStatus;
import dev.voras.framework.spi.FrameworkException;
import dev.voras.framework.spi.IDynamicStatusStore;
import dev.voras.framework.spi.IDynamicStatusStoreService;
import dev.voras.framework.spi.IFramework;
import dev.voras.framework.spi.IRun;


/**
 * Authentication JWT generator
 * 
 * For the JWT to be created, the user needs to be authenticated by the Servlet Filters
 * 
 */
@Component(
		service=Servlet.class,
		scope=ServiceScope.PROTOTYPE,
		property= {"osgi.http.whiteboard.servlet.pattern=/schedule/*"},
		configurationPid= {"dev.voras"},
		configurationPolicy=ConfigurationPolicy.REQUIRE,
		name="Voras Schedule Tests"
		)
public class ScheduleTests extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Reference
	public IFramework framework;   // NOSONAR
	
	private Logger logger;

	private final Properties configurationProperties = new Properties();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String UUID = getUUID(req);
		List<IRun> runs = null;
		try {
			runs = framework.getFrameworkRuns().getAllGroupedRuns(UUID);
		}catch(FrameworkException fe) {
			logger.severe("Unable to obtain framework runs for UUID: " + UUID);
			resp.setStatus(500);
			return;
		}
		ScheduleStatus status = new ScheduleStatus();
		boolean complete = true;
		for(IRun run : runs) {
			if(!"FINISHED".equalsIgnoreCase(run.getStatus()))
				complete = false;
		}
				
		if(complete) {
			status.scheduleStatus = RunStatus.FINISHED_RUN;
		}else {
			status.scheduleStatus = RunStatus.TESTING;
		}
		
		resp.setStatus(200);
		resp.setHeader("Content-Type", "Application/json");
		
		try {
			resp.getWriter().write(new Gson().toJson(status));
		}catch(IOException ioe) {
			logger.severe("Unable to respond to requester" + System.lineSeparator() + ioe.getStackTrace());
			resp.setStatus(500);
		}
	}
	
	@Override 
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean submissionFailures = false;
		String UUID = getUUID(req);
		ScheduleRequest request = (ScheduleRequest)new Gson().fromJson(new InputStreamReader(req.getInputStream()), ScheduleRequest.class);
		for(String className : request.classNames) {
			String bundle = className.split("/")[0];
			String testClass = className.split("/")[1];
			try {
				framework.getFrameworkRuns().submitRun(null, request.requestorType.toString(), bundle, testClass, UUID, request.mavenRepository, request.obr, request.testStream, false, false);
			}catch(FrameworkException fe) {
				logger.warning("Failure when submitting run: " + className + System.lineSeparator() + fe.getStackTrace());
				submissionFailures = true;
				continue;
			}
			
		}
		if(!submissionFailures) {
			resp.setStatus(200);
		}else {
			resp.setStatus(500);
		}
	}

	private String getUUID(HttpServletRequest req) {
		return req.getPathInfo().substring(1);
	}
	
	@Activate
	void activate(Map<String, Object> properties) {
		modified(properties);
		this.logger = Logger.getLogger(this.getClass().toString());
	}

	@Modified
	void modified(Map<String, Object> properties) {
		// TODO set the JWT signing key etc
	}

	@Deactivate
	void deactivate() {
		//TODO Clear the properties to prevent JWT generation
	}

}
