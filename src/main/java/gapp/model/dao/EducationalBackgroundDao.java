package gapp.model.dao;

import gapp.model.EducationalBackground;

public interface EducationalBackgroundDao {

	EducationalBackground getEducationalBackground(Integer id);

	EducationalBackground saveEducationalBackground(EducationalBackground educationalBackground);

	void deleteEducationalBackgroundDao(EducationalBackground educationalBackground);

	void deleteEducationalBackgroundDao(Integer id);
}
