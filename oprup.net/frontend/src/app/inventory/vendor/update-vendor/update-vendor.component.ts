import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, AbstractControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { VendorService } from '../Vendor.service';

@Component({
  selector: 'app-update-vendor',
  templateUrl: './update-vendor.component.html',
  styleUrls: ['./update-vendor.component.scss']
})
export class UpdateVendorComponent implements OnInit {

  vendorId=this.activateRoute.snapshot.params['id'];
  vendor:any;
  form: FormGroup = new FormGroup({

    vendorAccountantNumber:new FormControl(''),
  //vendorCode: new FormControl(''),
  vendorName: new FormControl(''),
  contactPerson: new FormControl(''),
  contactNumber:new FormControl(''),
  });

  constructor(
    private vendorService: VendorService,
    public fb: FormBuilder, // Form Builder service for Reactive forms
    private activateRoute:ActivatedRoute,
    private router: Router,
    ) { }

  ngOnInit(): void {
    this.getvendorById()
    this.form = this.fb.group(
      {

        vendorAccountantNumber:[null, Validators.compose([
          Validators.required,
           Validators.pattern('^([0-9]+)$')
        ])],
        // vendorCode: [null, Validators.compose([
        //   Validators.required,
        //    Validators.pattern('^([0-9]+)$')
        // ])],
        vendorName: [null, Validators.compose([
          Validators.required,
          // Validators.pattern('^([a-zA-Z\s]+)$')
        ])],
        contactPerson: [null, Validators.compose([
          Validators.required,
          // Validators.pattern('^([0-9]+)$')
        ])],
        contactNumber:[null, Validators.compose([
          Validators.required,
          Validators.pattern('^([0-9]+)$')
        ])]



      }

    )

  }

  submitted = false;
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }
  getvendorById=()=>{
   this.vendorService.getVendorById(this.vendorId).subscribe(data=>{
    this.vendor=data

   })
  }

  vendorUpdate=()=>{
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    this.vendorService.updateVendor(this.vendor).subscribe(
      () => {this.router.navigate(['/vendor/vendor'])}
    )
  }
}

