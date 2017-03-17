package gapp.model.dao;

import java.util.List;

import gapp.model.Application;
import gapp.model.ApplicationStatusChange;

public interface ApplicationStatusChangeDao {

	List<ApplicationStatusChange> getApplicationStatusChange();

	List<ApplicationStatusChange> getApplicationStatusChanges(Application application);

	ApplicationStatusChange getLatestApplicationStatusChange(Application application);
	ApplicationStatusChange getLatestApplicationStatus(Integer Id);

	ApplicationStatusChange saveApplicationStatusChange(ApplicationStatusChange applicationStatusChange);
}
