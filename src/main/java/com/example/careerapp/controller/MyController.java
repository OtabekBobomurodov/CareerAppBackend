package com.example.careerapp.controller;

import com.example.careerapp.entity.*;
import com.example.careerapp.entity.enums.Contract;
import com.example.careerapp.entity.enums.Hours;
import com.example.careerapp.entity.enums.Industry;
import com.example.careerapp.entity.enums.Scope;
import com.example.careerapp.model.*;
import com.example.careerapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class MyController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    ExperienceRepository experienceRepository;
    @Autowired
    PreferencesRepository preferencesRepository;
    @Autowired
    GoalsRepository goalsRepository;
    @Autowired
    IndustryRepository industryRepository;

    OrganisationRepository organisationRepository;
    OccupationRepository occupationRepository;

    @Autowired
    JobsRepository jobsRepository;

    public MyController(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    public void setOccupationRepository(OccupationRepository occupationRepository) {
        this.occupationRepository = occupationRepository;
    }




    //CONTACT
    @PostMapping("/addContact")
    public Response addContactDetails(@RequestParam String username, @RequestBody ContactReq contactReq) {
        try {
            Contact contact = new Contact(employeeRepository.findByUsername(username),
                    contactReq.getEmail(), contactReq.getPhone(), contactReq.getMobile());
            if (contactReq.getPhone().length() == 9) {
                contactRepository.save(contact);
                return new Response("Contact successfully added", true);
            } else {
                return new Response("Phone number format is wrong", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error", false);
        }
    }

    @PutMapping("/editContact")
    public Response editContactDetails(@RequestParam String username, @RequestBody ContactReq contactReq) {
        try {
            Contact contactDetails = contactRepository.findByEmployeeUsername(username);
            contactDetails.setEmail(contactReq.getEmail());
            contactDetails.setMobile(contactReq.getMobile());
            contactDetails.setPhone(contactReq.getPhone());

            if (contactReq.getPhone().length() == 9) {
                contactRepository.save(contactDetails);
                return new Response("Contact successfully edited", true);
            } else {
                return new Response("Phone number format is wrong", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error", false);
        }
    }

    @GetMapping("/getContact")
    public Contact getContactDetails(@RequestParam String username) {
        return contactRepository.findByEmployeeUsername(username);
    }

    @GetMapping("/getEmployee")
    public Employee getEmployee(@RequestParam String username) {
        return employeeRepository.findByUsername(username);
    }

    @PutMapping("/editEmployee")
    public Response editEmployee(@RequestParam String username, @RequestBody PersonalReq personalReq) {
        try {
            Employee employee = employeeRepository.findByUsername(username);
            employee.setTitle(personalReq.getTitle());
            employee.setAddress(personalReq.getAddress());
            employee.setFirstName(personalReq.getFirstName());
            employee.setLastName(personalReq.getLastName());
            employee.setDob(personalReq.getDob());
            employee.setCountry(personalReq.getCountry());
            employee.setCity(personalReq.getCity());
            employee.setPostalCode(personalReq.getPostalCode());

            employeeRepository.save(employee);
            return new Response("Employee successfuly edited", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error", false);
        }
    }

    @PostMapping("/addEducation")
    public Response addEducation(@RequestParam String username, @RequestBody EducationReq educationReq) {
        try {
            Education education = new Education(
                    employeeRepository.findByUsername(username),
                    educationReq.getCountry(),
                    educationReq.getInstitution(),
                    educationReq.getDegree(),
                    educationReq.getAward(),
                    educationReq.getStartDate(),
                    educationReq.getCompletionDate(),
                    educationReq.getStatus(),
                    educationReq.getStudyMode()
            );
            educationRepository.save(education);
            return new Response("Successfully added", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error", false);
        }
    }

    @GetMapping("/getEducation")
    public List<?> getEducation(@RequestParam String username) {
        return educationRepository.findAllByEmployeeUsername(username);
    }

    @GetMapping("/getEducationById")
    public Education getEduById(@RequestParam Integer id) {
        return educationRepository.findById(id).get();
    }

    @PutMapping("/editEducation")
    public Response editEducation(@RequestParam Integer id, @RequestBody EducationReq educationReq) {
        try {
            Education education = educationRepository.findById(id).get();
            education.setCountry(educationReq.getCountry());
            education.setInstitution(educationReq.getInstitution());
            education.setDegree(educationReq.getDegree());
            education.setAward(educationReq.getAward());
            education.setStartDate(educationReq.getStartDate());
            education.setCompletionDate(educationReq.getCompletionDate());
            education.setStatus(educationReq.getStatus());
            education.setStudyMode(educationReq.getStudyMode());

            educationRepository.save(education);
            return new Response("Successfully edited", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error", false);
        }
    }

    @DeleteMapping("/deleteEducation")
    public Response deleteEducation(@RequestParam Integer id) {
        try {
            educationRepository.deleteById(id);
            return new Response("Successfully deleted!", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error", false);
        }
    }

    @PostMapping("/addExperience")
    public Response addExperience(@RequestParam String username, @RequestBody ExperienceReq experienceReq) {
        try {
            Experience experience = new Experience(
                    employeeRepository.findByUsername(username),
                    experienceReq.getTitle(),
                    experienceReq.getOrganisationName(),
                    experienceReq.getStartDate(),
                    experienceReq.getCompletionDate(),
                    experienceReq.getContractHours(),
                    experienceReq.getDescription(),
                    experienceReq.getRefereeName(),
                    experienceReq.getRefereeEmail(),
                    experienceReq.getRefereePhone()
            );
            experienceRepository.save(experience);
            return new Response("Successfully added", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error", false);
        }
    }

    @GetMapping("/getExperience")
    public List<?> getExperience(@RequestParam String username) {
        return experienceRepository.findAllByEmployeeUsername(username);
    }

    @GetMapping("/getExperienceById")
    public Experience getExperienceById(@RequestParam Integer id) {
        return experienceRepository.findById(id).get();
    }

    @PutMapping("/editExperience")
    public Response editExperience(@RequestParam Integer id, @RequestBody ExperienceReq experienceReq) {
        try {
            Experience experience = experienceRepository.findById(id).get();
            experience.setTitle(experienceReq.getTitle());
            experience.setOrganisationName(experienceReq.getOrganisationName());
            experience.setStartDate(experienceReq.getStartDate());
            experience.setCompletionDate(experienceReq.getCompletionDate());
            experience.setContractHours(experienceReq.getContractHours());
            experience.setDescription(experienceReq.getDescription());
            experience.setRefereeName(experienceReq.getRefereeName());
            experience.setRefereeEmail(experienceReq.getRefereeEmail());
            experience.setRefereePhone(experienceReq.getRefereePhone());

            experienceRepository.save(experience);
            return new Response("Successfully edited", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error", false);
        }
    }

    @DeleteMapping("/deleteExperience")
    public Response deleteExperience(@RequestParam Integer id) {
        try {
            experienceRepository.deleteById(id);
            return new Response("Successfully deleted!", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error", false);
        }
    }

    @PostMapping("/addPreferences")
    public Response addPreferences(@RequestParam String username, @RequestBody PreferencesReq preferencesReq) {
        try {
            Employee employee = employeeRepository.findByUsername(username);
            Preferences preferences = new Preferences(employee, preferencesReq.getIndustry(),
                    preferencesReq.getPosition(), preferencesReq.getLevel(), preferencesReq.getWorkMode(),
                    preferencesReq.getSalary(), preferencesReq.getCurrency(), preferencesReq.getContract());

            preferencesRepository.save(preferences);
            return new Response("Successfully added", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error", false);
        }
    }

    @PutMapping("/editPreferences")
    public Response editPreferences(@RequestParam String username, @RequestBody PreferencesReq preferencesReq) {
        try {
            Preferences preferences = preferencesRepository.findByEmployeeUsername(username);
            preferences.setIndustry(preferencesReq.getIndustry());
            preferences.setContractType(preferencesReq.getContract());
            preferences.setCurrency(preferencesReq.getCurrency());
            preferences.setLevel(preferencesReq.getLevel());
            preferences.setPosition(preferencesReq.getPosition());
            preferences.setSalary(preferencesReq.getSalary());
            preferences.setWorkMode(preferencesReq.getWorkMode());

            preferencesRepository.save(preferences);
            return new Response("Successfully edited!", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error", false);
        }
    }

    @GetMapping("/getPreferences")
    public Preferences getPreferences(@RequestParam String username) {
        return preferencesRepository.findByEmployeeUsername(username);
    }

//    @PostMapping("/login")
//    public Employee login(@RequestParam String username, @RequestParam String password) {
//        Integer id = employeeRepository.findByUsername(username).getId();
//        String password1 = employeeRepository.findByUsername(username).getPassword();
//        if (employeeRepository.existsById(id) && password.equals(password1)) {
//            return employeeRepository.findByUsername(username);
//        }
//        return null;
//    }

//    @GetMapping("/getJobs")
//    public HttpEntity<?> getJobs(@RequestParam Integer page, @RequestParam String title, @RequestParam String workMode, @RequestParam String contractType) {
//        Pageable pageable = PageRequest.of(page - 1, 5);
//        Page<Jobs> jobs = jobsRepository.findAllByJobTitleContainingIgnoreCaseOrWorkModeContainingIgnoreCaseOrContractTypeContainingIgnoreCase(
//                title, workMode, contractType, pageable
//        );
//
//        List<JobsModel> filterList = new ArrayList<>();
//
//        for (Jobs jobs1 : jobs) {
//            JobsModel jobsModel = new JobsModel(
//                    jobs1.getId(),
//                    jobs1.getJobTitle(),
//                    jobs1.getDescription(),
//                    jobs1.getSalary(),
//                    jobs1.getCurrency(),
//                    jobs1.getLocation(),
//                    jobs1.getWorkMode(),
//                    jobs1.getContractType(),
//                    jobs1.getContractHours(),
//                    jobs1.getDeadline()
//            );
//            filterList.add(jobsModel);
//        }
//        return ResponseEntity.ok(new PageResponse(filterList, jobs.getTotalElements(), jobs.getTotalPages()));
//    }

    @GetMapping("/getJobs")
    public HttpEntity<?> getJobs(@RequestParam Integer page, @RequestParam String jobTitle, @RequestParam Hours contractHours, @RequestParam Contract contractType, @RequestParam String username) {
        Pageable pageable = PageRequest.of(page - 1, 3);
        Page<Jobs> allJobs = jobsRepository.findAllByJobTitleContainingIgnoreCaseOrContractHoursAndContractType(
                jobTitle, contractHours, contractType, pageable);

        List<JobsModel> filterList = new ArrayList<>();
        for (Jobs jobs : allJobs) {
            JobsModel jobsModel = new JobsModel(
                    jobs.getId(),
                    jobs.getJobTitle(),
                    jobs.getDescription(),
                    jobs.getSalary(),
                    jobs.getCurrency(),
                    jobs.getLocation(),
                    jobs.getContractType(),
                    jobs.getContractHours(),
                    jobs.getDeadline(),
                    jobs.getOrganisation(),
                    jobs.getBookmarkedEmployee().contains(employeeRepository.findByUsername(username))?1:0
            );
            filterList.add(jobsModel);
        }
        return ResponseEntity.ok(new PageResponse(filterList, allJobs.getTotalElements(), allJobs.getTotalPages()));
    }

    @GetMapping("/getJobsAll")
    public HttpEntity<?> getJobsAll(@RequestParam Integer page, @RequestParam String username) {
        Pageable pageable = PageRequest.of(page - 1, 3);
        Page<Jobs> allJobs = jobsRepository.findAll(pageable);

        List<JobsModel> filterList = new ArrayList<>();
        for (Jobs jobs : allJobs) {
            JobsModel jobsModel = new JobsModel(
                    jobs.getId(),
                    jobs.getJobTitle(),
                    jobs.getDescription(),
                    jobs.getSalary(),
                    jobs.getCurrency(),
                    jobs.getLocation(),
                    jobs.getContractType(),
                    jobs.getContractHours(),
                    jobs.getDeadline(),
                    jobs.getOrganisation(),
                    jobs.getBookmarkedEmployee().contains(employeeRepository.findByUsername(username))?1:0
            );
            filterList.add(jobsModel);
        }
        return ResponseEntity.ok(new PageResponse(filterList, allJobs.getTotalElements(), allJobs.getTotalPages()));
    }


    @GetMapping("/getJobById")
    public Jobs getJobById(@RequestParam Integer id) {
        return jobsRepository.findById(id).get();
    }

    @GetMapping("/getOrganisations")
    public HttpEntity<?> getOrganisations(@RequestParam Integer page, @RequestParam String name, @RequestParam Industry industry, @RequestParam Scope scope, @RequestParam String username) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<Organisation> allOrganisations = organisationRepository.findAllByNameIgnoreCaseOrIndustryAndScope(
                name, industry, scope, pageable);

        List<OrganisationModel> filterList = new ArrayList<>();
        for (Organisation organisation : allOrganisations) {
            OrganisationModel organisation1 = new OrganisationModel(
                    organisation.getId(),
                    organisation.getName(),
                    organisation.getLocation(),
                    organisation.getIndustry(),
                    organisation.getScope(),
                    organisation.getPhone(),
                    organisation.getEmail(),
                    organisation.getWebsite(),
                    organisation.getPostalCode(),
                    organisation.getFollowingEmployee().contains(employeeRepository.findByUsername(username))?1:0
            );
            filterList.add(organisation1);
        }
        return ResponseEntity.ok(new PageResponse(filterList, allOrganisations.getTotalElements(), allOrganisations.getTotalPages()));
    }

    @GetMapping("/getOrganisationsAll")
    public HttpEntity<?> getOrganisationsAll(@RequestParam Integer page, @RequestParam String username) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<Organisation> allOrganisations = organisationRepository.findAll(pageable);


        List<OrganisationModel> filterList = new ArrayList<>();
        for (Organisation organisation : allOrganisations) {
            OrganisationModel organisation1 = new OrganisationModel(
                    organisation.getId(),
                    organisation.getName(),
                    organisation.getLocation(),
                    organisation.getIndustry(),
                    organisation.getScope(),
                    organisation.getPhone(),
                    organisation.getEmail(),
                    organisation.getWebsite(),
                    organisation.getPostalCode(),
                    organisation.getFollowingEmployee().contains(employeeRepository.findByUsername(username))?1:0
            );
            filterList.add(organisation1);
        }
        return ResponseEntity.ok(new PageResponse(filterList, allOrganisations.getTotalElements(), allOrganisations.getTotalPages()));
    }

    @GetMapping("/getOrganisationById")
    public Organisation getOrganisationById(@RequestParam Integer id) {
        return organisationRepository.findById(id).get();
    }


    @PutMapping("/bookmarkJob")
    public Response bookmarkJob(@RequestParam Integer jobId, @RequestParam String username) {
        Jobs job = jobsRepository.findById(jobId).get();
        List<Employee> list = new ArrayList<>();
        List<Employee> employee = employeeRepository.findByUsernameOk(username);
        list.addAll(job.getBookmarkedEmployee());
        if (list.equals(employee)) {
            list.removeAll(employee);
        } else {
            list.addAll(employee);
        }
        job.setBookmarkedEmployee(list);

        jobsRepository.save(job);
        return new Response("Bookmarked!", true);
    }

    @PutMapping("/followOrganisation")
    public Response followOrganisation(@RequestParam Integer organisationId, @RequestParam String username) {
        Organisation organisation = organisationRepository.findById(organisationId).get();
        List<Employee> list = new ArrayList<>();
        List<Employee> employee = employeeRepository.findByUsernameOk(username);
        list.addAll(organisation.getFollowingEmployee());
        if (list.equals(employee)) {
            list.removeAll(employee);
        } else {
            list.addAll(employee);
        }
        organisation.setFollowingEmployee(list);

        organisationRepository.save(organisation);
        return new Response("Following", true);
    }

    @GetMapping("/getBookmarkedJobs")
    public List<?> getBookmarkedJobs(@RequestParam String username) {
        return jobsRepository.findByBookmarkedEmployee(employeeRepository.findByUsername(username));
    }

    @GetMapping("/getFollowedOrganisations")
    public List<?> getFollowedOrganisations(@RequestParam String username) {
        return organisationRepository.findByFollowingEmployee(employeeRepository.findByUsername(username));
    }

    @PostMapping("/login")
    public User Login(@RequestParam String username, @RequestParam String password) {
        if(employeeRepository.findByUsername(username)!=null &&
                (employeeRepository.findByUsername(username).getPassword().equals(password)) &&
        employeeRepository.findByUsername(username).getUsername().equals(username)) {
            return new User(username,"user");
        }
        else if(organisationRepository.findByUsername(username)!=null &&
                (organisationRepository.findByUsername(username).getPassword().equals(password)) &&
                organisationRepository.findByUsername(username).getUsername().equals(username)) {
            return new User(username,"admin");
        }
        return null;
    }
}
