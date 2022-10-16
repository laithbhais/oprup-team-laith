import { DecimalPipe } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { TranslateService } from '@ngx-translate/core';
import { ToastrService } from 'ngx-toastr';
import { CountryService } from 'src/app/components/tables/counteries.service';
import { Partner } from 'src/app/hr/company/partner';
import { Items } from 'src/app/inventory/items/Items';
import { ItemsService } from 'src/app/inventory/items/items.service';
import Swal from 'sweetalert2';
import { ItemRequestService } from '../item-request.service';

@Component({
  selector: 'app-create-item-request',
  templateUrl: './create-item-request.component.html',
  styleUrls: ['./create-item-request.component.scss'],
  providers: [CountryService, DecimalPipe],
})
export class CreateItemRequestComponent implements OnInit {
  items!:any;
  year:any;
  itemsDetailsById:any;
  itemsDetails:any;
  isPrinting = true;
  elementType = 'svg';
  lineColor = '#000000';
  width = 1;
  height =30;
  displayValue = true;
  fontOptions = '';
  format = 'CODE128';
  font = 'monospace';
  textAlign = 'right';
  textPosition = 'bottom';
  textMargin = 0;
  fontSize = 1;
  background = '#ffffff';
  margin = 1;
  marginTop = 9;
  marginBottom = 0;
  marginLeft = 0;
  marginRight = 0;
  hiddenDiv = false;



  itemRequestData = {

    itemRequestId:'',

    itemRequestDate:'',

    deleteFlag: 1
  }

  itemRequestDetailsData={
    itemRequestDetailsId:'',
    quantityPackage:'',
    quantity:'',
    itemRequest:{
      itemRequestId:'',
    },
    items:{
      itemsId:'',
    },
    deleteFlag: 1
  }


  form: FormGroup = new FormGroup({

    quantityPackage:new FormControl(''),
    quantity:new FormControl(''),
    // itemRequestDate:new FormControl(''),

  });



  constructor(
    public service: CountryService,
    private itemsService: ItemsService,
    private modalService: NgbModal,
    // Language code
    private translate: TranslateService,
    private router: Router,
    private itemRequestService: ItemRequestService,
    private toaster:ToastrService,
    public fb: FormBuilder, // Form Builder service for Reactive forms
  )    {

   // Language code
   this.translate.setDefaultLang('ar');
   const lang = localStorage.getItem('lang') || 'ar';
   this.translate.use(lang);
   document.documentElement.lang = lang;

   }

   public getAllItemsById(ItemRequest:any): void {

    this.itemRequestService.getItemRequestDetailsByItemRequest(ItemRequest).subscribe(
      (response) => {
        this.itemsDetailsById = response;
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

   public getAllItems(): void {
    this.itemsService.getAllItems().subscribe(
      (response: Items[]) => {
        this.items = response;
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  isLoggedIn = true;
  getItemByItemCode(event: any){

    this.itemsService.getItemsById(event).subscribe(data=>{
      this.itemsDetails=data
      this.isLoggedIn = false;
     console.log('ddddd',data)

     })

  }
  count(){
    this.itemRequestService.count().subscribe((data: number)=>{
      this.itemRequestData.itemRequestId=`${data+1}`
    })
  }
  count2(){
    this.itemRequestService.count().subscribe((data: number)=>{
      this.itemRequestDetailsData.itemRequest.itemRequestId=`${data}`
    })
  }









  ngOnInit(): void {
    this.getAllItems();
    this.count();

    this.form = this.fb.group(
      {

        quantityPackage:[null, Validators.compose([
          Validators.required,

        ])],
        quantity:[null, Validators.compose([
          Validators.required,

        ])],
        // itemsId:[null, Validators.compose([Validators.required,])],
        // itemRequestDate:[null, Validators.compose([Validators.required,])],
      }

    )

  }

  submitted = false;
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }


  addItemRequestDetails(){
   this.itemRequestService.addItemRequestDetails(this.itemRequestDetailsData).subscribe(
     () => {

      this.getAllItemsById(this.itemRequestDetailsData.itemRequest.itemRequestId);
      this.router.navigate(['/itemRequest/create-itemRequest'])}

   ),
   (error: HttpErrorResponse) => {
     console.log("errrrrre",this.itemRequestDetailsData)
   }

  }

  Select2Update(select2modal:any,p:any) {
    this.itemRequestDetailsData=p
    this.modalService.open(select2modal);

  }


  deletePartner(p:any){

    Swal.fire({
      icon: 'info',
      title: this.translate.instant('areyousuretodeletetherecord'),
      confirmButtonText:this.translate.instant('delete'),
      showCancelButton: true,
      cancelButtonText: this.translate.instant('cancel'),
    }).then((result) => {
      if(result.isConfirmed){

        this.itemRequestService.deleteItemRequestDetails(p).subscribe(
          (response) => {
            Swal.fire(this.translate.instant('success'), this.translate.instant('dataisDeleted'), 'success')

            this.getAllItemsById(p.itemRequest.itemRequestId);

          this.toaster.success(this.translate.instant('success'))

            //location.reload();

          },
          (error) => {
            Swal.fire(this.translate.instant('error'), this.translate.instant('errorwhiledeletingData'), 'error')

        this.toaster.error(this.translate.instant('error'))

          }
        );
      }


    })
   }

   toggelHidden(){
    if(this.hiddenDiv == false){
      this.hiddenDiv = true

    }
   }

  public addItemRequest(): void{

    this.itemRequestService.addItemRequest(this.itemRequestData).subscribe(

      () => {
        this.toggelHidden()
        this.count2();
        this.router.navigate(['/itemRequest/create-itemRequest'])}

    )
  }



  Select2Open(select2modal:any) {

    this.modalService.open(select2modal);

  }

}

