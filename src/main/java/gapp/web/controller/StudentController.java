package gapp.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import gapp.model.AcademicRecords;
import gapp.model.AdditionalDocs;
import gapp.model.AdditionalDocsValue;
import gapp.model.Application;
import gapp.model.ApplicationStatus;
import gapp.model.ApplicationStatusChange;
import gapp.model.Department;
import gapp.model.EducationalBackground;
import gapp.model.Program;
import gapp.model.StudentInfo;
import gapp.model.Term;
import gapp.model.User;
import gapp.model.UserType;
import gapp.model.dao.AcademicRecordsDao;
import gapp.model.dao.AdditionalDocsDao;
import gapp.model.dao.AdditionalDocsValueDao;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.ApplicationStatusChangeDao;
import gapp.model.dao.ApplicationStatusDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.EducationalBackgroundDao;
import gapp.model.dao.ProgramDao;
import gapp.model.dao.StudentInfoDao;
import gapp.model.dao.TermDao;
import gapp.model.dao.UserDao;
import gapp.model.dao.UserTypeDao;
import gapp.model.dao.jpa.UserTypeDaoImpl;
import gapp.web.validator.newUserValidator;
import gapp.web.validator.AcademicRecordsValidator;
import gapp.web.validator.AdditionalDocumentValidator;
import gapp.web.validator.DepartmentValidator;
import gapp.web.validator.ProgramValidator;
import gapp.web.validator.UserValidator;

@Controller
@SessionAttributes({ "applications", "userid" })
public class StudentController {

	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ProgramDao programDao;
	@Autowired
	private AdditionalDocsDao additionalDocsDao;
	@Autowired
	private UserTypeDao userTypeDao;
	@Autowired
	private TermDao termDao;
	@Autowired
	private ApplicationDao applicationDao;
	@Autowired
	private AdditionalDocsValueDao additionalDocsValueDao;
	@Autowired
	private ApplicationStatusChangeDao applicationStatusChangeDao;
	@Autowired
	private ApplicationStatusDao applicationStatusDao;
	@Autowired
	private StudentInfoDao studentInfoDao;
	@Autowired
	private AcademicRecordsDao academicRecordsDao;
	@Autowired
	private EducationalBackgroundDao educationalBackgroundDao;

	@Autowired
	private newUserValidator newUserValidator;
	@Autowired
	private AdditionalDocumentValidator additionalDocumentValidator;
	@Autowired
	private ProgramValidator programValidator;
	@Autowired
	private DepartmentValidator departmentValidator;
	@Autowired
	private AcademicRecordsValidator academicRecordsValidator;

	@Autowired
	private ServletContext context;

	private File getFileDirectory() {
		String path = context.getRealPath("/WEB-INF/files");
		return new File(path);

	}

	@RequestMapping("/studentHome.html")
	public String studentHome(@RequestParam Integer userid, ModelMap models, SessionStatus sessionStatus) {
		System.out.println("studentHome LOGIN");
		sessionStatus.setComplete();

		return "redirect:/student.html?userid=" + userid;
	}

	@RequestMapping("/student.html")
	public String student(@RequestParam Integer userid, ModelMap models, SessionStatus sessionStatus) {
		System.out.println("STUDENT LOGIN");

		System.out.println(userid);
		User user = userDao.getUser(userid);
		Map<Application, ApplicationStatus> applications = new HashMap<Application, ApplicationStatus>();
		applications = applicationDao.getApplication_Status(user);

		models.put("applications_list", applications);
		models.put("userid", userid);
		return "student";
	}

	@RequestMapping(value = "/DeleteApplication.html")
	public String deleteApplication(@RequestParam Integer applicationId, SessionStatus sessionStatus) {
		System.out.println("DeleteApplication get");
		System.out.println(applicationId);
		Application application = applicationDao.getApplication(applicationId);
		Integer userid = application.getUser().getUserId();
		applicationDao.deleteApplication(application);

		sessionStatus.setComplete();
		return "redirect:/student.html?userid" + userid;
	}

	@RequestMapping(value = "/IncompleteApplication.html", method = RequestMethod.GET)
	public String IncompleteApplication_GET(@RequestParam Integer applicationId, ModelMap models,
			SessionStatus sessionStatus) {
		System.out.println("IncompleteApplication get");

		Application applications = applicationDao.getApplication(applicationId);
		Integer userid = applications.getUser().getUserId();
		models.put("applications", applications);

		if (applications.getStudentInfo() == null)
			return "Step2";
		else if (applications.getAcademicRecords() == null)
			return "Step3";
		else if (applications.getEducationalBackground().size() == 0) {
			return "redirect:/Step4.html?applicationId=" + applications.getApplicationId();
		}

		else {
			return "redirect:/ReviewApplication.html?applicationId=" + applicationId;
		}
	}

	@RequestMapping(value = "/ViewApplication.html", method = RequestMethod.GET)
	public String ViewApplication_GET(@RequestParam Integer applicationId, ModelMap models) {
		System.out.println("ViewApplication get");

		Application applications = applicationDao.getApplication(applicationId);
		models.put("applications", applications);

		return "redirect:/ReviewApplication.html?applicationId=" + applicationId;
	}

	@RequestMapping(value = "/SavedApplication.html", method = RequestMethod.GET)
	public String SavedApplication_GET(@RequestParam Integer applicationId, ModelMap models) {
		System.out.println("SavedApplication get");

		Application applications = applicationDao.getApplication(applicationId);
		models.put("applications", applications);

		return "redirect:/ReviewApplication.html?applicationId=" + applicationId;
	}

	@RequestMapping(value = "/EditApplicationDepartment.html", method = RequestMethod.GET)
	public String editApplicationDepartment_get(@RequestParam Integer applicationId, ModelMap models) {
		System.out.println("EditApplicationDepartment get");

		Application applications = applicationDao.getApplication(applicationId);
		models.put("applications", applications);

		models.put("programs", applications.getDept().getPrograms());
		models.put("terms", termDao.getTerms());

		return "EditApplicationDepartment";
	}

	@RequestMapping(value = "/EditApplicationDepartment.html", method = RequestMethod.POST)
	public String editApplicationDepartment_post(@RequestParam Integer applicationId,
			@ModelAttribute Application applications, ModelMap models) {
		System.out.println("EditApplicationDepartment post");

		Application old_application = applicationDao.getApplication(applicationId);
		old_application.setProgram(applications.getProgram());
		old_application.setTerm(applications.getTerm());

		applications = applicationDao.saveApplication(old_application);

		// models.put("applications", applications);

		return "redirect:/ReviewApplication.html?applicationId=" + applicationId;
	}

	@RequestMapping(value = "/EditStudentDetails.html", method = RequestMethod.GET)
	public String editStudentDetails_get(@RequestParam Integer applicationId, ModelMap models) {
		System.out.println("EditStudentDetails get");

		models.put("applications", applicationDao.getApplication(applicationId));

		return "EditStudentDetails";
	}

	@RequestMapping(value = "/EditStudentDetails.html", method = RequestMethod.POST)
	public String editStudentDetails_post(@RequestParam Integer applicationId, @ModelAttribute Application applications,
			ModelMap models) {
		System.out.println("EditStudentDetails post");

		Application old_application = applicationDao.getApplication(applicationId);

		old_application.setStudentInfo(applications.getStudentInfo());
		old_application.getStudentInfo().setApplications(old_application);
		applications = applicationDao.saveApplication(old_application);

		// models.put("applications", applications);

		return "redirect:/ReviewApplication.html?applicationId=" + applicationId;
	}

	@RequestMapping(value = "/EditAcademicDetails.html", method = RequestMethod.GET)
	public String editAcademicDetails_get(@RequestParam Integer applicationId, ModelMap models) {
		System.out.println("EditAcademicDetails get");

		models.put("applications", applicationDao.getApplication(applicationId));

		return "EditAcademicDetails";
	}

	@RequestMapping(value = "/EditAcademicDetails.html", method = RequestMethod.POST)
	public String editAcademicDetails_post(@RequestParam Integer applicationId,
			@ModelAttribute Application applications, @RequestParam(required = false) MultipartFile file0,
			BindingResult result, ModelMap models) throws IllegalStateException, IOException {
		System.out.println("EditAcademicDetails post");

		Application old_application = applicationDao.getApplication(applicationId);
		User user = old_application.getUser();
		Integer userid = user.getUserId();
		AcademicRecords academicRecords = applications.getAcademicRecords();

		System.out.println(file0.getOriginalFilename());

		if (file0.getOriginalFilename() != "" && file0 != null) {
			System.out.println("Not null");
			file0.transferTo(new File(getFileDirectory(),
					"transcript_" + userid + "_" + applicationId + "_" + file0.getOriginalFilename()));
			academicRecords.setTranscript(file0.getOriginalFilename());

		} else {
			academicRecords.setTranscript(old_application.getAcademicRecords().getTranscript());
		}

		old_application.setAcademicRecords(academicRecords);
		old_application.getAcademicRecords().setApplications(old_application);
		old_application = applicationDao.saveApplication(old_application);

		return "redirect:/ReviewApplication.html?applicationId=" + applicationId;
	}

	@RequestMapping(value = "/EditEducationalBackground.html", method = RequestMethod.GET)
	public String editEducationalBackground_get(@RequestParam Integer applicationId, ModelMap models) {
		System.out.println("EditStudentDetails get");

		models.put("applications", applicationDao.getApplication(applicationId));
		models.put("neweducationalbackground", new EducationalBackground());

		return "Step4";
	}

	// @RequestMapping(value = "/EditEducationalBackground.html", method =
	// RequestMethod.POST)
	// public String editEducationalBackground_post(@RequestParam Integer
	// applicationId, @ModelAttribute Application applications,
	// ModelMap models) {
	// System.out.println("EditStudentDetails post");
	//
	// Application old_application =
	// applicationDao.getApplication(applicationId);
	//
	// old_application.setStudentInfo(applications.getStudentInfo());
	// old_application.getStudentInfo().setApplications(old_application);
	// applications = applicationDao.saveApplication(old_application);
	//
	// // models.put("applications", applications);
	//
	// return "redirect:/ReviewApplication.html?applicationId=" + applicationId;
	// }
	//
	@RequestMapping(value = "/download.html", method = RequestMethod.GET)
	public String download(@RequestParam String documentid, HttpServletResponse response) throws IOException {

		response.setContentType("text/plain");
		response.setHeader("Content-Disposition", "inline; filename=" + documentid);
		System.out.println("download GET");
		FileInputStream in = new FileInputStream(new File(getFileDirectory(), documentid));
		OutputStream out = response.getOutputStream();

		byte buffer[] = new byte[2048];
		int byteRead;

		while ((byteRead = in.read(buffer)) > 0) {
			out.write(buffer, 0, byteRead);
		}
		in.close();
		return null;
	}

	@RequestMapping(value = "/DepartmentLoad.html", headers = "Accept=*/*", method = RequestMethod.GET)
	public @ResponseBody Department loadDepartment(@RequestParam(required = true) Integer id)
			throws IllegalStateException {

		System.out.println("deptload");
		Department dept = departmentDao.getDepartment(id);
		// models.put("applications", new Application());
		// Specify the returning object you want here
		return dept;
	}

	@RequestMapping(value = "/NewApplication.html", method = RequestMethod.GET)
	public String Step1_get(@RequestParam Integer userid, ModelMap models, HttpSession session) {
		System.out.println("AddApplication get");

		Application applications = new Application();

		List<Department> departments = departmentDao.getDepartmentList();
		List<Term> terms = termDao.getTerms();

		models.put("departments", departments);

		models.put("applications", applications);

		models.put("terms", terms);

		return "Step1";
	}

	@RequestMapping(value = "/Step1.html", method = RequestMethod.POST)
	public String Step1_post(@RequestParam Integer userid, @ModelAttribute Application applications, ModelMap models) {
		System.out.println("Step1 post");
		Date date = new Date();
		User user = userDao.getUser(userid);

		// Set the User
		applications.setUser(user);

		// Set the department
		Department dept = departmentDao.getDepartment(applications.getDept().getDeptId());
		applications.setDept(dept);

		// Set the program
		Program prog = programDao.getProgram(applications.getProgram().getProgramId());
		applications.setProgram(prog);

		// Set the Term
		Term term = termDao.getTerm(applications.getTerm().getTermId());
		applications.setTerm(term);

		// Set the status
		ApplicationStatus status = applicationStatusDao.getApplicationStatus(7);
		ApplicationStatusChange statusChange = new ApplicationStatusChange();
		statusChange.setApplicationstatus(status);
		statusChange.setChangedTime(date);
		statusChange.setComment("Please Complete the application");
		statusChange.setApplication(applications);
		List<ApplicationStatusChange> listStatus = new ArrayList<ApplicationStatusChange>();
		listStatus.add(statusChange);
		applications.setApplicationStatusChange(listStatus);

		// save the application
		applications = applicationDao.saveApplication(applications);

		System.out.println("Application department : " + applications.getDept().getDeptId());
		System.out.println("Application program : " + applications.getProgram().getProgramId());

		models.put("applications", applications);
		return "redirect:/Step2.html?applicationId=" + applications.getApplicationId();
	}

	@RequestMapping(value = "/Step2.html", method = RequestMethod.GET)
	public String Step2_get(@RequestParam Integer applicationId, @ModelAttribute Application applications,
			ModelMap models) {

		System.out.println("Step2 get");

		models.put("applications", applicationDao.getApplication(applicationId));
		return "Step2";
	}

	@RequestMapping(value = "/Step2.html", method = RequestMethod.POST)
	public String Step2post(@RequestParam Integer applicationId, @ModelAttribute Application applications,
			ModelMap models) {

		System.out.println("Step2 post");

		Application old_application = applicationDao.getApplication(applicationId);

		old_application.setStudentInfo(applications.getStudentInfo());
		old_application.getStudentInfo().setApplications(old_application);
		applications = applicationDao.saveApplication(old_application);

		System.out.println("step 1 = " + applications.getDept().getDeptName());
		System.out.println("step 2 = " + applications.getStudentInfo().getCin());

		return "redirect:/Step3.html?applicationId=" + applications.getApplicationId();
	}

	@RequestMapping(value = "/Step3.html", method = RequestMethod.GET)
	public String Step3_get(@RequestParam Integer applicationId, @ModelAttribute Application applications,
			ModelMap models, HttpSession session) {

		System.out.println("Step3 get");

		models.put("applications", applicationDao.getApplication(applicationId));
		return "Step3";
	}

	@RequestMapping(value = "/Step3.html", method = RequestMethod.POST)
	public String Step3_post(@RequestParam Integer applicationId, @ModelAttribute Application applications,
			@RequestParam(required = false) MultipartFile file0, BindingResult result, ModelMap models)
					throws IllegalStateException, IOException {
		System.out.println("Step3 post");

		Application old_application = applicationDao.getApplication(applicationId);
		User user = old_application.getUser();
		Integer userid = user.getUserId();
		AcademicRecords academicRecords = applications.getAcademicRecords();

		if (file0.getOriginalFilename() != "" && file0 != null) {
			System.out.println("Not null");
			file0.transferTo(new File(getFileDirectory(),
					"transcript_" + userid + "_" + applicationId + "_" + file0.getOriginalFilename()));
			academicRecords.setTranscript(file0.getOriginalFilename());

		}

		old_application.setAcademicRecords(academicRecords);
		old_application.getAcademicRecords().setApplications(old_application);
		old_application = applicationDao.saveApplication(old_application);

		models.put("applications", old_application);
		return "redirect:/Step4.html?applicationId=" + old_application.getApplicationId();

	}

	@RequestMapping(value = "/Step4.html", method = RequestMethod.GET)
	public String Step4_get(@RequestParam Integer applicationId, ModelMap models) {

		System.out.println("Step4 get");

		models.put("applications", applicationDao.getApplication(applicationId));
		models.put("neweducationalbackground", new EducationalBackground());
		return "Step4";
	}

	@RequestMapping(value = "/deleteDegree.html", method = RequestMethod.GET)
	public String deleteDegree(@RequestParam Integer eduid, @RequestParam Integer applicationId,
			HttpServletResponse response, ModelMap models) throws IOException {

		System.out.println("deleteDegree get");
		EducationalBackground edu = educationalBackgroundDao.getEducationalBackground(eduid);
		Application old_application = applicationDao.getApplication(applicationId);
		educationalBackgroundDao.deleteEducationalBackgroundDao(edu);
		models.put("neweducationalbackground", new EducationalBackground());
		models.put("applications", old_application);
		return "redirect:/Step4.html?applicationId=" + old_application.getApplicationId();
	}

	
	@RequestMapping(value = "/Step4.html", method = RequestMethod.POST)
	public String Step4_post(@ModelAttribute Application applications, ModelMap models)
			throws IllegalStateException, IOException {
		System.out.println("step 4 post");

		Integer applicationId = applications.getApplicationId();
		System.out.println(applicationId);
		Application old_application = applicationDao.getApplication(applicationId);
		models.put("applications", old_application);

		if (old_application.getEducationalBackground().size() == 0) {
			models.put("neweducationalbackground", new EducationalBackground());
			return "Step4";
		}

		return "redirect:/ReviewApplication.html?applicationId=" + applicationId;
	}
	
	@RequestMapping(value = "/EditEducationalBackground.html", method = RequestMethod.POST)
	public String EditEducationalBackground_post(@ModelAttribute Application applications, ModelMap models)
			throws IllegalStateException, IOException {
		System.out.println("EditEducationalBackground post");

		Integer applicationId = applications.getApplicationId();
		System.out.println(applicationId);
		Application old_application = applicationDao.getApplication(applicationId);
		models.put("applications", old_application);

		if (old_application.getEducationalBackground().size() == 0) {
			models.put("neweducationalbackground", new EducationalBackground());
			return "Step4";
		}

		return "redirect:/ReviewApplication.html?applicationId=" + applicationId;
	}

	@RequestMapping(value = "/NewEducationalBackground.html", method = RequestMethod.POST)
	public String newEducationalBackgroundpost(@RequestParam Integer applicationId,
			@ModelAttribute EducationalBackground neweducationalbackground, ModelMap models)
					throws IllegalStateException, IOException {
		System.out.println("new Educational background post");
		Application old_application = applicationDao.getApplication(applicationId);

		neweducationalbackground.setApplications(old_application);
		neweducationalbackground = educationalBackgroundDao.saveEducationalBackground(neweducationalbackground);

		old_application = applicationDao.getApplication(applicationId);

		models.put("applications", old_application);
		models.put("neweducationalbackground", new EducationalBackground());

		return "redirect:/Step4.html?applicationId=" + applicationId;
	}

	@RequestMapping(value = "/ReviewApplication.html", method = RequestMethod.GET)
	public String ReviewApplication_GET(@RequestParam Integer applicationId, ModelMap models) throws IOException {

		System.out.println("ReviewApplication get");

		Application old_application = applicationDao.getApplication(applicationId);
		System.out.println("user is " + old_application.getUser().getUserId());

		models.put("applications", old_application);
		List<ApplicationStatusChange> statusChanges = old_application.getApplicationStatusChange();
		ApplicationStatusChange status = applicationStatusChangeDao.getLatestApplicationStatusChange(old_application);
		System.out.println("Status " + status.getApplicationstatus().getStatus());
		models.put("status", status);
		return "ReviewApplication";
	}

	@RequestMapping(value = "/ReviewApplication.html", method = RequestMethod.POST)
	public String ReviewApplication_POST(@RequestParam Integer applicationId, ModelMap models,
			HttpServletRequest request, SessionStatus sessionStatus) throws IllegalStateException, IOException {
		System.out.println("ReviewApplication post");

		Application applications = applicationDao.getApplication(applicationId);
		Date date = new Date();

		if (request.getParameter("save") != null) {
			System.out.println("clicked save");
			// Set the status
			ApplicationStatus status = applicationStatusDao.getApplicationStatus(6);
			ApplicationStatusChange statusChange = new ApplicationStatusChange();
			statusChange.setApplicationstatus(status);
			statusChange.setChangedTime(date);
			statusChange.setComment("Please Submit the application");
			statusChange.setApplication(applications);
			System.out.println("status set");
			statusChange = applicationStatusChangeDao.saveApplicationStatusChange(statusChange);

			applications.getApplicationStatusChange().add(statusChange);
		}

		else if (request.getParameter("submit") != null) {
			System.out.println("clicked Submit");
			// Set the status
			ApplicationStatus status = applicationStatusDao.getApplicationStatus(1);
			ApplicationStatusChange statusChange = new ApplicationStatusChange();
			statusChange.setApplicationstatus(status);
			statusChange.setChangedTime(date);
			statusChange.setComment("Successfully Submitted");

			statusChange.setApplication(applications);

			statusChange = applicationStatusChangeDao.saveApplicationStatusChange(statusChange);

			applications.getApplicationStatusChange().add(statusChange);
			applications.setDateSubmitted(date);
			// applications.setApplicationStatusChange(listStatus);

		}

		System.out.println("Out of if");
		// save the application
		applications = applicationDao.saveApplication(applications);
		System.out.println(applicationId);
		Integer userid = applications.getUser().getUserId();

		sessionStatus.setComplete();
		return "redirect:/student.html?userid" + userid;
	}

}
