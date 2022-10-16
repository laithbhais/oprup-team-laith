import { Component, ElementRef, OnInit, QueryList, VERSION, ViewChild, ViewChildren } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';
import { NgbdSortableHeader, SortEvent } from 'src/app/shared/directives/soratable.directive';
import Swal from 'sweetalert2';
import { Section } from '../section';
import { SectionService } from '../section.service';
import * as XLSX from 'xlsx';
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';
import { CountryService } from 'src/app/components/tables/counteries.service';
import { Country } from 'src/app/components/tables/table-modal/countreies.modal';
import { DecimalPipe } from '@angular/common';


@Component({
  selector: 'app-section',
  templateUrl: './section.component.html',
  styleUrls: ['./section.component.scss'],
  providers: [CountryService, DecimalPipe]

})
export class SectionComponent implements OnInit {

  sections: any;
  countries$: Observable<Country[]>;
  total$: Observable<number>;
  
  @ViewChild('sectionprint') sectionElement!: ElementRef;
  pdfTable!: ElementRef;

  @ViewChildren(NgbdSortableHeader) headers!: QueryList<NgbdSortableHeader>;

  constructor(
    private toaster:ToastrService,
    public service: CountryService,
    // Language code
    private translate: TranslateService,
    private sectionService: SectionService
    ) {
      this.countries$ = service.countries$;
      this.total$ = service.total$;
    // Language code
    this.translate.setDefaultLang('ar');
    const lang = localStorage.getItem('lang')  || 'ar';
    this.translate.use(lang);
    document.documentElement.lang = lang;
  }
  
  ngOnInit(): void {
    this.getAllSections()
   }

   getAllSections(){
     this.sectionService.getAllSections()
     .subscribe(data => this.sections = data)
     console.log(this.sections)
   }

   public deleteSection(sectionId: Section){
    Swal.fire({
      icon: 'info',
      title: this.translate.instant('Are you Sure to delete The Record'),
      confirmButtonText:  'Delete',
      showCancelButton: true,
    }).then((result) => {
      if(result.isConfirmed){
        this.sectionService.deleteSection(sectionId).subscribe(
          (response) => {
            Swal.fire(this.translate.instant('success'), this.translate.instant('Data Is Deleted'), 'success')
           this.toaster.success('success')
            this.getAllSections();
          },
          (error) => {
            Swal.fire(this.translate.instant('Error'), this.translate.instant('Error while Deleting Data'), 'error')
            this.toaster.error('Error')
          }
        );
      }


    })
}

@ViewChild('TABLE', { static: false })
  TABLE!: ElementRef;
  title = 'Excel';
  paginator: any;
  matSort: any;

  ExportTOExcel() {
    let ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(this.TABLE.nativeElement);
    delete (ws['D1'])
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');
    XLSX.writeFile(wb, 'ScoreSheet.xlsx');
  }
  public generatePDF(): void {

    html2canvas(this.sectionElement.nativeElement, { scale: 2,allowTaint:true,useCORS:true }).then((canvas) => {
      const imageGeneratedFromTemplate = canvas.toDataURL('image/PNG');

      const fileWidth = 210;
      const generatedImageHeight = (canvas.height * fileWidth) / canvas.width;
      let PDF = new jsPDF('p', 'mm', 'a4',);
      PDF.addImage(imageGeneratedFromTemplate, 'PNG', 0, 5, fileWidth, generatedImageHeight,);
       PDF.html(this.sectionElement.nativeElement.innerHTML)
      PDF.save(`Reports.pdf`);
    });
  }

name = 'Angular ' + VERSION.major;

  printPage() {
    window.print();

  }

}
