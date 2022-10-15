import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { BankService } from '../bank.service';

@Component({
  selector: 'app-add-bank',
  templateUrl: './add-bank.component.html',
  styleUrls: ['./add-bank.component.scss']
})
export class AddBankComponent implements OnInit {
  
  form: FormGroup = new FormGroup({

    bankName:new FormControl(''),
    bankDescription:new FormControl(''),

  });

  
  constructor(
    private bankService:BankService,
    private translate:TranslateService,
    public fb: FormBuilder, // Form Builder service for Reactive forms
    ) { }

  bankData = {
    bankName: '',
    bankDescription: '',
    deleteFlag: 1
  }

  ngOnInit(): void {
    this.form = this.fb.group(
      {

        
        bankName: [null, Validators.compose([
          Validators.required,
          // Validators.pattern('^([a-zA-Z\s]+)$')
        ])],
        bankDescription: [null, Validators.compose([
          Validators.nullValidator,
          // Validators.pattern('^([a-zA-Z\s]+)$')
        ])],



      }

    )
  }
  submitted = false;
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  public addBank(): void{
    
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    this.bankService.addBank(this.bankData).subscribe(
      () => {location.assign('../bank/view')}
    )
    console.log(this.bankData)

  }

}
