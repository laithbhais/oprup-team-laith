import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { UniversityService } from '../university.service';

@Component({
  selector: 'app-add-university',
  templateUrl: './add-university.component.html',
  styleUrls: ['./add-university.component.scss']
})
export class AddUniversityComponent implements OnInit {
  form: FormGroup = new FormGroup({

    salaryObjectName:new FormControl(''),
    country:new FormControl(''),
    universityType:new FormControl(''),

  });
  constructor(
    private universityService:UniversityService,
    private translate: TranslateService,
    public fb: FormBuilder,
    
    ) { }

  universityData = {
    universityName: '',
    country: '',
    universityType: '',
    deleteFlag: 1
  }

  ngOnInit(): void {
    this.form = this.fb.group(
      {

        
        universityName: [null, Validators.compose([
          Validators.required,
          // Validators.pattern('^([a-zA-Z\s]+)$')
        ])],
        country: [null, Validators.compose([
          Validators.required,
          // Validators.pattern('^([a-zA-Z\s]+)$')
        ])],
        universityType: [null, Validators.compose([
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

  public addUniversity(): void{
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    this.universityService.addUniversity(this.universityData).subscribe(
      () => {location.assign('../university/view')}
    )
    console.log(this.universityData)

  }

}
