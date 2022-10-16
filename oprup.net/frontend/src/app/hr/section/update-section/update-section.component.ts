import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { SectionService } from '../section.service';

@Component({
  selector: 'app-update-section',
  templateUrl: './update-section.component.html',
  styleUrls: ['./update-section.component.scss']
})
export class UpdateSectionComponent implements OnInit {
  sectionId=this.activateRoute.snapshot.params['id'];
  section:any;

  form: FormGroup = new FormGroup({

    sectionName: new FormControl(''),
    });
    
  constructor(
    public fb: FormBuilder,
    private sectionService: SectionService,
    private activateRoute:ActivatedRoute,
    private translat :TranslateService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.getSectionById()
    this.form = this.fb.group(
      {

       
        sectionName: [null, Validators.compose([
          Validators.required])],
      }

    )
   
  }
  submitted = false;
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  getSectionById=()=>{
   this.sectionService.getSectionById(this.sectionId).subscribe(data=>{
    this.section=data
   })
   console.log(this.section)
  }

  sectionUpdate=()=>{
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    this.sectionService.updateSection(this.section).subscribe(
      () => {this.router.navigate(['section/view'])}
    )
  }
}
