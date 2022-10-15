import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { DepartmentService } from '../department.service';

@Component({
  selector: 'app-update-department',
  templateUrl: './update-department.component.html',
  styleUrls: ['./update-department.component.scss']
})
export class UpdateDepartmentComponent implements OnInit {
  departmentId=this.activateRoute.snapshot.params['id'];
  department:any;

  form: FormGroup = new FormGroup({

    departmentName: new FormControl(''),
    departmentDescription: new FormControl(''),

    });
    
  constructor(
    public fb: FormBuilder,
    private departmentService: DepartmentService,
    private activateRoute:ActivatedRoute,
    private translat :TranslateService
    ) { }

  ngOnInit(): void {
    this.form = this.fb.group(
      {

       
        departmentName: [null, Validators.compose([
          Validators.required,
          // Validators.pattern('^([a-zA-Z\s]+)$')
        ])],
        departmentDescription: [null, Validators.compose([
          Validators.nullValidator,
          // Validators.pattern('^([a-zA-Z\s]+)$')
        ])],



      }

    )
    this.getDepartmentById()
  }
  submitted = false;
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  getDepartmentById=()=>{
   this.departmentService.getDepartmentById(this.departmentId).subscribe(data=>{
    this.department=data
    
   })
  }

  departmentUpdate=()=>{
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    this.departmentService.updateDepartment(this.department).subscribe(
      () => {location.assign('../department/view')}
    )
  }
}
