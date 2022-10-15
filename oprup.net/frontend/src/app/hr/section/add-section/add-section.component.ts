import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { SectionService } from '../section.service';
import { DepartmentService } from '../../department/department.service';


@Component({
  selector: 'app-add-section',
  templateUrl: './add-section.component.html',
  styleUrls: ['./add-section.component.scss']
})
export class AddSectionComponent implements OnInit {
  form: FormGroup = new FormGroup({
    sectionName: new FormControl(''),
  });


  constructor(
  public fb: FormBuilder, // Form Builder service for Reactive forms
  private sectionService:SectionService,
  private translate:TranslateService,
  private departmentService: DepartmentService
  ) 
  { }

  sectionData = {
    sectionName: '',
    deleteFlag: 1,
    department:{
      departmentId:''
    }
  }

  departments:any;

  ngOnInit(): void {
    this.getAllDepartments()
    this.form = this.fb.group(
      {
        sectionName: [null, Validators.compose([
          Validators.required,
          // Validators.pattern('^([a-zA-Z\s]+)$')
        ])],
      }

    )
  }
  submitted = false;
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  public addSection(): void{
    console.log(this.sectionData)
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    this.sectionService.addSection(this.sectionData).subscribe(
    )
  }

  getAllDepartments(){
    this.departmentService.getAllDepartments()
    .subscribe(data => this.departments = data)
    console.log(this.departments)
  }

}




