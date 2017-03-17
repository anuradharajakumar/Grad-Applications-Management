package gapp.web.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import gapp.model.AdditionalDocs;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.User;
import gapp.model.dao.AdditionalDocsDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.ProgramDao;
import gapp.model.dao.UserDao;
import gapp.model.dao.UserTypeDao;
import gapp.web.validator.AdditionalDocumentValidator;
import gapp.web.validator.DepartmentValidator;
import gapp.web.validator.ProgramValidator;
import gapp.web.validator.newUserValidator;

@Controller
public class AdminController {

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
	private newUserValidator newUserValidator;
	@Autowired
	private AdditionalDocumentValidator additionalDocumentValidator;
	@Autowired
	private ProgramValidator programValidator;
	@Autowired
	private DepartmentValidator departmentValidator;

	@RequestMapping("/admin.html")
	public String admin(@RequestParam Integer userid, ModelMap models) {
		System.out.println(userid);
		return "admin";
	}

	////////////////////////////// GET METHODS /////////////////////////

	@RequestMapping(value = "/ManageUsers.html", method = RequestMethod.GET)
	public String manageUsers(ModelMap models) {

		System.out.println("Manage Users GET");

		models.put("users", userDao.getUsers());
		models.put("newUser", new User());
		models.put("usertypes", userTypeDao.getUserTypes());
		return "ManageUsers";
	}

	@RequestMapping(value = "/ManageDepartments.html", method = RequestMethod.GET)
	public String manageDepartments(ModelMap models) {

		System.out.println("ManageDepartments get");
		Map<Department, Integer> departments = new TreeMap<Department, Integer>();
		departments = departmentDao.getDepartment();
		models.put("departments", departments);
		models.put("newDepartment", new Department());
		return "ManageDepartments";
	}

	@RequestMapping(value = "/ViewDepartment.html", method = RequestMethod.GET)
	public String viewDepartment(@RequestParam Integer deptId, ModelMap models) {
		System.out.println("viewDepartment get");
		System.out.println(deptId);

		Department dept = departmentDao.getDepartment(deptId);
		List<Program> prog = programDao.getPrograms(dept);
		List<AdditionalDocs> docs = additionalDocsDao.getAdditionalDocs(dept);

		models.put("department", dept);
		models.put("programs", prog);
		models.put("documents", docs);

		Program program = new Program();

		program.setDept(dept);

		AdditionalDocs document = new AdditionalDocs();
		document.setDept(dept);

		System.out.println(program.getDept().getDeptName());
		models.put("newProgram", program);
		models.put("newAdditionalDocs", document);

		return "ViewDepartment";
	}

	@RequestMapping(value = "/EditProgram.html", method = RequestMethod.GET)
	public String editProgram(@RequestParam Integer programId, @RequestParam Integer deptId, ModelMap models) {
		System.out.println("EditProgram get");
		System.out.println(programId);

		Program prog = programDao.getProgram(programId);
		Department department = departmentDao.getDepartment(deptId);
		List<Department> departments = departmentDao.getDepartmentList();

		models.put("program", prog);
		models.put("department", department);
		models.put("departments", departments);

		return "EditProgram";
	}

	@RequestMapping(value = "/EditDocument.html", method = RequestMethod.GET)
	public String editDocument(@RequestParam Integer docId, @RequestParam Integer deptId, ModelMap models) {
		System.out.println("EditDocument get");
		System.out.println(docId);

		AdditionalDocs doc = additionalDocsDao.getAdditionalDocs(docId);
		Department department = departmentDao.getDepartment(deptId);
		List<Department> departments = departmentDao.getDepartmentList();

		models.put("document", doc);
		models.put("department", department);
		models.put("departments", departments);

		return "EditDocument";
	}

	///////////////////////// ADD NEW ENTITIES ////////////////////////////

	@RequestMapping(value = "/ManageUsers.html", method = RequestMethod.POST)
	public String newUser_button(@ModelAttribute User user, BindingResult result, ModelMap models) {

		System.out.println("ManageUsers post");

		newUserValidator.validate(user, result);

		if (result.hasErrors()) {
			System.out.println("has errors");
			models.put("users", userDao.getUsers());
			models.put("newUser", new User());
			models.put("usertypes", userTypeDao.getUserTypes());
			return "ManageUsers";
		}

		user = userDao.saveUser(user);
		return "redirect:/ManageUsers.html";
	}

	@RequestMapping(value = "/ManageDepartments.html", method = RequestMethod.POST)
	public String newDepartment_button(@ModelAttribute Department dept, BindingResult result, ModelMap models) {

		System.out.println("ManageDepartment post");
		departmentValidator.validate(dept, result);
		if (result.hasErrors()) {
			System.out.println("has errors");
			models.put("departments", departmentDao.getDepartment());
			models.put("newDepartment", new Department());
			return "ManageDepartments";
		}
		dept = departmentDao.saveDepartment(dept);
		return "redirect:/ManageDepartments.html";
	}

	@RequestMapping(value = "/NewProgram.html", method = RequestMethod.POST)

	public String newProgram_button(@RequestParam Integer deptId, @ModelAttribute Program program,
			BindingResult result) {

		System.out.println("NewProgram post");

		programValidator.validate(program, result);

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "redirect:/ViewDepartment.html?deptId=" + deptId;
		}

		Department dept = departmentDao.getDepartment(deptId);

		program.setDept(dept);

		program = programDao.saveProgram(program);

		return "redirect:/ViewDepartment.html?deptId=" + deptId;
	}

	@RequestMapping(value = "/NewDocument.html", method = RequestMethod.POST)

	public String newDocument_button(@RequestParam Integer deptId, @ModelAttribute AdditionalDocs document,
			BindingResult result) {

		System.out.println("NewDocument post");

		additionalDocumentValidator.validate(document, result);

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "redirect:/ViewDepartment.html?deptId=" + deptId;
		}

		Department dept = departmentDao.getDepartment(deptId);
		document.setDept(dept);
		document = additionalDocsDao.saveDocument(document);

		return "redirect:/ViewDepartment.html?deptId=" + deptId;
	}

	////////////////////////////// DELETE ENTITIES /////////////////////////

	@RequestMapping(value = "/DeleteUser.html")
	public String deleteUser(@RequestParam Integer userId, ModelMap models) {
		System.out.println("DeleteUser get");

		User user = userDao.getUser(userId);
		userDao.deleteUser(user);

		return "redirect:/ManageUsers.html";
	}

	@RequestMapping(value = "/DeleteDepartment.html")
	public String deleteDepartment(@RequestParam Integer deptId, ModelMap models) {
		System.out.println("DeleteDepartment get");
		System.out.println(deptId);
		Department dept = departmentDao.getDepartment(deptId);
		System.out.println("Exit getDepartment" + dept.getDeptId());
		departmentDao.deleteDepartment(dept);
		return "redirect:/ManageDepartments.html";
	}

	@RequestMapping(value = "/DeleteProgram.html")
	public String deleteProgram(@RequestParam Integer programId, @RequestParam Integer deptId, ModelMap models) {
		System.out.println("DeleteProgram get");

		System.out.println(programId);

		Program prog = programDao.getProgram(programId);
		programDao.deleteProgram(prog);

		return "redirect:/ViewDepartment.html?deptId=" + deptId;
	}

	@RequestMapping(value = "/DeleteDocument.html")
	public String deleteDocument(@RequestParam Integer docId, @RequestParam Integer deptId, ModelMap models) {
		System.out.println("DeleteDocument get");

		System.out.println(docId);

		AdditionalDocs document = additionalDocsDao.getAdditionalDocs(docId);
		additionalDocsDao.deleteDocument(document);

		return "redirect:/ViewDepartment.html?deptId=" + deptId;
	}

	////////////////////////////// EDIT ENTITIES /////////////////////////

	@RequestMapping(value = "/EditDepartment.html", method = RequestMethod.POST)
	public String editDepartment_button(@ModelAttribute Department dept, SessionStatus status, BindingResult result) {
		System.out.println("EDIT DEPARTMENT POST");
		departmentValidator.validate(dept, result);

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "redirect:/ViewDepartment.html?deptId=" + dept.getDeptId();
		}

		departmentDao.saveDepartment(dept);

		status.setComplete();
		return "redirect:/ViewDepartment.html?deptId=" + dept.getDeptId();
	}

	@RequestMapping(value = "/EditProgram.html", method = RequestMethod.POST)
	public String editProgram_button(@RequestParam Integer deptId, @ModelAttribute Program program,
			SessionStatus status, BindingResult result) {

		programValidator.validate(program, result);

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "redirect:/EditProgram.html?programId=" + program.getProgramId() + "&deptId=" + deptId;
		}

		programDao.saveProgram(program);

		status.setComplete();
		return "redirect:/ViewDepartment.html?deptId=" + deptId;
	}

	@RequestMapping(value = "/EditDocument.html", method = RequestMethod.POST)
	public String editDocument_button(@RequestParam Integer deptId, @ModelAttribute AdditionalDocs document,
			SessionStatus status, BindingResult result) {
		System.out.println("EditDocument post");

		additionalDocumentValidator.validate(document, result);

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "redirect:/EditDocument.html?docId=" + document.getDocId() + "&deptId=" + deptId;
		}

		additionalDocsDao.saveDocument(document);

		status.setComplete();
		return "redirect:/ViewDepartment.html?deptId=" + deptId;
	}

}
