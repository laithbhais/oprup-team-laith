import { HttpErrorResponse, HttpEvent, HttpEventType } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import * as saveAs from 'file-saver';
import { SortEvent } from 'src/app/shared/directives/soratable.directive';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-more-details',
  templateUrl: './more-details.component.html',
  styleUrls: ['./more-details.component.scss']
})
export class MoreDetailsComponent implements OnInit {
  employeeId=this.activateRoute.snapshot.params['id'];

  selectAFile: File = null as any;
  filesPreview: File[] = [];
  img: any;
  headers: any;
  service: any;
  employees: any;
  employeeInfo:any;
  banks:any;

  constructor(
    public fb: FormBuilder,
    public employeeService: EmployeeService,
    private modalService: NgbModal,
    private activateRoute:ActivatedRoute,

  ) { }
  employeeData = {
    arabicName: '',
    employeeName: '',
    employeeNameAr:'',
    employeeCode: '',
    image: '',
    gender:'',
    banks:{
      bankId:''

    },
  }
  onSort({column, direction}: SortEvent | any) {
    // resetting other headers
    this.headers.forEach((header: { sortable: any; direction: string; }) => {
      if (header.sortable !== column) {
        header.direction = '';
      }
    });

    this.service.sortColumn = column;
    this.service.sortDirection = direction;
  }
  Select2Open(select2modal:any) {

    this.modalService.open(select2modal);

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


  form: FormGroup = new FormGroup({

    bankName:new FormControl(''),
    bankDescription:new FormControl(''),

  });

  submitted = false;
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }
  

  getEmployeeById=()=>{
    this.employeeService.getEmployeeById(this.employeeId).subscribe(data=>{
     this.employeeInfo=data
     console.log("aaaaa",this.employeeInfo)
     
    })
   }
  ngOnInit(): void {
    this.getEmployeeById();

  }


}
