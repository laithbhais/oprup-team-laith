import { HttpErrorResponse, HttpEvent, HttpEventType } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import * as saveAs from 'file-saver';
import { EmployeeType } from '../../employee-type/employee-type';
import { EmployeeTypeService } from '../../employee-type/employee-type.service';
import { EmployeeService } from '../employee.service';
import countries  from '../../../files/countries.json';
import countriesEn from '../../../files/countriesEn.json';
@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.scss']
})
export class AddEmployeeComponent implements OnInit {

  countryList:{name:String,code:String}[]=countries;
  countryListEn:{name:String,code:String}[]=countriesEn;

  selectAFile: File = null as any;
  filesPreview: File[] = [];
  img: any;
  employeeType:any;
  employeeByemployeeType: any;
  employeeTypes: any;

  constructor(
    private employeeTypeService:EmployeeTypeService,

    public fb: FormBuilder,
    public employeeService: EmployeeService
  ) { }
  employeeData = {
    employeeName: '',
    employeeNameAr: '',
    dateOfJoin: '',
    gender: '',
    image:'',
    employeeCode:'',
    placeOfBirth:'',
    dateOfBirth:'',
    nationality:'',
    religion:'',
    maritalStatus:'',
    employeeType:{
      employeeTypeId:1},
      jobStatus:"",

    deleteFlag:1



  }

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

employeeTypeId:any
employee:any
  form: FormGroup = new FormGroup({

    employeeName:new FormControl(''),
    employeeDescription:new FormControl(''),

  });

  submitted = false;
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  ngOnInit(): void {
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
  
  public addEmployee(): void{
    this.employeeService.addEmployee(this.employeeData).subscribe(
      () => {}
    )
    console.log(this.employeeData)
  }

}
