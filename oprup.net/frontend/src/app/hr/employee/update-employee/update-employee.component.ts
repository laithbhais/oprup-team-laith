import { HttpErrorResponse, HttpEvent, HttpEventType } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import * as saveAs from 'file-saver';
import { EmployeeType } from '../../employee-type/employee-type';
import { EmployeeTypeService } from '../../employee-type/employee-type.service';
import { EmployeeService } from '../employee.service';
import countries  from '../../../files/countries.json';
import countriesEn from '../../../files/countriesEn.json';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.scss']
})
export class UpdateEmployeeComponent implements OnInit {


  countryList:{name:String,code:String}[]=countries;
  countryListEn:{name:String,code:String}[]=countriesEn;


employeeId: any ;
  employee: any;
  employeeTypes: any;
  employeeType: any;
  employeeByemployeeType: any;
  filesPreview: any;
  img: any;
  employeeData: any;

  form: FormGroup = new FormGroup({
  //   employeeName:new FormControl(''),
  // employeeNameAr:new FormControl(''),
  // dateOfJoin:new FormControl(''),
  // gender:new FormControl(''),
  // image:new FormControl(''),
  //employeeCode:new FormControl(''),
  // placeOfBirth:new FormControl(''),
  // dateOfBirth:new FormControl(''),
  // nationality:new FormControl(''),
  // religion:new FormControl(''),
  // maritalStatus:new FormControl(''),
  // employeeTypeId:new FormControl(''),
  // jobStatus:new FormControl(''),
  })



  constructor(
    private employeeTypeService:EmployeeTypeService,
    private employeeService:EmployeeService,private activateRoute:ActivatedRoute,
    private router: Router) { }

  // upload img
  onPreviewFileSelect(event:any) {
    // console.log(event.addedFiles[0].name)
    if(this.filesPreview.length<1)
      {
      // console.log(event);
		  this.filesPreview.push(...event.addedFiles);
      this.img = event.addedFiles
      this.employeeData.image = 'assets/img/upload/'+event.addedFiles[0].name
      }
	}
  onPreviewFileRemove(event:any) {
		// console.log(event);
		this.filesPreview.splice(this.filesPreview.indexOf(event), 1);
	}

  filenames: string[] = [];
  fileStatus = { status: '', requestType: '', percent: 0 };

// $event.target.files
  // define a function to upload files
  onUploadFiles(files: File[]): void {
    const formData = new FormData();
    for (const file of files) { formData.append('files', file, file.name); }
    this.employeeService.upload(formData).subscribe(
      event => {
        console.log(event);
        this.resportProgress(event);
      },
      (error: HttpErrorResponse) => {
        // console.log(error);
      }
    );
  }

  private resportProgress(httpEvent: HttpEvent<string[] | Blob>): void {
    // console.log(httpEvent)
    switch(httpEvent.type) {
      case HttpEventType.Response:
        if (httpEvent.body instanceof Array) {
          this.fileStatus.status = 'done';
          for (const filename of httpEvent.body) {
            this.filenames.unshift(filename);
          }
        } else {
          saveAs(new File([httpEvent.body!], httpEvent.headers.get('File-Name')!,
                  {type: `${httpEvent.headers.get('Content-Type')};charset=utf-8`}));
        }
        this.fileStatus.status = 'done';
        break;
        default:
          // console.log(httpEvent);
          break;

    }
  }
// upload img
ar=false
en=false
  getlanguage(){

   if(localStorage.getItem('lang')=='ar')
   {
    this.ar=true
    this.en=false


   }
   if(localStorage.getItem('lang')=='en')
   {
    this.ar=false
    this.en=true

   }



  }


    ngOnInit(): void {
    this.getEmployeeByemployeeId()
    this.getAllEmployeeTypes()
  }
  public getAllEmployeeTypes():void{
    this.employeeTypeService.getAllEmployeeTypes().subscribe(
    (response:EmployeeType[])=>{
     this.employeeType=response;
     console.log(response);
    },
    (error: HttpErrorResponse) => {
      console.log(error.message);
    }
    )
  }

  getEmployeeType = (event: any) => {
    this.employeeByemployeeType = this.employeeTypes.filter((element: any) => {
      return element.employeeType.employeeTypeId == event && element.deleteFlag != 0;
    });
  };
  getEmployeeByemployeeId=()=>{
    this.employeeId=this.activateRoute.snapshot.params['id'];
    console.log('oooooo',this.employeeId)
    this.employeeService.getEmployeeById(this.employeeId).subscribe(data=>{this.employee=data;
      console.log('hhhhhhhhhh',this.employee)

    }

      )


  }
 employeeUpdate=()=>{
  this.employeeService.updateEmployee(this.employee).subscribe(
    () => {this.router.navigate(['employee/view'])}
    )
 }

}
