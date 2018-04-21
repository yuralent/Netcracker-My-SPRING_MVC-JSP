package by.netcracker.controllers;

import by.netcracker.entities.FacultyEntity;
import by.netcracker.models.FacultyViewModel;
import by.netcracker.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FacultyController {


    private ConversionService conversionService;
    private FacultyService facultyService;

    @Autowired
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Autowired
    public void setFacultyService(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @RequestMapping(value = "/faculty", method = RequestMethod.POST)
    @ResponseBody
    public FacultyViewModel AddFaculty(@RequestBody FacultyViewModel facultyViewModel) {
       FacultyEntity faculty = this.conversionService.convert(facultyViewModel, FacultyEntity.class);
      //FacultyEntity faculty = new FacultyEntity();
    // faculty.setNamefaculty(facultyViewModel.getNamefaculty());
        this.facultyService.addFaculty(faculty);
        return facultyViewModel;
    }
}