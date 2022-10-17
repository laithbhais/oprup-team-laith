package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Section;
import net.oprup.erp.model.Department;
import net.oprup.erp.repo.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SectionService {
    
    private SectionRepo sectionRepo;

    @Autowired
    public SectionService(SectionRepo sectionRepo) {
        this.sectionRepo = sectionRepo;
    }

    public Section addSection(Section section){
        section.setDeleteFlag(1);
        return sectionRepo.save(section);
    }





    public List<Section> findAllSections() {
        return sectionRepo.findSectionByDeleteFlag();
    }

//    public List<Section> findAllSection(){
//        return sectionRepo.findSectionByDeleteFlag();
//    }

    public Section updateSection(Section section){
        section.setDeleteFlag(1);
        return sectionRepo.save(section);
    }


    public List<Section> getSectionsByDepartmentId(Department department){
        return sectionRepo.findSectionsByDepartmentId(department);
    }

    public Section findSectionBySectionId(Long sectionId){
        return sectionRepo.findBySectionId(sectionId)
                .orElseThrow(() -> new NotFoundException("Section by id: " + sectionId + " not found"));
    }
    
    
    
    public  Section deleteSection(Section section){
        section.setDeleteFlag(0);
        return sectionRepo.save(section);
    }


}
